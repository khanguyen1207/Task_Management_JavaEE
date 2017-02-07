package com.employee.controller;

import com.employee.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by khanguyen on 07/02/2017.
 */
//Note @RestController allow us to return object as json in response body
//Try to compare @Controller to @RestController f
@RestController
public class EmployeeController {
    public ResponseEntity<?> updateEmployee(String username) {
        //TODO Implement actuall controller method
        return new ResponseEntity<>(new Employee(), HttpStatus.OK);
    }
}
