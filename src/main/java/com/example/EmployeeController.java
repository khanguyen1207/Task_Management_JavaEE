package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.EmployeeDAO;

/**
 * Created by khanguyen on 24/01/2017.
 */
@RestController
public class EmployeeController {
    //private static final String template = "Hello, %s!";
    @Autowired
    @Qualifier("bean")
    private EmployeeDAO employeeDAO;
    @RequestMapping({"/get-by-id"})
    @ResponseBody
    public Employee getById(@RequestParam(value = "id", defaultValue = "1")String id) {
        Employee employee;
        System.out.println("coinn card");
        try {
            employee = employeeDAO.findById(Integer.parseInt(id));
            //userName = employee.getName();
        } catch (Exception e) {
            System.out.println(e);
            return new Employee("Kha", 24, 3000);
        }
        return employee;
    }


}
