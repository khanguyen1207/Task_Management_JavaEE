package com.task.controller;

import com.task.model.Task;
import com.task.model.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by khanguyen on 09/02/2017.
 */
@RestController
public class TaskController {
    @Autowired
    TaskDAO taskDAO;
    @RequestMapping(value = "/task/create", method = RequestMethod.POST)
    @ResponseBody
    public void addTask(@RequestParam("nameTask") String nameTask, @RequestParam("description") String description, @RequestParam("empId") int empId) {
        Task task = new Task(nameTask, description, empId);
        taskDAO.save(task);
    }
}
