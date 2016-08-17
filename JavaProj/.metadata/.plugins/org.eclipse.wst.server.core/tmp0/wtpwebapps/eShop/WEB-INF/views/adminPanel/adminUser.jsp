<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>
</head>
<body>
	<h3>Add user:</h3>
	<form:form action="/admin/user" method="post" modelAttribute="user">
		<form:errors path="*"/><br>
		<form:input path="id" type="hidden"/>
		<label for="fullName">User full name:</label><br> 
		<form:input type="text" path="fullName" id="fullName" placeholder="input full name here" required="true"/><br>
		<label for="login">Login:</label><br> 
		<form:input type="text" path="login" id="login" placeholder="input login here" required="true"/><br>
		<label for="password">Password:</label><br> 
		<form:input type="text" path="password" id="password" placeholder="input password here" required="true"/><br>
		<label for="mail">E-mail:</label><br> 
		<form:input type="email" path="mail" id="mail" placeholder="input e-mail here" required="true"/><br>
		<label for="phone">Phone:</label><br> 
		<form:input type="tel" path="phone" id="phone" placeholder="input phone here" required="true"/><br>
		<label for="address">Address:</label><br> 
		<form:input type="text" path="address" id="address" placeholder="input address here" required="true"/><br>		
		<input type="submit" value="Save user">
	</form:form><br>
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
			<td><a href="/admin/user/delete/${user.id}">delete</a></td>
			<td><a href="/admin/user/update/${user.id}">update</a></td>			
		</tr>			
	</c:forEach>	
	</table><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>	
</body>
</html>