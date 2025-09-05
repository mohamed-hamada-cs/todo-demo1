package com.mohamedhamada.todo_demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoServiceImp implements IToDoService{
    private List<Todo> todos;

    @Override
    public ResponseEntity<String> saveTodo(Todo todo) {
        return null;
    }

    @Override
    public ResponseEntity<List<Todo>> getAllTodos() {
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Todo> getTodoById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteTodoById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateTodoByID(UUID id) {
        return null;
    }
}
