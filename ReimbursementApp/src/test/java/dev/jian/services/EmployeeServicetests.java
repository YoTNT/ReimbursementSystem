package dev.jian.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeServicetests {

	public static EmployeeService empserv = new EmployeeServiceImpl();
	
	@Test
	public void employeeLogin() {
		
		String username = "jian";
		String password = "j123";
		
		System.out.println(empserv.employeeLogin(username, password));
		
	}

}
