package com.example.todo_list_project.repository;

import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.SearchTasks;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;

public interface CustomTaskRepository {
    List<Task> findByCriteria(SearchTasks searchTask, String email);
}
