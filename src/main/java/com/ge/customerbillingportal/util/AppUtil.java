package com.ge.customerbillingportal.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ge.customerbillingportal.common.security.TadalinUserDetail;

import java.util.Locale;


/**
 * @author Nitin K.
 * Utility class to get message and currently logged in user details
 */
@Component
public class AppUtil {
    private static MessageSource messageSource;

    @Autowired
    public AppUtil(MessageSource messageSource) {
        AppUtil.messageSource = messageSource;
    }

    /**
     * To read message information
     * @param messageKey
     * @param args
     * @return
     */
    public static String getMessage(String messageKey, Object... args) {
        return messageSource.getMessage(messageKey, args, Locale.ROOT);
    }

    /**
     * To get the currently logged in user details
     * @return TadalinUserDetail
     */
    public static TadalinUserDetail getAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(null != auth) {
            Object principal = auth.getPrincipal();
            if(principal instanceof TadalinUserDetail) {
                return (TadalinUserDetail) principal;
            }
        }
        return null;
    }
}
