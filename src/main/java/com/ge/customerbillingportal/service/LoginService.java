package com.ge.customerbillingportal.service;

import org.springframework.http.ResponseEntity;

import com.ge.customerbillingportal.dto.AuthenticateUser;
import com.ge.customerbillingportal.entity.CustomerAccount;

/**
 * @author Nitin K.
 * Interface containing methods to login to customer billing portal
 */
public interface LoginService {
	
	/**
	 * @author Nitin K.
	 * @purpose to login to customer billing portal
	 * @param CustomerAccount customerAccoun
	 * @return ResponseEntity<AuthenticateUser>
	 * @date 2017-07-05
	 */
	public ResponseEntity<AuthenticateUser> login(CustomerAccount customerAccount);

}
