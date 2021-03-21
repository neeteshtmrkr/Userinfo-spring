package com.userinfo.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.userinfo.main.model.User;

public interface UserRepo extends CrudRepository<User,Long>{
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String username);
	
	/*
	 * @Query("SELECT p.* from post p innerjoin user u on(p.user_id=u.id) where u.username=:loggedinusername"
	 * ) public User getUsernameDetails(@Param("username") String
	 * loggedinusernameusername);
	 */
	
	List<User> findByUsername(String username); 
	
	List<User> findById(Integer id);
}
