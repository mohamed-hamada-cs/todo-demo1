package com.mohamedhamada.todo_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todos")
@Slf4j
public class ServiceController {
    private final IToDoService todoService;

    public ServiceController(IToDoService todoService) {
        this.todoService = todoService;
    }

    /*** Controller endpoints ***/

    @PostMapping
    public ResponseEntity<String> addTodo(@RequestBody Todo todo) {
        log.trace("Called Post todo | POST Mapping");
        return todoService.saveTodo(todo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        log.trace("Called GetAllTodos | Get Mapping");
        return todoService.getAllTodos();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Todo> getTodoById(@PathVariable UUID uuid) {
        log.trace("Called Get Todo By UUID | Get Mapping");
        return todoService.getTodoById(uuid);
    }
}













