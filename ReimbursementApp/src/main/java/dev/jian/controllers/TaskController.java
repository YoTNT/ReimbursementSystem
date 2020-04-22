package dev.jian.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.jian.entities.Employee;
import dev.jian.entities.Reimbursement;
import dev.jian.exceptions.EmployeeNotExistException;
import dev.jian.exceptions.UnmatchPasswordException;
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
		
		// Unwrapping the JSON object
		Employee employee = gson.fromJson(body, Employee.class);
		try {
			employee = empserv.employeeLogin(employee);
			HttpSession sess = request.getSession();
			sess.setAttribute("employee",employee);
			
			String json = gson.toJson(employee);
			response.getWriter().append(json);
			return;
		}catch(EmployeeNotExistException e) {
			response.sendError(403);
			return;
		}catch(UnmatchPasswordException e) {
			response.sendError(403);
			return;
		}
	}
	
	public void getEmployeeInformation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// get employee object from cookie
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		
		// Testing
		System.out.println(employee);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(employee);

		response.getWriter().append(json);
		return;
	}

	public void listAllEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Gson gson = new Gson();
		
		String json = gson.toJson(empserv.getAllEmployees());
		
		response.getWriter().append(json);
	}
	
	public void getReimbursementHistoryByEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		
		Gson gson = new Gson();
		List<Reimbursement> reimbursements = reimserv.getReimbursementsByEmployee(employee);
		String json = gson.toJson(reimbursements);
		
		PrintWriter pw = response.getWriter();
		pw.append(json);
	}
	
	public void submitReimbursementByEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// Get employee in order to have the requester ID
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		
		// Renew reimbursement's requester ID
		reimbursement.setRequesterId(employee.geteId());
		
		reimbursement = reimserv.submitReimbursement(reimbursement);
		if(reimbursement.getStatus().equals("Pending")) {
			response.getWriter().append("Success");
		}
		else {
			response.getWriter().append("Fail");
		}
	}
		
}
