package dev.jian.services;

import dev.jian.entities.Employee;
import dev.jian.exceptions.EmployeeNotExistException;
import dev.jian.exceptions.UnmatchPasswordException;

public interface EmployeeService {
	
	public Employee employeeLogin(String username, String password) throws EmployeeNotExistException, UnmatchPasswordException;
	
}
