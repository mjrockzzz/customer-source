package com.ge.customerbillingportal.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ge.customerbillingportal.entity.CustomerAccount;
import com.ge.customerbillingportal.entity.CustomerBill;

public interface CustomerBillRepository extends CrudRepository<CustomerBill, Integer> {

	@Query("SELECT billAmount FROM CustomerBill WHERE customerAccount = :customerAccount order by paymentDate desc")
	public List<BigDecimal> findByCustomerAccount(@Param("customerAccount") CustomerAccount customerAccount);

	@Query("FROM CustomerBill WHERE customerAccount =:customerAccount")
	public List<CustomerBill> findCustomerBillByCustomerAccount(@Param("customerAccount") CustomerAccount customerAccount);
	
	List<CustomerBill> findByCustomerAccountOrderByBillCycleEndDateDesc(CustomerAccount customerAccount);
	
}
