package com.todo.todo_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.todo_app.model.TodoApp;
import com.todo.todo_app.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping
	public String getTasks(Model model) {
		List<TodoApp>tasks=todoService.getAllTasks();
		model.addAttribute("tasks",tasks);	
		return "tasks";

	}

	@PostMapping
	public String addTask(@RequestParam String title) {
		todoService.createTask(title);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		todoService.deleteTaskById(id);
		return "redirect:/";

	}

	@GetMapping("/toggle/{id}")
	public String toggleById(@PathVariable Long id) {
		todoService.toggleTaskById(id);
		return "redirect:/";

	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id,@RequestParam String title) {
		todoService.updateTaskById(id,title);
		return "redirect:/";
		
	}

}
