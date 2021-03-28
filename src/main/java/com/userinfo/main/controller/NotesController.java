package com.userinfo.main.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.annotation.Resource;

import org.dom4j.util.UserDataAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.databind.ObjectMapper;
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

	
	@GetMapping("/")
	public String get(Model model) {
		List<Notes> notes=notesServices.getFiles();
		model.addAttribute("notes",notes);
		return "file-adding";
		
	}
	
	
	@PostMapping("/uploadFiles")
	public String uploadFiles(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file:files) {
			notesServices.save(file);
		}
		return "redirect:/";
	}
	
	
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId){
		Notes notes=notesServices.getFile(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(notes.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+notes.getDocName()+"\"")
				.body(new ByteArrayResource(notes.getData()));
	}
	
	
	
	/*
	 * @RequestMapping(value="/create-new") public String
	 * get(@CurrentSecurityContext(expression = "authentication?.name") String
	 * username,Model model){ Notes notes=new Notes(); List<User> usern =
	 * userRepo.findByUsername(username); model.addAttribute("usern", usern);
	 * model.addAttribute("notes", notes); return "create-new"; }
	 */

	/*
	 * @RequestMapping(value="/create-new",method = RequestMethod.POST,consumes =
	 * {MediaType.MULTIPART_FORM_DATA_VALUE},produces =
	 * {MediaType.APPLICATION_JSON_VALUE}) public String save(@RequestParam("file")
	 * MultipartFile file,@ModelAttribute("notes") Notes notes)throws IOException{
	 * File convertFile=new File("var/tmp/"+file.getOriginalFilename());
	 * convertFile.createNewFile(); FileOutputStream fout=new
	 * FileOutputStream(convertFile); fout.write(file.getBytes()); fout.close();
	 * notesServices.save(notes); return "redirect:/user/"; }
	 */
	/*
	 * ObjectMapper objectMapper=new ObjectMapper();
	 * 
	 * @RequestMapping(value="/create-new",method = RequestMethod.POST) public
	 * String save(@RequestParam(required = true,value="file") MultipartFile
	 * file,@RequestParam(required = true,value ="jsondata" )String jsondata,Model
	 * model) throws IOException{ File convertFile=new
	 * File("c://mydownloads//"+file.getName()); convertFile.createNewFile();
	 * FileOutputStream fout=new FileOutputStream(convertFile);
	 * fout.write(file.getBytes()); fout.close();
	 * 
	 * Notes notes=objectMapper.readValue(jsondata,Notes.class);
	 * model.addAttribute("notes",notes); return "create-new"; }
	 */

	/*
	 * public String save(@RequestParam("title") String title,
	 * 
	 * @RequestParam("description") String description) { notesServices.
	 * 
	 * }
	 */

	
	 
	 
	/*
	 * @RequestMapping("/all") public ResponseEntity<?> get_all(){ return new
	 * ResponseEntity<>(notesServices.list(),HttpStatus.OK); }
	 */

	/*
	 * @RequestMapping(value="/edit/{_id}",method = RequestMethod.PUT) public
	 * ResponseEntity<?> edit(@PathVariable long _id,@RequestBody Notes notes){
	 * return new ResponseEntity<>(notesServices.edit(_id,notes),HttpStatus.OK); }
	 */

	/*
	 * @RequestMapping(value="/delete/{_id}",method = RequestMethod.DELETE) public
	 * void delete(@PathVariable long _id){ notesServices.delete(_id);}
	 */

}
