<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>
   <jsp:forward page="/welcome.jsp">
  <jsp:param name="firstName" value="One" />
  <jsp:param name="lastName" value="Two" />
 </jsp:forward>
 <h1>This wont print as control forwards to welcome.jsp page</h1> 
</body>
</html>