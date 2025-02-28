package com.todo.todo_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todo_app.model.TodoApp;
import com.todo.todo_app.repository.TodoRepo;

@Service
public class TodoService {
	@Autowired
	private TodoRepo todoRepo;

	public List<TodoApp> getAllTasks() {
		return todoRepo.findAll();
	}

	public TodoApp AddTasks(TodoApp app) {
		return todoRepo.save(app);
		
	}

	public void createTask(String title) {
		TodoApp t=new TodoApp();
		t.setTask(title);
		t.setCompleted(false);
		todoRepo.save(t);
	}

	public void deleteTaskById(Long id) {
		todoRepo.deleteById(id);
	}

	public void toggleTaskById(Long id) {
		TodoApp tt=todoRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Task"));
		
		tt.setCompleted(!tt.isCompleted());
		todoRepo.save(tt);
		
		
	}

	public void updateTaskById(Long id,String title) {
		
		TodoApp todo=todoRepo.findById(id).orElseThrow(() -> new RuntimeException("task not found"));
		if(!title.isBlank()) {
			todo.setTask(title);
		}
		todoRepo.save(todo);
	
	
		
		
	}

}
