/*
 * $Id: PAResponse.java 24539 2011-07-12 11:29:03Z maarten $
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

/**
 * De PAResponse bevat alle data die door de protocol adapter terug is gestuurd
 */
public class PAResponse {
	
	private String response;
	private String eppResponseCode; 
	private boolean connectieSluiten;
	private String httpSessieId;
	
	public PAResponse() {}
	
	public PAResponse(String response) {
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public String getEppResponseCode() {
		return eppResponseCode;
	}

	public void setEppResponseCode(String eppResponseCode) {
		this.eppResponseCode = eppResponseCode;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public boolean isConnectieSluiten() {
		return connectieSluiten;
	}

	public void setConnectieSluiten(boolean connectieSluiten) {
		this.connectieSluiten = connectieSluiten;
	}
	

    public String getHttpSessieId() {
		return httpSessieId;
	}

	public void setHttpSessieId(String httpSessieId) {
		this.httpSessieId = httpSessieId;
	}

	@Override
	public String toString() {
		return "PAResponse [response=" + response
				+ ", eppResponseCode=" + eppResponseCode
				+ ", httpSessieId=" + httpSessieId
				+ ", connectieSluiten=" + connectieSluiten + "]";
	}

}
