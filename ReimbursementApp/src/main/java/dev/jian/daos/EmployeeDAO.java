package dev.jian.daos;

import java.util.List;

import dev.jian.entities.Employee;

public interface EmployeeDAO {

	Employee getEmployeeById(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeByName(String name);
	
}
