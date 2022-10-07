package com.example.todo_list_project.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Tag")
public class Tag {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String tagName;

    @OneToMany(mappedBy = "tag")
    List<Task> tasks;
}
