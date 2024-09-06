/*
 * $Id: SocketServerPipelineFactory.java 23976 2011-05-18 13:23:33Z maarten $
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

import static org.jboss.netty.channel.Channels.pipeline;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import nl.sidn.eppadapter.support.Instellingen;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.handler.codec.frame.LengthFieldBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.LengthFieldPrepender;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.handler.execution.ExecutionHandler;
import org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor;

/**
 * Factory class welke een pipeline bouwt voor een socket connectie.
 * De pipeline modeleert de stappen welke de door de socket
 * ontvangen data doorloopt.
 *
 */
public class SocketServerPipelineFactory implements ChannelPipelineFactory {
	
	private static final Logger LOGGER = Logger.getLogger(SocketServerPipelineFactory.class);
    
	private ExecutionHandler execHandler;
	
	private boolean productie;
    
	//maximale lengte van een binnenkomend epp xml bericht.
    private static final int EPP_MAX_FRAME_SIZE = 65536;
    
    /* 
     * de instellingen voor het vinden en afknippen van de 4 byte lengte
     * prefix die voor elk epp xml bericht zit geplakt. 
     */
    private static final int EPP_LENGTH_SIZE = 4;
    private static final int EPP_LENGTH_OFFSET = 0;
    private static final int EPP_LENGTH_ADJUST = -4;

	/*
	 * static stringdecoders ivm performance, string en/decoders kunnen
	 * threadsafe gedeeld worden door verschillende pipelines.
	 */
	private static final ChannelHandler STR_DECODER = new StringDecoder();
	private static final ChannelHandler STR_ENCODER = new StringEncoder();
	
	/* Maak een ExecutorService met een threadpool van 10, deze threads
	 * worden gebruikt door de SocketServerHandler om tijdens het starten
	 * van de socket connectie de boss thread zo snel mogelijk weer
	 * vrij te geven.
	 */
    private static final int CONNECT_EXECUTER_POOL = 10;
	private static ExecutorService executorService = Executors.newFixedThreadPool(CONNECT_EXECUTER_POOL);

	public SocketServerPipelineFactory(boolean productie) {
		this.productie = productie;
		/* De execHandler zorgt ervoor dat ontvangen requests in de juiste
		 * volgorde worden uitgevoerd.
		 * De execHandler heeft een interne threadpool die niet door WLS wordt
		 * gemanaged, dit is opzich geen probleem.
		 */
		execHandler = new ExecutionHandler(new OrderedMemoryAwareThreadPoolExecutor(Instellingen.getSocketThreadpoolSize(), Instellingen.getSocketThreadMaxMemSize(),
				Instellingen.getSocketThreadMaxMemSize()));
	}

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("Bouw nieuwe pipeline voor tcp connectie");
		}
		ChannelPipeline pipeline = pipeline();
		/*
		 * Hander welke zorgt voor het decoderen van EPP requests. Deze handler is statefull, niet delen over meedere requests.
		 * De eerste 4 bytes van een EPP request bevatten de lengte van het bericht deze moeten verwijderd worden van het bericht.
		 * 
		 *  lengthFieldOffset = 0, lengthFieldLength = 4, lengthAdjustment = -4, initialBytesToStrip = 4 (= the length of the Length field)
		 *	
		 *	BEFORE DECODE (14 bytes)         AFTER DECODE (10 bytes)
		 *	+--------+----------------+      +----------------+
		 *	| Length | Actual Content |----->| Actual Content |
		 *	| 0x000E | "HELLO, WORLD" |      | "HELLO, WORLD" |
		 *	+--------+----------------+      +----------------+
		 */
		pipeline.addLast(ChannnelHandlerType.DECODER.toString(), new LengthFieldBasedFrameDecoder(EPP_MAX_FRAME_SIZE,
				EPP_LENGTH_OFFSET, EPP_LENGTH_SIZE, EPP_LENGTH_ADJUST, EPP_LENGTH_SIZE));
		/*
		 * Encoder welke de lengte van de response in de 1e vier bytes van teruggestuurde antwoord zet.
		 * 
		 *   10 bytes             			14 bytes
		 *   +----------------+				+-------------------------+
		 *	 | "HELLO, WORLD" |-----> 		 4 bytes   10 bytes
		 *	 +----------------+				+--------+----------------+
		 *									+ 0x000E | "HELLO, WORLD" |
		 *   								+--------+----------------+
		 */
		pipeline.addLast(ChannnelHandlerType.ENCODER.toString(), new LengthFieldPrepender(EPP_LENGTH_SIZE, true));
		/*
		 * handler die ervoor zorgt dat alle requests als een String te lezen zijn door de server.
		 */
		pipeline.addLast(ChannnelHandlerType.STRINGDECODER.toString(), STR_DECODER);
		/*
		 * Handler die ervoor zorgt dat de output als tekst naar de client wordt verstuurd
		 */
		pipeline.addLast(ChannnelHandlerType.STRINGENCODER.toString(), STR_ENCODER);
		/*
		 * voeg een executer toe die ervoor zorgt dat langdurende
		 * taken niet op de io thread en in de juiste volgorde worden uitgevoerd
		 */
		pipeline.addLast(ChannnelHandlerType.EXECUTORHANDLER.toString(), execHandler);
		/*
		 * Hieronder wordt de handler toegevoegd welke verantwoordelijk is voor
		 * het afhandelen van requests.
		 */
		pipeline.addLast(ChannnelHandlerType.SOCKETSERVERHANDLER.toString(), new SocketServerHandler(executorService, productie));
		return pipeline;
	}

}
