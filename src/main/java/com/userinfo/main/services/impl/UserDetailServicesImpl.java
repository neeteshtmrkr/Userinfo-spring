package com.userinfo.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.userinfo.main.model.User;
import com.userinfo.main.repo.UserRepo;
import com.userinfo.main.userdetails.MyUserDetails;

public class UserDetailServicesImpl implements UserDetailsService {
 
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.getUserByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(user);
	} 

}
