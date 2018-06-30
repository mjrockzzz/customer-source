package com.ge.customerbillingportal.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ge.customerbillingportal.entity.CustomerAccount;
import com.ge.customerbillingportal.entity.CustomerBill;

/**
 * @author Nitin K.
 * Interface contains method to get CustomerBill data from database
 */
public interface CustomerBillRepository extends CrudRepository<CustomerBill, Integer> {

	/**
	 * Method to get list of billAmount for given customerAccount order by paymentDate from CustomerBill table
	 * @param customerAccount CustomerAccount
	 * @return billAmount List<BigDecimal>
	 */
	@Query("SELECT billAmount FROM CustomerBill WHERE customerAccount = :customerAccount order by paymentDate desc")
	public List<BigDecimal> findByCustomerAccount(@Param("customerAccount") CustomerAccount customerAccount);

	/**
	 * Method to get List of CustomerBill for given customerAccount from CustomerBill table
	 * @param customerAccount CustomerAccount
	 * @return List of CustomerBill
	 */
	@Query("FROM CustomerBill WHERE customerAccount =:customerAccount")
	public List<CustomerBill> findCustomerBillByCustomerAccount(@Param("customerAccount") CustomerAccount customerAccount);
	
	/**
	 * Method to get list of billAmount for given customerAccount order by BillCycle from CustomerBill table
	 * @param customerAccount CustomerAccount
	 * @return List of CustomerBill
	 */
	List<CustomerBill> findByCustomerAccountOrderByBillCycleEndDateDesc(CustomerAccount customerAccount);
	
}
