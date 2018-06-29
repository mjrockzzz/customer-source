package com.ge.customerbillingportal.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class WSCustomerAccount {
	private Integer accountId;
	private String customerName;
	private String serviceAddress1;
	private String serviceAddress2;
	private String serviceCity;
	private BigDecimal serviceZip;
	private String serviceAddressState;
	private String billingName;
	private String billingAddress1;
	private String billingAddress2;
	private String billingCity;
	private BigDecimal billingZip;
	private String billingAddressState;
	private BigDecimal saId;
	private Date startDate;
	private Date endDate;
	private String accountStatus;
	private String username;
	private String password;
	private String emailAddress;
	private String phoneNumber;
	private String longitude;
	private String latitude;
	private String locationCode;
	private String locationDescription;
	private String addressPoBox;
	private BigDecimal scId;
	private BigDecimal recuringAmount;
	private String invoiceDeliveryMethod;
	private List<WSCustomerMeter> customerMeters;
	private List<WSCustomerBill> customerBills;
	private List<WSCustomerPayment> customerPayments;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getServiceAddress1() {
		return serviceAddress1;
	}
	public void setServiceAddress1(String serviceAddress1) {
		this.serviceAddress1 = serviceAddress1;
	}
	public String getServiceAddress2() {
		return serviceAddress2;
	}
	public void setServiceAddress2(String serviceAddress2) {
		this.serviceAddress2 = serviceAddress2;
	}
	public String getServiceCity() {
		return serviceCity;
	}
	public void setServiceCity(String serviceCity) {
		this.serviceCity = serviceCity;
	}
	public BigDecimal getServiceZip() {
		return serviceZip;
	}
	public void setServiceZip(BigDecimal serviceZip) {
		this.serviceZip = serviceZip;
	}
	public String getServiceAddressState() {
		return serviceAddressState;
	}
	public void setServiceAddressState(String serviceAddressState) {
		this.serviceAddressState = serviceAddressState;
	}
	public String getBillingName() {
		return billingName;
	}
	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}
	public String getBillingAddress1() {
		return billingAddress1;
	}
	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}
	public String getBillingAddress2() {
		return billingAddress2;
	}
	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public BigDecimal getBillingZip() {
		return billingZip;
	}
	public void setBillingZip(BigDecimal billingZip) {
		this.billingZip = billingZip;
	}
	public String getBillingAddressState() {
		return billingAddressState;
	}
	public void setBillingAddressState(String billingAddressState) {
		this.billingAddressState = billingAddressState;
	}
	public BigDecimal getSaId() {
		return saId;
	}
	public void setSaId(BigDecimal saId) {
		this.saId = saId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getLocationDescription() {
		return locationDescription;
	}
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
	public String getAddressPoBox() {
		return addressPoBox;
	}
	public void setAddressPoBox(String addressPoBox) {
		this.addressPoBox = addressPoBox;
	}
	public BigDecimal getScId() {
		return scId;
	}
	public void setScId(BigDecimal scId) {
		this.scId = scId;
	}
	public BigDecimal getRecuringAmount() {
		return recuringAmount;
	}
	public void setRecuringAmount(BigDecimal recuringAmount) {
		this.recuringAmount = recuringAmount;
	}
	public String getInvoiceDeliveryMethod() {
		return invoiceDeliveryMethod;
	}
	public void setInvoiceDeliveryMethod(String invoiceDeliveryMethod) {
		this.invoiceDeliveryMethod = invoiceDeliveryMethod;
	}
	public List<WSCustomerMeter> getCustomerMeters() {
		return customerMeters;
	}
	public void setCustomerMeters(List<WSCustomerMeter> customerMeters) {
		this.customerMeters = customerMeters;
	}
	public List<WSCustomerBill> getCustomerBills() {
		return customerBills;
	}
	public void setCustomerBills(List<WSCustomerBill> customerBills) {
		this.customerBills = customerBills;
	}
	public List<WSCustomerPayment> getCustomerPayments() {
		return customerPayments;
	}
	public void setCustomerPayments(List<WSCustomerPayment> customerPayments) {
		this.customerPayments = customerPayments;
	}
	
	
	
	

}
