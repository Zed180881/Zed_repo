<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>
</head>
<body>
	<h3>Add user:</h3>
	<form action="/admin/user" method="post">
		<label for="fullName">User full name:</label><br> 
		<input type="text" name="fullName" placeholder="input full name here" required><br>
		<label for="login">Login:</label><br> 
		<input type="text" name="login" placeholder="input login here" required><br>
		<label for="password">Password:</label><br> 
		<input type="text" name="password" placeholder="input password here" required><br>
		<label for="mail">E-mail:</label><br> 
		<input type="email" name="mail" placeholder="input e-mail here" required><br>
		<label for="phone">Phone:</label><br> 
		<input type="tel" name="phone" placeholder="input phone here" required><br>
		<label for="address">Address:</label><br> 
		<input type="text" name="address" placeholder="input address here" required><br>		
		<input type="submit" value="Add user">
	</form><br>
	<h3>Current users:</h3>
	<table>
		<tr>
			<th>Full Name</th>
			<th>Login</th>
			<th>Password</th>
			<th>E-mail</th>
			<th>Phone</th>
			<th>Address</th>				
		</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.fullName}</td>
			<td>${user.login}</td>
			<td>${user.password}</td>
			<td>${user.mail}</td>
			<td>${user.phone}</td>
			<td>${user.address}</td>			
		</tr>			
	</c:forEach>	
	</table><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>	
</body>
</html>