package com.todo.todo_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.todo_app.model.TodoApp;

public interface TodoRepo extends JpaRepository<TodoApp, Long>{

}
