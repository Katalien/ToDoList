package com.example.todo_list_project.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;

@Data
public class UserAccountDto {

    long id;

    String name;

    String email;
}
