package com.mm.rest.webservices.restfulwebservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mm.rest.webservices.restfulwebservices.entity.Todo;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "in28minutes", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn about Microservices", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Learn about Angular", new Date(), false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public List<Todo> findAllByUsername(String username){
		
		List<Todo> listTodos = new ArrayList<Todo>();
		
		todos.forEach((todo)->{
			if(todo.getUsername().equals(username)) {
				listTodos.add(todo);
			}
		});
		
		return listTodos;
	}
	
}
