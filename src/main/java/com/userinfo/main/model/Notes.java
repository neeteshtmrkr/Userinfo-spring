package com.userinfo.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@SQLDelete(sql="UPDATE notes SET deleted=true WHERE id=?")//adding this query for soft delete
@Where(clause="deleted=false")
public class Notes {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne()
	@JsonBackReference
	private User user;
	
	private String title;
	
	private String description;
	
	@Column(name="deleted",columnDefinition = "default'false'")
	private Boolean deleted=false;
	
	@CreationTimestamp
	private Date dateCreated;
	
	@UpdateTimestamp
	private Date dateUpdated;
	
}
