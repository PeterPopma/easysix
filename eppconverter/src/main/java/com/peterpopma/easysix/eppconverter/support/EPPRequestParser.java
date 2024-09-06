/*
 * $Id: EPPRequestParser.java 24539 2011-07-12 11:29:03Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.support;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import nl.sidn.eppadapter.logic.EPPRequestType;
import nl.sidn.eppadapter.transport.tcp.model.EPPRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * JAXB - StAX parser welke het ontvangen EPP XML bericht
 * parsed en de elementen die in de SA nodig zijn uit het bericht
 * probeert te halen.
 * 
 * Het XML bericht wordt NIET gevalideerd tegen het EPP XML schema, dit
 * gebeurd door de protocol adapter.
 *
 */
public final class EPPRequestParser {
    
    private static final  Logger LOGGER = Logger.getLogger(EPPRequestParser.class);
    
    /* de onderstaande elementen moeten aanwezig zijn om het command
     * in het request te kunnen bepalen. 
     */
    private static final String EPP_BERICHT = "epp";
    private static final String EPP_COMMAND = "command";
    private static final String EPP_EXTENSION = "extension";
    
    /* De onderstaande velden moeten uit het XML request worden gehaald
     * omdat ze nodig zijn voor de correcte werking van de EPP adapter.
     */
    private static final String EPP_LOGIN_USER = "clID";
    private static final String EPP_LOGIN_PASSWORD = "pw";
    private static final String EPP_REGISTRAR_TRANS_ID = "clTRID";
    
    private static XMLInputFactory xmlif;
    
    static{
        
        /* maak de StaX parser factory 1x aan, dit is een dure operatie en de parser factory
         * kan steeds worden hergebruikt.
         * 
         * Geef ook de opties op die nodig zijn om een hoge performance te halen
         */
        xmlif = XMLInputFactory.newInstance();

        xmlif.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES,Boolean.FALSE);
        xmlif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES,Boolean.FALSE);
        xmlif.setProperty(XMLInputFactory.IS_COALESCING, Boolean.FALSE);
        xmlif.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);
    }

    private EPPRequestParser() {
        
    }

    /**
     * Parse het EPP XML bericht, het bericht wordt niet gevalideerd tegen het EPP schema.
     * Er wordt alleen gekeken of de volgende elementen uit het bericht gehaald kunnen 
     * worden:
     * 
     * - Het type command
     * - Het type extension
     * - In geval van een login command, de username en password
     * - Het registrar transactie id.
     *  
     */
    public static EPPRequest parse(String request) {
        log("parse request");

        EPPRequest eppRequest = new EPPRequest(request); 

        XMLStreamReader xmlsr = null;
        try {
            xmlsr = xmlif.createXMLStreamReader(new ByteArrayInputStream(request.getBytes(Instellingen.getEncoding())));
            
            doParse(xmlsr, eppRequest);
            
        } catch (XMLStreamException e) {
            LOGGER.error("invalide XML gevonden, request: " + request, e);
            //stop met verder parsen, geef leeg sarrequest terug
            eppRequest.setParseFout(e.getMessage());
            return eppRequest;
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("invalide encoding in de XML gevonden, request: " + request, e);
            //stop met verder parsen, geef leeg sarrequest terug
            eppRequest.setParseFout(e.getMessage());
            return eppRequest;
        } finally {
            try {
            	if (xmlsr != null) {
            		xmlsr.close();
            	}
            } catch (XMLStreamException e) {
                /* de stream kan niet worden gesloten, maar is wel goed ingelezen, ga gewoon door */
                LOGGER.error("Sluiten van de XML stream is mislukt", e);
            }
        }
        return eppRequest;
    }
    
    protected static EPPRequest doParse(XMLStreamReader xmlsr, EPPRequest sARequest)throws XMLStreamException {

        boolean berichtGevonden = false;
        boolean commandGevonden = false;
        boolean loginGevonden = false;
        boolean requestGevonden = false;
        
        int eventType;
        while (xmlsr.hasNext()) {
            eventType = xmlsr.next();
            if (eventType == XMLEvent.START_ELEMENT) {

                if (berichtGevonden(xmlsr)) {
                    berichtGevonden = true;
                    log("epp element gevonden");
                } else if (helloGevonden(berichtGevonden, xmlsr)) {
                    requestGevonden = verwerkHello(xmlsr, sARequest);
                    break;
                } else if (extensionGevonden(commandGevonden,berichtGevonden, xmlsr)) {
                    requestGevonden = verwerkExtension(sARequest);
                } else if (commandGevonden(berichtGevonden, xmlsr)) {
                    commandGevonden = true;
                    log("epp commando element gevonden");                    
                } else if (commandGevonden && !requestGevonden) {
                    requestGevonden = true;
                    EPPRequestType requestType = EPPRequestType.fromString(xmlsr.getLocalName());
                    sARequest.setRequestType(requestType);

                    log("epp request type gevonden");

                    if (commandGevonden && requestType == EPPRequestType.LOGIN) {
                        loginGevonden = true;
                        log("epp login gevonden");
                    }
                } else if (userNameGevonden(loginGevonden, xmlsr)) {
                    verwerkUsername(xmlsr, sARequest);
                } else if (passwordGevonden(loginGevonden, xmlsr)) {
                    verwerkPassword(xmlsr, sARequest);
                } else if (registrarTransactionIdGevonden(xmlsr)) {
                    verwerkTransactionId(xmlsr, sARequest);
                }
            }
        }
        return sARequest;
    }

    private static void verwerkTransactionId(XMLStreamReader xmlsr, EPPRequest sARequest) throws XMLStreamException {
        int eventType;
        eventType = xmlsr.next();
        if (eventType == XMLEvent.CHARACTERS || eventType == XMLEvent.CDATA) {
            sARequest.setClTRID(xmlsr.getText());
            log("epp registrar transactie id gevonden");
        }
    }

    private static void verwerkPassword(XMLStreamReader xmlsr, EPPRequest sARequest) throws XMLStreamException {
        int eventType;
        eventType = xmlsr.next();
        if (eventType == XMLEvent.CHARACTERS || eventType == XMLEvent.CDATA) {
            sARequest.setPw(xmlsr.getText());
            log("epp password gevonden");
        }
    }

    private static void verwerkUsername(XMLStreamReader xmlsr, EPPRequest sARequest) throws XMLStreamException {
        int eventType;
        eventType = xmlsr.next();
        if (eventType == XMLEvent.CHARACTERS || eventType == XMLEvent.CDATA) {
            sARequest.setUser(xmlsr.getText());
            log("epp username gevonden");
        }
    }

    private static boolean verwerkExtension(EPPRequest sARequest) {
        boolean requestGevonden;
        requestGevonden = true;
        log("epp extension element gevonden");
        EPPRequestType extensionRequestType = EPPRequestType.EXTENSION;
        sARequest.setRequestType(extensionRequestType);
        return requestGevonden;
    }

    private static boolean verwerkHello(XMLStreamReader xmlsr, EPPRequest sARequest) {
        boolean requestGevonden;
        log("epp hello element gevonden");
        // hello request gevonden, er hoeft niet verder te worden gekeken. stop met parsen
        requestGevonden = true;
        EPPRequestType requestType = EPPRequestType.fromString(xmlsr.getLocalName());
        sARequest.setRequestType(requestType);
        return requestGevonden;
    }
    
    private static boolean berichtGevonden(XMLStreamReader xmlsr){
        return StringUtils.equalsIgnoreCase(EPP_BERICHT, xmlsr.getLocalName());
    }
    
    private static boolean helloGevonden(boolean berichtGevonden, XMLStreamReader xmlsr){
        return berichtGevonden && StringUtils.equalsIgnoreCase(EPPRequestType.HELLO.getNaam(), xmlsr.getLocalName());
    }
    
    private static boolean commandGevonden(boolean berichtGevonden, XMLStreamReader xmlsr){
        return berichtGevonden && StringUtils.equalsIgnoreCase(EPP_COMMAND, xmlsr.getLocalName());
    }

    private static boolean extensionGevonden(boolean commandGevonden, boolean berichtGevonden, XMLStreamReader xmlsr) {
        return !commandGevonden && berichtGevonden && StringUtils.equalsIgnoreCase(EPP_EXTENSION, xmlsr.getLocalName());
    }

    private static boolean userNameGevonden(boolean loginGevonden, XMLStreamReader xmlsr){
        return loginGevonden && StringUtils.equalsIgnoreCase(EPP_LOGIN_USER, xmlsr.getLocalName());
    }

    private static boolean passwordGevonden(boolean loginGevonden, XMLStreamReader xmlsr){
        return loginGevonden && StringUtils.equalsIgnoreCase(EPP_LOGIN_PASSWORD, xmlsr.getLocalName());
    }
    
    private static boolean registrarTransactionIdGevonden(XMLStreamReader xmlsr){
        return StringUtils.equalsIgnoreCase(EPP_REGISTRAR_TRANS_ID, xmlsr.getLocalName());
    }
    
    private static void log(String msg){
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug(msg);
        }
    }

}
