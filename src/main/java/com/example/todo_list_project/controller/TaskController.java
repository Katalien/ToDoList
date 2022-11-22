package com.example.todo_list_project.controller;

import com.example.todo_list_project.dto.SearchTasks;
import com.example.todo_list_project.dto.TaskDto;
import com.example.todo_list_project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping("/tasks")
    public List<TaskDto> getTasks(@AuthenticationPrincipal OAuth2User principal, SearchTasks searchTasks){
        String email = principal.getAttribute("email");
        return service.getAllByCriteria(searchTasks, email);
    };

    @PostMapping("/tasks")
    void addTask(@RequestBody TaskDto task,  @AuthenticationPrincipal OAuth2User principal){
        String email = principal.getAttribute("email");
        service.addTask(task, email);
    }

    @PatchMapping("/tasks")
    void editTask(@RequestBody TaskDto task,  @AuthenticationPrincipal OAuth2User principal){
        String email = principal.getAttribute("email");
        service.editTask(task, email);
    }

    @DeleteMapping("/tasks/id")
    void deleteTask(@RequestParam(name = "id") long id){
        service.deleteTask(id);
    }
}
