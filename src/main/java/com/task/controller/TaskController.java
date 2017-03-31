package com.task.controller;

import com.task.model.Task;
import com.task.model.TaskDAO;
import com.task.model.TaskDAOImpl;
import com.util.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskDAOImpl taskDAO;
    @RequestMapping(value = "/task/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        try {
            System.out.println(task.getId());
            Calendar cal = Calendar.getInstance();
            Date utilDate = cal.getTime();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            task.setAssignor(authentication.getName());
            task.setStartTime(new java.sql.Date(utilDate.getTime()));
            taskDAO.save(task);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(task, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @RequestMapping(value = "/task/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getTask() {
        try {
            List<Task> lstTasks = taskDAO.findAll();
            return new ResponseEntity<>(lstTasks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseJSON("Fail to load tasks"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/task/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTask(@RequestBody Task task) {
        try {
            taskDAO.update(task);
            return new ResponseEntity<>(taskDAO.findById(task.getId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseJSON("Failed to update task"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/task/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTask(@RequestParam("id") int id) {
        try {
            taskDAO.deleteById(id);
            return new ResponseEntity<>(new ResponseJSON("Deleted successfully"), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseJSON("Failed to delete task"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
