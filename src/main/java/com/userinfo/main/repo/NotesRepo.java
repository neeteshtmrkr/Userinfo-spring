package com.userinfo.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userinfo.main.model.Notes;

public interface NotesRepo extends JpaRepository<Notes, Long>{
	
	
}
