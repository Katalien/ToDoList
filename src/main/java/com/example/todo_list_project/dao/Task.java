package com.example.todo_list_project.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinTable(name = "tag_id")
    Tag tag;

    @Column
    Date eventDate;

    @Column
    Date notificationDate;

    @Column
    String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;


    @JoinColumn(name = "user_email")
    private String userEmail;

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
