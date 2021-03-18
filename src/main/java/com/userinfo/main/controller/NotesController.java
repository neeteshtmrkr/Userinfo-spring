package com.userinfo.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.main.model.Notes;
import com.userinfo.main.services.NotesServices;

@RestController
@RequestMapping("/notes")
public class NotesController {

	@Autowired
	private NotesServices<Notes> notesServices;
	
	@PostMapping("/create-new")
	public ResponseEntity<?> save(@RequestBody Notes notes){
		return new ResponseEntity<>(notesServices.save(notes),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> get_all(){
		return new ResponseEntity<>(notesServices.list(),HttpStatus.OK);
	}
	
	@PutMapping("/edit/{_id}")
	public ResponseEntity<?> edit(@PathVariable long _id,@RequestBody Notes notes){
		return new ResponseEntity<>(notesServices.edit(_id,notes),HttpStatus.OK);
	}
	 
	
}
