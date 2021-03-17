package com.userinfo.main.user.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class Notes {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String description;
	
	@CreationTimestamp
	private Date dateCreated;
	
	@UpdateTimestamp
	private Date dateUpdated;
	
}
