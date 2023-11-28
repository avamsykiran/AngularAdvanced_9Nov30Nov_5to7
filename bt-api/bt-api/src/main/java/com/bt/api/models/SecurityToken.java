package com.bt.api.models;

import java.io.Serializable;

public class SecurityToken implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;

	private final String jwttoken;

	public SecurityToken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}