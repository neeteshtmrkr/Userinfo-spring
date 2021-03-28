package com.userinfo.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.annotation.CurrentSecurityContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.main.model.User;
import com.userinfo.main.repo.UserRepo;
import com.userinfo.main.services.UserServices;


import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServices<User> userServices;

	@Autowired
	private UserRepo userRepo;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody User user) {
		return new ResponseEntity<>(userServices.save(user), HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> get_all() {
		return new ResponseEntity<>(userServices.list(), HttpStatus.OK);
	}

	@RequestMapping(value = "")
	public String info(@CurrentSecurityContext(expression = "authentication?.name") String username, Model model) {
		List<User> user = userRepo.findByUsername(username);
		model.addAttribute("user", user);
		return "userinfo";
	}

}
