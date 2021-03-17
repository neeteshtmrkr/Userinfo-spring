package com.userinfo.main.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userinfo.main.user.model.User;

public interface UserRepo extends JpaRepository<User,Long>{
	
}
