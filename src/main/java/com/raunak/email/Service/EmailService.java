package com.raunak.email.Service;

import org.springframework.http.ResponseEntity;

import com.raunak.email.Entity.EmailDetails;

public interface EmailService {
    ResponseEntity<Object> sendSimpleMail(EmailDetails details);
}
