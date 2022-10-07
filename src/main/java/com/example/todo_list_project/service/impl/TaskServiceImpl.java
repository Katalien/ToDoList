package com.example.todo_list_project.service.impl;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.TagDto;
import com.example.todo_list_project.dto.TaskDto;
import com.example.todo_list_project.repository.TagRepository;
import com.example.todo_list_project.repository.TaskRepository;
import com.example.todo_list_project.service.Converter;
import com.example.todo_list_project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository repos;

    @Autowired
    TagRepository tagRepos;
    @Autowired
    Converter converter;

    @Override
    public TaskDto addTask(TaskDto task) {
        Task myTask = converter.convertToTask(task);
        Tag tag = tagRepos.findByTagName(task.getTagName());
        myTask.setTag(tag);
        TaskDto newTask = converter.convertToTaskDto(repos.saveAndFlush(myTask));
        return newTask;
    }

    @Override
    public TaskDto getById(long id){
        return converter.convertToTaskDto(repos.findById(id).orElse(null));
    }

    @Override
    public void delete(long id) {
        repos.deleteById(id);
    }

    @Override
    public TaskDto getByName(String name) {
        return converter.convertToTaskDto(repos.findByName(name));
    }

    @Override
    public TaskDto editTask(TaskDto task) {
        Task myTask = converter.convertToTask(task);
        return converter.convertToTaskDto(repos.saveAndFlush(myTask));
    }

    @Override
    public List<TaskDto> getAll() {
        List<Task> tasks = repos.findAll();
        List<TaskDto> tasksDto = new ArrayList<>();
        for (Task task : tasks){
            tasksDto.add(converter.convertToTaskDto(task));
        }
        return tasksDto;
    }

    @Override
    public List<TaskDto> getByDate(LocalDate eventDate) {
        return repos.findByEventDate(eventDate).stream()
                .map(el -> converter.convertToTaskDto(el))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getByTag(String tagName) {

        List<TaskDto> tasks = repos.findByTagTagName(tagName).stream()
                .map(el -> converter.convertToTaskDto(el))
                .collect(Collectors.toList());
        return tasks;
    }

    @Override
    public List<TaskDto>getByStatus(String status){
        return repos.findByStatus(status).stream()
                .map(el -> converter.convertToTaskDto(el))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto>getByTagAndDate(TagDto tagDto, LocalDate date){
        Tag tag = converter.convertToTag(tagDto);
        return repos.findByTagAndEventDate(tag, date).stream()
                .map(el -> converter.convertToTaskDto(el))
                .collect(Collectors.toList());
    }
    @Override
   public List<TaskDto>getByTagAndStatus(TagDto tagDto, String status){
        Tag tag = converter.convertToTag(tagDto);
        return repos.findByTagAndStatus(tag, status).stream()
                .map(el -> converter.convertToTaskDto(el))
                .collect(Collectors.toList());
    }
    @Override
    public TaskDto editTask(long id){
       return new TaskDto();
    }

    @Override
    public void deleteTask(long id){
        repos.deleteById(id);
    }

}
