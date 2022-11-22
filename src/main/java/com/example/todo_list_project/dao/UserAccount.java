package com.example.todo_list_project.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usersAccount")
@Data
public class UserAccount{
    @Id
    private String id;

    private String name;

    private String email;

    private String login;
}
