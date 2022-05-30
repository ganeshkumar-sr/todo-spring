package com.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.enitity.Task;
import com.todo.exception.TaskNotFoundException;
import com.todo.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> getTasks(){
		List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}
	
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Task updateTask(Long id,Task task) throws TaskNotFoundException {
		final Task existingTask = taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException("Task not found for the id :"+id));
		existingTask.setName(task.getName());
		existingTask.setDescription(task.getDescription());
		existingTask.setStatus(task.isStatus());
		taskRepository.save(existingTask);
		return existingTask;
	}
	
	public boolean deleteTask(Long id) throws TaskNotFoundException {
		Task task = taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException("Task not found for the Id :"+id));
		taskRepository.delete(task);
		return true;
	}
}
