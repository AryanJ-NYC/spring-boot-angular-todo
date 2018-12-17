package com.example.todo.todo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorld {
    @GetMapping(value = {"/hello-world", "/hello-world/{customString}"})
    public ResponseEntity<String> getHelloWorld(
        @PathVariable(name = "customString", required = false) String customString
    ) {
        StringBuilder prefix = new StringBuilder("Hello, ");
        String suffix = "!";
        String body = "World";
        if (customString != null) {
            body = customString;
        }
        String response = prefix.append(body).append(suffix).toString();
        return ResponseEntity.ok(response);
    }
}
