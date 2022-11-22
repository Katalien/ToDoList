package com.example.todo_list_project.service.impl;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.SearchTasks;
import com.example.todo_list_project.dto.TaskDto;
import com.example.todo_list_project.repository.TagRepository;
import com.example.todo_list_project.repository.TaskRepository;
import com.example.todo_list_project.service.Converter;
import com.example.todo_list_project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository repos;

    @Autowired
    TagRepository tagRepos;
    @Autowired
    Converter converter;

    @Override
    public TaskDto addTask(TaskDto task, String email) {
        Task myTask = converter.convertToTask(task);
        myTask.setUserEmail(email);
        if(task.getTagName() != null) {
            Tag tag = tagRepos.findByTagName(task.getTagName());
            myTask.setTag(tag);
        }
        TaskDto newTask = converter.convertToTaskDto(repos.saveAndFlush(myTask));
        newTask.setUserEmail(email);
        return newTask;
    }

    @Override
    public TaskDto editTask(TaskDto taskToEditDto, String email) {
        Task taskToEdit  = converter.convertToTask(taskToEditDto);
        Optional<Task> oldTaskOptional = repos.findById(taskToEdit.getId());
        Task oldTask = oldTaskOptional.orElse(null);
        Task newTask = new Task();
        newTask.setId(oldTask.getId());
        newTask.setUserAccount(oldTask.getUserAccount());
        if(oldTask.getName() != taskToEdit.getName()){
            newTask.setName(taskToEdit.getName());
        }
        else{
            newTask.setName(oldTask.getName());
        }
        if(oldTask.getComment()!= taskToEdit.getComment()){
            newTask.setComment(taskToEdit.getComment());
        }
        else{
            newTask.setComment(oldTask.getComment());
        }
        if(oldTask.getTag()!= taskToEdit.getTag()){
            newTask.setTag(taskToEdit.getTag());
        }
        else{
            newTask.setTag(oldTask.getTag());
        }
        if(oldTask.getEventDate()!= taskToEdit.getEventDate()){
            newTask.setEventDate(taskToEdit.getEventDate());
        }
        else{
            newTask.setEventDate(oldTask.getEventDate());
        }
        repos.deleteById(oldTask.getId());
        repos.saveAndFlush(newTask);
        return converter.convertToTaskDto(newTask);
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
    public TaskDto editTask(long id, TaskDto taskWithChanges){
        Optional<Task> taskToEdit = repos.findById(id);
        TaskDto taskToEditDto = converter.convertToTaskDto(taskToEdit.get());
        if(taskToEditDto == null){
            return null;
        }
        if(!taskToEditDto.getName().equals( taskWithChanges.getName())){
            taskToEditDto.setName(taskWithChanges.getName());
        }
        if(!taskToEditDto.getTagName().equals( taskWithChanges.getTagName())){
            taskToEditDto.setTagName(taskWithChanges.getTagName());
        }
        if(!taskToEditDto.getComment().equals( taskWithChanges.getComment())){
            taskToEditDto.setComment(taskWithChanges.getComment());
        }
        if(!taskToEditDto.getStatus().equals( taskWithChanges.getStatus())){
            taskToEditDto.setStatus(taskWithChanges.getStatus());
        }
        if(taskToEditDto.getEventDate() != taskWithChanges.getEventDate()){
            taskToEditDto.setEventDate(taskWithChanges.getEventDate());
        }
        if(taskToEditDto.getNotificationDate() != taskWithChanges.getNotificationDate()){
            taskToEditDto.setNotificationDate(taskWithChanges.getNotificationDate());
        }
        repos.deleteById(id);
        repos.saveAndFlush(converter.convertToTask(taskToEditDto));
       return taskToEditDto;
    }

    @Override
    public void deleteTask(long id){
        repos.deleteById(id);
    }

    @Override
    public List<TaskDto> getAllByCriteria(SearchTasks searchTasks, String email) {
        List<Task> tasks = repos.findByCriteria(searchTasks, email);
        List<TaskDto> tasksDto = new ArrayList<>();
        for (Task task : tasks){
            tasksDto.add(converter.convertToTaskDto(task));
        }
        return tasksDto;
    }

}
