package com.userinfo.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.userinfo.main.model.Notes;
import com.userinfo.main.model.User;
import com.userinfo.main.repo.NotesRepo;

@Service
public class NotesServices{

	@Autowired
	public NotesRepo notesRepo;
	
	public Notes save(MultipartFile file) {
		String docname=file.getOriginalFilename();
		try {
			Notes notes=new Notes(docname,file.getContentType(),file.getBytes());
			return notesRepo.save(notes);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Optional<Notes> getFile(Long fileId) {
		return notesRepo.findById(fileId);
	}
	public List<Notes> getFiles(){
		return notesRepo.findAll();
	}
	
}