package com.ge.customerbillingportal.service;

import com.ge.customerbillingportal.dto.WSCustomerAccount;

public interface CustomerService {

	public WSCustomerAccount getCustomerByAccountId(Integer accountId);

}
