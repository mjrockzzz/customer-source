package com.ge.customerbillingportal.common.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ge.customerbillingportal.util.AppUtil;

public class AccountNoActiveException extends UsernameNotFoundException {

    public AccountNoActiveException() {
        super(AppUtil.getMessage("accountNoActiveException"));
    }
    public AccountNoActiveException(String msg) {
        super(msg);
    }
}
