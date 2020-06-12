package com.mm.rest.webservices.restfulwebservices.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mm.rest.webservices.restfulwebservices.model.Welcome;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WelcomeController {

	@GetMapping(path = "/welcome-message")
	public Welcome getWelcomeMessage() {
		return new Welcome("Welcome to Spring Boot - changed");
	}
	
	@GetMapping(path = "/welcome-error")
	public Welcome getWelcomeError() {
		throw new RuntimeException("Some Error Has Happened! Contac Support at ***-***");
	}
	
	@GetMapping(path = "/welcome/{name}")
	public Welcome getWelcomeWithParam(@PathVariable String name) {
		return new Welcome(String.format("Hello World, %s", name));
	}
		
}
