/*
 * $Id: HttpHeaderType.java 24539 2011-07-12 11:29:03Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.transport.http;

public enum HttpHeaderType {
	
	//sessie id
	COOKIE("Cookie"),
	COOKIE_SESSIE("session"),
	
	//EPP payload
	FRAME("frame"),
	//De clTRID uit het EPP XML request
	CLTRID("clTRID"),
	
	//EPP response code ontvangen van de PA
	EPP_RESPONSE_CODE("X-F5-EPP-Code"),
	
	//Client adres informatie
 	X_FORWARDED_FOR("X-Forwarded-For"),
		

	//Close requested headers
	CONNECTION_CLOSE("Connection"),
	X_CONNECTION_CLOSE("X-Connection"),
	
	SET_COOKIE("Set-Cookie");
	
	
	
	
	private String naam;
	
	private HttpHeaderType(String naam){
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}

}
