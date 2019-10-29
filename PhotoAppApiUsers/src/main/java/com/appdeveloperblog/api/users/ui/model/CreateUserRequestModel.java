package com.appdeveloperblog.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
	@NotNull(message="first name cant be null")
	@Size(min=2,message="Firstname cannot be less than two chars")
	private String firstName;
	@NotNull(message="Last name cant be null")
	@Size(min=2,message="Last name cannot be less than two chars")
	private String lastname;
	@NotNull(message="Password cant be null")
	@Size(min=8,max=16,message="Password cannot be less than 8 and cannot be more than 16")
	private String password;
	@NotNull(message="Email cant be null")
	@Email
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
