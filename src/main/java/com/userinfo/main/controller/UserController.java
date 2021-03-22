package com.userinfo.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
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

	/*
	 * @RequestMapping(value="/",method = RequestMethod.GET) public String
	 * index(Model model){
	 * 
	 * List<User> userItems= (List<User>) userServices.list(); //
	 * model.addAttribute("userItems",userItems);
	 * 
	 * return "index"; }
	 * 
	 * model.addAttribute("userList",userRepo.findAll()); return "userinfo"; }
	 */

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

	@RequestMapping(value = "/{_id}", method = RequestMethod.GET)
	public ResponseEntity<?> info(@PathVariable("_id") int _id, Principal principal) {
//		return new ResponseEntity<>(userServices.findById(_id),HttpStatus.OK);

		return new ResponseEntity<>(userServices.getById(_id), HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value="/username",method = RequestMethod.GET) public String
	 * currentUsername(Authentication authentication) { Object
	 * principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal
	 * (); if(principal instanceof UserDetails) { String username; return
	 * username=((UserDetails)principal).getUsername(); }else { String username;
	 * return username=principal.toString(); } }
	 */

	/*
	 * @RequestMapping(value="/username",method = RequestMethod.GET) public String
	 * currentUsername(Authentication authentication) { Object
	 * principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal
	 * ();
	 * 
	 * if(principal instanceof UserDetails) { String loggedinusername; return
	 * loggedinusername=((UserDetails)principal).getUsername(); }else { String
	 * loggedinusername; return loggedinusername=principal.toString(); } User
	 * user=userRepo.getUsernameDetails(loggedinusername); }
	 */

	/*
	 * @RequestMapping(value = "") public ResponseEntity<?>
	 * hello(@CurrentSecurityContext(expression = "authentication?.name") String
	 * username) { return new ResponseEntity<>(userRepo.findByUsername(username),
	 * HttpStatus.OK); }
	 */

//	 @RequestMapping(value="/details/{name}")
//	 public ResponseEntity<?> details(@PathVariable ("name"==username),@CurrentSecurityContext(expression = "authentication?.name") String username){
//		 
//	 }

	@RequestMapping(value = "")
	public String info(@CurrentSecurityContext(expression = "authentication?.name") String username, Model model) {
		List<User> user = userRepo.findByUsername(username);
		model.addAttribute("user", user);
		return "userinfo";
	}

}
