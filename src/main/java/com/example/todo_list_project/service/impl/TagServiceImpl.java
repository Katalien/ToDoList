package com.example.todo_list_project.service.impl;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.TagDto;
import com.example.todo_list_project.repository.TagRepository;
import com.example.todo_list_project.repository.TaskRepository;
import com.example.todo_list_project.service.Converter;
import com.example.todo_list_project.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository repos;

    @Autowired
    Converter converter;

    @Override
    public TagDto addTag(TagDto tag){
        Tag newTag = repos.saveAndFlush(converter.convertToTag(tag));
        return converter.convertToTagDto(newTag);
    }

    @Override
    public void deleteTag(long id){
        repos.deleteById(id);
    }

}
