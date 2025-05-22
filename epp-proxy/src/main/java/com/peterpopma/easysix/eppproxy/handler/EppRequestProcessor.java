package com.peterpopma.easysix.eppproxy.handler;

import com.peterpopma.easysix.eppproxy.service.RestClientService;
import ietf.params.xml.ns.epp_1.CommandType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

@Component
public class EppRequestProcessor extends SimpleChannelInboundHandler<CommandType> {

    private final RestClientService restClientService;

    public EppRequestProcessor(RestClientService restClientService) {
        this.restClientService = restClientService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CommandType eppRequest) {
        // Forward the request to the Spring Boot REST client reactively
        restClientService.sendToRestClient(eppRequest)
                .subscribe(eppResponse -> {
                    // Send the response back to the client
                    ctx.writeAndFlush(eppResponse);
                }, throwable -> {
                    // Handle errors
                    ctx.fireExceptionCaught(throwable);
                });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}