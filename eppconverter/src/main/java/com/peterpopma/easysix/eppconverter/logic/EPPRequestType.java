/*
 * $Id: EPPRequestType.java 24539 2011-07-12 11:29:03Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.logic;

/**
 * Deze Enum bevat alle EPP commandos die door een EPP client
 * gebruikt mogen worden. Als er een ander commando in een EPP
 * bericht wordt gebruikt dan moet er een EPP foutcode worden
 * teruggestuurd.
 *
 */
public enum EPPRequestType {
	
	//SESSION COMMAND
	HELLO("HELLO","/epp/session/hello"),
	LOGIN("LOGIN", "/epp/session/login"),
	LOGOUT("LOGOUT", "/epp/session/logout"),
	//QUERY COMMANDS
	CHECK("CHECK","/epp/command/check"),
	INFO("INFO","/epp/command/info"),
	POLL("POLL","/epp/command/poll"),
	//TRANSFOROM COMMANDS
	CREATE("CREATE","/epp/command/create"),
	UPDATE("UPDATE","/epp/command/update"),
	DELETE("DELETE","/epp/command/delete"),
	DOMAINCANCELDELETE("DOMAINCANCELDELETE","/epp/command/delete"),
	TRANSFER("TRANSFER","/epp/command/transfer"),
	RENEW("RENEW","/epp/command/renew"),
	//EXTENSIONS
	EXTENSION("EXTENSION","/epp/extension");
	
	private String naam;
	private String path;
	
	private EPPRequestType(String naam, String path){
		this.naam = naam;
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public static EPPRequestType fromString(String type){
		EPPRequestType[] types = values();
		for (EPPRequestType eppRequestType : types) {
			if(eppRequestType.getNaam().equalsIgnoreCase(type)){
				return eppRequestType;
			}
		}
		
		return null;
	}

}
