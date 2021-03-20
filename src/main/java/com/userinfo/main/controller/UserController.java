package com.userinfo.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.main.model.User;
import com.userinfo.main.repo.UserRepo;
import com.userinfo.main.services.UserServices;

import java.lang.ProcessBuilder.Redirect;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

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

	
	@RequestMapping(value="/",method = RequestMethod.GET) 
	public String index(Model model){
	/*
	 * List<User> userItems= (List<User>) userServices.list(); //
	 * model.addAttribute("userItems",userItems);
	 * 
	 * return "index"; }
	 */
		model.addAttribute("userList",userRepo.findAll());
		return "userinfo";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> get_all() {
		return new ResponseEntity<>(userServices.list(), HttpStatus.OK);
	}
	
	/*
	 * @RequestMapping(value="/{user_id}",method = RequestMethod.GET) public
	 * ResponseEntity<?> getUserInfo(@PathVariable("user_id") Long user_id,Principal
	 * principal) { if(principal.equals(user_id)) { return new
	 * ResponseEntity<>(userServices.find_by_id(user_id),HttpStatus.OK); } else
	 * return null; }
	 */
	
	@RequestMapping(value="/{_id}",method = RequestMethod.GET)
	public ResponseEntity<?> info(@PathVariable("_id") int _id){
//		return new ResponseEntity<>(userServices.findById(_id),HttpStatus.OK);
		return new ResponseEntity<>(userServices.getById(_id),HttpStatus.OK);
	}
	
	
	
	
	
}
