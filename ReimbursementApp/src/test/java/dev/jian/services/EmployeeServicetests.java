package dev.jian.services;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.jian.entities.Employee;

public class EmployeeServicetests {

	public static EmployeeService empserv = new EmployeeServiceImpl();
	
	@Test
	public void employeeLogin() {
		
		Employee emp1 = new Employee();
		emp1.setUsername("jian");
		emp1.setPassword("j123");
		
		System.out.println(empserv.employeeLogin(emp1));
		
	}
	
	@Test
	public void getAllEmployees() {
		System.out.println(empserv.getAllEmployees());
	}

}
