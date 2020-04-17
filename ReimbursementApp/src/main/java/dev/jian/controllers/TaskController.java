package dev.jian.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.jian.entities.Employee;
import dev.jian.services.EmployeeService;
import dev.jian.services.EmployeeServiceImpl;
import dev.jian.services.ReimbursementService;
import dev.jian.services.ReimbursementServiceImpl;

public class TaskController {
	
	EmployeeService empserv = new EmployeeServiceImpl();
	ReimbursementService reimserv = new ReimbursementServiceImpl();
	
	public void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		
		Gson gson = new Gson();
		
		Employee employee = gson.fromJson(body, Employee.class);
		
		employee = empserv.employeeLogin(employee);
		
		String json = gson.toJson(employee);
		response.getWriter().append(json);
	}

	public void listAllEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.print("I'm in the controller");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(empserv.getAllEmployees());
		
		System.out.print("I converted to the JSON: " + json);
		
		response.getWriter().append(json);
	}
	
}
