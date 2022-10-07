package com.example.todo_list_project.repository;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dao.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    Task findByName(@Param("name") String name);

    List<Task> findByStatus(String status);

    List<Task> findByTag(Tag tag);

    List<Task> findByTagTagName(String tag);

    List<Task> findByEventDate(LocalDate eventDate);

    List<Task> findByTagAndEventDate(Tag tag, LocalDate eventDate);
    List<Task> findByTagAndStatus(Tag tag, String status);

}