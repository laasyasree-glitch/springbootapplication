package com.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

// /login=>"HELLO WORLD"
@Controller //To spring
@SessionAttributes("name")

public class LoginController {
	//Injected Automatically
	@Autowired
	LoginService service = new LoginService();
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String ShowLoginPage(ModelMap model) {
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showWelcomePage(@RequestParam String name,@RequestParam String password,  ModelMap model) {
		boolean validation = service.validate(name,password);
		if(!validation) {
			model.put("message", "INVALID CREDENTIALS");
			return "login";
		}
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}
}
