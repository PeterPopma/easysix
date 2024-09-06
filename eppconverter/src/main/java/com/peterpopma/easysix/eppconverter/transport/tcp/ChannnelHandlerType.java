/*
 * $Id: ChannnelHandlerType.java 23976 2011-05-18 13:23:33Z maarten $
 *
 * Copyright (c) 2009 Stichting Internet Domeinregistratie Nederland (SIDN).
 * Utrechtseweg 310 6812 AR Arnhem Nederland All rights reserved.
 *
 * This software is the confidential and proprietary information of SIDN
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SIDN.
 */
package nl.sidn.eppadapter.transport.tcp;

/**
 * Enum met de verschillende typen channel handlers welke
 * in de socket server pipeline worden gebruikt.
 *
 */
public enum ChannnelHandlerType {

	DECODER,
	ENCODER,
	STRINGDECODER,
	STRINGENCODER,
	CLIENTTIMEOUTHANDLER,
	SERVERTIMEOUTHANDLER,
	EXECUTORHANDLER,
	SOCKETSERVERHANDLER;
	
	
	@Override
	public String toString() {
		return name();
	}
	
}
