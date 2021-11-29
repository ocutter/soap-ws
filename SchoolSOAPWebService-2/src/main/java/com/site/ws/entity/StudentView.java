package com.site.ws.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "view_student")
public class StudentView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "StudentId")
	private long studentId;
	
	@Column(name = "FullName")
	private String fullName;
	
	@Column(name = "DateOfBirth")
	private String dateOfBirth;
	
	@Column(name = "Age")
	private int age;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "AcademicDegree")
	private String academicDegree;
	
	@Column(name = "ParentId")
	private long parentId;
	
	@Column(name = "ParentFullName")
	private String parentFullName;
	
	@Column(name = "ParentIdCard")
	private String parentIdCard;
	
	@Column(name = "ParentDOBText")
	private String parentDOBText;
	
	public String getParentFullName() {
		return parentFullName;
	}

	public void setParentFullName(String parentFullName) {
		this.parentFullName = parentFullName;
	}

	public String getParentIdCard() {
		return parentIdCard;
	}

	public void setParentIdCard(String parentIdCard) {
		this.parentIdCard = parentIdCard;
	}

	public String getParentDOBText() {
		return parentDOBText;
	}

	public void setParentDOBText(String parentDOBText) {
		this.parentDOBText = parentDOBText;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(String academicDegree) {
		this.academicDegree = academicDegree;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	
}
