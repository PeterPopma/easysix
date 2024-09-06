/*
 * $Id: SARequest.java 24539 2011-07-12 11:29:03Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.transport.tcp.model;

import nl.sidn.eppadapter.logic.EPPRequestType;

/**
 * Java object welke de informatie uit het door de client
 * verstuurde EPP XML request bevat.
 *
 */
public class EPPRequest {

	private String origineel;
	private String parseFout;
	private EPPRequestType requestType;
	private String user;
	private String pw;
	private String clTRID;

	
	public EPPRequest(String origineel){
		this.origineel = origineel;
	}
	
	public boolean isValide() {
		
		/* als er een foutmelding van de parser aanwezig is dan is het
		 * request niet valide
		 */
		if(parseFout != null){
			return false;
		}
		
		/* als er geen geldig requesttype gevonden kon worden
		 * dan is het request niet valide
		 */
		if(requestType == null){
			//fout geen geldig request commando gevonden
			return false;
		}
		
		/*
		 * Bij een login request moeten de user en pw zijn ingevuld.
		 */
		if(requestType == EPPRequestType.LOGIN && (user == null || pw == null)){
			return false;
		}
		
		return true;
			
	}

	public String getOrigineel() {
		return origineel;
	}

	public void setOrigineel(String origineel) {
		this.origineel = origineel;
	}

	public String getParseFout() {
		return parseFout;
	}

	public void setParseFout(String parseFout) {
		this.parseFout = parseFout;
	}

	public EPPRequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(EPPRequestType requestType) {
		this.requestType = requestType;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getClTRID() {
		return clTRID;
	}

	public void setClTRID(String clTRID) {
		this.clTRID = clTRID;
	}

	@Override
	public String toString() {
		return "SARequest [parseFout=" + parseFout + ", requestType="
				+ requestType + ", user=" + user + ", pw=" + pw
				+ ", clTRID=" + clTRID + "]";
	}

	
}
