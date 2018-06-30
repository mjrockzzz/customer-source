package com.ge.customerbillingportal.dto;

/**
 * @author Nitin K.
 * Object class to wrap user for response.
 */
public class UserResponse {

	private String userName;

	private String customerName;

	private Integer accountId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

}
