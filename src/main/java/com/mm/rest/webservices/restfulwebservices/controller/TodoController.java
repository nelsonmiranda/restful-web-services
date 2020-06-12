package com.mm.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping(path = "/users/todos")
	public List<Todo> geListTodos(){
		return todoService.findAll();
	}
	
	@GetMapping(path = "/users/{username}/todos")
	public List<Todo> getListTodosByUser(@PathVariable String username){
		return todoService.findAllByUsername(username);
	}
	
	@GetMapping(path = "/users/{username}/todos/{id}")
	public Todo getTodoById(@PathVariable String username, @PathVariable long id){
		return todoService.findById(id);
	}
	
	@DeleteMapping(path = "/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable long id) {
		
		if(todoService.deleteById(id) != null) {
			return ResponseEntity.noContent().build();
		} 
		return ResponseEntity.notFound().build();
	}
	
}
