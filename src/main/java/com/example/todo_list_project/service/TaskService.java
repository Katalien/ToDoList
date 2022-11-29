package com.example.todo_list_project.service;

import com.example.todo_list_project.dto.SearchTasks;
import com.example.todo_list_project.dto.TaskDto;

import java.util.List;

public interface TaskService {

   TaskDto addTask(TaskDto task, String email);

   void editTask(Long ig, TaskDto taskToEditDto, String email);

    List<TaskDto> getAll();

    public TaskDto editTask(long id, TaskDto taskWithChanges);

    void deleteTask(long id);

   List<TaskDto> getAllByCriteria(SearchTasks searchTasks, String email);
}
