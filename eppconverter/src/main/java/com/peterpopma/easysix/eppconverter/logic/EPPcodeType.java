package com.peterpopma.easysix.eppconverter.logic;

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
