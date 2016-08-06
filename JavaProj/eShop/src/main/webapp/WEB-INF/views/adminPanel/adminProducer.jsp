<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commodity Producers Management</title>
</head>
<body>
	<h3>Add producer:</h3>
	<form action="/admin/producer" method="post">
		<label for="name">Producer name:</label><br>
		<input type="text" name="name" placeholder="input name here" required><br>
		<input type="submit" value="Add producer">
	</form><br>
	<h3>Current producers:</h3>
	<ul>
		<c:forEach items="${producers}" var="producer">
			<li>${producer.producerName}</li>
		</c:forEach>
	</ul><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>
</body>
</html>