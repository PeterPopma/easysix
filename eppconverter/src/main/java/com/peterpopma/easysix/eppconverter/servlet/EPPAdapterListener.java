/*
 * $Id: EPPAdapterListener.java 24539 2011-07-12 11:29:03Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.servlet;

import java.net.InetSocketAddress;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import nl.sidn.eppadapter.support.Instellingen;
import nl.sidn.eppadapter.transport.http.ProtocolAdapterClient;
import nl.sidn.eppadapter.transport.tcp.SocketServerPipelineFactory;

import org.apache.log4j.Logger;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

/**
 * Implementatie class van een servlet context listener. Deze class start de
 * Netty socket library op. Er worden 2 thread pools gebruikt: 1) boss pool,
 * deze threads handelen de inkomende connectie verzoeken af, en geven deze door
 * aan een worker uit de worker pool. 2) worker pool, elke thread in deze pool
 * verwerkt 1 connectie.
 */
public class EPPAdapterListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(EPPAdapterListener.class);

    /*
     * Geeft aan hoe het duurt voor een niet gebruikte thread in een thread pool
     * opgeruimd moet worden. (alleen als er meer threads zijn dan het mimimaal
     * aantal geconfigureerde threads, worden er niet gebruikte threads
     * opgeruimd)
     */
    private static final int THREAD_KEEPALIVE_SECONDS = 75;

    /* er is altijd maar 1 boss thread, want er is maar 1 server socket actief */
    private static final int MAX_BOSS_THREADS = 1;
    private static final int MIN_WORKER_THREADS = 200;

    /*
     * Groupeer alle channels (connecties) om groups acties te kunnen uitvoeren.
     */
    private static final ChannelGroup ALLCHANNELS = new DefaultChannelGroup("socket-connections");

    private ChannelFactory channelFactory;

    private ArrayBlockingQueue<Runnable> bossRequestQueue;
    private ArrayBlockingQueue<Runnable> workerRequestQueue;

    @Override
    public void contextInitialized(ServletContextEvent ctxe) {
        LOGGER.info("******* Start EPPAdapterListener *******");

        // laad de configuratie
        Instellingen.init();
        // start de server voor binnenkomende connecties.
        startServer(Boolean.TRUE);
        // start admin poort
        startServer(Boolean.FALSE);
        // start de client voor uitgaande http connecties
        ProtocolAdapterClient.start();

        LOGGER.info("******* Klaar met starten EPPAdapterListener *******");
    }

    /**
     * Stop de resource adapter, dit is een callback van WLS Zorg ervoor dat
     * alle resources worden vrijgegeven en zonodig opgeruimd worden.
     */
    @Override
    public void contextDestroyed(ServletContextEvent ctxe) {
        stopServer();
    }

    public void stopServer() {
        LOGGER.info("******* Start stoppen EPPAdapterListener *******");
        // sluit alle inkomende tcp connections
        sluitAlleBestaandeConnecties();
        // sluit alle http connecties naar de PA
        ProtocolAdapterClient.getInstance(Boolean.TRUE).stop();
        // sluit ook de admin poort.
        ProtocolAdapterClient.getInstance(Boolean.FALSE).stop();
        LOGGER.info("******* Einde stoppen EPPAdapterListener *******");
    }

    /**
     * Start de server. De server start een server socket en begint te luisteren
     * op de geconfigureerde poort.
     */
    public void startServer(boolean productie) {
        /*
         * worker thread moet meteen doorgaan met opvangen van nieuwe
         * connecties, niet wachten totdat de worker gestart is. De
         * workerExecuter wordt gebruikt om de IO taken van accepted channels
         * uit te voeren. Maak een boss en een worker executer aan, blokkeer tot
         * de executers daadwerkelijk als thread draaien. De bossExecuter wordt
         * gebruikt als thread voor de server socket deze is verantwoordelijk
         * voor het opzetten van een connectie en geeft deze daarna door aan een
         * worker thread.
         */
        bossRequestQueue = new ArrayBlockingQueue<Runnable>(MAX_BOSS_THREADS);
        workerRequestQueue = new ArrayBlockingQueue<Runnable>(Instellingen.getMaxWorkerThreads());

        Executor bossExecuter = new ThreadPoolExecutor(MAX_BOSS_THREADS, MAX_BOSS_THREADS, THREAD_KEEPALIVE_SECONDS, TimeUnit.SECONDS, bossRequestQueue);

        Executor workerExecuter = new ThreadPoolExecutor(MIN_WORKER_THREADS, Instellingen.getMaxWorkerThreads(), THREAD_KEEPALIVE_SECONDS, TimeUnit.SECONDS, workerRequestQueue);

        channelFactory = new NioServerSocketChannelFactory(bossExecuter, workerExecuter);
        ServerBootstrap bootstrap = createBootstrap(productie, channelFactory);
        
        // start de server.
        Channel serverChannel = null;
        if (productie) {
            serverChannel = bootstrap.bind(new InetSocketAddress(Instellingen.getTcpPort()));
        } else {
            serverChannel = bootstrap.bind(new InetSocketAddress(Instellingen.getTcpAdminPort()));
        }
        /*
         * Voeg de serverchannel aan de channelgroep toe, zodat de server
         * channel samen met alle accepted channels in 1x gesloten kan worden
         */
        addChanneltoGroup(serverChannel);
    }

    private ServerBootstrap createBootstrap(boolean productie, ChannelFactory channelFactory) {
        ServerBootstrap bootstrap = new ServerBootstrap(channelFactory);
        /*
         * Configure the pipeline factory. als productie == true dan wordt er
         * een pipeline naar de PA op de standaard poort gemaakt. anders een
         * pipelinen naar de PA op de admin poort.
         */
        bootstrap.setPipelineFactory(new SocketServerPipelineFactory(productie));

        /*
         * maak een server socket welke naar binnenkomende socket requests zal
         * luisteren als er een request wordt ontvangen zal de server socket
         * hier een nieuw accepted channel voor maken, deze zal op een eigen
         * thread het request afhandelen. onderstaande opties gelden alleen voor
         * de accepted sockets omdat "child." wordt gebruikt als prefix.
         * child.tcpNoDelay = geen Nagle algoritme gebruiken, data moet meteen
         * verstuurd worden zie voor meer info:
         * http://en.wikipedia.org/wiki/Nagle's_algorithm child.keepAlive =
         * verstuur na een langere periode van inactiviteit een keepalive test
         * om te controleren of de client nog reageert. Bij geen reactie van de
         * client wordt de connectie gesloten. child.connectTimeoutMillis = als
         * na een bepaalde tijd (100ms)de connect actie niet is gelukt, dan de
         * connect actie stoppen.
         */
        bootstrap.setOption("child.tcpNoDelay", true);
        bootstrap.setOption("child.keepAlive", true);
        bootstrap.setOption("child.connectTimeoutMillis", Instellingen.getTcpConnectTimeout());
        
        return bootstrap;
    }

    /**
     * Voeg elk channel toe aan de channelgroup, op deze manier kunnen
     * eenvoudige alle connecties egsloten worden tijdens het stoppen van deze
     * resource adapter.
     * 
     * @param channel
     */
    public static synchronized void addChanneltoGroup(Channel channel) {
        ALLCHANNELS.add(channel);
    }

    /**
     * Sluit alle actieve socket connecties.
     */
    private void sluitAlleBestaandeConnecties() {
        ChannelGroupFuture future = ALLCHANNELS.close();
        if (future != null) {
            future.awaitUninterruptibly();
        }
        // Belangrijk geef door aan Netty dat alle resources vrijgegeven moeten
        // worden.
        if (channelFactory != null) {
            channelFactory.releaseExternalResources();
        }

    }

}
