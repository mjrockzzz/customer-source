package com.ge.customerbillingportal.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class WSCustomerMeter {
	private BigDecimal meterNumber;
	private Date startDate;
	private Date endDate;
	private String meterStatus;
	private BigDecimal spId;
	private String feeder;
	private String svcDeliveryPt;
	private String currentTransformerRatio;
	private String voltageTransformerRatio;
	private BigDecimal meterMultiplier;
	private Timestamp instalationDate;
	private Timestamp removalDate;
	private Integer deemandMultiplier;
	private BigDecimal intervalValue;
	private BigDecimal installMeterReading;
	private BigDecimal removableMeterReading;
	private BigDecimal manualMeterReading;
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
	public Integer getDeemandMultiplier() {
		return deemandMultiplier;
	}
	public void setDeemandMultiplier(Integer deemandMultiplier) {
		this.deemandMultiplier = deemandMultiplier;
	}
	public BigDecimal getIntervalValue() {
		return intervalValue;
	}
	public void setIntervalValue(BigDecimal intervalValue) {
		this.intervalValue = intervalValue;
	}
	public BigDecimal getInstallMeterReading() {
		return installMeterReading;
	}
	public void setInstallMeterReading(BigDecimal installMeterReading) {
		this.installMeterReading = installMeterReading;
	}
	public BigDecimal getRemovableMeterReading() {
		return removableMeterReading;
	}
	public void setRemovableMeterReading(BigDecimal removableMeterReading) {
		this.removableMeterReading = removableMeterReading;
	}
	public BigDecimal getManualMeterReading() {
		return manualMeterReading;
	}
	public void setManualMeterReading(BigDecimal manualMeterReading) {
		this.manualMeterReading = manualMeterReading;
	}
	
	
	
}
