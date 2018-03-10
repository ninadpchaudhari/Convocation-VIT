/**
 * 
 */
package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ninad
 *
 */
@Entity
public class Student {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String branch;
	private String gender;
	private String examId;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getExamId() {
		return examId;
	}


	public void setExamId(String examId) {
		this.examId = examId;
	}


	public Student(String firstName, String lastName, String branch, String gender, String examId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
		this.gender = gender;
		this.examId = examId;
	}


	/**
	 * 
	 */
	public Student() {
		// TODO Auto-generated constructor stub
	}

}
