package com.example.todo_list_project.service;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.TagDto;
import com.example.todo_list_project.dto.TaskDto;
import org.springframework.stereotype.Service;

@Service
public class Converter {
    public Task convertToTask (TaskDto taskDto){
        Task task = new Task();
        task.setName(taskDto.getName());
        task.setComment(taskDto.getComment());
        task.setId(taskDto.getId());
        task.setStatus(taskDto.getStatus());
        task.setEventDate(taskDto.getEventDate());
        task.setNotificationDate(taskDto.getNotificationDate());
        return task;
    }

    public TaskDto convertToTaskDto (Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setName(task.getName());
        taskDto.setComment(task.getComment());
        taskDto.setId(task.getId());
        taskDto.setStatus(task.getStatus());
        taskDto.setEventDate(task.getEventDate());
        taskDto.setNotificationDate(task.getNotificationDate());
        taskDto.setTagName(task.getTag().getTagName());
        return taskDto;
    }

    public Tag convertToTag (TagDto tagDto){
        Tag tag = new Tag();
        tag.setId(tagDto.getId());
        tag.setTagName(tagDto.getTagName());
        return tag;
    }

    public TagDto convertToTagDto (Tag tag){
        TagDto tagDto = new TagDto();
        tagDto.setId(tag.getId());
        tagDto.setTagName(tag.getTagName());
        return tagDto;
    }


}
