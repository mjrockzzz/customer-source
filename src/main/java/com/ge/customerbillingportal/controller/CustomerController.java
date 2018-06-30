package com.ge.customerbillingportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ge.customerbillingportal.common.consts.UrlPathConstants;
import com.ge.customerbillingportal.dto.WSCustomerAccount;
//import com.ge.customerbillingportal.entity.CustomerAccount;
import com.ge.customerbillingportal.service.CustomerService;


/**
 * @author Nitin K.
 * Contains API to get customer all data from account id
 */
@RestController
@RequestMapping(value = UrlPathConstants.CUSTOMER)
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	
	/**
	 * @author Nitin K.
	 * @purpose to get customer all data from account id
	 * @param accountId Integer
	 * @return ResponseEntity<CustomerAccount>
	 * @date 2017-07-05
	 */

	@RequestMapping(value = UrlPathConstants.GET_CUSTOMER_DATA, method = RequestMethod.GET)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<WSCustomerAccount> getCustomerData(@RequestParam(value = "accountId") Integer accountId) {

		logger.info("Entered into getCustomerData controller.......");

		WSCustomerAccount customerAccount = customerService.getCustomerByAccountId(accountId);
		if(customerAccount!=null)
		return new ResponseEntity<WSCustomerAccount>(customerAccount, HttpStatus.OK);
		else
			return new ResponseEntity<WSCustomerAccount>(customerAccount, HttpStatus.NOT_FOUND);
			

	}

}
