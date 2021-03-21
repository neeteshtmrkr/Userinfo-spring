package com.userinfo.main.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userinfo.main.model.Notes;
import com.userinfo.main.repo.NotesRepo;
import com.userinfo.main.services.NotesServices;

@Service
public class NotesServicesImpl implements NotesServices<Notes> {

	@Autowired
	private NotesRepo notesRepo;
	
	@Override
	public Object save(Notes t) {
		return notesRepo.save(t);
	}

	@Override
	public Object edit(long id,Notes t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		notesRepo.deleteById(id);
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
