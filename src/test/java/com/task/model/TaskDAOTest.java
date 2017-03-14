package com.task.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class TaskDAOTest {
	@Autowired
	private TaskDAO taskDAO;
	
	
	@Test
	public void findByIdTest(){
		Task task = taskDAO.findById(7);
		assertThat(task.getTitle()).isEqualTo("name");
	}
	
	@Test
	public void findByIdTest1(){
		Task task = taskDAO.findById(7);
		assertThat(task.getAssignee()).isEqualTo("khanguyen");
	}
	
	@Test
	public void findByIdTest2(){
		Task task = taskDAO.findById(7);
		assertThat(task.getAssignor()).isEqualTo("khanguyen");
	}
	
	@Test
	public void finbyAssgineeTest(){
		List<Task> tasks= taskDAO.findByAssignee("khanguyen");
		assertThat(tasks.size()).isEqualTo(3);
		
	}
	
	@Test
	public void finbyAssgineeTest1(){
		List<Task> tasks= taskDAO.findByAssignee("zozo");
		assertThat(tasks.size()).isEqualTo(1);
		
	}
	
	@Test
	public void finbyAssgineeTest2(){
		List<Task> tasks= taskDAO.findByAssignee("abcde");
		assertThat(tasks.size()).isEqualTo(1);
		
	}
	@Test
	public void finbyAssgineeTest3(){
		List<Task> tasks= taskDAO.findByAssignee("donaldtrump");
		assertThat(tasks.size()).isEqualTo(2);
		
	}
	@Test
	public void finbyAssgineeTest4(){
		List<Task> tasks= taskDAO.findByAssignee("khanguyen1");
		assertThat(tasks.size()).isEqualTo(1);
		
	}
	
	
}
