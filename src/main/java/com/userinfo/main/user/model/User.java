package com.userinfo.main.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private Long mobilenumber;
	private String username;
	private String password;
	
}
