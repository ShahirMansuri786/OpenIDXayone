package com.example.email.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.email.entity.EmailDetails;
import com.example.email.entity.GenerateOtp;
import com.example.email.repo.EmailDataRepo;
import com.example.email.service.EmailService;

@RestController

public class HomeController {
	
      @Autowired EmailDataRepo emailDataRepo;
 	
	  @Autowired private EmailService emailService;
	  
	    // Sending a simple Email
	  
	  @PostMapping("/generateOtp")
	  public String  generate(@RequestBody GenerateOtp generateOtp ) {
		  
		 
		return emailService.generate(generateOtp);
			    
	  }
	  
	  
	  
	    @PostMapping("/sendMail")
	    public String sendMail(@RequestBody EmailDetails details)
	    {
	    	
	        String status= emailService.sendSimpleMail(details);
	 
	        return status;
	    }
	
	

}
