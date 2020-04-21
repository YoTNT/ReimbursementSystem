package dev.jian.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.jian.controllers.TaskController;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TaskController tcontroller = new TaskController();

    public DispatcherServlet() {
        super();
    }


    // HTTP requests get to this method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		
		switch(uri) {
		
		case "/ReimbursementApp/api/loginemployee":
			tcontroller.loginEmployee(request, response);
			break;
			
		case "/ReimbursementApp/api/listallemployees":
			tcontroller.listAllEmployees(request, response);
			break;
			
		case "/ReimbursementApp/api/employee":
			tcontroller.getEmployeeInformation(request, response);
			break;
		
		default:
			response.getWriter().append("Served at: ").append(request.getContextPath());
//			response.sendRedirect("http://localhost:8080/ReimbursementApp/index.html");
			break;
		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}