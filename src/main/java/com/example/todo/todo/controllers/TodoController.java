package com.example.todo.todo.controllers;

import java.util.List;
import java.util.Optional;

import com.example.todo.todo.dtos.TodoDto;
import com.example.todo.todo.persistence.Todo;
import com.example.todo.todo.persistence.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping()
    public ResponseEntity<?> getTodos() {
        List<Todo> todos = todoRepository.findAll();
        return ResponseEntity.ok(todos);
    }

    @PostMapping()
    public ResponseEntity<?> createTodo(@Validated @RequestBody TodoDto todoDto) {
        Todo todo = todoRepository.saveAndFlush(Todo.builder()
            .description(todoDto.getDescription())
            .completed(todoDto.isCompleted())
            .build());

        return ResponseEntity.ok(todo);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<?> updateTodo(
        @Validated @RequestBody TodoDto todoDto,
        @PathVariable("todoId") Long todoId) {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);

        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todoRepository.save(todo
                .toBuilder()
                .description(todoDto.getDescription())
                .completed(todoDto.isCompleted())
            .build());
            return ResponseEntity.ok(todo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
