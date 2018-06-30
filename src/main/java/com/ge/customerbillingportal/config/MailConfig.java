package com.ge.customerbillingportal.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

import com.ge.customerbillingportal.common.mail.MailSender;
import com.ge.customerbillingportal.common.mail.SmtpMailSender;

/**
 * @author Nitin K.
 * Bean configuration class to register mail service interfaces
 */
@Configuration
public class MailConfig {

    private static Logger LOG = LoggerFactory.getLogger(MailConfig.class);

    @Value("${spring.mail.username}")
    private String from;

    @Bean
    @Profile("!test")
    public MailSender smtpMailSender(JavaMailSender javaMailSender) {
        SmtpMailSender smtpMailSender = new SmtpMailSender();
        smtpMailSender.setJavaMailSender(javaMailSender, from);
        return smtpMailSender;
    }

    @Bean
    @Profile("test")
    public MailSender testMailSender() {
        return new MailSender() {
            @Override
            public void send(String to, String subject, String body) {
                LOG.warn("\n\n---> Start send mail");
                LOG.warn("TestMailSender:" + to + "," + subject + "," + body);
                LOG.warn("\n");
            }
        };
    }


}
