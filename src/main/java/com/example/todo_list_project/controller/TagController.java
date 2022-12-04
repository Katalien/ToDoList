package com.example.todo_list_project.controller;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dto.TagDto;
import com.example.todo_list_project.dto.TaskDto;
import com.example.todo_list_project.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TagController {
    @Autowired
    private TagService service;

    @PostMapping("/tags")
    void addNewTag(@RequestBody TagDto tag){
        service.addTag(tag);
    }

    @GetMapping("/tags")
    public List<TagDto> getTags(){
        return service.getAll();
    };

    @PatchMapping("/tags/{id:\\d+}")
    public void editTag(@PathVariable Long id,@RequestBody TagDto tagDto, @AuthenticationPrincipal OAuth2User principal){
       String email = principal.getAttribute("email");
       service.editTag(id,tagDto, email);
    }

    @DeleteMapping("/tags/{id:\\d+}")
    void deleteTag(@PathVariable("id") long id){
        service.deleteTag(id);
    }
}
