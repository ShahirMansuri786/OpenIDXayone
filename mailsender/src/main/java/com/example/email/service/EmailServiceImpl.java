package com.example.email.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.email.entity.EmailDetails;
import com.example.email.entity.GenerateOtp;
import com.example.email.repo.EmailDataRepo;

import jakarta.mail.internet.MimeMessage;



@Service
public class EmailServiceImpl implements EmailService {

	@Autowired private JavaMailSender javaMailSender;
	
	private GenerateOtp genrateOtp;
	
	@Autowired private EmailDataRepo emailDataRepo;
	
	 
    @Value("${spring.mail.username}") 
    private String sender;
    
   
 
    
    // To send a simple email
    public String sendSimpleMail(EmailDetails details)
    {
	    	
        try {
 
        	MimeMessage mime= javaMailSender.createMimeMessage();
        	MimeMessageHelper mailMessage=new MimeMessageHelper(mime, true);
 
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
 
            javaMailSender.send(mime);
            return "Mail Sent Successfully...";
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
        	e.printStackTrace();
            return "Error while Sending Mail";
        }}
    
    
    
  


	@Override
	public String generate(GenerateOtp generateOtp) {
	
		Random random = new Random();
		Integer otp=random.nextInt(1000, 2000);
		
		try {
	    	
	    	MimeMessage mime= javaMailSender.createMimeMessage();
	    	MimeMessageHelper mailMessage=new MimeMessageHelper(mime, true);

	        // Setting up necessary details
	        mailMessage.setFrom(sender);
	        mailMessage.setTo(generateOtp.getRecipient());
	      //  mailMessage.setTo(generateOtp.getSubject());
	        mailMessage.setText(otp.toString());
	  
	        javaMailSender.send(mime);
	        return "OTP Sent Successfully...";
	    }

	    // Catch block to handle the exceptions
	    catch (Exception e) {
	    	e.printStackTrace();
	        return "Error while Sending Mail";
	    }	}
	

}
