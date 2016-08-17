<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commodity Categories Management</title>
</head>
<body>
	<h3>Add category:</h3>
	<form:form action="/admin/category" method="post" modelAttribute="category">
		<form:errors path="categoryName"/><br>
		<form:input path="id" type="hidden"/>
		<label for="categoryName">Category name:</label><br>
		<form:input type="text" path="categoryName" id="categoryName" placeholder="input category name here" required="true"/><br> 
		<input type="submit" value="Save category">
	</form:form><br>
	<h3>Current categories:</h3>
	<table>
		<c:forEach items="${categories}" var="category">
		<tr>
			<td>${category.categoryName}</td>
			<td><a href="/admin/category/delete/${category.id}">delete</a></td>
			<td><a href="/admin/category/update/${category.id}">update</a></td>
		</tr>
		</c:forEach>		
	</table><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>
</body>
</html>