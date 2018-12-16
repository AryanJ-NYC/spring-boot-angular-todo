package com.example.todo.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("\n\n: We are running! ");
		SpringApplication.run(DemoApplication.class, args);
	}
}
