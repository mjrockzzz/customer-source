package com.ge.customerbillingportal.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class LoadForecast {

	private Integer customerAccountId;
	private Date forecastDate;
	private BigDecimal kWh;
	private BigDecimal kVARH;
	private BigDecimal temperature;
	private Time intervalTime;
	private Date billCycleDate;

	public Integer getCustomerAccountId() {
		return customerAccountId;
	}

	public void setCustomerAccountId(Integer customerAccountId) {
		this.customerAccountId = customerAccountId;
	}

	public Date getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(Date forecastDate) {
		this.forecastDate = forecastDate;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getkWh() {
		return kWh;
	}

	public void setkWh(BigDecimal kWh) {
		this.kWh = kWh;
	}

	public Time getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Time intervalTime) {
		this.intervalTime = intervalTime;
	}

	public Date getBillCycleDate() {
		return billCycleDate;
	}

	public void setBillCycleDate(Date billCycleDate) {
		this.billCycleDate = billCycleDate;
	}

	public BigDecimal getkVARH() {
		return kVARH;
	}

	public void setkVARH(BigDecimal kVARH) {
		this.kVARH = kVARH;
	}

}
