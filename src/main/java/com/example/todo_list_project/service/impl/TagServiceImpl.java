package com.example.todo_list_project.service.impl;
import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.TagDto;
import com.example.todo_list_project.dto.TaskDto;
import com.example.todo_list_project.repository.TagRepository;
import com.example.todo_list_project.repository.TaskRepository;
import com.example.todo_list_project.service.Converter;
import com.example.todo_list_project.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagRepository repos;
    @Autowired
    TaskRepository taskRepos;

    @Autowired
    Converter converter;

    public List<TagDto> getAll() {
        List<Tag> tags = repos.findAll();
        List<TagDto> tasksDto = new ArrayList<>();
        for (Tag tag : tags){
            tasksDto.add(converter.convertToTagDto(tag));
        }
        return tasksDto;
    }

    @Override
    public TagDto addTag(TagDto tag){
        Tag newTag = repos.saveAndFlush(converter.convertToTag(tag));
        return converter.convertToTagDto(newTag);
    }

    @Override
    public void editTag(Long id, TagDto tagDto, String email){
        Tag oldTag = repos.findById(id).orElseThrow(()->new RuntimeException("no such id") );
        if(!tagDto.getTagName().equals(oldTag.getTagName())){
            oldTag.setTagName(tagDto.getTagName());
        }
        repos.save(oldTag);
    }

    @Override
    public void deleteTag(long id){
        List<Task> tasks = taskRepos.findByTag(repos.findById(id).orElse(null));
        if(tasks.size() != 0) {
            ListIterator<Task> listIterator = tasks.listIterator();
            for (Task task : tasks) {
                task.setTag(null);
                taskRepos.save(task);
            }
        }
        repos.deleteById(id);
    }
}
