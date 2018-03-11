package com.example.demo.controller;

import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Value("${redirect_url}")
	String redirect_url;
	@GetMapping(value="/login")
	public String renderLogin() {
        return "login";
	}
	
	@GetMapping(value="/")
	public ModelAndView hi(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format(new Date());
		String hash = Base64.getEncoder().encodeToString(DigestUtils.md5Digest(time.getBytes(Charset.forName("UTF-8"))));
		request.getSession().setAttribute("state", hash);
		mv.setViewName("index");
		mv.addObject("state",hash);
		mv.addObject("redirect_url", redirect_url);
		
		
        return mv;
	}
}
