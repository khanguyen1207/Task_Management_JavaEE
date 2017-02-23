package com.task.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by khanguyen on 08/02/2017.
 */
@Entity
@Table(name = "task")
public class Task {
    @Id @GeneratedValue private int id;
    @Column(name = "description") private String description;
    @Column(name = "assignee") private String empUsername;
    @Column(name = "assignor") private String managerUsername;
    @Column(name = "empconf") private boolean employeeConfirm;
    @Column(name = "mngconf") private boolean managerConfirm;
    @Column(name = "name") private String taskName;
    @Column(name = "issue_date") private Date issueDate;
    @Column(name = "deadline") private Date deadline;
    public Task() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpUsername() {
        return empUsername;
    }

    public void setEmpUsername(String empUsername) {
        this.empUsername = empUsername;
    }

    public String getManagerUsername() {
        return managerUsername;
    }

    public void setManagerUsername(String managerUsername) {
        this.managerUsername = managerUsername;
    }

    public boolean isEmployeeConfirm() {
        return employeeConfirm;
    }

    public void setEmployeeConfirm(boolean employeeConfirm) {
        this.employeeConfirm = employeeConfirm;
    }

    public boolean isManagerConfirm() {
        return managerConfirm;
    }

    public void setManagerConfirm(boolean managerConfirm) {
        this.managerConfirm = managerConfirm;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
