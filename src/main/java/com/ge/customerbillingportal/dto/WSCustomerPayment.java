package com.ge.customerbillingportal.dto;

import java.util.Date;
/**
 * @author Nitin K.
 * Object class contains methods to wrap CustomerPayment.
 */
public class WSCustomerPayment {

	private Integer customerPaymentId;
	private String paymentMethod;
	private String cardOrChkNumber;
	private Date paymentSubmitDate;
	private String routingOrCvvnumber;
	private String cardOrChkHoldername;
	private String cardOrChkHolderAddress;
	private Date cardExpiryDate;
	private String accountType;
	private String nickName;
	public Integer getCustomerPaymentId() {
		return customerPaymentId;
	}
	public void setCustomerPaymentId(Integer customerPaymentId) {
		this.customerPaymentId = customerPaymentId;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getCardOrChkNumber() {
		return cardOrChkNumber;
	}
	public void setCardOrChkNumber(String cardOrChkNumber) {
		this.cardOrChkNumber = cardOrChkNumber;
	}
	public Date getPaymentSubmitDate() {
		return paymentSubmitDate;
	}
	public void setPaymentSubmitDate(Date paymentSubmitDate) {
		this.paymentSubmitDate = paymentSubmitDate;
	}
	public String getRoutingOrCvvnumber() {
		return routingOrCvvnumber;
	}
	public void setRoutingOrCvvnumber(String routingOrCvvnumber) {
		this.routingOrCvvnumber = routingOrCvvnumber;
	}
	public String getCardOrChkHoldername() {
		return cardOrChkHoldername;
	}
	public void setCardOrChkHoldername(String cardOrChkHoldername) {
		this.cardOrChkHoldername = cardOrChkHoldername;
	}
	public String getCardOrChkHolderAddress() {
		return cardOrChkHolderAddress;
	}
	public void setCardOrChkHolderAddress(String cardOrChkHolderAddress) {
		this.cardOrChkHolderAddress = cardOrChkHolderAddress;
	}
	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
