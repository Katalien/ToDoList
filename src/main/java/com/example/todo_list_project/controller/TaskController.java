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
    TaskDto addTask(@RequestBody TaskDto task,  @AuthenticationPrincipal OAuth2User principal){
        String email = principal.getAttribute("email");
        TaskDto taskDto = service.addTask(task, email);
        return taskDto;
    }

    @PatchMapping("/tasks/{id:\\d+}")
    void editTask(@PathVariable Long id, @RequestBody TaskDto task,  @AuthenticationPrincipal OAuth2User principal){
        String email = principal.getAttribute("email");
        service.editTask(id, task, email);
    }

    @DeleteMapping("/tasks/id")
    void deleteTask(@RequestParam(name = "id") long id){
        service.deleteTask(id);
    }
}
