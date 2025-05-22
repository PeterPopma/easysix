package com.peterpopma.easysix.eppproxy.config;

import com.peterpopma.easysix.eppproxy.handler.EppRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

@Configuration
public class NettyServerConfig {

    @Value("${epp.proxy.port:7000}")
    private int port;

    @Bean
    public ServerBootstrap serverBootstrap(EppRequestHandler eppRequestHandler) {
        ServerBootstrap b = new ServerBootstrap();
        b.group(new NioEventLoopGroup(), new NioEventLoopGroup())
         .channel(NioServerSocketChannel.class)
         .childHandler(eppRequestHandler)
         .option(ChannelOption.SO_BACKLOG, 128)
         .childOption(ChannelOption.SO_KEEPALIVE, true);
        return b;
    }

    @Bean
    public InetSocketAddress tcpSocketAddress() {
        return new InetSocketAddress(port);
    }
}