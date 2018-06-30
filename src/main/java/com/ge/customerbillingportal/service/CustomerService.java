package com.ge.customerbillingportal.service;

import com.ge.customerbillingportal.dto.WSCustomerAccount;

/**
 * @author Nitin K.
 * Interface containing methods to get customer all data from account id
 */
public interface CustomerService {

	/**
	 * @author Nitin K.
	 * @purpose to get customer all data from account id
	 * @param Integer accountId
	 * @return CustomerAccount
	 * @date 2017-07-06
	 */
	public WSCustomerAccount getCustomerByAccountId(Integer accountId);

}
