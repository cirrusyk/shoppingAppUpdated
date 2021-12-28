package com.shoestore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoestore.domain.User;

import com.shoestore.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		User user = repository.findByUsername(username);
		if(null== user) {
			throw new UsernameNotFoundException("User not found");
			
		}
		 return new CustomUserDetails(user);
	}

	

}
