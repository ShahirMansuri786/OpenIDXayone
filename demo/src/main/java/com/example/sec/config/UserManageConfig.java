package com.example.sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.sec.service.LoginUser;

@Configuration
public class UserManageConfig {

	private final String pass="12345";
  @Bean
	public UserDetailsService user() {
	
    	var ud= new InMemoryUserDetailsManager();
    	UserDetails user=User.withUsername("Sahir").password(pass).authorities("read").build();
        ud.createUser(user);
       
    	return ud;	
	}
    
    @Bean
    public PasswordEncoder pass() {
    	return NoOpPasswordEncoder.getInstance();
    }
    
}
