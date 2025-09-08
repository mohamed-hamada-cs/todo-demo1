package com.mohamedhamada.todo_demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoServiceImp implements IToDoService {

    // Instead of List<Todo>
    // This now store in db (converted to -> JPQL -> SQL)
    private final ITodoRepo iTodoRepo;

    public TodoServiceImp(ITodoRepo iTodoRepo) {
        this.iTodoRepo = iTodoRepo;
    }

    @Override
    public ResponseEntity<String> saveTodo(Todo todo) {
        this.iTodoRepo.save(todo);
        return new ResponseEntity<>("Added Todo Successfully!\\n" + todo.toString(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = this.iTodoRepo.findAll();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Todo> getTodoById(UUID id) {
        Optional<Todo> todo = this.iTodoRepo.findById(id);
        return todo.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<String> deleteTodoById(UUID id) {
        return iTodoRepo.findById(id)
                .map(todo -> {
                    this.iTodoRepo.deleteById(id);
                    return new ResponseEntity<>(" ", HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>("Not found id", HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<String> updateTodoByID(Todo todo) {
        if (todo == null || todo.getUuid() == null)
            return new ResponseEntity<>("Not valid Todo data", HttpStatus.BAD_REQUEST);

        return iTodoRepo.findById(todo.getUuid())
                .map(foundTodo -> {

                    foundTodo.setTitle(todo.getTitle());
                    foundTodo.setDescription(todo.getDescription());
                    foundTodo.setStatus(todo.getStatus());

                    Todo updatedTodo = this.iTodoRepo.save(foundTodo);
                    return new ResponseEntity<>("Todo Updated: " + updatedTodo.toString(), HttpStatus.OK);
                }).orElse(new ResponseEntity<>("Not found id", HttpStatus.NOT_FOUND));
    }
}
