package com.ge.customerbillingportal.common.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ge.customerbillingportal.util.AppUtil;

/**
 * @author Nitin K.
 * Class containing methods for handling exception for non existing account
 */
public class AccountNotExistException extends UsernameNotFoundException {

   private static final long serialVersionUID = 1L;

	public AccountNotExistException() {
        super(AppUtil.getMessage("accountNotExistException"));
    }

    public AccountNotExistException(String msg) {
        super(msg);
    }
}
