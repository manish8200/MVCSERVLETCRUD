<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	background-image: url("images/im.jpg");
}
.no-background {
    background-image: url("images/blank.jpg");
}
</style>

<meta charset="ISO-8859-1">
<title>WelCome Page</title>
</head>
<body background="im.jpg">
	 <sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
	 url="jdbc:mysql://localhost:3306/myusers?useSSL=false"
		user="root" password="root" />

	<sql:query var="listUsers" dataSource="${myDS}">
        SELECT * FROM myusers.employee;
    </sql:query>
 
	 <div align="center" class="container">
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>UserNmae</th>
                <th>Email</th>
                <th>Password</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.UserName}" /></td>
                    <td><c:out value="${user.Email}" /></td>
                    <td><c:out value="${user.Password}" /></td>
                    <td><a href="register?action=edit&userId=${user.Id}">Edit User</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>