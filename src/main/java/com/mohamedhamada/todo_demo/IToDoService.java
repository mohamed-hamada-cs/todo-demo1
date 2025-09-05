package com.mohamedhamada.todo_demo;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IToDoService {
    public ResponseEntity<String> saveTodo(Todo todo);
    public ResponseEntity<List<Todo>> getAllTodos();
    public ResponseEntity<Todo> getTodoById(UUID id);
    public ResponseEntity<String> deleteTodoById(UUID id);
    public ResponseEntity<String> updateTodoByID(UUID id);
}
