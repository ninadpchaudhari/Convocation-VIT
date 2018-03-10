package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.LinkedInProfile;
import com.example.demo.repo.LinkedInProfileRepository;

/**
 * @author ninad
 *
 */
@Controller
public class RegistrationController {
	@Autowired
	LinkedInProfileRepository linkedInRepo;
	@GetMapping(value="/")
	public String hi() {
        return "index";
	}
	@GetMapping(value="/allSignIns")
	public ModelAndView getLinkedInInfo() 
	{
		ModelAndView mv = new ModelAndView();
		List<LinkedInProfile> profiles = linkedInRepo.findAll();
		mv.addObject("profiles", profiles);
		mv.setViewName("showAllUsers");
		return mv;
	}
	
}
