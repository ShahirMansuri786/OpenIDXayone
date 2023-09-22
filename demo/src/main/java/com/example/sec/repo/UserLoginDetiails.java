package com.example.sec.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.sec.entity.User;

public class UserLoginDetiails implements UserDetails {
	
	private final User u;
	
	public UserLoginDetiails(User u){
		this.u=u;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(()->"read");
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return u.getPassWord();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return u.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
