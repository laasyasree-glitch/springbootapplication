package com.springboot.web.springbootfirstwebapplication.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	//service.retrieveTodos(name)->Not present in controller
	List<Todo> findByUser(String user);
	
	//service.deleteTodo(id);
	//service.retrieveTodo(id)
	//service.updateTodo(todo)
	//service.addTodo(getLoggedInUserName(model) 
	//, todo.getDesc ( ) , todo.getTarge)
}

/*
repository.deleteById(id);
Todo todo = repository.findById(id).get();
*/