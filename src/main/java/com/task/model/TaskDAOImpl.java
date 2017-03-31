package com.task.model;

import com.employee.model.Employee;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by khanguyen on 3/23/17.
 */
public class TaskDAOImpl {
    private final String appUrl = "https://ascendant-timer-158814.firebaseio.com/task/";
    private final String json = ".json/";
    private final String listTaskEndpoint = "list_task/";
    private final String autoIncrementEndpoint = "auto_increment/";

    public Task findById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String url = appUrl + listTaskEndpoint + json + "?orderBy=\"id\"&equalTo=";
            String jsonResponse = restTemplate.getForObject(url + id , String.class);
            JSONObject jsonObject = new JSONObject(jsonResponse.trim());
            Iterator<?> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                if (jsonObject.get(key) instanceof JSONObject) {
                    return new Gson().fromJson(jsonObject.get(key).toString(), Task.class);
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String url = appUrl + listTaskEndpoint + json + "?orderBy=\"id\"&equalTo=";
            String jsonResponse = restTemplate.getForObject(url + id , String.class);
            JSONObject jsonObject = new JSONObject(jsonResponse.trim());
            Iterator<?> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                restTemplate.delete(appUrl + listTaskEndpoint + key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Task> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        List<Task> tasks = new ArrayList<>();
        try {
            String url = appUrl + listTaskEndpoint + json;
            String jsonResponse = restTemplate.getForObject(url, String.class);
            JSONObject jsonObject = new JSONObject(jsonResponse.trim());
            Iterator<?> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                if (!key.equals("not_array")) {
                    JSONObject taskData = jsonObject.getJSONObject(key);
                    System.out.println(jsonObject.get(key));
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date startTime = simpleDateFormat.parse(taskData.getString("startTime"));
                    Date endTime = simpleDateFormat.parse(taskData.getString("endTime"));
                    int id = Integer.parseInt(taskData.get("id").toString());
                    String description = taskData.getString("description");
                    String assignor = taskData.getString("assignor");
                    String assignee = taskData.getString("assignee");
                    String title = taskData.getString("title");
                    String status = taskData.getString("status");
                    tasks.add(new Task(id, description, assignee, assignor, title, status, startTime, endTime));
                }
            }
            return tasks;
        } catch (Exception e) {
            e.printStackTrace();
            return tasks;
        }
    }

    public void save(Task task) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String url = appUrl + autoIncrementEndpoint + json;
            String jsonResponse = restTemplate.getForObject(url, String.class);
            JSONObject jsonObject = new JSONObject(jsonResponse.trim());
            int id = (Integer) jsonObject.get("index");
            task.setId(id);
            restTemplate.put(appUrl + autoIncrementEndpoint +"index/" + json, id + 1);
            restTemplate.put(appUrl+listTaskEndpoint+id+"/"+json, task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Task task) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.put(appUrl+listTaskEndpoint+task.getId()+"/"+json, task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
