package dev.jian.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.jian.services.EmployeeService;
import dev.jian.services.EmployeeServiceImpl;
import dev.jian.services.ReimbursementService;
import dev.jian.services.ReimbursementServiceImpl;

public class TaskController {
	
	EmployeeService empserv = new EmployeeServiceImpl();
	ReimbursementService reimserv = new ReimbursementServiceImpl();
	
	public void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.getWriter().append("I'm in the controller!!");
		
	}

}
