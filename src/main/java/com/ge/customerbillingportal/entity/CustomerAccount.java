package com.ge.customerbillingportal.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "cust_acct")
public class CustomerAccount {

	@Id
	@Column(name = "Acct_ID", length = 11)
	private Integer accountId;

	@Column(name = "Cust_Name", length = 64)
	private String customerName;

	@Column(name = "Service_Addr1", length = 128)
	private String serviceAddress1;

	@Column(name = "Service_Addr2", length = 128)
	private String serviceAddress2;

	@Column(name = "Service_city", length = 50)
	private String serviceCity;

	@Column(name = "Service_Zip", precision = 5, scale = 0, columnDefinition = "decimal")
	private BigDecimal serviceZip;

	@Column(name = "billing_name", length = 64)
	private String billingName;

	@Column(name = "billing_Addr1", length = 128)
	private String billingAddress1;

	@Column(name = "Billing_Addr2", length = 128)
	private String billingAddress2;

	@Column(name = "Billing_city", length = 50)
	private String billingCity;

	@Column(name = "Billing_Zip", precision = 5, scale = 0, columnDefinition = "decimal")
	private BigDecimal billingZip;

	@Column(name = "SA_ID", precision = 10, scale = 0, columnDefinition = "decimal")
	private BigDecimal saId;

	@Column(name = "Start_Date")
	private Date startDate;

	@Column(name = "End_Date")
	private Date endDate;

	@Column(name = "Acct_Status", length = 16)
	private String accountStatus;

	@Column(name = "username", length = 32)
	private String username;

	@Column(name = "user_pwd", length = 32)
	private String password;

	@Column(name = "email_address", length = 128)
	private String emailAddress;

	@Column(name = "phone_num", length = 16)
	private String phoneNumber;

	// As per new modifications
	@Column(name = "longitude", length = 40)
	private String longitude;

	@Column(name = "latitude", length = 40)
	private String latitude;

	@Column(name = "location_code", length = 40)
	private String locationCode;

	@Column(name = "location_description", length = 128)
	private String locationDescription;

	@Column(name = "Addr_PO_BOX ", length = 128)
	private String addressPoBox;

	@Column(name = "SC_ID", precision = 10, scale = 0, columnDefinition = "decimal")
	private BigDecimal scId;

	// One To Many relationship between CustomerAccount and CustomerMeter

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerAccount")
	private List<CustomerMeter> customerMeters = new ArrayList<CustomerMeter>(0);

	// One To Many relationship between CustomerAccount and CustomerBill

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerAccount")
	@OrderBy("billDueDate DESC")
	private List<CustomerBill> customerBills = new ArrayList<CustomerBill>(0);

	// One To Many relationship between CustomerAccount and BillForecast

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerAccount")
	private List<BillForecast> billForecasts = new ArrayList<BillForecast>(0);

	// One To Many relationship between CustomerAccount and CustomerPayment

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerAccount")
	private List<CustomerPayment> customerPayments = new ArrayList<CustomerPayment>(0);

	// One To Many relationship between CustomerAccount and
	// CustomerNotificationLog

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerAccount")
	private List<CustomerNotificationLog> customerNotificationLogs = new ArrayList<CustomerNotificationLog>(0);

	// One To Many relationship between CustomerAccount and
	// CustomerForecastIntervalData

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerAccount")
	private List<CustomerForecastIntervalData> customerForecastIntervalDatas = new ArrayList<CustomerForecastIntervalData>(
			0);

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

	public List<CustomerMeter> getCustomerMeters() {
		return customerMeters;
	}

	public void setCustomerMeters(List<CustomerMeter> customerMeters) {
		this.customerMeters = customerMeters;
	}

	public List<CustomerBill> getCustomerBills() {
		return customerBills;
	}

	public void setCustomerBills(List<CustomerBill> customerBills) {
		this.customerBills = customerBills;
	}

	public List<BillForecast> getBillForecasts() {
		return billForecasts;
	}

	public void setBillForecasts(List<BillForecast> billForecasts) {
		this.billForecasts = billForecasts;
	}

	public List<CustomerPayment> getCustomerPayments() {
		return customerPayments;
	}

	public void setCustomerPayments(List<CustomerPayment> customerPayments) {
		this.customerPayments = customerPayments;
	}

	public List<CustomerNotificationLog> getCustomerNotificationLogs() {
		return customerNotificationLogs;
	}

	public void setCustomerNotificationLogs(List<CustomerNotificationLog> customerNotificationLogs) {
		this.customerNotificationLogs = customerNotificationLogs;
	}

	public List<CustomerForecastIntervalData> getCustomerForecastIntervalDatas() {
		return customerForecastIntervalDatas;
	}

	public void setCustomerForecastIntervalDatas(List<CustomerForecastIntervalData> customerForecastIntervalDatas) {
		this.customerForecastIntervalDatas = customerForecastIntervalDatas;
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

}
