package com.employee.controller;

import com.employee.model.Employee;
import com.employee.model.EmployeeDAO;
import com.util.EmployeeJSON;
import com.util.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khanguyen on 07/02/2017.
 */
//Note @RestController allow us to return object as json in response body
//Try to compare @Controller to @RestController f
@RestController
@RequestMapping(value = "employee")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        //TODO Implement actuall controller method
        try {
            Employee toSave = employeeDAO.findByUsername(employee.getUsername());
            toSave.setRole(employee.getRole());
            toSave.setEmail(employee.getEmail());
            toSave.setAvatar_url(employee.getAvatar_url());
            employeeDAO.save(toSave);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseJSON("Cannot find employee"), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/get")
    public ResponseEntity<?> getEmployee(@RequestParam("username") String username) {
        try {
            Employee employee = employeeDAO.findByUsername(username);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseJSON("Cannot find employee"), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        employee.setPassword(new BCryptPasswordEncoder().encode(employee.getPassword()));
        employee.setEnabled(true);
        if (employee.getAvatar_url() == null)
            employee.setAvatar_url("http://i.imgur.com/NJ01RZC.jpg");
        if (employee.getRole() == null)
            employee.setRole("ROLE_USER");
        try {
            employeeDAO.save(employee);
            return new ResponseEntity<>(new ResponseJSON("Success"), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(new ResponseJSON("Username existed"), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@RequestParam("username") String username) {
        try {
            employeeDAO.deleteByUsername(username);
            return new ResponseEntity<>(new ResponseJSON("Deleted successfully"), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseJSON("Failed to delete employee"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/getall")
    public ResponseEntity<?> getAllEmployee() {
        try {
            List<EmployeeJSON> lstEmployeeJson = new ArrayList<>();
            List<Employee> lstEmployees = employeeDAO.findAll();
            for (Employee employee : lstEmployees) {
                lstEmployeeJson.add(new EmployeeJSON(employee.getUsername(), employee.getRole(), employee.getAvatar_url(), employee.getEmail()));
            }
            return new ResponseEntity<>(lstEmployeeJson, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseJSON("Can't get employee"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getemp", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getEmployee() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Employee employee = employeeDAO.findByUsername(authentication.getName());
            EmployeeJSON employeeJSON = new EmployeeJSON(employee.getUsername(), employee.getRole(), employee.getAvatar_url(), employee.getEmail());
            return new ResponseEntity<>(employeeJSON, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseJSON("Can't get employee"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
