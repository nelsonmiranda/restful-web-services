package com.mm.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mm.rest.webservices.restfulwebservices.entity.Todo;
import com.mm.rest.webservices.restfulwebservices.reposity.TodoReposity;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoJpaController {
	
	@Autowired
	private TodoReposity todoReposity;
	
	@GetMapping(path = "/jpa/users/todos")
	public List<Todo> geListTodos(){
		return todoReposity.findAll();
	}
	
	@GetMapping(path = "/jpa/users/{username}/todos")
	public List<Todo> getListTodosByUser(@PathVariable String username){
		return todoReposity.findByUsername(username);
	}
	
	@GetMapping(path = "/jpa/users/{username}/todos/{id}")
	public Todo getTodoById(@PathVariable String username, @PathVariable long id){
		return todoReposity.findById(id).get();
	}
	
	@DeleteMapping(path = "/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable long id) {
		
		todoReposity.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, 
			@PathVariable long id, @RequestBody Todo todo) {
		
		Todo todoUpdate = todoReposity.save(todo);
		return new ResponseEntity<Todo>(todoUpdate, HttpStatus.OK);
	}
	
	@PostMapping(path = "/jpa/users/{username}/todos")
	public ResponseEntity<Todo> saveTodo(@PathVariable String username, @RequestBody Todo todo) {
		Todo todoCreated = todoReposity.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(todoCreated.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
