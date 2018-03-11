package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.LinkedInProfile;
import com.example.demo.entity.Student;
import com.example.demo.repo.LinkedInProfileRepository;
import com.example.demo.repo.StudentRepository;

/**
 * @author ninad
 *
 */
@Controller
public class JSLinkedInController {
	@Autowired
	LinkedInProfileRepository linkedInRepo;

	@Autowired
	StudentRepository studentRepo;
	
	
	
	@GetMapping(value="/allSignIns")
	public ModelAndView getLinkedInInfo() 
	{
		ModelAndView mv = new ModelAndView();
		List<LinkedInProfile> profiles = linkedInRepo.findAll();
		mv.addObject("profiles", profiles);
		mv.setViewName("showAllUsers");
		return mv;
	}
	
	
	
	//Store Linkedin info !
		@PostMapping(value="/linkedIn")
		public HashMap<String, String> saveLinkedInInfo(
				@RequestParam(name="firstName", required=false, defaultValue="") String firstName,
				@RequestParam(name="lastName", required=false, defaultValue="") String lastName,
				@RequestParam(name="linkedInId", required=true) String linkedInId,
				@RequestParam(name="pictureUrl", required=true) String pictureUrl,
				@RequestParam(name="headline", required=false, defaultValue="") String headline,
				@RequestParam(name="fullResponse", required=true, defaultValue="") String fullResponse

				) 
		{
			HashMap<String, String> map = new HashMap<String,String> ();
			 linkedInRepo.save(new LinkedInProfile(
					firstName,
					lastName,
					linkedInId,
					headline,
					pictureUrl,
					fullResponse
					)).toString();
			String branches = "";
			
			List<Student> studentli = studentRepo.findByFirstNameAndLastName(firstName, lastName);
			if(studentli.isEmpty()) {
				
				map.put("certificate", "notfound");
				return map;
			}
			for(Student s : studentli) {
				branches = branches + s.getBranch() + " (" + s.getExamId() + ") | ";
			}

			map.put("certificate", "found");

			map.put("branches",branches);
			return map;
		}
}
