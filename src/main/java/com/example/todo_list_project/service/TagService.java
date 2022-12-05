package com.example.todo_list_project.service;
import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.TagDto;
import com.example.todo_list_project.dto.TaskDto;

import java.util.ArrayList;
import java.util.List;

public interface TagService {
    TagDto addTag(TagDto tag) ;

    List<TagDto> getAll() ;

   void editTag(Long id, TagDto tagDto, String email);

    void deleteTag(long id);

}
