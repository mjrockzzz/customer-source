package com.ge.customerbillingportal.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ge.customerbillingportal.common.consts.CommonMessages;
import com.ge.customerbillingportal.dao.CustomerAccountRepository;
import com.ge.customerbillingportal.dto.AuthenticateUser;
import com.ge.customerbillingportal.dto.UserResponse;
import com.ge.customerbillingportal.entity.CustomerAccount;
import com.ge.customerbillingportal.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private CustomerAccountRepository customerAccountRepository;
	
	/**
	 * @author Nitin K.
	 * @purpose to login to customer biling portal
	 * @param CustomerAccount customerAccoun
	 * @return ResponseEntity<AuthenticateUser>
	 * @date 2017-07-05
	 */


	@Override
	public ResponseEntity<AuthenticateUser> login(CustomerAccount customerAccount) {
		// TODO Auto-generated method stub
		logger.info("Entered into login service method.....");
		AuthenticateUser authenticateUser = new AuthenticateUser();

		CustomerAccount existedCustomerAccount = customerAccountRepository
				.findByUsername(customerAccount.getUsername());
		if (existedCustomerAccount == null) {
			logger.debug("user not found with name " + customerAccount.getUsername());
			authenticateUser.setMessage(CommonMessages.INVALID_USERNAME);
			return new ResponseEntity<AuthenticateUser>(authenticateUser, HttpStatus.NOT_FOUND);
		} else {
			if (existedCustomerAccount.getPassword().equals(customerAccount.getPassword())) {
				logger.debug("user found with name " + customerAccount.getUsername());
				authenticateUser.setMessage(CommonMessages.VALID_USER);
				UserResponse userResponse = new UserResponse();
				userResponse.setUserName(existedCustomerAccount.getUsername());
				userResponse.setAccountId(existedCustomerAccount.getAccountId());
				userResponse.setCustomerName(existedCustomerAccount.getCustomerName());
				authenticateUser.setUserResponse(userResponse);
				return new ResponseEntity<AuthenticateUser>(authenticateUser, HttpStatus.OK);

			}
		}
		logger.debug("Password is wrong for user " + customerAccount.getUsername());
		authenticateUser.setMessage(CommonMessages.INVALID_PASSWORD);
		return new ResponseEntity<AuthenticateUser>(authenticateUser, HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
