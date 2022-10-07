package com.example.todo_list_project.service;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dto.TagDto;

public interface TagService {
    public TagDto addTag(TagDto tag) ;

    void deleteTag(long id);

}
