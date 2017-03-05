package com.main;

import com.employee.model.Employee;
import com.employee.model.EmployeeDAO;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * Created by khanguyen on 11/02/2017.
 */
@RestController
public class HomeController {
    @Autowired
    EmployeeDAO employeeDAO;
    @RequestMapping(value = "/")
    public ResponseEntity<?> index(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Employee employee =  employeeDAO.findByUsername(username);
        HttpSession session = request.getSession();
        session.setAttribute("user", username);
        session.setMaxInactiveInterval(30*60);
        Cookie userName = new Cookie("user", username);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
