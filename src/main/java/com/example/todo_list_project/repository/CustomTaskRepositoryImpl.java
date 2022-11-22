package com.example.todo_list_project.repository;

import com.example.todo_list_project.dao.Task;
import com.example.todo_list_project.dto.SearchTasks;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomTaskRepositoryImpl implements CustomTaskRepository {
    @Autowired
    EntityManager em;

    @Override
    public List<Task> findByCriteria(SearchTasks searchTask, String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Task> cq = cb.createQuery(Task.class);

        Root<Task> task = cq.from(Task.class);
        List<Predicate> predicates = new ArrayList<>();

        if (searchTask.getTag() != null && task.get("tag") != null) {
            predicates.add(cb.equal(task.get("tag").get("tagName"), searchTask.getTag()));
        }
        if (searchTask.getDate() != null) {
            predicates.add(cb.equal(task.get("eventDate"), searchTask.getDate() ));
        }
        if (searchTask.getStatus() != null) {
            predicates.add(cb.equal(task.get("status"), searchTask.getStatus()));
        }
        predicates.add(cb.equal(task.get("userEmail"), email));

        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}
