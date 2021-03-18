package com.userinfo.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.main.model.User;
import com.userinfo.main.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServices<User> userServices;
	
	@PostMapping("/signup")
	public ResponseEntity<?> save(@RequestBody User user){
		return new ResponseEntity<>(userServices.save(user),HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> get_all(){
		return new ResponseEntity<>(userServices.list(),HttpStatus.OK);
	}
}
