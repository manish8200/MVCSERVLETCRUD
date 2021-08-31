package com.test.Dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.model.EmployeePojo;

public class EmployeeDao {

	private java.sql.Connection con;
	
	public int registerEmployee(EmployeePojo employee) throws ClassNotFoundException {
		
		int result = 0;
		
		String Insert_Query = "INSERT INTO `myusers`.`employee`\r\n" + 
				"(`UserName`,\r\n" +  
				"`Email`,\r\n" + 
				"`Password`)\r\n" + 
				"VALUES (?,?,?)";
				
		Class.class.forName("com.mysql.jdbc.Driver");
		
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers?useSSL=false", "root", "root");
			 
			 String select_query = "Select * from `myusers`.`employee` where UserName=? AND Email=?";
			 
			 PreparedStatement selectStatement = con.prepareStatement(select_query);
			 
			 selectStatement.setString(1, employee.getUserName());
			 selectStatement.setString(2, employee.getEmail());
			 
			 ResultSet RS = selectStatement.executeQuery();
		
		//	String ValidateUser = RS.getString("UserName");
			
			PreparedStatement pStatements = con.prepareStatement(Insert_Query);
			
			//pStatements.setInt(1, 1);
			pStatements.setString(1, employee.getUserName());
			pStatements.setString(2, employee.getEmail());
			pStatements.setString(3, employee.getPassword());
			
			System.out.println(pStatements);
			
		 result = pStatements.executeUpdate();
		}  catch (SQLException se) {
			System.out.println(se);
		}catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
		}
		
		
		return result; 
	}
	
	public List<EmployeePojo> fetchListOfUser() throws ClassNotFoundException {
		String FEtch_Query = "Select * from employee";

		List<EmployeePojo> empList = new ArrayList<EmployeePojo>();

		Class.class.forName("com.mysql.jdbc.Driver");

		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers?useSSL=false",
					"root", "root");

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(FEtch_Query);

			while (rs.next()) {
				EmployeePojo emp = new EmployeePojo();
				emp.setUserName(rs.getString("UserName"));
				emp.setEmail(rs.getString("Email"));
				emp.setPassword(rs.getString("Password"));
				empList.add(emp);

			}

			System.out.println(empList);

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
		return empList;
	}
}
