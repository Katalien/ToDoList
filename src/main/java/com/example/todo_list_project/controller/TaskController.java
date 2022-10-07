package com.example.todo_list_project.controller;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.TagDto;
import com.example.todo_list_project.dto.TaskDto;
import com.example.todo_list_project.repository.TaskRepository;
import com.example.todo_list_project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping("/tasks")
    public List<TaskDto> getTasks(){
        return service.getAll();
    };

    @GetMapping("/cat/status")
    public String getTaskByTagUsingQueryParam(@RequestParam(name = "cat") String tagName, @RequestParam(name = "status") String status) {
        return "TAG: " + tagName + "status" + status;
    }

    @PostMapping("/tasks")
    void addTask(@RequestBody TaskDto task){
        service.addTask(task);
    }

    @GetMapping("/tasks/status")
    List<TaskDto>getByStatus(@RequestParam(name = "status") String status){
        return service.getByStatus(status);
    }

    @GetMapping("/tasks/{id}/{status}")
    TaskDto editTask(@RequestParam(name = "id") long id, @RequestParam(name = "staus") String status){
        return service.editTask(id);
    }

    @GetMapping("/tasks/tag")
    List<TaskDto> getByTag(@RequestParam(name = "tag") String tagName){
        return service.getByTag(tagName);
    };


    @GetMapping("/tasks/date")
    List<TaskDto> getByDate(@RequestParam(name = "date") LocalDate date){
        return service.getByDate(date);
    }

    @GetMapping("/tasks/tag/date")
    List<TaskDto> getByTagAndDate(@RequestParam(name = "tag") TagDto tag, @RequestParam(name = "date") LocalDate date){
        return service.getByTagAndDate(tag, date);
    }

    @GetMapping("/tasks/tag/status")
    List<TaskDto> getByTagAndDate(@RequestParam(name = "tag") TagDto tag, @RequestParam(name = "status") String status){
        return service.getByTagAndStatus(tag, status);
    }

    @DeleteMapping("/tasks/id")
    void deleteTask(@RequestParam(name = "id") long id){
        service.deleteTask(id);
    }

//    @GetMapping("/{date}")
//    public List<String> getTasksByDate(@PathVariable("date") Tag tag, Model model){};
//
//    @GetMapping("/{tag}{day}")
//    public List<String> getTasksByTag(@PathVariable("tag") Tag tag, @PathVariable("day") LocalDate date, Model model);
//
}
