<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
		<%
			String s1 = request.getAttribute("emp").toString().toUpperCase();
		%>
		Hello <b> <%=s1%></b> ! ,  user with <b> <%=s1%> </b>	 is already exist please use different userName. <br>
		<a href="Greet.jsp"> List of users </a> <br>	
		<a href="welcome.jsp"> add new  users </a>
		
		
</body>
</html>