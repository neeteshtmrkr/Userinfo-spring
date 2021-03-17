package com.userinfo.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userinfo.main.user.model.User;
import com.userinfo.main.user.repo.UserRepo;
import com.userinfo.main.user.services.UserServices;

@Service
public class UserServicesImpl implements UserServices<User> {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public Object save(User t) {
		return userRepo.save(t);
	}

	@Override
	public Object edit(long id, User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list() {
		return userRepo.findAll();
	}

}
