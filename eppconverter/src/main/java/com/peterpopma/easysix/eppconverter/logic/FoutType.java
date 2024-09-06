/*
 * $Id: FoutType.java 24539 2011-07-12 11:29:03Z maarten $
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
 * 
 * ENUM met de fouttypen die kunnen optreden en het pad op de 
 * protocol adapter welke in het geval van de fout moet worden
 * aangeroepen zodat de PA de fout response kan genereren.
 *
 */
public enum FoutType {
	
	//Inkomende EPP XML bericht kan niet geparsed worden.
	PARSE("/epp/error/parse"),
	//Interne fout in de SA
	INTERNAL("/epp/error/internal"),
	//Vaker dan 1x inloggen in 1 sessie.
	LOGIN("/epp/error/login"),
	//versturen van een command zonder ingelogd te zijn.
	AUTHORISATIE("/epp/error/authrequired"),
	;
	
	private String path;
	
	private FoutType(String path){
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
