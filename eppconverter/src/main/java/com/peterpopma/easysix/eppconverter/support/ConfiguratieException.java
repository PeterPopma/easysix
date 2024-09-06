/*
 * $Id: ConfiguratieException.java 24539 2011-07-12 11:29:03Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.support;

public class ConfiguratieException extends RuntimeException {

	private static final long serialVersionUID = -8188253839407436608L;

	public ConfiguratieException() {
		super();
	}

	public ConfiguratieException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConfiguratieException(String message) {
		super(message);
	}
	
	

}
