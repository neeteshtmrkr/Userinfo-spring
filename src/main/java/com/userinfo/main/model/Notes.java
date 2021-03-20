package com.userinfo.main.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Notes {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne()
	@JsonBackReference
	private User user;
	
	private String title;
	
	private String description;
	
	@CreationTimestamp
	private Date dateCreated;
	
	@UpdateTimestamp
	private Date dateUpdated;
	
}
