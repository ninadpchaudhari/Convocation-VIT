package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LinkedInProfile;
import com.example.demo.repo.LinkedInProfileRepository;
import com.example.demo.repo.StudentRepository;

@RestController
public class StudentsController {
	
	@Autowired
	LinkedInProfileRepository linkedInRepo;
	
	//Store Linkedin info !
	@PostMapping(value="/linkedIn")
	public String saveLinkedInInfo(
			@RequestParam(name="firstName", required=false, defaultValue="") String firstName,
			@RequestParam(name="lastName", required=false, defaultValue="") String lastName,
			@RequestParam(name="linkedInId", required=true) String linkedInId,
			@RequestParam(name="pictureUrl", required=true) String pictureUrl,
			@RequestParam(name="headline", required=false, defaultValue="") String headline,
			@RequestParam(name="fullResponse", required=true, defaultValue="") String fullResponse

			) 
	{
		return linkedInRepo.save(new LinkedInProfile(
				firstName,
				lastName,
				linkedInId,
				headline,
				pictureUrl,
				fullResponse
				)).toString();
		
		
	}
	
	
}
