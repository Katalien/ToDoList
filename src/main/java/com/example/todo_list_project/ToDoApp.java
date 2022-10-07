package com.example.todo_list_project;

import com.example.todo_list_project.dao.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ToDoApp {
    public static void main(String[] args) {
        SpringApplication.run(ToDoApp.class, args);
    }
}
