/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.model;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 51202_000
 */
public class TaskTest {
    
    public TaskTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDescription method, of class Task.
     */
    
    @Test
    public void testConstructor(){
        Task task = new Task();
        assertEquals(task!=null, true);
    }
    
    @Test
    public void testConstructor2(){
        Task task = new Task("cleaning");
        assertEquals(task.getDescription(),"cleaning");
    }
    
    
    
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Task instance = new Task();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setDescription method, of class Task.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "cleaning";
        Task instance = new Task();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getDescription(), description);
    }

    /**
     * Test of getTitle method, of class Task.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Task instance = new Task();
        String expResult = null;
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setTitle method, of class Task.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "today task";
        Task instance = new Task();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(title, instance.getTitle());
    }

    /**
     * Test of getId method, of class Task.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Task instance = new Task();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of setId method, of class Task.
     */


    /**
     * Test of getAssignee method, of class Task.
     */
    @Test
    public void testGetAssignee() {
        System.out.println("getAssignee");
        Task instance = new Task();
        String expResult = null;
        String result = instance.getAssignee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of setAssignee method, of class Task.
     */
    @Test
    public void testSetAssignee() {
        System.out.println("setAssignee");
        String assignee = "Ngoc";
        Task instance = new Task();
        instance.setAssignee(assignee);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(assignee, instance.getAssignee());
    }

    /**
     * Test of getAssignor method, of class Task.
     */
    @Test
    public void testGetAssignor() {
        System.out.println("getAssignor");
        Task instance = new Task();
        String expResult = null;
        String result = instance.getAssignor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setAssignor method, of class Task.
     */
    @Test
    public void testSetAssignor() {
        System.out.println("setAssignor");
        String assignor = "Ngoc";
        Task instance = new Task();
        instance.setAssignor(assignor);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getAssignor(), assignor);
    }

    /**
     * Test of isEmployeeConfirm method, of class Task.
     */
    @Test
    public void testIsEmployeeConfirm() {
        System.out.println("isEmployeeConfirm");
        Task instance = new Task();
        boolean expResult = false;
        boolean result = instance.isEmployeeConfirm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setEmployeeConfirm method, of class Task.
     */
    @Test
    public void testSetEmployeeConfirm() {
        System.out.println("setEmployeeConfirm");
        boolean employeeConfirm = true;
        Task instance = new Task();
        instance.setEmployeeConfirm(employeeConfirm);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.isEmployeeConfirm(), employeeConfirm);
    }

    /**
     * Test of isManagerConfirm method, of class Task.
     */
    @Test
    public void testIsManagerConfirm() {
        System.out.println("isManagerConfirm");
        Task instance = new Task();
        boolean expResult = false;
        boolean result = instance.isManagerConfirm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setManagerConfirm method, of class Task.
     */
    @Test
    public void testSetManagerConfirm() {
        System.out.println("setManagerConfirm");
        boolean managerConfirm = true;
        Task instance = new Task();
        instance.setManagerConfirm(managerConfirm);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.isManagerConfirm(), managerConfirm);
    }

    /**
     * Test of getStartTime method, of class Task.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        Task instance = new Task();
        Date expResult = null;
        Date result = instance.getStartTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of setStartTime method, of class Task.
     */
    @Test
    public void testSetStartTime() {
        System.out.println("setStartTime");
        Date startTime = new Date(1111111111);
        Task instance = new Task();
        instance.setStartTime(startTime);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.getStartTime().compareTo(startTime), 0);
    }

    /**
     * Test of getEndTime method, of class Task.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        Task instance = new Task();
        Date expResult = null;
        Date result = instance.getEndTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setEndTime method, of class Task.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        Date endTime = new Date(1111111111);
        Task instance = new Task();
        instance.setEndTime(endTime);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(endTime.compareTo(instance.getEndTime()), 0);
    }

    /**
     * Test of getStatus method, of class Task.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Task instance = new Task();
        String expResult = null;
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of setStatus method, of class Task.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "done";
        Task instance = new Task();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(status, instance.getStatus());
    }
    
}
