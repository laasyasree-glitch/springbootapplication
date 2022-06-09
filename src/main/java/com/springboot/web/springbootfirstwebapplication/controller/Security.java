package com.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@EnableWebSecurity
	@Configuration
	public class Security extends WebSecurityConfigurerAdapter{
		//Create User - in28Minutes/dummy
		@Autowired
	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
	            throws Exception {
			auth.inMemoryAuthentication()
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
        		.withUser("laasya").password("kls").roles("USER", "ADMIN");;
	    }
		
		@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests().antMatchers("/login").permitAll()
	                .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
	                .formLogin();
	    }
	}
