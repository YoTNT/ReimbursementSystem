package dev.jian.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.jian.daos.EmployeeDAO;
import dev.jian.daos.EmployeeDAOmaria;
import dev.jian.entities.Employee;

public class EmployeeDAOmariatests {

	public static EmployeeDAO empdao = new EmployeeDAOmaria();
	
	@Test
	public void getAllEmployee() {
		System.out.println(empdao.getAllEmployee());
	}

	@Test
	public void getEmployeeById() {
		Employee emp1 = new Employee();
		emp1.seteId(3);
		System.out.println(empdao.getEmployeeById(emp1));
	}
	
	@Test
	public void getEmployeeByName() {
		String name1 = "Jian Qiu";
		String name2 = "Peter Lee";
		System.out.println(empdao.getEmployeeByName(name2));
	}
}
