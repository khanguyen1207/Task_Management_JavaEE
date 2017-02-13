package com.employee.controller;

import com.employee.model.Employee;
import com.employee.model.EmployeeDAO;
import com.google.inject.Inject;
import com.util.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by khanguyen on 07/02/2017.
 */
//Note @RestController allow us to return object as json in response body
//Try to compare @Controller to @RestController f
@RestController
@RequestMapping(value = "api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    public ResponseEntity<?> updateEmployee(String username) {
        //TODO Implement actuall controller method
        return new ResponseEntity<>(new Employee(), HttpStatus.OK);
    }
    @RequestMapping(value = "/get")
    public  ResponseEntity<?> getEmployee(@RequestParam("username") String username) {
        try {
            List<Employee> employee = employeeDAO.findByUsername(username);
            return new ResponseEntity<>(employee.get(0), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(new Employee("kha", "123", "coin"), HttpStatus.OK);
        }
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> coincard(@RequestBody Employee employee ) {
        try {
            employeeDAO.save(employee);
            return new ResponseEntity<>(new ResponseJSON(200, "Success"), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(new ResponseJSON(200, "Username existed"), HttpStatus.OK);
        }
    }
}
