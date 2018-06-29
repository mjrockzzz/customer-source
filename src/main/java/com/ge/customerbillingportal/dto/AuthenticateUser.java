package com.ge.customerbillingportal.dto;

public class AuthenticateUser extends Result {

	private UserResponse userResponse;

	public UserResponse getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(UserResponse userResponse) {
		this.userResponse = userResponse;
	}

}
