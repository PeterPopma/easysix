package com.peterpopma.easysix.eppconverter.logic;

public enum ErrorMessageType {

	PARSE_NO_CLID_OR_PW("Error in login (clID and pw must be present)."),

	LOGIN_INVALID_USER_PASSWORD("Username/Password invalid."),
	LOGIN_ALREADY_LOGGED_IN("Already logged in. Use <logout> first."),
	LOGIN_NOT_YET_LOGGED_IN("You need to login first."),
	LOGOUT_NOT_YET_LOGGED_IN("Already logged out. Use <login> first."),
	INTERNAL_ERROR("Internal error."),
	GREETING("Internal error producing greeting."),
	;
	
	private String msg;
	
	private ErrorMessageType(String msg){
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
