package com.userinfo.main.model;

import java.util.Date;

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


import lombok.Data;

@Entity
/*
 * @SQLDelete(sql="UPDATE notes SET deleted=true WHERE id=?")//adding this query
 * for soft delete
 * 
 * @Where(clause="deleted=false")
 */
public class Notes{

	@Id
	@GeneratedValue
	private Long id;
	
	/*
	 * @ManyToOne()
	 * 
	 * @JsonBackReference private User user;
	 */
	
	/*
	 * private String title;
	 * 
	 * 
	 * private String description;
	 */
	
	/*
	 * @Column(name="deleted") private Boolean deleted=false;
	 */
	
	/*
	 * @Column(columnDefinition = "MEDIUMBLOB") private String image;
	 */
	
	private String docName;
	
	private String docType;
	
	
	
	/*
	 * @CreationTimestamp private Date dateCreated;
	 * 
	 * @UpdateTimestamp private Date dateUpdated;
	 */
	
	@Lob
	private byte[] data;

	public Notes(String docName, String docType, byte[] data) {
		super();
		this.docName = docName;
		this.docType = docType;
		this.data = data;
	}

	public Notes() {
		
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
	
	
}
