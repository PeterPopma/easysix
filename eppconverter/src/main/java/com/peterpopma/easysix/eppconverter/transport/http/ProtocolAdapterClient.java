/*
 * $Id: ProtocolAdapterClient.java 24539 2011-07-12 11:29:03Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.transport.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nl.sidn.eppadapter.support.Instellingen;
import nl.sidn.eppadapter.transport.http.model.PARequest;
import nl.sidn.eppadapter.transport.http.model.PAResponse;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * ProtocolAdapterClient is een client voor het versturen van berichten naar de
 * HTTP interface van de protocol adapter. Alle HTTP gerelateerde logica is in
 * deze class geimplementeerd.
 */
public final class ProtocolAdapterClient {

    private static final Logger LOGGER = Logger.getLogger(ProtocolAdapterClient.class);

    private static final String SOCKET_ADAPTER_USER_AGENT = "EPP Adapter/" + Instellingen.getVersie();

    private static final int MILLIS_IN_SECONDEN = 1000;

    /**
     * httpClient is een threadsafe http client welke door alle epp sessies
     * gebruikt kan worden. Achter de http client zit een connectie pool van een
     * instelbaar aantal connecties. Hierdoor is het versturen van een http
     * request naar de protocol adapter lekker snel.
     */
    private static ProtocolAdapterClient client;
    private static ProtocolAdapterClient adminClient;

    private ThreadSafeClientConnManager tsConnMgr;
    private DefaultHttpClient httpClient;

    private IdleConnectionMonitorThread connectionMonitor;

    private ProtocolAdapterClient(int httpPort) {
        init(httpPort);
    };

    private void init(int httpPort) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("initialiseer de http client.");
        }
        // maak een nieuwe scheme aan.
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(Instellingen.getHttpScheme(), Instellingen.getHttpPort(), PlainSocketFactory.getSocketFactory()));

        /*
         * gebruik een conenction pool voor de http connecties, hierdoor hoeft
         * de http connectie niet voor elk nieuw http request opnieuw te worden
         * opgebouwd.
         */
        tsConnMgr = new ThreadSafeClientConnManager(schemeRegistry);
        tsConnMgr.setMaxTotal(Instellingen.getHttpConnectionPoolSize());

        /*
         * configureer de http server (protocol adapter) waar de http requests
         * naar toe worden verzonden.
         */
        HttpHost host = new HttpHost(Instellingen.getHttpHost(), httpPort);
        // er is maar 1 route, die max alle conns hebben

        tsConnMgr.setMaxForRoute(new HttpRoute(host), Instellingen.getHttpConnectionPoolSize());

        // maak de herbruikbare httpClient
        httpClient = new DefaultHttpClient(tsConnMgr);

        /*
         * bepaal de keepalive strategie dwz bepaal hoe lang de http connecties
         * naar de PA maximaal open mogen blijven staan. Deze keepalive moet
         * korter zijn dan de keepalive van WLS (default 30 minuten)
         */
        httpClient.setKeepAliveStrategy(new KeepAliveStrategy());

        setParameters();

        if (LOGGER.isDebugEnabled()) {
            printDebugInfo();
        }

    }

    private void setParameters() {
        /*
         * koppel een connection monitor thread aan de connection pool deze
         * monitor zal http connecties die door de PA (WLS) zijn sluiten Voorkom
         * dat httpclient zelf op stale connecties checkt.
         */

        HttpParams params = httpClient.getParams();
        // controleer niet op stale connecties dit wordt door
        // IdleConnectionMonitorThread gedaan.
        HttpConnectionParams.setStaleCheckingEnabled(params, false);

        connectionMonitor = new IdleConnectionMonitorThread(tsConnMgr, Instellingen.getHttpConnectionMonitor() * MILLIS_IN_SECONDEN);
        connectionMonitor.start();

        // zet de timeout bij het opzetten van nieuwe http connecties naar de PA
        // server
        HttpConnectionParams.setConnectionTimeout(params, Instellingen.getHttpTimeout());
        // zet de timeout bij het wachten op data van de PA server
        HttpConnectionParams.setSoTimeout(params, Instellingen.getHttpReadTimeout());

        // Alle http content is UTF-8 gecodeerd
        HttpProtocolParams.setContentCharset(params, Instellingen.getEncoding());

        // zet de user agent zodat deze in de logging van de PA vermeld wordt.
        HttpProtocolParams.setUserAgent(params, SOCKET_ADAPTER_USER_AGENT);

        /*
         * maak geen automatisch gebruik van cookies, dit wordt met de hand
         * gedaan en niet door httpclient. De JSESSIONID wordt in de get en post
         * methoden aan het httprequest toegeveoegd en naar de PA verstuurd.
         * Voor het gebruik van de WLS redeployment functionaliteit (versie
         * upgraden zonder downtijd) moet er ook gebruik worden gemaakt van http
         * sessions. - De http sessie identificeert de epp gebruiker die een epp
         * request via de epp adapter verstuurd. - De sessie id in de "session"
         * http request header identificeert de gebruiker die het request
         * verstuurd via de epp adapter Er wordt dus 2 verschillende
         * identificerende session id's naar de protocol adapter verstuurd. dit
         * is niet handig en is een kandidaat voor refactoring, nu even zo
         * gelaten omdat de oude mod_epp ook zo werkte.
         */
        params.setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.IGNORE_COOKIES);
    }

    private void printDebugInfo() {
        LOGGER.debug("Aantal connecties in de HTTPClient pool: " + tsConnMgr.getConnectionsInPool());
        HttpHost host = new HttpHost(Instellingen.getHttpHost(), Instellingen.getHttpPort());
        LOGGER.debug("Max Aantal connecties voor host \"" + Instellingen.getHttpHost() + "\": " + tsConnMgr.getMaxForRoute(new HttpRoute(host)));
        LOGGER.debug("Totaal max aantal connecties: " + tsConnMgr.getMaxTotal());
    }

    /**
     * De ProtocolAdapterClient is een singleton want de resources die in deze
     * class gebruikt worden kunnen door meerdere threads gedeeld worden.
     * 
     * @return
     */
    public static ProtocolAdapterClient getInstance(boolean productie) {
        if (productie) {
            return client;
        } else {
            return adminClient;
        }
    }

    public static void start() {
        if (client == null) {
            client = new ProtocolAdapterClient(Instellingen.getHttpPort());
        }
        if (adminClient == null) {
            adminClient = new ProtocolAdapterClient(Instellingen.getHttpAdminPort());
        }
    }

    /**
     * Stop de httpclient en alle resources die gekoppeld zijn aan de
     * httpClient.
     */
    public void stop() {
        // Stop de monitor
        connectionMonitor.shutdown();
        // stop de connectionmanager en ruim alle conencties in de pool op.
        httpClient.getConnectionManager().shutdown();
    }

    /**
     * Voer een HTTP GET request uit
     * 
     * @param request de url en parameters waarmee het request moet worden
     *            opgebouwd.
     * @return response van de GET
     * @throws HttpException als er een probleem is met het versturen van het
     *             GET request
     */
    public PAResponse doHttpGet(PARequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Geen request parameter aanwezig");
        }

        Set<String> paramKeys = request.getParams().keySet();
        Map<String, String> params = request.getParams();

        List<NameValuePair> nvpList = new LinkedList<NameValuePair>();

        for (String key : paramKeys) {
            nvpList.add(new BasicNameValuePair(key, params.get(key)));
        }

        /* voeg het request toe als parameter met de naam "frame" */
        if (request.getEppRequest() != null) {
            nvpList.add(new BasicNameValuePair(HttpHeaderType.FRAME.getNaam(), request.getEppRequest()));
        }

        String queryString = URLEncodedUtils.format(nvpList, Instellingen.getEncoding());

        try {
            /* bouw de complete url die aangeroepen moet worden met de GET */
            URI uri = URIUtils.createURI(Instellingen.getHttpScheme(), Instellingen.getHttpHost(), Instellingen.getHttpPort(), request.getPath(), queryString, null);

            HttpRequestBase get = new HttpGet(uri);

            setDefaultRequestHeaders(request, get);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Start http GET request:" + get.getRequestLine());
                Header[] headers = get.getAllHeaders();
                for (Header header : headers) {
                    LOGGER.debug("HTTP Request header \"" + header.getName() + "\" :" + header.getValue());
                }
                printDebugInfo();
            }

            return httpClient.execute(get, new ProtocolAdapterResponseHandler());
        } catch (ClientProtocolException e) {
            throw new HttpException("Versturen HTTP GET request mislukt.", e);
        } catch (UnsupportedEncodingException e) {
            throw new HttpException("Bouwen van querystring mislukt.", e);
        } catch (URISyntaxException e) {
            throw new HttpException("Versturen HTTP GET request mislukt.", e);
        } catch (IOException e) {
            throw new HttpException("Versturen HTTP GET request mislukt.", e);
        }
    }
    /**
     * voeg request headers toe aan het request De header met de naam
     * "session" wordt door de PA gebruikt om de gebruiker sessie bij te
     * houden.
     */
    private void setDefaultRequestHeaders(PARequest paRequest, HttpRequestBase httpRequest) {
        
        // voeg de cookie met de sessie identifier toe aan het request
		httpRequest.addHeader(HttpHeaderType.COOKIE.getNaam(), HttpHeaderType.COOKIE_SESSIE.getNaam() + "=" + paRequest.getSessieId());

		if( paRequest.getUsername() != null && paRequest.getPassword() != null) {
			httpRequest.addHeader("username",paRequest.getUsername());
			httpRequest.addHeader("password",paRequest.getPassword());
		}

		httpRequest.addHeader(HttpHeaderType.X_FORWARDED_FOR.getNaam(),paRequest.getIpaddress());

		// voeg de http sessie toe aan het request als er al een http sessie
		// bestaat
		if (paRequest.getHttpSessieId() != null) {
		    httpRequest.addHeader(HttpHeaderType.COOKIE.getNaam(), paRequest.getHttpSessieId());
		}
	}

    /**
     * Verstuur een http request middels een http POST methode. De parameters
     * worden gepost met content-type "multipart/form-data"
     * 
     * @param req het PArequest welke via http verstuurd moet worden naar de PA
     * @return PAResponse met de status en response van het request
     * @throws HttpException als er een probleem is met het versturen van het
     *             POST request
     */
    public PAResponse doHttpPost(PARequest req) {

        try {
            URI uri = URIUtils.createURI(Instellingen.getHttpScheme(), Instellingen.getHttpHost(), Instellingen.getHttpPort(), req.getPath(), null, null);

            HttpPost httpPost = new HttpPost(uri);

            // Voeg de "frame" en "clTID" parameters toe aan het form
            MultipartEntity multipart = new MultipartEntity();
            StringBody eppXmlRequestBody = new StringBody(req.getEppRequest(), "application/xml", Charset.forName(Instellingen.getEncoding()));
            multipart.addPart(HttpHeaderType.FRAME.getNaam(), eppXmlRequestBody);
            StringBody eppClTRIDBody = new StringBody(req.getClTRID(), "text/plain", Charset.forName(Instellingen.getEncoding()));
            multipart.addPart(HttpHeaderType.CLTRID.getNaam(), eppClTRIDBody);
            httpPost.setEntity(multipart);

        	setDefaultRequestHeaders(req,httpPost);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Start http POST request:" + httpPost.getRequestLine());
                Header[] headers = httpPost.getAllHeaders();
                for (Header header : headers) {
                    LOGGER.debug("HTTP Request header \"" + header.getName() + "\" :" + header.getValue());
                }
                printDebugInfo();
            }

            return httpClient.execute(httpPost, new ProtocolAdapterResponseHandler());
        } catch (ClientProtocolException e) {
            throw new HttpException("Versturen HTTP POST request mislukt.", e);
        } catch (UnsupportedEncodingException e) {
            throw new HttpException("Bouwen van querystring mislukt.", e);
        } catch (URISyntaxException e) {
            throw new HttpException("Versturen HTTP POST request mislukt.", e);
        } catch (IOException e) {
            throw new HttpException("Versturen HTTP POST request mislukt.", e);
        }
    }

    /**
     * Response handler welke het antwoord van de protocol adapter verwerkt in
     * een PAResponse.
     */
    private class ProtocolAdapterResponseHandler implements org.apache.http.client.ResponseHandler<PAResponse> {

        /**
         * zorg ervoor dat alle eventueel aanwezig context geconsumed is en de
         * onderliggende stream gesloten is. anders worden de resources niet
         * vrij gegegeven.
         */
        private void sluitEntity(HttpEntity entity) throws IOException {
            if (entity != null) {
                EntityUtils.consume(entity);
            }
        }

        @Override
        public PAResponse handleResponse(HttpResponse response) throws IOException {

            PAResponse par = new PAResponse();

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("HTTP response code: " + response.getStatusLine().getStatusCode());
            }

            /* haal het resultaat op uit het antwoord van de PA */

            HttpEntity entity = response.getEntity();

            // OK status
            handleHttpStatus200(response, par, entity);

            /*
             * controleer of de PA de X-F5-EPP-Code header met de epp resultaat
             * code terug heeft gestuurd en of de Connection of X-Connection
             * headers op "close" staan
             */

            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {

                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("HTTP header \"" + header.getName() + "\" : " + header.getValue());
                }

                if (HttpHeaderType.EPP_RESPONSE_CODE.getNaam().equals(header.getName())) {
                    /*
                     * De protocol adapter heeft de EPP response code
                     * meegestuurd
                     */
                    par.setEppResponseCode(header.getValue());
                } else if ((HttpHeaderType.CONNECTION_CLOSE.getNaam().equals(header.getName()) || HttpHeaderType.X_CONNECTION_CLOSE.getNaam().equals(header.getName()))
                        && header.getValue().equalsIgnoreCase("close")) {

                    /*
                     * Header gevonden welke aangeeft dat de connectie gesloten
                     * moet worden. geef dit door aan de protocol handler welke
                     * de EPP sessie zal sluiten.
                     */
                    par.setConnectieSluiten(true);
                } else if (HttpHeaderType.SET_COOKIE.getNaam().equals(header.getName())) {
                    /*
                     * header met de JSESSION id gevonden, deze bewaren voor
                     * volgende requests dan kan het request aan de http sessie
                     * op de protocol adapter worden gekoppeld.
                     */
                    par.setHttpSessieId(header.getValue());
                }

            }
            return par;
        }

        private void handleHttpStatus200(HttpResponse response, PAResponse par, HttpEntity entity) throws IOException {
            /*
             * controleer of het http request met status code 200 terugkomt of
             * een 401 (authenticatie probleem)
             */
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode() || HttpStatus.SC_UNAUTHORIZED == response.getStatusLine().getStatusCode()) {

                /*
                 * bij een HttpStatus.SC_UNAUTHORIZED geeft de protocol adapter
                 * een xml response terug met daarin de reden waarom er niet
                 * ingelogd kon worden.
                 */
                // par.setHttpCode(HttpCodeType.fromInt(response.getStatusLine().getStatusCode()));

                if (entity != null) {
                    par.setResponse(EntityUtils.toString(entity, Instellingen.getEncoding()));
                    sluitEntity(entity);
                }

                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("HTTP response: " + par.getResponse());
                }
            } else {
                sluitEntity(entity);
                // fout geen http 200 of 401 ontvangen, laat de EPP Adapter een epp 2400
                // terugsturen.
                throw new HttpException("HTTP error " + response.getStatusLine().getStatusCode() + " van de protocol adapter ontvangen.");
            }
        }
    }

    /**
     * Strategy welke een beperkte levensduur van de http connecties naar de PA
     * instelt. Deze moet ideaal gezien korter zijn dan de keepalive die is
     * ingesteld door de WLS server. zodat httpclient in control is m.b.t. het
     * sluiten van http connecties.
     */
    private class KeepAliveStrategy extends DefaultConnectionKeepAliveStrategy {

        // bereken het aantal ms dat een connectie open mag blijven staan.
        private long keepAlive = Instellingen.getHttpKeepAlive() * MILLIS_IN_SECONDEN;

        @Override
        public long getKeepAliveDuration(HttpResponse resp, HttpContext ctx) {
            return keepAlive;
        }

    }

}
