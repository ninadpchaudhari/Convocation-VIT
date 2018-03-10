/**
 * 
 */
package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * @author ninad
 *
 */
@Entity
public class LinkedInProfile {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String linkedInId;
	private String headline;
	private String pictureUrl;
	@Lob
	@Column( length = 100000 )
	private String fullProfile;
	

	public String getFullProfile() {
		return fullProfile;
	}



	public void setFullProfile(String fullProfile) {
		this.fullProfile = fullProfile;
	}



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



	public String getLinkedInId() {
		return linkedInId;
	}



	public void setLinkedInId(String linkedInId) {
		this.linkedInId = linkedInId;
	}



	public String getHeadline() {
		return headline;
	}



	public void setHeadline(String headline) {
		this.headline = headline;
	}



	public String getPictureUrl() {
		return pictureUrl;
	}



	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}




	public LinkedInProfile(String firstName, String lastName, String linkedInId, String headline, String pictureUrl,
			String fullProfile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.linkedInId = linkedInId;
		this.headline = headline;
		this.pictureUrl = pictureUrl;
		this.fullProfile = fullProfile;
	}



	@Override
	public String toString() {
		return "LinkedInProfile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", linkedInId="
				+ linkedInId + ", headline=" + headline + ", pictureUrl=" + pictureUrl + ", fullProfile=" + fullProfile
				+ "]";
	}



	/**
	 * 
	 */
	public LinkedInProfile() {
		// TODO Auto-generated constructor stub
	}




}
