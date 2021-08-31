package com.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Dao.EmployeeDao;
import com.test.model.EmployeePojo;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeDao dao = new EmployeeDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uid = request.getParameter("userId").toString();
		String action =  request.getParameter("action").toString();
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/welcome.jsp");
		rd.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result = 0;
		List<EmployeePojo> empList =  new ArrayList<EmployeePojo>();
		EmployeePojo emp = new EmployeePojo();
		try {
			
			String fullName = request.getParameter("firstName") + " " + request.getParameter("lastName"); 
			emp.setId(1L);
			emp.setUserName(fullName);
			emp.setEmail(request.getParameter("email"));
			emp.setPassword(request.getParameter("password"));
			
			result = dao.registerEmployee(emp);
			
			// empList =	dao.fetchListOfUser();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			response.sendRedirect("Error.jsp");
		}
		if(result != 0) {
		//request.setAttribute("EmplList", empList);
		RequestDispatcher rd = request.getRequestDispatcher("Greet.jsp");
		rd.forward(request, response);
		}
		else { 
		request.setAttribute("emp", emp.getUserName());
		RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
		rd.forward(request, response);
		}
		// response.sendRedirect("Greet.jsp");
		
	}

	
}
