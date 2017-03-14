package com.task.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by khanguyen on 08/02/2017.
 */
@Repository
public interface TaskDAO extends JpaRepository<Task, Long> {
    Task findById(int id);
    List<Task> findByAssignee(String assignee);
    @Transactional
    Long deleteById(int id);
}
