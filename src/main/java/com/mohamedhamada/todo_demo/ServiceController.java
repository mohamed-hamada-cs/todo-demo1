package com.mohamedhamada.todo_demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

@RestController
@RequestMapping("/todos")
public class ServiceController {
    private final IToDoService todoService;
    private static final Logger logger = Logger.getLogger(ServiceController.class.getName());


    public ServiceController(IToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos(){
        logger.log( Level.INFO, "Called GetAllTodos | Get Mapping");

//        System.out.println("Called the public ResponseEntity<List<Todo>> getAllTodos() | GETMAPPING");
        return todoService.getAllTodos();
    }

}













