package com.sai.sandeep.domain;

import org.springframework.security.core.GrantedAuthority;

public class Authorities implements GrantedAuthority {

	private static final long serialVersionUID = -1213410168059324446L;
	private String username;
	private String authority;

	public Authorities(String username, String authority) {
		this.authority = authority;
		this.username = username;
	}

	public String getAuthority() {
		return this.authority;
	}

	public String getUsername() {
		return username;
	}
}
