package com.peterpopma.easysix.eppconverter.logic;

/**
 * 
 * ENUM met de fouttypen die kunnen optreden en het pad op de 
 * protocol adapter welke in het geval van de fout moet worden
 * aangeroepen zodat de PA de fout response kan genereren.
 *
 */
public enum ErrorType {
	
	//Inkomende EPP XML bericht kan niet geparsed worden.
	PARSE("/epp/error/parse"),
	//Interne fout in de SA
	INTERNAL("/epp/error/internal"),
	//Vaker dan 1x inloggen in 1 sessie.
	LOGIN("/epp/error/login"),
	//versturen van een command zonder ingelogd te zijn.
	AUTHORISATION("/epp/error/authrequired"),
	;
	
	private String path;
	
	private ErrorType(String path){
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
