package com.example;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by khanguyen on 24/01/2017.
 */
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    private int age;
    @NotNull
    private int salary;
    public Employee() {}
    public Employee(String name, int age, int salary) {
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}