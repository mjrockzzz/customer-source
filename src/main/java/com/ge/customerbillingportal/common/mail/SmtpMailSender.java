package com.ge.customerbillingportal.common.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/**
 * @author Nitin K.
 * Class containing method to send mail
 */
public class SmtpMailSender implements MailSender {

    private static Logger LOG = LoggerFactory.getLogger(MailSender.class);

    private JavaMailSender javaMailSender;
    private String from;

    /**
     * Method sets mail sender and receiver.
     * @param javaMailSender JavaMailSender
     * @param from String
     */
    public void setJavaMailSender(JavaMailSender javaMailSender, String from) {
        this.javaMailSender = javaMailSender;
        this.from = from;
    }

    /**
     * Method to send mail
     * @param to String
     * @param subject String 
     * @param body String
     */
    @Override
    public void send(String to, String subject, String body) {

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body, true);
            mimeMessageHelper.setFrom(from);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOG.error("发送邮件异常: " + to + ", 错误原因: " + e.toString());
        }
    }
}
