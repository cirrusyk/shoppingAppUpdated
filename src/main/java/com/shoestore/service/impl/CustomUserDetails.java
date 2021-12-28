package com.shoestore.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.shoestore.domain.User;

public class CustomUserDetails implements org.springframework.security.core.userdetails.UserDetails {
	
	private User user;
	
	
	public CustomUserDetails(User user) {
		 
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return null;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
	
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
