package dev.jian.services;

import java.util.ArrayList;
import java.util.List;

import dev.jian.daos.EmployeeDAO;
import dev.jian.daos.EmployeeDAOmaria;
import dev.jian.entities.Employee;
import dev.jian.exceptions.EmployeeNotExistException;
import dev.jian.exceptions.UnmatchPasswordException;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO empdao = new EmployeeDAOmaria();

	@Override
	public Employee employeeLogin(Employee employee)
			throws EmployeeNotExistException, UnmatchPasswordException {

		boolean employeeExist = false;
		boolean passwordCorrect = false;
		
		List<Employee> employees = new ArrayList<Employee>(empdao.getAllEmployee());
		Employee result = new Employee();
		
		for(Employee e : employees) {
			
			if(e.getUsername().equals(employee.getUsername())) {
				employeeExist = true;
				if(e.getPassword().equals(employee.getPassword())) {
					passwordCorrect = true;
					result.seteId(e.geteId());
					result.setName(e.getName());
					result.setUsername(e.getUsername());
					result.setPassword(e.getPassword());
					
					return result;
				}
			}
		}
		
		if(!employeeExist)
			throw new EmployeeNotExistException();
		if(employeeExist && !passwordCorrect)
			throw new UnmatchPasswordException();
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empdao.getAllEmployee();
	}

}
