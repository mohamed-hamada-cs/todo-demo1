package com.mohamedhamada.todo_demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITodoRepo extends JpaRepository<Todo, UUID> {
    // CRUD operations out of the box, just use it in service
    // Spring implements this interface and inject
}
