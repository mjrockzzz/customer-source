package com.ge.customerbillingportal.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cust_forecast_interval_data")
public class CustomerForecastIntervalData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerForecastIntervalDataId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Acct_ID", nullable = false)
	private CustomerAccount customerAccount;

	@Column(name = "interval_time")
	private Date intervalTime;

	@Column(name = "kWH", precision = 10, scale = 2, columnDefinition = "decimal")
	private BigDecimal kWH;

	@Column(name = "kVARH", precision = 10, scale = 2, columnDefinition = "decimal")
	private BigDecimal kVARH;

	@Column(name = "temperature", precision = 3, scale = 2, columnDefinition = "decimal")
	private BigDecimal temperature;

	@Column(name = "interval_amt", precision = 10, scale = 0, columnDefinition = "decimal")
	private BigDecimal intervalAmount;

	@Column(name = "Channel_num", length = 11)
	private Integer channelNumber;

	public Integer getCustomerForecastIntervalDataId() {
		return customerForecastIntervalDataId;
	}

	public void setCustomerForecastIntervalDataId(Integer customerForecastIntervalDataId) {
		this.customerForecastIntervalDataId = customerForecastIntervalDataId;
	}

	@JsonIgnore
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public Date getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Date intervalTime) {
		this.intervalTime = intervalTime;
	}

	public BigDecimal getkWH() {
		return kWH;
	}

	public void setkWH(BigDecimal kWH) {
		this.kWH = kWH;
	}

	public BigDecimal getkVARH() {
		return kVARH;
	}

	public void setkVARH(BigDecimal kVARH) {
		this.kVARH = kVARH;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getIntervalAmount() {
		return intervalAmount;
	}

	public void setIntervalAmount(BigDecimal intervalAmount) {
		this.intervalAmount = intervalAmount;
	}

	public Integer getChannelNumber() {
		return channelNumber;
	}

	public void setChannelNumber(Integer channelNumber) {
		this.channelNumber = channelNumber;
	}

}
