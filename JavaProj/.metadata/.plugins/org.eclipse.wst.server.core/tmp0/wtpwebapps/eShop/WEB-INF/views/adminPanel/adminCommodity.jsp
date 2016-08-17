<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commodity Management</title>
</head>
<body>
	<h3>Add commodity:</h3>
	<form:form action="/admin/commodity" method="post" modelAttribute="commodity">
		<form:errors path="*"/><br>
		<form:input path="id" type="hidden"/>
		<label for="model">Model:</label><br> 
		<form:input type="text" path="model" id="model" placeholder="input model here" required="true"/><br>
		<label for="category">Category:</label><br> 
		<form:select path="category" id="category">
			<c:forEach items="${categories}" var="category">
				<c:choose>
					<c:when test="${commodity.category.id eq category.id}">
						<option value="${category.id}" selected="selected">${category.categoryName}</option>
					</c:when>
					<c:otherwise>
						<option value="${category.id}">${category.categoryName}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>			
		</form:select><br>
		<label for="producer">Producer:</label><br>
		<form:select path="producer" id="producer">
			<c:forEach items="${producers}" var="producer">
				<c:choose>
					<c:when test="${commodity.producer.id eq producer.id}">
						<option value="${producer.id}" selected="selected">${producer.producerName}</option>
					</c:when>
					<c:otherwise>
						<option value="${producer.id}">${producer.producerName}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</form:select><br>		
		<label for="quantity">Quantity:</label><br> 
		<form:input type="number" path="quantity" id="quantity" min="1" step="1" required="true"/><br>
		<label for="price">Price:</label><br> 
		<form:input type="number" path="price" id="price" min="0" step="0.01" required="true"/><br>
		<label for="commodityStatus">Commodity Status:</label><br>
		<form:select path="commodityStatus" id="commodityStatus">
			<c:forEach items="${commodityStatuses}" var="commodityStatus">
				<c:choose>
					<c:when test="${commodity.commodityStatus.id eq commodityStatus.id}">
						<option value="${commodityStatus.id}" selected="selected">${commodityStatus.commodityStatusName}</option>
					</c:when>
					<c:otherwise>
						<option value="${commodityStatus.id}">${commodityStatus.commodityStatusName}</option>
					</c:otherwise>
				</c:choose>			
			</c:forEach>
		</form:select><br>		
		<label for="warranty">Warranty (months):</label><br> 
		<form:input type="number" path="warranty" id="warranty" min="0" step="1" required="true"/><br>
		<input type="submit" value="Save commodity">
	</form:form><br>
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
			<th></th>
			<th></th>	
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
			<td><a href="/admin/commodity/delete/${commodity.id}">delete</a></td>
			<td><a href="/admin/commodity/update/${commodity.id}">update</a></td>
		</tr>			
	</c:forEach>	
	</table><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>	
</body>
</html>