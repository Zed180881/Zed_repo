<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commodity Categories Management</title>
</head>
<body>
	<h3>Add category:</h3>
	<form action="/admin/category" method="post">
		<label for="name">Category name:</label><br>
		<input type="text" name="name" placeholder="input name here" required><br> 
		<input type="submit" value="Add category">
	</form><br>
	<h3>Current categories:</h3>
	<ul>
		<c:forEach items="${categories}" var="category">
			<li>${category.categoryName}</li>
		</c:forEach>
	</ul><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>
</body>
</html>