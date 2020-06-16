package com.mm.rest.webservices.restfulwebservices.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mm.rest.webservices.restfulwebservices.entity.Todo;
import java.lang.String;
import java.util.List;

@Repository
public interface TodoReposity extends JpaRepository<Todo, Long> {

	List<Todo> findByUsername(String username);
	
}
