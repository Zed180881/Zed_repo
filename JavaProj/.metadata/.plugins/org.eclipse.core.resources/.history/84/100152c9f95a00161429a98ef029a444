<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commodity Statuses Management</title>
</head>
<body>
	<h3>Add commodity status:</h3>
	<form action="/admin/comstatus" method="post">
		<label for="name">Commodity status name:</label><br> 
		<input type="text" name="name" placeholder="input name here" required><br>
		<input type="submit" value="Add status">
	</form><br>
	<h3>Current commodity statuses:</h3>
	<ul>
		<c:forEach items="${commodityStatuses}" var="commodityStatus">
			<li>${commodityStatus.commodityStatusName}</li>
		</c:forEach>
	</ul><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>
</body>
</html>