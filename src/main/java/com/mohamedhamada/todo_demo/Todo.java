package com.mohamedhamada.todo_demo;

import java.util.UUID;


public class Todo {
    private UUID uuid;
    private String title;
    private String description;
    private TodoStatus status;

    public Todo(String title, String description, TodoStatus status) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.status = status;
    }
    public Todo(String title, String description) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.status = TodoStatus.NOT_STARTED;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }
}
