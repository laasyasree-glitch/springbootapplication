package com.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// /login=>"HELLO WORLD"
@Controller //To spring
public class WelcomeController {
	//Injected Automatically
	
	@RequestMapping(value = "/",  method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		model.put("name", getLoggedInUserName());
		return "welcome";
	}
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
}
