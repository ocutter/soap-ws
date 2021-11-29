package com.site.ws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parent")
public class Parent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ParentId")
	private long parentId;

	@Column(name = "FullName")
	private String fullName;

	@Column(name = "DateOfBirthStr")
	private String dateOfBirthStr;

	@Column(name = "IdentificationCard")
	private String identificationCard;

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateOfBirthStr() {
		return dateOfBirthStr;
	}

	public void setDateOfBirthStr(String dateOfBirthStr) {
		this.dateOfBirthStr = dateOfBirthStr;
	}

	public String getIdentificationCard() {
		return identificationCard;
	}

	public void setgetIdentificationCard(String identificationCard) {
		this.identificationCard = identificationCard;
	}


}
