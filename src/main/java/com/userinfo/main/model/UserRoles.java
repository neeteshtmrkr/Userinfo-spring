package com.userinfo.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users_roles")
public class UserRoles {

	@Id
	@Column(name="user_id")
	private Long user_id;
	
	@Column(name="role_id")
	private Long role_id;
}
