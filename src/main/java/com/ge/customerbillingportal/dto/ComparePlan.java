package com.ge.customerbillingportal.dto;

import java.math.BigDecimal;

/**
 * @author Nitin K.
 * Object class contains methods to wrap ComparePlan.
 */
public class ComparePlan {

	private String currentPlan;
	private String alternateRatePlan;
	private BigDecimal alternateRateAmount;
	private BigDecimal projectedAnnualAmount;
	private BigDecimal savingAmount;

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

	public BigDecimal getProjectedAnnualAmount() {
		return projectedAnnualAmount;
	}

	public void setProjectedAnnualAmount(BigDecimal projectedAnnualAmount) {
		this.projectedAnnualAmount = projectedAnnualAmount;
	}

	public String getCurrentPlan() {
		return currentPlan;
	}

	public void setCurrentPlan(String currentPlan) {
		this.currentPlan = currentPlan;
	}

	public BigDecimal getSavingAmount() {
		return savingAmount;
	}

	public void setSavingAmount(BigDecimal savingAmount) {
		this.savingAmount = savingAmount;
	}

}
