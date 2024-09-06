/*
 * $Id: IdleConnectionMonitorThread.java 24539 2011-07-12 11:29:03Z maarten $
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

import org.apache.http.conn.ClientConnectionManager;
import org.apache.log4j.Logger;

/**
 * Deze class controleert op bepaalde intervallen of
 * de connecties in de http connectie pool niet expired zijn geraakt.
 * 
 * Dit kan gebeuren doordat de andere kant (PA) de http connectie heeft
 * gesloten. 
 * 
 * Dit is de meeste efficiente manier om deze controle te doen. Anders
 * moet het bij elk http request worden gedaan en levert dat een extra
 * overheid van 30ms per request op.
 * 
 *
 */
public class IdleConnectionMonitorThread extends Thread {

	private static final Logger LOGGER = Logger.getLogger(IdleConnectionMonitorThread.class);

	private final ClientConnectionManager connMgr;
	private final long waitTime;
	private volatile boolean shutdown;

	public IdleConnectionMonitorThread(ClientConnectionManager connMgr,	long waitTime) {
		super();
		this.waitTime = waitTime;
		this.connMgr = connMgr;
	}

	@Override
	public void run() {
		try {
			while (!shutdown) {
				synchronized (this) {
					wait(waitTime);
					if(LOGGER.isDebugEnabled()){
						LOGGER.debug("Start controle op idle connections.");
					}
					/*
					 * Sluit http connecties die ondertussen door de WLS server
					 * aan de PA kant zinj gesloten.
					 */
					connMgr.closeExpiredConnections();
					if(LOGGER.isDebugEnabled()){
						LOGGER.debug("Einde controle op idle connections.");
					}
				}
			}
		} catch (InterruptedException ex) {
			LOGGER.error("De idle connection monitor was interrupted.");
		}
	}

	public void shutdown() {
		shutdown = true;
		synchronized (this) {
			notifyAll();
		}
	}

}
