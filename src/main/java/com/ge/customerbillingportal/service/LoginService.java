package com.ge.customerbillingportal.service;

import org.springframework.http.ResponseEntity;

import com.ge.customerbillingportal.dto.AuthenticateUser;
import com.ge.customerbillingportal.entity.CustomerAccount;

public interface LoginService {
	public ResponseEntity<AuthenticateUser> login(CustomerAccount customerAccount);

}
