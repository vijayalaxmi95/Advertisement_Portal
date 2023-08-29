package com.app.raven.model;

import lombok.Data;

@Data
public class LoginObject { // object is used to login the user
	private String email; // the email is fetched and compared with the customer's email
	private String password; // the password is fetched and compared with the customer's password

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	}
