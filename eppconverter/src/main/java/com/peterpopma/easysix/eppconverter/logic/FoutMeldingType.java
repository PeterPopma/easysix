/*
 * $Id: FoutMeldingType.java 24539 2011-07-12 11:29:03Z maarten $
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

public enum FoutMeldingType {
	
	PARSE_GEEN_CLID_OF_PW("Error in login (clID and pw must be present)."),
	
	//Meldingen voor mislukt inlog request 
	LOGIN_ONGELDIGE_USER_PASSWORD("Username/Password invalid."),
	LOGIN_REEDS_INGELOGD("Already logged in. Use <logout> first."),
	LOGIN_NOG_NIET_INGELOGD("You need to login first."),
	LOGOUT_NOG_NIET_INGELOGD("Already logged out. Use <login> first."),
	INTERNE_FOUT("Internal error."),
	GREETING("Internal error producing greeting."),
	;
	
	private String msg;
	
	private FoutMeldingType(String msg){
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
