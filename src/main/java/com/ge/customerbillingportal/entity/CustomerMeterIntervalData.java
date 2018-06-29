package com.ge.customerbillingportal.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
@Table(name = "cust_meter_interval_data")
public class CustomerMeterIntervalData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerMeterIntervalDataId;

	// Many To One relationship between CustomerMeterIntervalData and
	// CustomerMeter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "meter_num", nullable = false)
	private CustomerMeter customerMeter;

	
	@Column(name = "interval_time")
	private Timestamp intervalTime;

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

	public Integer getCustomerMeterIntervalDataId() {
		return customerMeterIntervalDataId;
	}

	public void setCustomerMeterIntervalDataId(Integer customerMeterIntervalDataId) {
		this.customerMeterIntervalDataId = customerMeterIntervalDataId;
	}

	@JsonIgnore
	public CustomerMeter getCustomerMeter() {
		return customerMeter;
	}

	public void setCustomerMeter(CustomerMeter customerMeter) {
		this.customerMeter = customerMeter;
	}

	
	public Timestamp getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Timestamp intervalTime) {
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
