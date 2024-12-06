package com.todo.todo_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TodoApp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
	String task;
	boolean completed;

}
