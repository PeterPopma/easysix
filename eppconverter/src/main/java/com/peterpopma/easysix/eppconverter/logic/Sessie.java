package com.peterpopma.easysix.eppconverter.logic;

import java.util.UUID;

/**
 * Sessie bevat de state van de gebruiker sessie op de EPP Adapter.
 * Alle gegevens die tussen gebruiker requests door bewaard moet worden 
 * staan in deze sessie.
  */
public class Sessie {
	
	/* unieke id voor deze connectie
	 * hiervoor wordt een 128 bit UUID gebruikt
	 * Elke nieuwe sessien krijgt een id welke naar de PA wordt
	 * doorgestuurd en daar als sessie identiefier wordt gebruikt.
	 */
	private String id;
	/* bewaar de user, password en ipaddress zodat deze steeds meegestuurd
	 * kunnen worden.
	 */
	private String user;
	private String pw;
	private String ipaddress;

	//true als de gebruik een geldige sessie heeft op de protocol adapter
	private boolean loggedIn;
	
	//id van de http sessie (JSESSIONID)
	private String httpSessionId;
	
	public Sessie(){
		id = UUID.randomUUID().toString(); 
		user = "";
		pw = "";
		loggedIn = false;
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

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getId() {
		return id;
	}
	
	public void loggedIn(){
		loggedIn = true;
	}
	
	public void loggedOut(){
		loggedIn = false;
		user = "";
		pw = "";
		httpSessionId = null;
	}

	public String getHttpSessionId() {
		return httpSessionId;
	}

	public void setHttpSessionId(String httpSessionId) {
		this.httpSessionId = httpSessionId;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
}
