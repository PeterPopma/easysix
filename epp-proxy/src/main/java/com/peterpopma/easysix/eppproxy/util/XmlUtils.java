package com.peterpopma.easysix.eppproxy.util;

import ietf.params.xml.ns.epp_1.CommandType;
import ietf.params.xml.ns.epp_1.ResponseType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlUtils {
    public static CommandType parseXmlToEppRequest(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(CommandType.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (CommandType) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            throw new RuntimeException("Failed to parse XML", e);
        }
    }

    public static String convertEppResponseToXml(ResponseType eppResponse) {
        try {
            JAXBContext context = JAXBContext.newInstance(ResponseType.class);
            Marshaller marshaller = context.createMarshaller();
            StringWriter writer = new StringWriter();
            marshaller.marshal(eppResponse, writer);
            return writer.toString();
        } catch (JAXBException e) {
            throw new RuntimeException("Failed to convert to XML", e);
        }
    }
}