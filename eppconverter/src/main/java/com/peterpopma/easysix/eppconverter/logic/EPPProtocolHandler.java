/*
 * $Id: EPPProtocolHandler.java 24539 2011-07-12 11:29:03Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.logic;

import java.net.InetSocketAddress;

import nl.sidn.eppadapter.support.EPPRequestParser;
import nl.sidn.eppadapter.support.Instellingen;
import nl.sidn.eppadapter.transport.http.HttpException;
import nl.sidn.eppadapter.transport.http.ProtocolAdapterClient;
import nl.sidn.eppadapter.transport.http.model.PARequest;
import nl.sidn.eppadapter.transport.http.model.PAResponse;
import nl.sidn.eppadapter.transport.tcp.model.EPPRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Dit is de "Main" class van de EPP Adapter en bevat de business logica voor het afhandelen
 * van de binnenkomende berichten en het doorsturen van die berichten naar de PA.
 * Het antwoord van de PA wordt gecontroleerd en er wordt een antwoord teruggestuurd
 * naar de client. 
 *
 */
public class EPPProtocolHandler {
	
	private static final Logger LOGGER = Logger.getLogger(EPPProtocolHandler.class);
	
	//EPP resultcodes die beginnen met een "1" staan voor een successvol utigeveord request;
	private static final String EPP_RESULTAAT_CODE_SERIE_OK = "1";
	
	private Sessie sessie;
	
	//het huidige request dat verwerkt wordt.
	private EPPRequest eppRequest;
	//de response van het huidige request
	private PAResponse response;
	
	private boolean productie;
	
	public EPPProtocolHandler(boolean productie){
		this.productie = productie;
	}
	
	/**
	 * Start het EPP protocol, de protcol variabelen worden
	 * geinitialiseerd en er wordt een greeting naar
	 * de client verstuurd.
	 * @param socketAddress 
	 * @return greeting
	 */
	public String start(InetSocketAddress socketAddress){
		//initialiseer de EPP connectie
		sessie = new Sessie();
		sessie.setIpaddress(socketAddress.getAddress().getHostAddress());
		response = null;
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Start SocketAdapter EPP protocol handler, sessieId:" + sessie.getId());
		}
		
		//verstuur een greeting naar de client.
		try {
			return greet();
			// Hier bewust de checkstyle uitgezet omdat in de interface naar de gebruiker toe geen fout zichtbaar mag worden.
            // CHECKSTYLE:OFF
        } catch (Exception e) {
            // CHECKSTYLE:ON
			LOGGER.error("Interne fout opgetreden, stuur EPP 2400 terug", e);
			return greetingFout();
		}
	}
	
	/**
	 * Verwerk een door de client verstuurd EPP request.
	 * Het request wordt geparsed en gedeeltelijk gevalideerd
	 * (niet tegen EPP schema).
	 * @param request : Het EPP XML request
	 * @return De response van de protocol adapter of een foutmelding.
	 */
	public String verwerkRequest(String request){
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("verwerkRequest(" + request + ")");
		}

		response = null;
			
		/* parse het binnengekomen request, het hoeft geen volledig valide xml te zijn
		 * volgens het EPP schema. 
		 */
		eppRequest = EPPRequestParser.parse(request);
		
		if(!eppRequest.isValide()){
			/* het EPP request is niet valide, roep de fout url op de PA 
			 * aan om een fout bericht te genereren.
			 */
			return parseFout();
		}

		/* Controleer of de EPP een session management command betreft */
		if(eppRequest.getRequestType() == EPPRequestType.HELLO){
			return greet();
		}else if(eppRequest.getRequestType() == EPPRequestType.LOGIN){
			return login();
		}else if(eppRequest.getRequestType() == EPPRequestType.LOGOUT){
			return logout();
		}

		/* Ale overige binnengekomen requests zijn commando's 
		 * controleer of de gebruiker is ingelogd voordat het command
		 * wordt uitgevoerd.
		 */
		
		if(sessie.isLoggedIn()){
		    if (eppRequest.getRequestType() == EPPRequestType.EXTENSION) {
	            return extension();
	        } else {
    			/* voer command uit */
    			return command();
	        }
		}
		
		/* niet ingelogd, verstuur foutmelding */
		return fout(FoutType.AUTHORISATIE, eppRequest.getClTRID(), EPPcodeType.EPP_2002, FoutMeldingType.LOGIN_NOG_NIET_INGELOGD.getMsg());
	}


	/**
	 * Verstuur een foutmelding naar de client, de parser heeft fouten gevonden.
	 * Dit kan zijn omdat het een login was en de login gegevens zijn niet gevonden.
	 * Het kan ook zijn dat de XML niet correct was. 
	 * @param eppRequest het (deels) geparste bericht
	 * @return een response voor de client met een foutmelding.
	 */
	private String parseFout(){
		assert eppRequest != null;
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("handleParserFout(" + eppRequest + ")");
		}
		
		if(eppRequest.getRequestType() == EPPRequestType.LOGIN &&
				(eppRequest.getUser() == null || eppRequest.getPw() == null)){
			
			//de login gegevens missen.
			return fout(FoutType.PARSE, eppRequest.getClTRID(), EPPcodeType.EPP_2001, FoutMeldingType.PARSE_GEEN_CLID_OF_PW.getMsg());
		}else{
			//generieke parse fout
			return fout(FoutType.PARSE, eppRequest.getClTRID(), EPPcodeType.EPP_2001,eppRequest.getParseFout() );	
				
		}
	}
	
	
	/** 
	 * Bij een login request moet aan de hand van de
	 * resultaat codes worden gecontroleerd of de login is gelukt.
	 * 
	 * Als de http resultaat code 200 is en de EPP resultaat code begint met een 1 (1xxx)
	 * dan is het resultaat OK
	 * 
	 *  @return De PA response van een succesvolle login of een foutmelding.
	 */
	private String login() {
		assert eppRequest != null;
		
		/* controleer of de client al ingelogd is. Als dat zo is
		 * dan moet er een EPP 2002 naar de client worden verstuurd.
		 */
		if(sessie.isLoggedIn()){
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Gebruiker " + eppRequest.getUser() + " is al ingelogd");
			}
			//gebruiker is al ingelogd verstuur foutmelding
			
			return fout(FoutType.LOGIN, eppRequest.getClTRID(), EPPcodeType.EPP_2002, FoutMeldingType.LOGIN_REEDS_INGELOGD.getMsg());
		}
		
		//Bewaar de username en password voor volgende requests 
		sessie.setUser(eppRequest.getUser());
		sessie.setPw(eppRequest.getPw());
		
		//verstuurd het login command naar de PA
		command();
		
		/*
		 * Controleer of de EPP status 1xxx is.
		 */
		if(isEppResponseOk(response.getEppResponseCode())){
			//login is gelukt
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Gebruiker " + eppRequest.getUser() + " is ingelogd");
			}
			sessie.loggedIn();
			
			/* zet de JSESSIONID in de sessie zodat de volgende requests bij dezelfde protocol
			 * adapter instatie uitkomen.
			 */
			sessie.setHttpSessionId(response.getHttpSessieId());
			
			return response.getResponse();
		}
		
		//login is mislukt
		LOGGER.error("Inloggen Gebruiker " + eppRequest.getUser() + " is mislukt");
			
		//reset de sessie gegevens
		sessie.loggedOut();
		
		/* kijk of de PA een nette foutmelding terug heeft gestuurd, geef deze dan 
		 * door aan de client. Als dit niet het geval is roep dan de fout methode
		 * aan op de PA voor een fout bericht.
		 */
		if(response.getResponse() != null){
			return response.getResponse();
		}

		return fout(FoutType.LOGIN, eppRequest.getClTRID(), EPPcodeType.EPP_2200, FoutMeldingType.LOGIN_ONGELDIGE_USER_PASSWORD.getMsg());

	}
	
	/**
	 * Verstuur een logout request naar de PA.
	 * Na een logout wordt de connectie van de SA met
	 * de client gesloten
	 * @return antwoord van de PA of fout response.
	 */
	private String logout() {
		assert eppRequest != null;
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("logout(sessie = " + sessie.getId() + ", user = " + sessie.getUser());
		}
		
		/*
		 * controleer eerst of er wel een ingelogde sessie aanwezig is
		 * als dat niet zo is dan foutmelding geven
		 */
		if(!sessie.isLoggedIn()){
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug("Gebruiker is niet ingelogd");
			}
			return fout(FoutType.LOGIN, eppRequest.getClTRID(), EPPcodeType.EPP_2002, FoutMeldingType.LOGOUT_NOG_NIET_INGELOGD.getMsg());
		}
		
		PARequest req = new PARequest().
		addPath(EPPRequestType.LOGOUT.getPath()).
			addEppRequest(eppRequest.getOrigineel()).
			addSessieId(sessie.getId()).
			addClTRID(eppRequest.getClTRID()).
			addIpaddress(sessie.getIpaddress()).
			addHttpSessieId(sessie.getHttpSessionId());

		response = ProtocolAdapterClient.getInstance(productie).doHttpGet(req);
		
		/* controller aan de hand van de epp response code
		 * of het uitloggen is gelukt. als dat het geval is
		 * dan moeten de user/pw info gereset worden
		 */
		if(isEppResponseOk(response.getEppResponseCode())){
			sessie.loggedOut();
		}
		return response.getResponse();
		
	}
	
	/**
	 * Verstuur een hello request naar de PA om een greeting te kunnen
	 * versturen naar de client.
	 * @return response van de PA met een greeting of een foutmelding.
	 */
	private String greet() {
		
		PARequest req = new PARequest().
			addPath(EPPRequestType.HELLO.getPath()).
			addEppRequest(Instellingen.getEppHello()).
			addSessieId(sessie.getId()).
			addIpaddress(sessie.getIpaddress()).
			addHttpSessieId(sessie.getHttpSessionId());
	
		response = ProtocolAdapterClient.getInstance(productie).doHttpGet(req);
		return response.getResponse();
	}
	
	/**
	 * Verstuur een extension request naar de PA om een extension te kunnen
	 * versturen naar de client.
	 * 
	 * @return response van de PA met het resultaat van de extension.
	 */
	private String extension() {
        PARequest req = new PARequest().
            addPath(EPPRequestType.EXTENSION.getPath()).
            addEppRequest(eppRequest.getOrigineel()).
            addUsername(sessie.getUser()).
            addPassword(sessie.getPw()).
            addClTRID(StringUtils.trimToEmpty(eppRequest.getClTRID())).
            addSessieId(sessie.getId()).
			addIpaddress(sessie.getIpaddress()).
            addHttpSessieId(sessie.getHttpSessionId());
        
        response = ProtocolAdapterClient.getInstance(productie).doHttpPost(req);
        return response.getResponse();        
	}
	
	/**
	 * Verstuur een fout situatie naar de PA, de PA zal een net fout bericht maken
	 * voor de SA client.
	 * @param fout de specifieke fout, afhankelijk van deze fout wordt een bepaalde /error url
	 * op de PA aangeroepen.
	 * @param clTRID de clTRID uit het client request. 
	 * @param code de EPP foutcode voor in het fout bericht.
	 * @param msg Een leesbare fout message welke in het fout bericht moet worden opgenomen.
	 * @return fout bericht.
	 */
	protected String fout(FoutType fout, String clTRID, EPPcodeType code, String msg) {
		assert fout != null;
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("verstuurFout( fout=" + fout + ", clTRID=" + clTRID + ", code=" + code + ", msg=" + msg);
		}
		
		
		String cleanClTRID = StringUtils.trimToEmpty(clTRID);
		String cleanMsg = StringUtils.trimToEmpty(msg);
		
		PARequest req = new PARequest().
			addPath(fout.getPath()).
			addParam("code",code.getCode()).
			addParam("clTRID", cleanClTRID).
			addParam("msg",cleanMsg).
			addSessieId(sessie.getId()).
			addUsername(sessie.getUser()).
			addPassword(sessie.getPw()).
			addIpaddress(sessie.getIpaddress()).
			addHttpSessieId(sessie.getHttpSessionId());
	
		try {
			response = ProtocolAdapterClient.getInstance(productie).doHttpGet(req);
		} catch (HttpException e) {
			LOGGER.error("Het aanroepen van de fout url op de protocol adapter is mislukt.");
			/* er is een fout opgetreden tijdens aanroepen fout url op de PA
			 * ga nu hieronder verder met het zelf fabrieken van een foutmelding
			 * als backup strategie.
			 */
			if(response == null){
				response = new PAResponse();
			}
			
			//fout aanroep bij de PA is mislukt, maakt een simpel antwoord bericht hier als backup strategie.
			
			LOGGER.error("Aanroepen fout url op de PA is mislukt, stuur een simpele foutmelding naar de client.");
			
			/* maak de default fout response door de template placeholder te
			 * vervangen door de echte values*/ 
			String foutResponse = Instellingen.getEppStandaardFout().
					replace("#code#", code.getCode()).
					replace("#msg#", cleanMsg).
					replace("#clTRID#", cleanClTRID);
			
			response.setResponse(Instellingen.getEppHeader() + foutResponse);
		}
		
		return response.getResponse();
	}
	
	
	/**
	 * Verstuur een command request naar de SA.
	 * Voor het kunnen uitvoeren van een command is vereist dat
	 * er eerst is ingelogd. 
	 * @return response van de PA met een ok of fout bericht.
	 */
	private String command() {
		assert eppRequest != null;
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("verstuurCommandRequest( sARequest=" + eppRequest + " )");
		}
		PARequest req = new PARequest().
			addPath(eppRequest.getRequestType().getPath()).
			addEppRequest(eppRequest.getOrigineel()).
			addUsername(sessie.getUser()).
			addPassword(sessie.getPw()).
			addClTRID(StringUtils.trimToEmpty(eppRequest.getClTRID())).
			addSessieId(sessie.getId()).
			addIpaddress(sessie.getIpaddress()).
			addHttpSessieId(sessie.getHttpSessionId());
		
		response = ProtocolAdapterClient.getInstance(productie).doHttpPost(req);
		return response.getResponse();
	}
	
	/**
	 * Controleer het antwoord van de protocol adapter om te zien
	 * of er een fout is opgetreden en of de connectie gesloten 
	 * moet worden.
	 * 
	 * De connectie wordt gesloten als de PA de Connection of X-Connections
	 * header met de waarde "close" heeft meegestuurd.
	 * Of als het 2e cijfer van de X-F5-EPP-Code header met de epp response code
	 * een 5 bevat. 
	 */
	public boolean connectieSluiten() {
		//assert response != null;
		
		if(response.isConnectieSluiten()){
			//de PA heeft aangegegeven dat de connectie gesloten dient te worden
			return true;
		}
		
		/* controleer de uitkomst van het EPP process, als de EPP code
		 * voldoet aan het masker x5xx dan moet de binnenkomende TCP
		 * connectie ook worden gesloten.
		 */
		return StringUtils.indexOf(response.getEppResponseCode(), "5") == 1;
	}
	
	/**
	 * Controleert of de protocol adapter of de load balancer aangeeft dat
	 * de connectie gesloten moet worden (EPP response code begint met 25).
	 * In dat geval moet ook de sessie opgeruimd worden.
	 */
	public void ruimSessieOpAlsNodig() {
		if (response.getEppResponseCode().startsWith("25")) {
			sessie.loggedOut();
		}
	}
	
	/**
	 * Als er een interne fout optreed in de SA dan moet deze een EPP 2400 
	 * naar de client versturen.
	 * @return EPP 2400 fout bericht.
	 */
	public String interneFout(){
		String clTRID = (eppRequest != null)?eppRequest.getClTRID():""; 
		return fout(FoutType.INTERNAL, clTRID ,  EPPcodeType.EPP_2400, FoutMeldingType.INTERNE_FOUT.getMsg());
	}
	
	private String greetingFout(){
		return fout(FoutType.INTERNAL, "",  EPPcodeType.EPP_2400, FoutMeldingType.GREETING.getMsg());
	}
	
	/** 
	 * EPP response codes die beginnen met "1" worden gebruikt in 
	 * ok situaties. 
	 * @param responseCode
	 * @return true als response code format is 1xxx
	 */
	protected boolean isEppResponseOk(String responseCode){
		return StringUtils.startsWith(responseCode, EPP_RESULTAAT_CODE_SERIE_OK );
	}

	protected PAResponse getResponse() {
		return response;
	}

	protected void setResponse(PAResponse response) {
		this.response = response;
	}
}
