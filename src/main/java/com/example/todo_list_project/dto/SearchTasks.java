package com.example.todo_list_project.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SearchTasks {
    String tag;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    Date date;

    String status;
}
