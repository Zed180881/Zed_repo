<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commodity Producers Management</title>
</head>
<body>
	<h3>Add producer:</h3>
	<form:form action="/admin/producer" method="post" modelAttribute="producer">
		<form:errors path="producerName"/><br>
		<form:input path="id" type="hidden"/>
		<label for="producerName">Producer name:</label><br>
		<form:input type="text" path="producerName" id="producerName" placeholder="input name here" required="true"/><br>
		<input type="submit" value="Save producer">
	</form:form><br>
	<h3>Current producers:</h3>	
	<table>
		<c:forEach items="${producers}" var="producer">
		<tr>
			<td>${producer.producerName}</td>
			<td><a href="/admin/producer/delete/${producer.id}">delete</a></td>
			<td><a href="/admin/producer/update/${producer.id}">update</a></td>
		</tr>
		</c:forEach>		
	</table><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>
</body>
</html>