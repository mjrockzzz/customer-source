package com.ge.customerbillingportal.dao;

import org.springframework.data.repository.CrudRepository;

import com.ge.customerbillingportal.entity.CustomerAccount;

/**
 * @author Nitin K.
 * Interface contains method to get CustomerAccount data from database
 */
public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Integer> {

	
	/**
	 * Method to get CustomerAccount for given accountId from database
	 * @param account Integer
	 * @return CustomerAccount
	 */
	public CustomerAccount findByAccountId(Integer accountId);
	
	/**
	 * Method to get CustomerAccount for given username from database
	 * @param username String
	 * @return CustomerAccount
	 */
	public CustomerAccount findByUsername(String  username);
	
	
	
}
