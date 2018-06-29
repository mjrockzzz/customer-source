package com.ge.customerbillingportal.dao;

import org.springframework.data.repository.CrudRepository;

import com.ge.customerbillingportal.entity.CustomerAccount;

public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Integer> {

	
	public CustomerAccount findByAccountId(Integer accountId);
	
	public CustomerAccount findByUsername(String  username);
	
	
	
}
