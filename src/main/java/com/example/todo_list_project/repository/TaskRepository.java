package com.example.todo_list_project.repository;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dao.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Repository
public interface TaskRepository extends JpaRepository<Task,Long>, CustomTaskRepository  {
    Task findByName(@Param("name") String name);
    List<Task> findByStatus(String status);
    List<Task> findByTag(Tag tag);
    List<Task> findByTagTagName(String tag);
    List<Task> findByEventDate(Date eventDate);
    List<Task> findByTagAndEventDate(Tag tag, Date eventDate);
    List<Task> findByTagAndStatus(Tag tag, String status);
    List<Task> findAllByUserAccountLogin(String login);

}