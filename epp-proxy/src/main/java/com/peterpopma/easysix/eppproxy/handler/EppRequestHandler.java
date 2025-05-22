package com.peterpopma.easysix.eppproxy.handler;

import com.peterpopma.easysix.eppproxy.codec.EppMessageDecoder;
import com.peterpopma.easysix.eppproxy.codec.EppMessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;

@Component
public class EppRequestHandler extends ChannelInitializer<SocketChannel> {

    private final EppRequestProcessor eppRequestProcessor;

    public EppRequestHandler(EppRequestProcessor eppRequestProcessor) {
        this.eppRequestProcessor = eppRequestProcessor;
    }

    @Override
    protected void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(
                new EppMessageDecoder(),  // Decodes raw bytes into EPP XML
                new EppMessageEncoder(),  // Encodes EPP XML into bytes
                eppRequestProcessor       // Processes EPP requests
        );
    }
}