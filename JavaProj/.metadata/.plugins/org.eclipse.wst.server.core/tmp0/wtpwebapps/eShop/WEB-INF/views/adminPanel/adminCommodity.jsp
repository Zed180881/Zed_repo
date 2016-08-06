<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commodity Management</title>
</head>
<body>
	<h3>Add commodity:</h3>
	<form action="/admin/commodity" method="post">
		<label for="model">Model:</label><br> 
		<input type="text" name="model" placeholder="input model here" required><br>
		<label for="categoryName">Category:</label><br> 
		<input type="text" name="categoryName" placeholder="input category here" required><br>
		<label for="producerName">Producer:</label><br> 
		<input type="text" name="producerName" placeholder="input producer here" required><br>
		<label for="quantity">Quantity:</label><br> 
		<input type="number" name="quantity" min="1" step="1" required><br>
		<label for="price">Price:</label><br> 
		<input type="number" name="price" min="0" step="0.01" required><br>
		<label for="statusName">Commodity Status:</label><br> 
		<input type="text" name="statusName" placeholder="input status here" required><br>
		<label for="warranty">Warranty (months):</label><br> 
		<input type="number" name="warranty" min="0" step="1" required><br>
		<input type="submit" value="Add commodity">
	</form><br>
	<h3>Current commodities:</h3>
	<table>
		<tr>
			<th>Model</th>
			<th>Category</th>
			<th>Producer</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Status</th>
			<th>Warranty</th>	
		</tr>
	<c:forEach items="${commodities}" var="commodity">
		<tr>
			<td>${commodity.model}</td>
			<td>${commodity.category.categoryName}</td>
			<td>${commodity.producer.producerName}</td>
			<td>${commodity.quantity}</td>
			<td>${commodity.price}</td>
			<td>${commodity.commodityStatus.commodityStatusName}</td>
			<td>${commodity.warranty}</td>
		</tr>			
	</c:forEach>	
	</table><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>	
</body>
</html>