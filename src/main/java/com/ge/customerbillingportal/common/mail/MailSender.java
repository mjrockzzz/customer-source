package com.ge.customerbillingportal.common.mail;

import org.springframework.scheduling.annotation.Async;


/**
 * @author Nitin K.
 * Interface to send mail
 */
public interface MailSender {

    /**
     * Method to send mail
     * @param to String
     * @param subject String 
     * @param body String
     */
    @Async
    void send(String to, String subject, String body);
}
