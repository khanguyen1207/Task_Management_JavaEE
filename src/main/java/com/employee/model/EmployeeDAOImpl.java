package com.employee.model;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public void deleteByUsername(String username) {
        //TODO: Implement delete function
        RestTemplate restTemplate = new RestTemplate();
        final  String url = appUrl + username + ".json";
        try {
            restTemplate.delete(url);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }

    public void save(Employee employee) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = appUrl + employee.getUsername() + ".json";
        try {
            restTemplate.put(url, employee);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        List<Employee> employees = new ArrayList<>();
        try {
            String jsonString = restTemplate.getForObject(appUrl + ".json", String.class);
            JSONObject jsonObject = new JSONObject(jsonString.trim());
            Iterator<?> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                if (jsonObject.get(key) instanceof JSONObject) {
                    //System.out.println(jsonObject.get(key).toString());
                    employees.add(new Gson().fromJson(jsonObject.get(key).toString(), Employee.class));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }


}
