package com.example.todo_list_project.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {
    long id;
    String name;
    String comment;
    Date eventDate;
    Date notificationDate;
    String status;
    String tagName;
    String userEmail;
}
