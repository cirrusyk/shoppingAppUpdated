package com.shoestore.service;

import java.util.List;
import java.util.Set;


import com.shoestore.domain.User;
import com.shoestore.domain.security.UserRole;



public interface UserService {
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
	List<User> findAll();

	User findByUsername(String username);

	
	
}
