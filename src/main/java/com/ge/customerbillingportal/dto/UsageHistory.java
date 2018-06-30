package com.ge.customerbillingportal.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

/**
 * @author Nitin K.
 * Object class contains methods to wrap UsageHistory.
 */
public class UsageHistory {

	private BigDecimal meternumber;
	private Date meterDate;
	private BigDecimal dailyLoad;
	private BigDecimal temperature;
	private Time metertime;

	public BigDecimal getMeternumber() {
		return meternumber;
	}

	public void setMeternumber(BigDecimal meternumber) {
		this.meternumber = meternumber;
	}

	public Date getMeterDate() {
		return meterDate;
	}

	public void setMeterDate(Date meterDate) {
		this.meterDate = meterDate;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getDailyLoad() {
		return dailyLoad;
	}

	public void setDailyLoad(BigDecimal dailyLoad) {
		this.dailyLoad = dailyLoad;
	}

	public Time getMetertime() {
		return metertime;
	}

	public void setMetertime(Time metertime) {
		this.metertime = metertime;
	}
	
	
	

}
