package com.userinfo.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.userinfo.main.user.model.Notes;
import com.userinfo.main.user.repo.NotesRepo;
import com.userinfo.main.user.services.NotesServices;

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
	public Object delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list() {
		return notesRepo.findAll();
	}

}
