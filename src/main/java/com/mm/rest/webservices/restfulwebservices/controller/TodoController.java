package com.mm.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.rest.webservices.restfulwebservices.entity.Todo;
import com.mm.rest.webservices.restfulwebservices.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping(path = "/users/{username}/todos")
	public List<Todo> getListTodos(@PathVariable String username){
		return todoService.findAll();
	}
}
