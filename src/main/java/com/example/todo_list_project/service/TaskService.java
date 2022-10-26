package com.example.todo_list_project.service;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.SearchTasks;
import com.example.todo_list_project.dto.TagDto;
import com.example.todo_list_project.dto.TaskDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TaskService {

   TaskDto addTask(TaskDto task);

 TaskDto getById(long id);

 void delete(long id);
    TaskDto getByName(String name);

    TaskDto editTask(TaskDto bank);
    List<TaskDto> getAll();

    List<TaskDto> getByDate(Date eventDate);

    List<TaskDto> getByTag(String tag);

    List<TaskDto>getByStatus(String status);

    List<TaskDto>getByTagAndDate(TagDto tag, Date date);
    List<TaskDto>getByTagAndStatus(TagDto tag, String status);

    TaskDto editTask(long id);

    void deleteTask(long id);

   List<TaskDto> getAllByCriteria(SearchTasks searchTasks);
}
