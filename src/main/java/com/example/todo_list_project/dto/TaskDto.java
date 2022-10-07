package com.example.todo_list_project.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {
    long id;
    String name;
    String comment;
    LocalDate eventDate;
    LocalDate notificationDate;
    String status;
    String tagName;
}
