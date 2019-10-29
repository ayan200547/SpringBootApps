package com.developerblog.app.ws.model;

import javax.validation.constraints.NotNull;

public class UpdateUserModel {
	@NotNull(message="First Name Cannot be null")
	private String firstName;
	@NotNull(message="Last Name Cannot be null")
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
