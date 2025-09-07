package com.mohamedhamada.todo_demo;

/* === JP === */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

/* === Lombok === */
import lombok.*;

/* === Java === */
import java.util.UUID;

@Entity
@Table(name="todos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable=false)
    private String title;

    private String description;
    private TodoStatus status;
}
