package com.ge.customerbillingportal.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class WSCustomerBill {
	private Integer customerBillId;
	private BigDecimal billAmount;
	private Date billDueDate;
	private String ratePlan;
	private Date billCycleStartDate;
	private Date billCycleEndDate;
	private String paymentStatus;
	private Date paymentDate;
	private String billDeliveryMethod;
	private String alternateRatePlan;
	private BigDecimal alternateRateAmount;
	private Timestamp rateEffective;
	private Timestamp rateTermination;
	private String billTemplate;
	private String customerClass;
	private BigDecimal paidAmount;
	private Date billGenerationDate;
	private Date billReadyDate;
	private Date billSentDate;
	private BigDecimal feeInterest;
	private Integer noOfReminderSent;
	private Date nextReminderDate;
	private Date finalReminderDate;
	private Date ratePlanTerimantionTimestamp;
	public Integer getCustomerBillId() {
		return customerBillId;
	}
	public void setCustomerBillId(Integer customerBillId) {
		this.customerBillId = customerBillId;
	}
	public BigDecimal getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}
	public Date getBillDueDate() {
		return billDueDate;
	}
	public void setBillDueDate(Date billDueDate) {
		this.billDueDate = billDueDate;
	}
	public String getRatePlan() {
		return ratePlan;
	}
	public void setRatePlan(String ratePlan) {
		this.ratePlan = ratePlan;
	}
	public Date getBillCycleStartDate() {
		return billCycleStartDate;
	}
	public void setBillCycleStartDate(Date billCycleStartDate) {
		this.billCycleStartDate = billCycleStartDate;
	}
	public Date getBillCycleEndDate() {
		return billCycleEndDate;
	}
	public void setBillCycleEndDate(Date billCycleEndDate) {
		this.billCycleEndDate = billCycleEndDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getBillDeliveryMethod() {
		return billDeliveryMethod;
	}
	public void setBillDeliveryMethod(String billDeliveryMethod) {
		this.billDeliveryMethod = billDeliveryMethod;
	}
	public String getAlternateRatePlan() {
		return alternateRatePlan;
	}
	public void setAlternateRatePlan(String alternateRatePlan) {
		this.alternateRatePlan = alternateRatePlan;
	}
	public BigDecimal getAlternateRateAmount() {
		return alternateRateAmount;
	}
	public void setAlternateRateAmount(BigDecimal alternateRateAmount) {
		this.alternateRateAmount = alternateRateAmount;
	}
	public Timestamp getRateEffective() {
		return rateEffective;
	}
	public void setRateEffective(Timestamp rateEffective) {
		this.rateEffective = rateEffective;
	}
	public Timestamp getRateTermination() {
		return rateTermination;
	}
	public void setRateTermination(Timestamp rateTermination) {
		this.rateTermination = rateTermination;
	}
	public String getBillTemplate() {
		return billTemplate;
	}
	public void setBillTemplate(String billTemplate) {
		this.billTemplate = billTemplate;
	}
	public String getCustomerClass() {
		return customerClass;
	}
	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}
	public BigDecimal getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Date getBillGenerationDate() {
		return billGenerationDate;
	}
	public void setBillGenerationDate(Date billGenerationDate) {
		this.billGenerationDate = billGenerationDate;
	}
	public Date getBillReadyDate() {
		return billReadyDate;
	}
	public void setBillReadyDate(Date billReadyDate) {
		this.billReadyDate = billReadyDate;
	}
	public Date getBillSentDate() {
		return billSentDate;
	}
	public void setBillSentDate(Date billSentDate) {
		this.billSentDate = billSentDate;
	}
	public BigDecimal getFeeInterest() {
		return feeInterest;
	}
	public void setFeeInterest(BigDecimal feeInterest) {
		this.feeInterest = feeInterest;
	}
	public Integer getNoOfReminderSent() {
		return noOfReminderSent;
	}
	public void setNoOfReminderSent(Integer noOfReminderSent) {
		this.noOfReminderSent = noOfReminderSent;
	}
	public Date getNextReminderDate() {
		return nextReminderDate;
	}
	public void setNextReminderDate(Date nextReminderDate) {
		this.nextReminderDate = nextReminderDate;
	}
	public Date getFinalReminderDate() {
		return finalReminderDate;
	}
	public void setFinalReminderDate(Date finalReminderDate) {
		this.finalReminderDate = finalReminderDate;
	}
	public Date getRatePlanTerimantionTimestamp() {
		return ratePlanTerimantionTimestamp;
	}
	public void setRatePlanTerimantionTimestamp(Date ratePlanTerimantionTimestamp) {
		this.ratePlanTerimantionTimestamp = ratePlanTerimantionTimestamp;
	}
	
	
}
