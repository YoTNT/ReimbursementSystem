package dev.jian.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.jian.entities.Employee;
import dev.jian.entities.Manager;
import dev.jian.entities.Reimbursement;
import dev.jian.exceptions.EmployeeNotExistException;
import dev.jian.exceptions.ManagerNotExistException;
import dev.jian.exceptions.UnmatchPasswordException;
import dev.jian.services.EmployeeService;
import dev.jian.services.EmployeeServiceImpl;
import dev.jian.services.ManagerService;
import dev.jian.services.ManagerServiceImpl;
import dev.jian.services.ReimbursementService;
import dev.jian.services.ReimbursementServiceImpl;

public class TaskController {
	
	EmployeeService empserv = new EmployeeServiceImpl();
	ReimbursementService reimserv = new ReimbursementServiceImpl();
	ManagerService manserv = new ManagerServiceImpl();
	
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
	
	public void loginManager(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		
		Gson gson = new Gson();
		
		// Unwrapping the JSON object
		Manager manager = gson.fromJson(body, Manager.class);
		try {
			manager = manserv.managerLogin(manager);
			HttpSession sess = request.getSession();
			sess.setAttribute("manager",manager);
			
			String json = gson.toJson(manager);
			response.getWriter().append(json);
			return;
		}catch(ManagerNotExistException e) {
			response.sendError(403);
			return;
		}catch(UnmatchPasswordException e) {
			response.sendError(403);
			return;
		}
	}
	
	
	public void getManagerInformation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(manager);

		response.getWriter().append(json);
		return;
	}
	
	
	public void getPendingReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Gson gson = new Gson();
		
		String json = gson.toJson(reimserv.getReimbursementsByStatus("Pending"));
		
		response.getWriter().append(json);
	}
	
	public void getApprovedReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Gson gson = new Gson();
		
		String json = gson.toJson(reimserv.getReimbursementsByStatus("Approved"));
		
		response.getWriter().append(json);
	}
	
	public void getDeniedReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Gson gson = new Gson();
		
		String json = gson.toJson(reimserv.getReimbursementsByStatus("Denied"));
		
		response.getWriter().append(json);
	}
	
	public void approveReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		
		Gson gson = new Gson();
		
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		
		String json = gson.toJson(reimserv.approveReimbursement(reimbursement));
		
		response.getWriter().append(json);
	}
	
	public void denyReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		
		Gson gson = new Gson();
		
		Reimbursement reimbursement = gson.fromJson(body, Reimbursement.class);
		
		String json = gson.toJson(reimserv.denyReimbursement(reimbursement));
		
		response.getWriter().append(json);
	}
		
}
