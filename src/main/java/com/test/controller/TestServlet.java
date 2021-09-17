package com.test.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Dao.EmployeeDao;
import com.test.model.EmployeePojo;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static EmployeeDao dao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
	private static String INSERT = "/welcome.jsp";
	private static String Edit = "/Edit.jsp";
	private static String ListOfUser = "/Greet.jsp";
	private static String ErroJsp = "/Error.jsp";
	
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
        dao = new EmployeeDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String REDIRECT = "/Greet.jsp";
	 String uid = request.getParameter("userId");
		// String uid = "1";
		String action = request.getParameter("action");
		
		if (uid != null && !uid.isEmpty()) {
			if (action.equalsIgnoreCase("editform") || action == "editform") {
				REDIRECT = Edit;
			} else if (action.equalsIgnoreCase("delete")) {
				Integer id = Integer.parseInt(uid);
				dao.deleteUser(id);

				REDIRECT = ListOfUser;

			} else if (action.equalsIgnoreCase("edit")) {
				Long id = Long.parseLong(uid);
				EmployeePojo emp = new EmployeePojo();
				emp.setId(id);
				emp.setUserName(request.getParameter("username"));
				emp.setEmail(request.getParameter("Email"));
				emp.setPassword(request.getParameter("password"));

				dao.updateUser(emp);
				REDIRECT = ListOfUser;

			}
		}else if(action != null && !action.isEmpty() && action.equalsIgnoreCase("listOfUser")) {
				REDIRECT = ListOfUser;
			}else if (action != null && !action.isEmpty() && action.equalsIgnoreCase("insert")) {
				try {

					EmployeePojo emp = new EmployeePojo();
					emp.setUserName(request.getParameter("firstName") +" " + request.getParameter("lastName"));
					emp.setEmail(request.getParameter("email"));
					emp.setPassword(request.getParameter("password"));
					
					dao.registerEmployee(emp);	
					REDIRECT = ListOfUser;
				} catch (Exception e) {
					// TODO: handle exception
				}
			
		
		}
		
		RequestDispatcher RD = request.getRequestDispatcher(REDIRECT);
		RD.forward(request, response);
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
