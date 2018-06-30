package com.ge.customerbillingportal.common.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ge.customerbillingportal.util.AppUtil;

/**
 * @author Nitin K.
 * Class containing methods for handling exception for frozen account
 */
public class AccountFrozenException extends UsernameNotFoundException {

    private static final long serialVersionUID = 1L;

	public AccountFrozenException() {
        super(AppUtil.getMessage("accountFrozenException"));
    }

    public AccountFrozenException(String msg) {
        super(msg);
    }
}
