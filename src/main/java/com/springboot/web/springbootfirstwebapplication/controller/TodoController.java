package com.springboot.web.springbootfirstwebapplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	@Autowired
	TodoRepository repository;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {//To access in same packages
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model){
		String name = extracted(model);
		//System.out.println(name);
		model.put("todos", repository.findByUser(name));
		//model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, extracted(model), "",new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.POST)
	public String addTodos(ModelMap model, @Valid Todo todo, BindingResult result){
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser(extracted(model));
		repository.save(todo);
		//service.addTodo(extracted(model), todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}
	@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id){
		/*if(id==1)
			throw new RuntimeException("Something went wrong");*/
		repository.deleteById(id);
		//service.deleteTodo(id);
		return "redirect:/list-todos";
	}
	@RequestMapping(value="/update-todo", method = RequestMethod.GET)
	public String showupdateTodo(ModelMap model,@RequestParam int id){
		//Todo updatedTodo=service.retrieveTodo(id);
		Todo updatedTodo = repository.findById(id).get();
		model.put("todo", updatedTodo);
		return "todo";
	}
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser(extracted(model));
		//service.updateTodo(todo);
		repository.save(todo);
		return "redirect:/list-todos";
	}
	private String extracted(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

}