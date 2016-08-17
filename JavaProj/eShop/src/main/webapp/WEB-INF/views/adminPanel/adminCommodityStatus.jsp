<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commodity Statuses Management</title>
</head>
<body>
	<h3>Add commodity status:</h3>
	<form:form action="/admin/comstatus" method="post" modelAttribute="commodityStatus">
		<form:errors path="commodityStatusName"/><br>
		<form:input path="id" type="hidden"/>
		<label for="commodityStatusName">Commodity status name:</label><br> 
		<form:input type="text" path="commodityStatusName" id="commodityStatusName" placeholder="input commodity status name here" required="true"/><br>
		<input type="submit" value="Save status">
	</form:form><br>
	<h3>Current commodity statuses:</h3>	
	<table>
		<c:forEach items="${commodityStatuses}" var="commodityStatus">
		<tr>
			<td>${commodityStatus.commodityStatusName}</td>
			<td><a href="/admin/comstatus/delete/${commodityStatus.id}">delete</a></td>
			<td><a href="/admin/comstatus/update/${commodityStatus.id}">update</a></td>
		</tr>
		</c:forEach>		
	</table><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>
</body>
</html>