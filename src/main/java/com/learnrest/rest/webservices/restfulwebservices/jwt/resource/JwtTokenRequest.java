package com.learnrest.rest.webservices.restfulwebservices.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;

//	{
//		"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU2MjA0OTgxMiwiaWF0IjoxNTYxNDQ1MDEyfQ.Kx3leF9TVdwTF4qct9OHF1L0aXw1KV1_--S1ryCVaHULbEfWTzVEvaO6Qy1NgMBMU7_2wdl5oCkv4GZeLaX8oQ"
//	}

	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}