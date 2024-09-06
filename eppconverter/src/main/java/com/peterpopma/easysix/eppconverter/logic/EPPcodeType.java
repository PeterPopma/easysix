/*
 * $Id: EPPcodeType.java 24539 2011-07-12 11:29:03Z maarten $
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
 * Deze ENUM bevast alle EPP code waar de Socket adapter op controleert
 * OF zelf terugstuurt aan de client.
 *
 */
public enum EPPcodeType {
	
	//OK response
	EPP_1000("1000"),
	//command syntax error (parse error)
	EPP_2001("2001"),
	// command use error, bijvoorbeeld 2x inloggen. 
	EPP_2002("2002"),
	//Authentication error, command verstuurd terwijl er nog niet is ingelogd.
	EPP_2200("2200"),
	//interne fout van de SA
	EPP_2400("2400");
	
	private String code;
	
	private EPPcodeType(String code){
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	

}
