package com.employee.model;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class EmployeeDAOImpl {
    final private String appUrl = "https://ascendant-timer-158814.firebaseio.com/employee/";
    public Employee findByUsername(String username) {
        final String url = appUrl + username + ".json?" ;
        RestTemplate restTemplate = new RestTemplate();
        Employee employeeFromJson;
        try {
            employeeFromJson = restTemplate.getForObject(url, Employee.class);
            return employeeFromJson;
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Long deleteByUsername(String username) {
        //TODO: Implement delete function
        return null;
    }

}
