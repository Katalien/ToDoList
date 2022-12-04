package com.example.todo_list_project.service.impl;

import com.example.todo_list_project.dao.Tag;
import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.SearchTasks;
import com.example.todo_list_project.dto.TaskDto;
import com.example.todo_list_project.repository.TagRepository;
import com.example.todo_list_project.repository.TaskRepository;
import com.example.todo_list_project.service.Converter;
import com.example.todo_list_project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository repos;

    @Autowired
    TagRepository tagRepos;
    @Autowired
    Converter converter;

    @Override
    public TaskDto addTask(TaskDto task, String email) {
        Task myTask = converter.convertToTask(task);
        myTask.setUserEmail(email);
        if(task.getTagName() != null) {
            Tag tag = tagRepos.findByTagName(task.getTagName());
            myTask.setTag(tag);
        }
        TaskDto newTask = converter.convertToTaskDto(repos.saveAndFlush(myTask));
        newTask.setUserEmail(email);
        return newTask;
    }

    @Override
    @Transactional
    public void editTask(Long id, TaskDto taskToEdit, String email) {
        Optional<Task> oldTaskOptional = repos.findById(id);
        Task oldTask = oldTaskOptional.orElseThrow(()->new RuntimeException("no such id") );
        if(taskToEdit.getName() != null && !oldTask.getName().equals(taskToEdit.getName())){
            oldTask.setName(taskToEdit.getName());
        }
        if(taskToEdit.getComment() != null && ((oldTask.getComment()==null && taskToEdit.getComment() !=null) ||
                (oldTask.getComment()!=null && !oldTask.getComment().equals(taskToEdit.getComment())))){
            oldTask.setComment(taskToEdit.getComment());
        }
        if(taskToEdit.getEventDate() != null && ((oldTask.getEventDate()==null && taskToEdit.getEventDate() !=null) ||
                ( oldTask.getEventDate()!=null && !oldTask.getEventDate().equals(taskToEdit.getEventDate())))){
            oldTask.setEventDate(taskToEdit.getEventDate());
        }
        repos.save(oldTask);
    }

    @Override
    public List<TaskDto> getAll() {
        List<Task> tasks = repos.findAll();
        List<TaskDto> tasksDto = new ArrayList<>();
        for (Task task : tasks){
            tasksDto.add(converter.convertToTaskDto(task));
        }
        return tasksDto;
    }

    @Override
    public void deleteTask(long id){
        repos.deleteById(id);
    }

    @Override
    public List<TaskDto> getAllByCriteria(SearchTasks searchTasks, String email) {
        List<Task> tasks = repos.findByCriteria(searchTasks, email);
        List<TaskDto> tasksDto = new ArrayList<>();
        for (Task task : tasks){
            tasksDto.add(converter.convertToTaskDto(task));
        }
        return tasksDto;
    }

}
