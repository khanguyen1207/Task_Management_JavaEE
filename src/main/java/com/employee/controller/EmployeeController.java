package com.employee.controller;

import com.employee.model.Employee;
import com.employee.model.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by khanguyen on 07/02/2017.
 */
//Note @RestController allow us to return object as json in response body
//Try to compare @Controller to @RestController f
@RestController
public class EmployeeController {
    @Autowired
    @Qualifier("employeeRepo")
    EmployeeDAO employeeDAO;
    public ResponseEntity<?> updateEmployee(String username) {
        //TODO Implement actuall controller method
        return new ResponseEntity<>(new Employee(), HttpStatus.OK);
    }
    @RequestMapping(value = "employee/get")
    public  ResponseEntity<?> getEmployee(@RequestParam("username") String username) {
        try {
            Employee employee = employeeDAO.findByUsername(username);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Employee("kha", "123", "coin"), HttpStatus.OK);
        }
    }
}
