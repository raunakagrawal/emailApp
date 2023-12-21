package com.raunak.email.Entity;

import java.util.List;

public class EmailDetails {

    private List<String> recipient;
    private String msgBody;
    private String subject;
    

	public List<String> getRecipient() {
		return recipient;
	}
	public void setRecipient(List<String> recipient) {
		this.recipient = recipient;
	}
	public String getMsgBody() {
		return msgBody;
	}
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public EmailDetails(List<String> recipient, String msgBody, String subject) {
		this.recipient = recipient;
		this.msgBody = msgBody;
		this.subject = subject;
	}
	public EmailDetails() {

	}
    
    
    
}
