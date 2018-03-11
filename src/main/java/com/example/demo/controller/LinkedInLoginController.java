package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.LinkedInProfile;
import com.example.demo.entity.Student;
import com.example.demo.repo.LinkedInProfileRepository;
import com.example.demo.repo.StudentRepository;

@RestController
public class LinkedInLoginController {
	
	@GetMapping(value="/linkedInCallback")
	public String linkedInServerCallback(
			@RequestParam(name="code", required=true) String code,
			@RequestParam(name="state", required=true) String state,
			@RequestParam(name="error", required=false,defaultValue="") String error,
			@RequestParam(name="error_description", required=false,defaultValue="") String error_description,
			HttpServletRequest request
			) {
		
		if(error.equals("")) {
			//Error orccured
			return error_description;
		}
		String hash = (String)request.getSession().getAttribute("state");
		if(!hash.equals(state)) {
			
			//Victom of CSRF attack!!!
			
			System.out.println("hash is not equal to state!");
			return "STATE does not match";
		}
		return "";
	}
	
	
}
