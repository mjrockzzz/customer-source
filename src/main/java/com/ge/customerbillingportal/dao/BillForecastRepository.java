package com.ge.customerbillingportal.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ge.customerbillingportal.entity.BillForecast;
import com.ge.customerbillingportal.entity.CustomerAccount;

public interface BillForecastRepository extends CrudRepository<BillForecast, Integer> {

	@Query("select forecastBillAmount from BillForecast where customerAccount=:customerAccount")
	public BigDecimal findEstimatedBillByCustomerAccountAndIntervalTime(
			@Param("customerAccount") CustomerAccount customerAccount);

}
