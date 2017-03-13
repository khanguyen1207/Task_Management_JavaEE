package com.employee.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class EmployeeDaoTest {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Test
	public void findByUsernameTest(){
		Employee e = employeeDAO.findByUsername("khanguyen");
		assertThat(e.getEmail()).isEqualTo("khanguyen1207@gmail.com");
	}
	@Test
	public void findByUsernameTest2(){
		Employee e = employeeDAO.findByUsername("abcde");
		assertThat(e.getEmail()).isEqualTo("abc@gmail.com");
	}
	@Test
	public void findByUsernameTest3(){
		Employee e = employeeDAO.findByUsername("nguyenkha");
		assertThat(e.getRole()).isEqualTo("ROLE_HR");
	}
	
	@Test
	public void findByUsernameTest4(){
		Employee e = employeeDAO.findByUsername("khanguyen");
		assertThat(e.getRole()).isEqualTo("ROLE_ADMIN");
	}
}
