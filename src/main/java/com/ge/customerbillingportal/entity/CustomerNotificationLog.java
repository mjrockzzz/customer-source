package com.ge.customerbillingportal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cust_notification_log")
public class CustomerNotificationLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerNotifcationLogId;

	@Column(name = "message_method", length = 16)
	private String messageMethod;

	@Column(name = "msg_address", length = 64)
	private String messageAddress;

	@Column(name = "Message_body", length = 200)
	private String messageBody;

	// Many To One relationship between CustomerNotificationLog and
	// CustomerAccount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Acct_ID", nullable = false)
	private CustomerAccount customerAccount;

	@Column(name = "Message_sent_time")
	private Date messageSentTime;

	@Column(name = "Message_scheduled_time")
	private Date messageScheduledTime;

	@Column(name = "message_status", length = 16)
	private String messageStatus;

	public Integer getCustomerNotifcationLogId() {
		return customerNotifcationLogId;
	}

	public void setCustomerNotifcationLogId(Integer customerNotifcationLogId) {
		this.customerNotifcationLogId = customerNotifcationLogId;
	}

	public String getMessageMethod() {
		return messageMethod;
	}

	public void setMessageMethod(String messageMethod) {
		this.messageMethod = messageMethod;
	}

	public String getMessageAddress() {
		return messageAddress;
	}

	public void setMessageAddress(String messageAddress) {
		this.messageAddress = messageAddress;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	@JsonIgnore
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}

	public Date getMessageSentTime() {
		return messageSentTime;
	}

	public void setMessageSentTime(Date messageSentTime) {
		this.messageSentTime = messageSentTime;
	}

	public Date getMessageScheduledTime() {
		return messageScheduledTime;
	}

	public void setMessageScheduledTime(Date messageScheduledTime) {
		this.messageScheduledTime = messageScheduledTime;
	}

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	
	

}
