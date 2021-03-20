package com.userinfo.main.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.el.stream.Optional;
import com.userinfo.main.model.User;
import com.userinfo.main.repo.UserRepo;
import com.userinfo.main.services.UserServices;

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

	@Override
	public Object find_by_name(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(int id) {
		return userRepo.findById(id);
	}

	
	
	
	

}
