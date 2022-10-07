package com.example.todo_list_project.dao;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Column
    private String name;

    @OneToMany
    private List<Task> task;
}
