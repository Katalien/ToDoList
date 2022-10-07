package com.example.todo_list_project.controller;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dto.TagDto;
import com.example.todo_list_project.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagController {
    @Autowired
    private TagService service;


    @PostMapping("/tags")
    void addNewTag(@RequestBody TagDto tag){
        service.addTag(tag);
    }

    @DeleteMapping("/tag/{id}")
    void deleteTag(@PathVariable("id") long id ){
        service.deleteTag(id);
    }
}
