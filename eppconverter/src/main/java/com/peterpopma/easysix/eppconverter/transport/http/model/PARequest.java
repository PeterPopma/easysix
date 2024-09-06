/*
 * $Id: PARequest.java 24539 2011-07-12 11:29:03Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.transport.http.model;

import java.util.HashMap;
import java.util.Map;

/**
 * De PARequest bevat alle data die nodig is om een request naar
 * de protocol adapter te kunnen versturen.
 *
 */
public class PARequest {
	
	private String path;
	private Map<String, String> params = new HashMap<String, String>();
	private String clTRID;
	private String eppRequest;
	private String sessieId;
	private String httpSessieId;
	private String username;
	private String password;
	private String ipaddress;
	
	public PARequest addPath(String path){
		this.path = path;
		return this;
	}
	
	public PARequest addClTRID(String id){
		this.clTRID = id;
		return this;
	}
	
	public PARequest addParam(String naam, String value){
		params.put(naam, value);
		return this;
	}

	public String getPath() {
		return path;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public String getClTRID() {
		return clTRID;
	}

	public String getUsername() {
		return username;
	}

	public PARequest addUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public PARequest addPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEppRequest() {
		return eppRequest;
	}

	public PARequest addEppRequest(String eppRequest) {
		this.eppRequest = eppRequest;
		return this;
	}
	
	public PARequest addSessieId(String id) {
		this.sessieId = id;
		return this;
	}

	public String getSessieId() {
		return sessieId;
	}

	public String getHttpSessieId() {
		return httpSessieId;
	}

	public PARequest addHttpSessieId(String httpSessieId) {
		this.httpSessieId = httpSessieId;
		return this;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public PARequest addIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
		return this;
	}

}
