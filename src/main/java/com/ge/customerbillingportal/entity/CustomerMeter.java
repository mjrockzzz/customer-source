package com.ge.customerbillingportal.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cust_meter")
public class CustomerMeter {

	@Id
	@Column(name = "Meter_num", precision = 10, scale = 0, columnDefinition = "decimal")
	private BigDecimal meterNumber;

	@Column(name = "Start_Date")
	private Date startDate;

	@Column(name = "End_Date")
	private Date endDate;

	@Column(name = "Meter_Status", length = 16)
	private String meterStatus;

	@Column(name = "SP_ID", precision = 10, scale = 0, columnDefinition = "decimal")
	private BigDecimal spId;

	// As per new Modifications

	@Column(name = "feeder", length = 64)
	private String feeder;

	@Column(name = "Svc_delivery_pt ", length = 64)
	private String svcDeliveryPt;

	@Column(name = "current_transformer_ratio", length = 32)
	private String currentTransformerRatio;

	@Column(name = "voltage_transformer_ratio ", length = 32)
	private String voltageTransformerRatio;

	@Column(name = "meter_multiplier ", precision = 10, scale = 0, columnDefinition = "decimal")
	private BigDecimal meterMultiplier;

	@Column(name = "instalation_date")
	private Timestamp instalationDate;

	@Column(name = "removal_date ")
	private Timestamp removalDate;

	// Many To One relationship between CustomerMeter and CustomerAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Acct_id", nullable = false)
	private CustomerAccount customerAccount;

	// One To Many relationship between CustomerMeter and
	// CustomerMeterIntervalData
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerMeter")
	private List<CustomerMeterIntervalData> customerMeterIntervalDatas = new ArrayList<CustomerMeterIntervalData>(0);

	public BigDecimal getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(BigDecimal meterNumber) {
		this.meterNumber = meterNumber;
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

	public String getMeterStatus() {
		return meterStatus;
	}

	public void setMeterStatus(String meterStatus) {
		this.meterStatus = meterStatus;
	}

	public BigDecimal getSpId() {
		return spId;
	}

	public void setSpId(BigDecimal spId) {
		this.spId = spId;
	}

	@JsonIgnore
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public List<CustomerMeterIntervalData> getCustomerMeterIntervalDatas() {
		return customerMeterIntervalDatas;
	}

	public void setCustomerMeterIntervalDatas(List<CustomerMeterIntervalData> customerMeterIntervalDatas) {
		this.customerMeterIntervalDatas = customerMeterIntervalDatas;
	}

	public String getFeeder() {
		return feeder;
	}

	public void setFeeder(String feeder) {
		this.feeder = feeder;
	}

	public String getSvcDeliveryPt() {
		return svcDeliveryPt;
	}

	public void setSvcDeliveryPt(String svcDeliveryPt) {
		this.svcDeliveryPt = svcDeliveryPt;
	}

	public String getCurrentTransformerRatio() {
		return currentTransformerRatio;
	}

	public void setCurrentTransformerRatio(String currentTransformerRatio) {
		this.currentTransformerRatio = currentTransformerRatio;
	}

	public String getVoltageTransformerRatio() {
		return voltageTransformerRatio;
	}

	public void setVoltageTransformerRatio(String voltageTransformerRatio) {
		this.voltageTransformerRatio = voltageTransformerRatio;
	}

	public BigDecimal getMeterMultiplier() {
		return meterMultiplier;
	}

	public void setMeterMultiplier(BigDecimal meterMultiplier) {
		this.meterMultiplier = meterMultiplier;
	}

	public Timestamp getInstalationDate() {
		return instalationDate;
	}

	public void setInstalationDate(Timestamp instalationDate) {
		this.instalationDate = instalationDate;
	}

	public Timestamp getRemovalDate() {
		return removalDate;
	}

	public void setRemovalDate(Timestamp removalDate) {
		this.removalDate = removalDate;
	}

}
