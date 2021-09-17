<%@page import="com.test.model.EmployeePojo"%>
<%@page import="com.test.Dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
	<%
		EmployeeDao dao = new EmployeeDao();
	%>


	<form action="<%=request.getContextPath()%>/test?action=edit">
		<%
			int id = Integer.parseInt(request.getParameter("userId"));
			EmployeePojo emp = dao.getEmployeeById(id);
		%>
	<table align="center" width="80%">
		<tr>
			<td>UserID</td>
			<td><input type="text" readonly="readonly" name="userId"
				value="<%=id%>"></td>
		</tr>
		<tr>
			<br>
			<td>UserName</td>
			<td><input type="text" name="username"
				value="<%=emp.getUserName()%>"></td>
		</tr>
		<tr>
			<br>
			<td>Email</td>
			<td><input type="text" name="Email"
				value=" <%=emp.getEmail()%> "></td>
		</tr>
		<br>
		<tr>
			<td>Password</td>
			<td><input type="text" name="password"
				value=" <%=emp.getPassword()%> "></td>
		</tr>
		<br>

		<tr>
			<td><input type="submit" name="action" value="edit">
			</td>
		</tr>
	</table>
	</form>

</body>
</html>