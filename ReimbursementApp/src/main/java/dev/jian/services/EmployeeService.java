package dev.jian.services;

import java.util.List;


import dev.jian.entities.Employee;
import dev.jian.exceptions.EmployeeNotExistException;
import dev.jian.exceptions.UnmatchPasswordException;

public interface EmployeeService {
	
	public Employee employeeLogin(Employee employee) throws EmployeeNotExistException, UnmatchPasswordException;
	
	public List<Employee> getAllEmployees();
}
