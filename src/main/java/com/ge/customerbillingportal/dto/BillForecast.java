package com.ge.customerbillingportal.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Nitin K.
 * Object class to wrap BillForecast request and response 
 */
public class BillForecast {

	private BigDecimal monthToDateConsumptionkWh;

	private List<BigDecimal> lastMonthsBills;

	private BigDecimal lastMonthsConsumptionkWh;

	private BigDecimal projectedConsumpForCurrentMonth;

	private BigDecimal estimatedBillTillToday;

	private BigDecimal estimatedBillForCurrentMonth;

	private Timestamp lastMeterIntervalRead;

	public BigDecimal getLastMonthsConsumptionkWh() {
		return lastMonthsConsumptionkWh;
	}

	public void setLastMonthsConsumptionkWh(BigDecimal lastMonthsConsumptionkWh) {
		this.lastMonthsConsumptionkWh = lastMonthsConsumptionkWh;
	}

	public BigDecimal getMonthToDateConsumptionkWh() {
		return monthToDateConsumptionkWh;
	}

	public void setMonthToDateConsumptionkWh(BigDecimal monthToDateConsumptionkWh) {
		this.monthToDateConsumptionkWh = monthToDateConsumptionkWh;
	}

	public List<BigDecimal> getLastMonthsBills() {
		return lastMonthsBills;
	}

	public void setLastMonthsBills(List<BigDecimal> lastMonthsBills) {
		this.lastMonthsBills = lastMonthsBills;
	}

	public BigDecimal getProjectedConsumpForCurrentMonth() {
		return projectedConsumpForCurrentMonth;
	}

	public void setProjectedConsumpForCurrentMonth(BigDecimal projectedConsumpForCurrentMonth) {
		this.projectedConsumpForCurrentMonth = projectedConsumpForCurrentMonth;
	}

	public BigDecimal getEstimatedBillTillToday() {
		return estimatedBillTillToday;
	}

	public void setEstimatedBillTillToday(BigDecimal estimatedBillTillToday) {
		this.estimatedBillTillToday = estimatedBillTillToday;
	}

	public BigDecimal getEstimatedBillForCurrentMonth() {
		return estimatedBillForCurrentMonth;
	}

	public void setEstimatedBillForCurrentMonth(BigDecimal estimatedBillForCurrentMonth) {
		this.estimatedBillForCurrentMonth = estimatedBillForCurrentMonth;
	}

	public Timestamp getLastMeterIntervalRead() {
		return lastMeterIntervalRead;
	}

	public void setLastMeterIntervalRead(Timestamp lastMeterIntervalRead) {
		this.lastMeterIntervalRead = lastMeterIntervalRead;
	}

}
