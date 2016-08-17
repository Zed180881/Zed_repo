<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Statuses Management</title>
</head>
<body>
	<h3>Add order status:</h3>
	<form:form action="/admin/ordstatus" method="post" modelAttribute="orderStatus">
		<form:errors path="orderStatusName"/><br>
		<form:input path="id" type="hidden"/>
		<label for="orderStatusName">Order status name:</label><br> 
		<form:input type="text" path="orderStatusName" id="orderStatusName" placeholder="input order status name here" required="true"/><br>
		<input type="submit" value="Save status">
	</form:form><br>
	<h3>Current order statuses:</h3>	
	<table>
		<c:forEach items="${orderStatuses}" var="orderStatus">
		<tr>
			<td>${orderStatus.orderStatusName}</td>
			<td><a href="/admin/ordstatus/delete/${orderStatus.id}">delete</a></td>
			<td><a href="/admin/ordstatus/update/${orderStatus.id}">update</a></td>
		</tr>
		</c:forEach>		
	</table><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>
</body>
</html>