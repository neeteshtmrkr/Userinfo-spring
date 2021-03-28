package com.userinfo.main.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

@SQLDelete(sql="UPDATE notes SET deleted=true WHERE id=?")//adding this query for soft delete
  
@Where(clause="deleted=false")
 
public class Notes{

	@Id
	@GeneratedValue
	private Long id;
	
	
	/*
	 * @ManyToOne()
	 * 
	 * @JsonBackReference private User user;
	 */
	
	@Column(name="deleted") 
	private Boolean deleted=false;
	
	private String docName;
	
	private String docType;
	
	/*
	 * @CreationTimestamp private Date dateCreated;
	 * 
	 * @UpdateTimestamp private Date dateUpdated;
	 */
	 
	@Lob
	private byte[] data;

	private String title;
	
	private String description;

	public Notes() {
		super();
	}
	
	public Notes(String docName, String docType, byte[] data,
			String title, String description,Boolean deleted) {
		super();
		this.deleted = false;
		this.docName = docName;
		this.docType = docType;

		this.data = data;
		this.title = title;
		this.description = description;
		
	}
	

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDocName() {
		return docName;
	}



	public void setDocName(String docName) {
		this.docName = docName;
	}



	public String getDocType() {
		return docType;
	}



	public void setDocType(String docType) {
		this.docType = docType;
	}



	public byte[] getData() {
		return data;
	}



	public void setData(byte[] data) {
		this.data = data;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	
	
}
