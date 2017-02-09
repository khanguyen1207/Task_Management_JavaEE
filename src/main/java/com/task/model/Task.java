package com.task.model;

import javax.persistence.*;

/**
 * Created by khanguyen on 08/02/2017.
 */
@Entity
@Table(name = "task")
public class Task {
    @Id @GeneratedValue private int id;
    @Column(name = "description") private String description;
    @Column(name = "empid") private int empId;
    @Column(name = "empconf") private boolean employeeConfirm;
    @Column(name = "mngconf") private boolean managerConfirm;
    @Column(name = "name") private String taskName;

    public Task() {

    }

    public Task(String name, String description, int empId) {
        this.taskName = name;
        this.description = description;
        this.empId = empId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
