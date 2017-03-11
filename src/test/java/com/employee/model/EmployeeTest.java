/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.model;

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
public class EmployeeTest {
    
    public EmployeeTest() {
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
     * Test of getUsername method, of class Employee.
     */
    
    @Test
    public void testConstructor(){
        Employee employee = new Employee();
        
        assertEquals(employee.getClass(), Employee.class );
    }
    
    @Test
    public void testConstructor1(){
        Employee employee = new Employee();
        
        assertEquals(employee!=null, true);
    }
    
    @Test
    public void testConstructor2(){
        Employee employee = new Employee("jack","123234","dasdas");
        
        assertEquals(employee.getClass(), Employee.class );
    }
    
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Employee instance = new Employee("jack","john","122344");
        String expResult = "jack";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setUsername method, of class Employee.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Employee instance = new Employee();
        instance.setUsername("jack");
        assertEquals(instance.getUsername(), "jack");
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPassword method, of class Employee.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
         Employee instance = new Employee("jack","john","122344");
        String expResult = "john";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of setPassword method, of class Employee.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "1234";
        Employee instance = new Employee();
        instance.setPassword(password);
        
        assertEquals(password, instance.getPassword());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getEmail method, of class Employee.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
         Employee instance = new Employee("jack","john","122344");
        String expResult = "122344";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of setEmail method, of class Employee.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "email";
        Employee instance = new Employee();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(email, instance.getEmail());
    }

    /**
     * Test of getFb_token method, of class Employee.
     */
    @Test
    public void testGetFb_token() {
        System.out.println("getFb_token");
        Employee instance = new Employee();
        instance.setFb_token("ngocvo");
        String expResult = "ngocvo";
        String result = instance.getFb_token();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of setFb_token method, of class Employee.
     */
    @Test
    public void testSetFb_token() {
        System.out.println("setFb_token");
        String fb_token = "ngocvo";
        Employee instance = new Employee();
        instance.setFb_token(fb_token);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(fb_token, instance.getFb_token());
    }

    /**
     * Test of getRole method, of class Employee.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Employee instance = new Employee();
        String expResult = null;
        String result = instance.getRole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setRole method, of class Employee.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "ROLE_ADMIN";
        Employee instance = new Employee();
        instance.setRole(role);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(role, instance.getRole());
    }

    /**
     * Test of getAvatar_url method, of class Employee.
     */
    @Test
    public void testGetAvatar_url() {
        System.out.println("getAvatar_url");
        Employee instance = new Employee();
        instance.setAvatar_url("/upload");
        String expResult = "/upload";
        assertEquals(expResult, instance.getAvatar_url());
        
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setAvatar_url method, of class Employee.
     */
    @Test
    public void testSetAvatar_url() {
        System.out.println("setAvatar_url");
        String avatar_url = "/upload";
        Employee instance = new Employee();
        instance.setAvatar_url(avatar_url);
        
        assertEquals(instance.getAvatar_url(), avatar_url);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of isEnabled method, of class Employee.
     */
    @Test
    public void testIsEnabled() {
        System.out.println("isEnabled");
        Employee instance = new Employee();
        boolean expResult = false;
        boolean result = instance.isEnabled();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setEnabled method, of class Employee.
     */
    @Test
    public void testSetEnabled() {
        System.out.println("setEnabled");
        boolean enabled = true;
        Employee instance = new Employee();
        instance.setEnabled(enabled);
        assertEquals(enabled, instance.isEnabled());
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
