<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome User</title>
</head>
<body> 

</body>
</html> --%>

<%@page import="com.sun.org.apache.bcel.internal.generic.LSTORE"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
    background-image: url("/im.jpg");
}
.no-background {
    background-image: url("blank.jpg");
}
</style> 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>A User Input Page !!!</title>
</head>

<body background="#ADB1A9">

<div >
	<form action="<%=request.getContextPath()%>/test?action=insert" method="post" name="action" value="insert"
		align="center"  style="background-image: url('im.jpg');" >
		<table style="width: 80%">
			<tr>
				<td>FirstName</td>
				<td><input type="text" name="firstName" align="top"></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><input type="text" name="lastName"></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="email" name="email"></td>
			</tr>

			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td><input type="submit" name="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</div>
</body>

</html>