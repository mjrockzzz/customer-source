package com.ge.customerbillingportal.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ge.customerbillingportal.entity.BillForecast;
import com.ge.customerbillingportal.entity.CustomerAccount;

/**
 * @author Nitin K.
 * Interface contains method to get forecastBillAmount data from database
 */
public interface BillForecastRepository extends CrudRepository<BillForecast, Integer> {

	/**
	 * Method to get forecastBillAmount from BillForecast table
	 * @param customerAccount CustomerAccount
	 * @return forecastBillAmount BigDecimal
	 */
	@Query("select forecastBillAmount from BillForecast where customerAccount=:customerAccount")
	public BigDecimal findEstimatedBillByCustomerAccountAndIntervalTime(
			@Param("customerAccount") CustomerAccount customerAccount);

}
