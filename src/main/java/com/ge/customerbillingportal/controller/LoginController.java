package com.ge.customerbillingportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ge.customerbillingportal.common.consts.UrlPathConstants;
import com.ge.customerbillingportal.dto.AuthenticateUser;
import com.ge.customerbillingportal.entity.CustomerAccount;
import com.ge.customerbillingportal.service.LoginService;

/**
 * @author Nitin K.
 * Contains API to login to customer billing portal
 */
@RestController
@RequestMapping(value = UrlPathConstants.LOGIN)
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	/**
	 * @author Nitin K.
	 * @purpose to login to customer billing portal
	 * @param customerAccount CustomerAccount
	 * @return ResponseEntity<AuthenticateUser>
	 * @date 2017-07-05
	 */

	@RequestMapping(value = UrlPathConstants.AUTHENTICATE, method = RequestMethod.POST)
	// @PreAuthorize("hasRole('TEST')")
	public ResponseEntity<AuthenticateUser> login(@RequestBody CustomerAccount customerAccount) {

		logger.info("Entered into login controller.......");

		return loginService.login(customerAccount);

	}

}
