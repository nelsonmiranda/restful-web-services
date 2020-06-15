package com.mm.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mm.rest.webservices.restfulwebservices.model.AuthenticationBean;
import com.mm.rest.webservices.restfulwebservices.model.Welcome;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthController {

	@GetMapping(path = "/basicauth")
	public AuthenticationBean getWelcomeMessage() {
		return new AuthenticationBean("You are authenticated!");
	}
		
}
