package com.example.sec.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sec.entity.User;
import com.example.sec.repo.LoginRepo;
import com.example.sec.repo.UserLoginDetiails;

public class LoginUser implements UserDetailsService{

	  @Autowired
	  private LoginRepo repo;
	 
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> user= repo.findByUserName(userName);
		
		System.out.println(user);
		
		User u = user.orElseThrow(()-> new UsernameNotFoundException("UserNotFound"));
		return new UserLoginDetiails(u);
	}

	public String create(User u) {
		repo.save(u);
		return "done";
	}

}
