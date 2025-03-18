package com.techlabs.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUpdateRequest {

	@Size(min = 2, message = "First name must be at least 2 characters long")
	private String firstName;

	@Size(min = 2, message = "Last name must be at least 2 characters long")
	private String lastName;

	@Email(message = "Invalid email format")
	private String email;

	@Size(min = 8, message = "Password must be at least 8 characters long")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerUpdateRequest() {
		super();
	}

	public CustomerUpdateRequest(
			@Size(min = 2, message = "First name must be at least 2 characters long") String firstName,
			@Size(min = 2, message = "Last name must be at least 2 characters long") String lastName,
			@Email(message = "Invalid email format") String email,
			@Size(min = 8, message = "Password must be at least 8 characters long") String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	

}
