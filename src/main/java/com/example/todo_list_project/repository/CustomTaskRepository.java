package com.example.todo_list_project.repository;
import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.SearchTasks;


import java.util.List;

public interface CustomTaskRepository {
    List<Task> findByCriteria(SearchTasks searchTask, String email);
}
