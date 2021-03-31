package com.userinfo.main.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.userinfo.main.model.Notes;
import com.userinfo.main.model.User;
import com.userinfo.main.repo.NotesRepo;
import com.userinfo.main.repo.UserRepo;
import com.userinfo.main.services.NotesServices;

@Controller
@RequestMapping("/notes")
public class NotesController {
	
	@Autowired
	private NotesServices notesServices;

	@Autowired
	private NotesRepo notesRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/")
	public String get(@CurrentSecurityContext(expression = "authentication?.name") String username,Model model) {
		List<User> user = userRepo.findByUsername(username);
		model.addAttribute("user", user);
		List<Notes> notes=notesServices.getFiles();
		model.addAttribute("notes",notes);
		return "create-new";
		
	}
	
	
	@PostMapping("/uploadFiles")
	public ResponseEntity<?> uploadFiles(@RequestParam("files") MultipartFile files,@RequestParam("title") String title,
				@RequestParam("description") String description,Boolean deleted) {
		return new ResponseEntity<>(notesServices.save(files, title,description,deleted),HttpStatus.OK);
	}
	
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId){
		Notes notes=notesServices.getFile(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(notes.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+notes.getDocName()+"\"")
				.body(new ByteArrayResource(notes.getData()));
	}
	
	  @RequestMapping(value="/edit/{_id}",method = RequestMethod.PUT) public
	  ResponseEntity<?> edit(@PathVariable long _id,@RequestBody Notes notes){
	  return new ResponseEntity<>(notesServices.edit(_id,notes),HttpStatus.OK); }
	 
	  @GetMapping("/delete/{_id}")
	  public String delete(@PathVariable long _id){ 
		  notesServices.delete(_id);
		  return "redirect:/user";
	  }
	 
	  @GetMapping("/all")
	  public ResponseEntity<?> all(){
		  return new ResponseEntity<>(notesServices.getFiles(),HttpStatus.OK);
	  }
	  
//================FOR EDITING THE NOTES DATA USING THE HTML PAGE=======================================================
	  
	  //To show the data associated with the note while in edit page
	  @GetMapping("/update/{_id}")
	  public String showUpdateForm(@PathVariable("_id") long _id,Model model) {
		  Notes notes=notesRepo.findById(_id)
				  .orElseThrow(()->new IllegalArgumentException("Invalid Notes Id:" + _id));
		  
		  model.addAttribute("notes",notes);
		  return "update-notes";
	  }
	  
	  //only editing the title and description
	  //using the edit from notes services which lets us to edit only required field and set other as it is
	  @PostMapping("/update/{_id}")
	  public String updateNotes(@PathVariable("_id") long _id,Notes notes) {
		  notesServices.edit(_id,notes);
		  return "redirect:/user/";
	  }
}
