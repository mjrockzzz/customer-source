package com.ge.customerbillingportal.entity;

import java.math.BigDecimal;
import java.sql.Date;
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
@Table(name = "cust_bill")
public class CustomerBill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerBillId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Acct_ID", nullable = false)
	private CustomerAccount customerAccount;

	@Column(name = "Bill_Amt", precision = 10, scale = 2, columnDefinition = "decimal")
	private BigDecimal billAmount;

	@Column(name = "Bill_Due")
	private Date billDueDate;

	@Column(name = "rate_plan", length = 32)
	private String ratePlan;

	@Column(name = "Billcycle_startdate")
	private Date billCycleStartDate;

	@Column(name = "billcycle_enddate")
	private Date billCycleEndDate;

	@Column(name = "payment_status", length = 16)
	private String paymentStatus;

	@Column(name = "payment_date")
	private Date paymentDate;

	@Column(name = "bill_delivery_method", length = 16)
	private String billDeliveryMethod;

	@Column(name = "alt_rate_plan", length = 32)
	private String alternateRatePlan;

	@Column(name = "alt_rate_amt", precision = 10, scale = 2, columnDefinition = "decimal")
	private BigDecimal alternateRateAmount;

	// As per new modifications
	@Column(name = "rate_effective")
	private Timestamp rateEffective;

	@Column(name = "rate_termination ")
	private Timestamp rateTermination;

	public Integer getCustomerBillId() {
		return customerBillId;
	}

	public void setCustomerBillId(Integer customerBillId) {
		this.customerBillId = customerBillId;
	}

	@JsonIgnore
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
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
}
