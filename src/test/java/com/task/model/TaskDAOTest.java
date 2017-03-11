/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.task.model;

import java.util.List;
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
public class TaskDAOTest {
    
    public TaskDAOTest() {
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
     * Test of findById method, of class TaskDAO.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        TaskDAO instance = new TaskDAOImpl();
        Task expResult = null;
        Task result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByAssignee method, of class TaskDAO.
     */
    @Test
    public void testFindByAssignee() {
        System.out.println("findByAssignee");
        String assignee = "";
        TaskDAO instance = new TaskDAOImpl();
        List<Task> expResult = null;
        List<Task> result = instance.findByAssignee(assignee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteById method, of class TaskDAO.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        int id = 0;
        TaskDAO instance = new TaskDAOImpl();
        Long expResult = null;
        Long result = instance.deleteById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class TaskDAOImpl implements TaskDAO {

        public Task findById(int id) {
            return null;
        }

        public List<Task> findByAssignee(String assignee) {
            return null;
        }

        public Long deleteById(int id) {
            return null;
        }
    }
    
}
