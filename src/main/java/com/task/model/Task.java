package com.task.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "assignee")
    private String assignee;
    @Column(name = "assignor")
    private String assignor;
    @Column(name = "title")
    private String title;
    @Column(name = "status")
    private String status;
    @Column(name = "issue_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @Column(name = "deadline")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    public Task() {

    }

    public Task(String description) {
        this.description = description;
    }

    public Task(int id, String description, String assignee, String assignor, String title, String status, Date startTime, Date endTime) {
        this.id = id;
        this.description = description;
        this.assignee = assignee;
        this.assignor = assignor;
        this.title = title;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
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
