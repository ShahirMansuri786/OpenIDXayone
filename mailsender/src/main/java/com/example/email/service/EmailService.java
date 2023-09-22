package com.example.email.service;

import com.example.email.entity.EmailDetails;
import com.example.email.entity.GenerateOtp;

public interface EmailService {


    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

	String generate(GenerateOtp generateOtp);
 
    // Method
    // To send an email with attachment
//    String sendMailWithAttachment(EmailDetails details);
	
	 
}
