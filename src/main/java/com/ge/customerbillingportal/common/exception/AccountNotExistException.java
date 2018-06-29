package com.ge.customerbillingportal.common.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ge.customerbillingportal.util.AppUtil;


public class AccountNotExistException extends UsernameNotFoundException {

    public AccountNotExistException() {
        super(AppUtil.getMessage("accountNotExistException"));
    }

    public AccountNotExistException(String msg) {
        super(msg);
    }
}
