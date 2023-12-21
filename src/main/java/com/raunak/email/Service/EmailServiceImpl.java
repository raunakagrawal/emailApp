package com.raunak.email.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.raunak.email.Entity.EmailDetails;
import com.raunak.email.ErrorResponce.ResponseHandler;

import jakarta.mail.internet.MimeMessage;
 
@Service
public class EmailServiceImpl implements EmailService {
 
    @Autowired
    private JavaMailSender javaMailSender;
 
    @Value("${spring.mail.username}")
    private String sender;
 
    public ResponseEntity<Object> sendSimpleMail(EmailDetails details)
    {
    	try {
	    	for(String reciptent: details.getRecipient()) {
	    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	        MimeMessageHelper mimeMessageHelper;
	        
	        	 mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	             mimeMessageHelper.setFrom(sender);
	             mimeMessageHelper.setTo(reciptent);
	             mimeMessageHelper.setText(details.getMsgBody());
	             mimeMessageHelper.setSubject(details.getSubject());
	 
	            javaMailSender.send(mimeMessage);
	        }
	    	return ResponseHandler.generateResponse("Mail Sent Successfully.", HttpStatus.OK, null);
    	}
        catch (Exception e) {
        	return ResponseHandler.generateResponse("Error while Sending Mail", HttpStatus.MULTI_STATUS, null);
        }
    }
}