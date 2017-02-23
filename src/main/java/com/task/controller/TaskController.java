package com.task.controller;

import com.task.model.Task;
import com.task.model.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by khanguyen on 09/02/2017.
 */
@RestController
public class TaskController {
    @Autowired
    TaskDAO taskDAO;
    @RequestMapping(value = "/task/create", method = RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        try {
            taskDAO.save(task);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(task, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
