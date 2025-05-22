package com.peterpopma.easysix.eppproxy.codec;

import ietf.params.xml.ns.epp_1.CommandType;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import com.peterpopma.easysix.eppproxy.util.XmlUtils;

import java.util.List;

public class EppMessageDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        byte[] bytes = new byte[in.readableBytes()];
        in.readBytes(bytes);
        String xml = new String(bytes);
        CommandType eppRequest = XmlUtils.parseXmlToEppRequest(xml);
        out.add(eppRequest);
    }
}