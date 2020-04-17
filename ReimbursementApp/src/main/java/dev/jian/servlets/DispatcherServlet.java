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
		
		default:
			response.getWriter().append("You request uri did not match anything!");
			break;
		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
