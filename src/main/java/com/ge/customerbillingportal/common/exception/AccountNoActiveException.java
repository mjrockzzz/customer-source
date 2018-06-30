package com.ge.customerbillingportal.common.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ge.customerbillingportal.util.AppUtil;

/**
 * @author Nitin K.
 * Class containing methods for handling exception for inactive account
 */
public class AccountNoActiveException extends UsernameNotFoundException {

	private static final long serialVersionUID = 1L;
	public AccountNoActiveException() {
        super(AppUtil.getMessage("accountNoActiveException"));
    }
    public AccountNoActiveException(String msg) {
        super(msg);
    }
}
