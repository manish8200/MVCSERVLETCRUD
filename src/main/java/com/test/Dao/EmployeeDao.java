package com.test.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.ConnectionProvider.ConnectionProvider;
import com.test.model.EmployeePojo;

public class EmployeeDao {

	private Connection con;
	
	public EmployeeDao() {
		// TODO Auto-generated constructor stub
		con = ConnectionProvider.getConnection();
	}
	
	public void registerEmployee(EmployeePojo employee) throws ClassNotFoundException {

		String Insert_Query = "INSERT INTO `myusers`.`employee`\r\n" + "(`UserName`,\r\n" + "`Email`,\r\n"
				+ "`Password`)\r\n" + "VALUES (?,?,?)";

		try {
			PreparedStatement pStatements = con.prepareStatement(Insert_Query);

			// pStatements.setInt(1, 1);
			pStatements.setString(1, employee.getUserName());
			pStatements.setString(2, employee.getEmail());
			pStatements.setString(3, employee.getPassword());

			System.out.println(pStatements);

			pStatements.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}

	}
	
	public List<EmployeePojo> fetchListOfUser() throws ClassNotFoundException {
		String FEtch_Query = "Select * from employee";

		List<EmployeePojo> empList = new ArrayList<EmployeePojo>();
			try {
			
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
	
	public void deleteUser(int uid) {
		try {
			String deleteQuery = "Delete from employee where Id = ?";
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, uid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
	}
	
	public void updateUser (EmployeePojo emp ) {
	
		try {
			String updateQuery = "UPDATE employee SET UserName=?, Email=? , Password=? WHERE Id=?" ;
			PreparedStatement ps =  con.prepareStatement(updateQuery);
			ps.setString(1, emp.getUserName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getPassword());
			ps.setLong(4, emp.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public EmployeePojo getEmployeeById ( int id ) {
		
		EmployeePojo emp =  new EmployeePojo();
		try {
			String fetchQuery = "select * from employee where id=?";
			PreparedStatement ps =  con.prepareStatement(fetchQuery);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp.setUserName(rs.getString("UserName"));
				emp.setEmail(rs.getString("Email"));
				emp.setPassword(rs.getString("Password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		return emp;
	}
}
