package com.userinfo.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.userinfo.main.model.User;

public interface UserRepo extends CrudRepository<User,Long>{
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String username);
	List<User> findById(Integer id);
}
