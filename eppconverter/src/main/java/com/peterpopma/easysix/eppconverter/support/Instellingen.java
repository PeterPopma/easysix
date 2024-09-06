/*
 * $Id: Instellingen.java 24539 2011-07-12 11:29:03Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Alle instellingen waarmee de SA geconfigureerd kan worden, zijn
 * in deze class bij elkaar geplaatst.
 * 
 * Tijdens het starten van de SA worden de instellingen 1x geladen.
 *
 */
public final class Instellingen {
	
	private static final Logger LOGGER = Logger.getLogger(Instellingen.class);
	
	private static final String INSTELLINGEN_PROPERTIES = "eppadapter.properties";
	private static Properties properties;
	
	private static String versie = "1.0";
	
	//instellingen voor de binnenkomende TCP connecties
	private static int tcpPort;
	/* Het aantal milliseconden voordat het opbouwen van een nieuwe
	 * inkomende tcp socket een timeout exceptie moet krijgen.
	 */
	//instellingen voor de binnenkomende TCP connecties op de admin poort
	private static int tcpAdminPort;
	private static int tcpConnectTimeout;

	private static int maxWorkerThreads;
	
	//instellingen voor de HTTP connecties naar de protocol adapter
	private static String httpHost;
	private static int httpPort;
	private static int httpAdminPort;
	private static int httpConnectionPoolSize;
	private static String httpScheme = "http";
	/* Het aantal minuten dat een http connectie tussen de
	 * SA en de PA open mag blijven voor hergebruik.
	 * http connectie keepalive, default van WLS is 30 minuten
	 * zorg dat de httpKeepAlive < 30 minuten is.
	 */
	private static int httpKeepAlive;
	//aantal seconden tussen controles op gesloten conencties.
	private static long httpConnectionMonitor;
	//timeout voor connecties naar de PA, in milliseconden
	private static int httpTimeout;
	//timeout tijdens wachten op data van de PA in milliseconden
	private static int httpReadTimeout;
	
	
	private static String encoding = "UTF-8";
	
	//instellingen voor de netty thread executor
	private static int socketThreadpoolSize;
	//De maximale hoeveelheid geheugen die door een enkele thread gebruikt mag worden
	private static long socketThreadMaxMemSize;
	//De maximale totale hoeveelheid geheugen die door alle threads gebruikt mag worden
    private static long socketPoolMaxMemSize;
    
    //epp hello request
    private static String eppHello;
    //epp standaard fout header
    private static String eppHeader;
    private static String eppStandaardFout;
    
    private Instellingen(){};
	
	/**
	 * laad de properties file met de instellingen
	 * deze socketadapter.properties moet ergens op
	 * het CLASSPATH staan.
	 */
    public static void init(){
    	
		properties = new Properties();
		
		try {
			properties.load(new FileInputStream(INSTELLINGEN_PROPERTIES));
			laadInstellingen();
		} catch (FileNotFoundException e) {
			LOGGER.error("Het socket adapter properties bestand kan niet gevonden worden: \"" + INSTELLINGEN_PROPERTIES + "\"");
		} catch (IOException e) {
			LOGGER.error("Fout tijdens het laden van de socket adapter properties: \"" + INSTELLINGEN_PROPERTIES + "\"");
		}catch(ConfiguratieException e){
			LOGGER.error("Fout tijdens het laden van de socket adapter property", e);
		}
		
	}
	
	/**
	 * Laad de verschillende instelling uit de property file.
	 * Als een property niet gevonden wordt en er is geen
	 * default waarde aanwezig dan wordt een ConfiguratieException
	 * gegooid.
	 */
	private static void laadInstellingen(){
		LOGGER.info("Start laden configuratie");
		
		versie = laadString("versie", "");
		//laad inkomende tcp settings
		tcpPort = laadInt("tcpPort", "700");
		
		tcpAdminPort = laadInt("tcpAdminPort", "7777");
		
		maxWorkerThreads = laadInt("maxWorkerThreads", "500");
		
		tcpConnectTimeout = laadInt("tcpConnectTimeout", "100");
		//laad http settings
		httpHost = laadString("httpHost", "");
		httpPort = laadInt("httpPort", "7001");
		httpAdminPort = laadInt("httpAdminPort", "9001");
		httpConnectionPoolSize = laadInt("httpConnectionPoolSize", "200");
		httpScheme = laadString("httpScheme", "http");
		httpKeepAlive = laadInt("httpKeepAlive", "25");
		httpConnectionMonitor = laadInt("httpConnectionMonitor", "5");
		httpTimeout = laadInt("httpTimeout", "5000");
		httpReadTimeout = laadInt("httpReadTimeout", "60000");
	
		encoding = laadString("encoding", "UTF-8");
		
		//laad de netty thread instellingen
		socketThreadpoolSize = laadInt("socketThreadpoolSize", "75");
		socketThreadMaxMemSize = laadInt("socketThreadMaxMemSize", "1048576");
		socketPoolMaxMemSize = laadInt("socketPoolMaxMemSize", "1048576");
		
		eppHello = laadString("eppHello", "");
		eppHeader = laadString("eppHeader", "");
		eppStandaardFout = laadString("eppStandaardFout", "");

		LOGGER.info("Klaar met laden configuratie");
	}
	
	private static int laadInt(String naam, String defaultValue){
		String val = null;
		try {
			val = StringUtils.trimToEmpty(properties.getProperty(naam, defaultValue));
			int intVal = Integer.parseInt(val);
			LOGGER.info(naam + ": " + intVal);
			return intVal;
		} catch (NumberFormatException e) {
			throw new ConfiguratieException(naam + " is geen geldig getal: " + val);
		}
	}
	
	private static String laadString(String naam, String defaultValue){
		String val = StringUtils.trimToEmpty(properties.getProperty(naam, defaultValue));
		LOGGER.info(naam + ": " + val);
		if(StringUtils.length(val) == 0){
			throw new ConfiguratieException(naam + " is niet ingevuld");
		}
		
		return val;
	}
	
	
	public static int getTcpPort() {
		return tcpPort;
	}

	public static String getHttpHost() {
		return httpHost;
	}
	public static int getHttpPort() {
		return httpPort;
	}
	public static int getHttpConnectionPoolSize() {
		return httpConnectionPoolSize;
	}
	public static String getHttpScheme() {
		return httpScheme;
	}
	public static String getEncoding() {
		return encoding;
	}
	public static String getVersie() {
		return versie;
	}
	public static int getHttpKeepAlive() {
		return httpKeepAlive;
	}
	public static long getHttpConnectionMonitor() {
		return httpConnectionMonitor;
	}
	public static int getHttpTimeout() {
		return httpTimeout;
	}
	public static int getHttpReadTimeout() {
		return httpReadTimeout;
	}
	public static int getTcpConnectTimeout() {
		return tcpConnectTimeout;
	}

	public static int getSocketThreadpoolSize() {
		return socketThreadpoolSize;
	}

	public static long getSocketThreadMaxMemSize() {
		return socketThreadMaxMemSize;
	}

	public static long getSocketPoolMaxMemSize() {
		return socketPoolMaxMemSize;
	}

	public static String getEppHello() {
		return eppHello;
	}

	public static String getEppHeader() {
		return eppHeader;
	}

	public static String getEppStandaardFout() {
		return eppStandaardFout;
	}

	public static int getMaxWorkerThreads() {
        return maxWorkerThreads;
    }

	public static int getTcpAdminPort() {
		return tcpAdminPort;
	}

	public static int getHttpAdminPort() {
		return httpAdminPort;
	}

}
