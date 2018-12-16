package com.example.todo.todo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping(value = {"/hello-world", "/hello-world/{customString}"})
    public ResponseEntity<String> getHelloWorld(
        @PathVariable(name = "customString", required = false) String customString
    ) {
        String responseString = "Hello, World!";
        if (customString != null) {
            responseString = customString;
        }
        return ResponseEntity.ok(responseString);
    }
}
