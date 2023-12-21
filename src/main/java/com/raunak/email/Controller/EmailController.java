package com.raunak.email.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.email.Entity.EmailDetails;
import com.raunak.email.Service.EmailService;

@RestController
public class EmailController {

	@Autowired private EmailService emailService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/sendMail")
	public ResponseEntity<Object> sendMail(@RequestBody EmailDetails details)
	{
		return emailService.sendSimpleMail(details);
	}
}
