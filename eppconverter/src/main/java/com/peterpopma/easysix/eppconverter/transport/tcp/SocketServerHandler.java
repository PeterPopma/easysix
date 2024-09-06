/*
 * $Id: SocketServerHandler.java 23976 2011-05-18 13:23:33Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.transport.tcp;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;

import nl.sidn.eppadapter.logic.EPPProtocolHandler;
import nl.sidn.eppadapter.servlet.EPPAdapterListener;

import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * 
 * Deze class is verantwoordelijk voor het afhandelen van ontvangen socket requests
 * Voor elke socket verbinding wordt door de pipeline factory een instantie
 * van deze class gemaakt om de connectie af te handelen.
 * Deze handler moet in een eigen thread worden gestart.
 * 
 */
public class SocketServerHandler extends SimpleChannelHandler {

	private static final Logger LOGGER = Logger.getLogger(SocketServerHandler.class);

	
	/* de EPPProtocolHandler is een delegate die verantwoordelijk
	 * is voor het afhandelen van het EPP protocol.
	 */
	private EPPProtocolHandler protocolHandler;
	private ExecutorService executorService;
	
	
	public SocketServerHandler(ExecutorService executorService, boolean productie){
		this.protocolHandler = new EPPProtocolHandler(productie);
		this.executorService = executorService;
	}

	/**
	 * Wordt aangeroepen op het moment dat de client een socket verbinding
	 * start.  
	 * Er wordt geen controle gedaan op het totaal aan connecties van een registrar of
	 * van alle registrars samen. Ook de levensduur van de sessie wordt niet gelimiteerd.
	 * Dit wordt allemaal door de loadbalancer F5 gedaan.
	 * 
	 * LET OP: deze methode wordt aangeroepen door de boss thread, zolang deze methode wordt
	 * uitgeveord door de boss thread kan de boss thread geen andere dingen doen zoals het starten
	 * van nieuwe connecties voor andere gebruikers.
	 * Daarom zal deze methode een nieuwe thread starten om het werk behorende bij het 
	 * starten van een nieuwe connectie uit te voeren.
	 * 
	 */
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		LOGGER.info("channelOpen() voor peer " + ctx.getChannel().getRemoteAddress());
		
		/* als channel open success, dan aan lijst van alle channels toevoegen
		 * een gesloten channel wordt automatisch verwijderd uit de channel group.
		 */
		EPPAdapterListener.addChanneltoGroup(e.getChannel());
		
		//maak een runneable om de connectie initiatie mee af te handelen
		ConnectionStarter cs = new ConnectionStarter(e.getChannel(), protocolHandler, this);
		//vraag de excuter om de connectie te starten op een andere thread
		executorService.execute(cs);
		
		//de boss thread hoeft niet te wachten op het resultaat en kan weer verder gaan nu. 
	}

	private void verstuurResponse(Channel channel, String response) {
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("verstuurResponse( response=" + response + " )");
		}
		if(response == null){
		    LOGGER.error("Socket adapter heeft null als response ontvangen");
		    /* sluit socket als er geen response is ontvangen. dit mag nooit voorkomen
		     * onmdat in een fout dituatie de response altijd een foutmelding
		     * moet bevatten. Deze if toch als extra controle toegeveoegd igg van programmeerfouten
		     */
		    schrijfDataWegEnSluitConnectie(channel);
		}else if(channel.isOpen() && channel.isConnected()){
		    /* 
		     * als de client de verbinding niet heeft gesloten schrijf dan
	         * het antwoord terug in de socket
	         */
			channel.write(response);
    		if (protocolHandler.connectieSluiten()) {
    		    //de socket moet gesloten worden nadat het antwoord verstuurd is.
    			schrijfDataWegEnSluitConnectie(channel);
    			protocolHandler.ruimSessieOpAlsNodig();
    		}
		}else{
		    LOGGER.error("Socket verbinding gesloten voordat antwoord teruggestuurd kon worden");
		}
	}
	
	private void schrijfDataWegEnSluitConnectie(Channel ch) {
	    if (ch.isOpen() && ch.isConnected()) {
            ch.write(ChannelBuffers.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }
	} 

	

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
		long startTime = 0;
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("messageReceived()");
			startTime = System.currentTimeMillis();
		}

		// haal het request op, is gedecodeerd naar een string in de pipeline
		String request = (String) e.getMessage();
		
		String response = null;
		try {
			response = protocolHandler.verwerkRequest(request);
		//CHECKSTYLE:OFF	
		} catch (Exception ex) {
		//CHECKSTYLE:ON
			LOGGER.error("Interne fout opgetreden, stuur EPP 2400 terug", ex);
			response = protocolHandler.interneFout();
		}
		
		verstuurResponse(e.getChannel(), response);

		// voor tracking de doorloop tijd van een request tonen
		if (LOGGER.isDebugEnabled()) {
			long endTime = System.currentTimeMillis();
			LOGGER.debug("messageReceived() doorlooptijd: " + (endTime - startTime));
		}
	}
	
	/**
	 * Handel excepties af die worden gegooid terwijl het request in de 
	 * pipeline wordt afgehandeld.
	 * Niet alle excepties leiden tot het sluiten van de socket
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
		LOGGER.error("Exception opgetreden, sluit connectie.", e.getCause());
		e.getChannel().close();
	}

	@Override
	public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		super.channelDisconnected(ctx, e);
		
		LOGGER.debug("channelDisconnected() voor peer " + e.getChannel().getRemoteAddress());
	}

	/**
	 * De ConnectionStarter is een Runnable welke in een aparte thread een 
	 * connectie opstart. Dit wordt in een aparte thread gedaan omdat het opstarten
	 * van een connectie wordt geiniteerd door de boss thread. Deze boss thread blokkeerd
	 * totdat de connectie is geinitieerd (epp adapter -> protocol adapter -> DRS kern (en weer terug))
	 * Om de hoeveelheid tijd dat de boss thread wordt geblokkeerd zo klein mogelijk te houden
	 * zal de boss thread deze ConnectionStarter afvuren en meteen daarna doorgaan en niet wachten
	 * op het antwoord.
	 *
	 */
	private class ConnectionStarter implements Runnable{
		
		private Channel channel;
		private EPPProtocolHandler protocolHandler;
		private SocketServerHandler handler;
		
		public ConnectionStarter(Channel channel, EPPProtocolHandler protocolHandler, SocketServerHandler handler) {
			this.channel = channel;
			this.protocolHandler = protocolHandler;
			this.handler = handler;
		}

		@Override
		public void run() {
			
			/* bij elke nieuwe verbinding de socketadapter starten
			 * Dit zorgt er automatisch voor dat er een EPP greeting wordt
			 * verstuurd naar de client.
			 */
			String response = protocolHandler.start((InetSocketAddress) channel.getRemoteAddress());
						handler.verstuurResponse(channel, response);
		}
		
	}
	
}
