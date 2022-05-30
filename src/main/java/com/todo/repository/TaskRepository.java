package com.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todo.enitity.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{
	
}
