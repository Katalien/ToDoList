package com.example.todo_list_project.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table (name = "Tasks")
public class Task {

    public Task() {}
    @Id
    @GeneratedValue
    long id;

    @Column(name = "name")
    private String name;

    @Column
    String comment;

    @ManyToOne(fetch = FetchType.EAGER, optional = true) // когда я получаю таск я хочу получать инфу о теге сразу
    @JoinTable(name = "tag_id")
    Tag tag;

    @Column
    LocalDate eventDate;

    @Column
    LocalDate notificationDate;

    @Column
    String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id == task.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
