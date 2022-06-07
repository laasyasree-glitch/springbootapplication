package com.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.stereotype.Component;

//Spring Bean
@Component
public class LoginService {
	public boolean validate(String userid,String password) {
		if(userid.equalsIgnoreCase("laasya") && password.equalsIgnoreCase("kls"))
			return true;
		return false;
	}
}
