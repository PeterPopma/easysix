package com.peterpopma.easysix.eppproxy.codec;

import ietf.params.xml.ns.epp_1.ResponseType;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import com.peterpopma.easysix.eppproxy.util.XmlUtils;

public class EppMessageEncoder extends MessageToByteEncoder<ResponseType> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ResponseType eppResponse, ByteBuf out) {
        String xml = XmlUtils.convertEppResponseToXml(eppResponse);
        out.writeBytes(xml.getBytes());
    }
}