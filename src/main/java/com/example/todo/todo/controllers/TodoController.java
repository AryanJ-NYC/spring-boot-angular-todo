package com.example.todo.todo.controllers;

import com.example.todo.todo.dtos.TodoDto;
import com.example.todo.todo.persistence.Todo;
import com.example.todo.todo.persistence.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    TodoRepository todoRepository;

    @PostMapping()
    public ResponseEntity<?> createTodo(@Validated @RequestBody TodoDto todoDto) {
        Todo todo = todoRepository.saveAndFlush(Todo.builder()
            .description(todoDto.getDescription())
            .completed(todoDto.isCompleted())
            .build());

        return ResponseEntity.ok(todo);
    }

    @PutMapping()
    public ResponseEntity<?> updateTodo(@Validated @RequestBody TodoDto todoDto) {
        System.out.println(todoDto.getId() + "\n\n\n");
        if (todoDto.getId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        Todo todo = todoRepository.findById(todoDto.getId()).orElse(
            Todo.builder()
                .description(todoDto.getDescription())
                .completed(todoDto.isCompleted())
                .build()
        );
        todoRepository.save(
            todo.toBuilder()
                .id(todoDto.getId())
                .description(todoDto.getDescription())
                .completed(todoDto.isCompleted())
                .build()
        );
        return ResponseEntity.ok(todo);
    }
}
