package com.mohamedhamada.todo_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

@RestController
@RequestMapping("/api/v1/todos")
@Slf4j
public class ServiceController {
    private final IToDoService todoService;

    public ServiceController(IToDoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<String> addTodo(@RequestBody Todo todo){
//        log.info("Called Post todo | POST Mapping");
        return todoService.saveTodo(todo);
    }
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
//        logger.log( Level.INFO, "Called GetAllTodos | Get Mapping");

//        System.out.println("Called the public ResponseEntity<List<Todo>> getAllTodos() | GETMAPPING");
        return todoService.getAllTodos();
    }


}













