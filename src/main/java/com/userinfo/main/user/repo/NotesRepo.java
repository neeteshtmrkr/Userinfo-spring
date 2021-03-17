package com.userinfo.main.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userinfo.main.user.model.Notes;

public interface NotesRepo extends JpaRepository<Notes, Long>{

}
