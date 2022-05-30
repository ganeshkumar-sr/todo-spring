package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.enitity.Task;
import com.todo.exception.TaskNotFoundException;
import com.todo.service.TaskService;

@RestController
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	public List<Task> getTasks(){
		return taskService.getTasks();
	}
	
	@PostMapping("/tasks")
	public Task addTask(@RequestBody Task task) {
		return taskService.addTask(task);
	}
	
	@PutMapping("/tasks/{id}")
	public Task updateTask(@PathVariable(name = "id") Long id,@RequestBody Task task) throws TaskNotFoundException {
		return taskService.updateTask(id,task);
	}
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Object> deleteTask(@PathVariable(name="id") Long id) throws TaskNotFoundException{
		return new ResponseEntity<>(taskService.deleteTask(id),HttpStatus.OK);
	}
}
