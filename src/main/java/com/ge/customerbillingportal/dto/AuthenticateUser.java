package com.ge.customerbillingportal.dto;

/**
 * @author Nitin K.
 * Object class contains methods to wrap authenticate user response.
 */
public class AuthenticateUser extends Result {

	private UserResponse userResponse;

	public UserResponse getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(UserResponse userResponse) {
		this.userResponse = userResponse;
	}
}
