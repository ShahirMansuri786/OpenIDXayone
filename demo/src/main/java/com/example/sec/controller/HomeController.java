package com.example.sec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sec.entity.EmailDetails;
import com.example.sec.service.EmailService;

@RestController("/")

public class HomeController {
	
	
	@GetMapping("home")
	public String Test() {
	
		return "Hi shahir";
	}
	
	  @Autowired private EmailService emailService;
	  
	    // Sending a simple Email
	    @PostMapping("/sendMail")
	    public String
	    sendMail(@RequestBody EmailDetails details)
	    {
	        String status
	            = emailService.sendSimpleMail(details);
	 
	        return status;
	    }
	
	

}
