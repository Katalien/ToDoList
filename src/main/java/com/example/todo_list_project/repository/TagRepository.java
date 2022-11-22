package com.example.todo_list_project.repository;


import com.example.todo_list_project.dao.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByTagName(String tagName);
}