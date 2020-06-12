package com.mm.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mm.rest.webservices.restfulwebservices.entity.Todo;
import com.mm.rest.webservices.restfulwebservices.service.TodoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping(path = "/users/{username}/todos")
	public List<Todo> getListTodosByUser(@PathVariable String username){
		return todoService.findAllByUsername(username);
	}
}
