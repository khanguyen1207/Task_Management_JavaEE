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
    @Column(name = "assignee") private String assignee;
    @Column(name = "assignor") private String assignor;
    @Column(name = "empconf") private boolean employeeConfirm;
    @Column(name = "mngconf") private boolean managerConfirm;
    @Column(name = "title") private String title;
    @Column(name = "status") private String status;
    @Column(name = "issue_date") private Date startTime;
    @Column(name = "deadline") private Date endTime;
    public Task() {

    }
    
    public Task(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getAssignor() {
        return assignor;
    }

    public void setAssignor(String assignor) {
        this.assignor = assignor;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
