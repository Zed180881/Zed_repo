<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commodity Order Management</title>
</head>
<body>
	<h3>Add commodity order:</h3>
	<form:form action="/admin/order" method="post" modelAttribute="commodityOrder">
		<form:errors path="*"/><br>
		<form:input path="id" type="hidden"/>
		<label for="user">User:</label><br>
		<form:select path="user" id="user">
			<c:forEach items="${users}" var="user">
				<c:choose>
					<c:when test="${commodityOrder.user.id eq user.id}">
						<option value="${user.id}" selected="selected">${user.fullName}</option>
					</c:when>
					<c:otherwise>
						<option value="${user.id}">${user.fullName}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</form:select><br>		
		<label for="orderStatus">Order Status:</label><br>
		<form:select path="orderStatus" id="orderStatus">
			<c:forEach items="${orderStatuses}" var="orderStatus">
				<c:choose>
					<c:when test="${commodityOrder.orderStatus.id eq orderStatus.id}">
						<option value="${orderStatus.id}" selected="selected">${orderStatus.orderStatusName}</option>
					</c:when>
					<c:otherwise>
						<option value="${orderStatus.id}">${orderStatus.orderStatusName}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</form:select><br>
		<label for="orderDate">Order Date:</label><br> 
		<form:input type="date" path="orderDate" id="orderDate" placeholder="YYYY-MM-DD" required="true"/><br>
		<label for="payDate">Pay Date:</label><br> 
		<form:input type="date" path="payDate" id="payDate" placeholder="YYYY-MM-DD"/><br>
		<label for="deliveryDate">Delivery Date:</label><br> 
		<form:input type="date" path="deliveryDate" id="deliveryDate" placeholder="YYYY-MM-DD"/><br>		
		<c:choose>
					<c:when test="${commodityOrder.id eq 0}">
						<h3>Choose commodities to add to order:</h3><br>
						<select name="commodities">			
							<c:forEach items="${commodities}" var="commodity">
								<option value="${commodity.id}">${commodity.model}</option>
							</c:forEach>
						</select><br>
						<select name="commodities">			
							<c:forEach items="${commodities}" var="commodity">
								<option value="${commodity.id}">${commodity.model}</option>
							</c:forEach>
						</select><br>
						<select name="commodities">			
							<c:forEach items="${commodities}" var="commodity">
								<option value="${commodity.id}">${commodity.model}</option>
							</c:forEach>
						</select><br>							
					</c:when>
					<c:otherwise>
						<h3>Current order commodities:</h3>
						<table>
							<tr>
								<th>Model</th><th>Category</th><th>Producer</th><th>Price</th><th>Warranty</th><th></th>
							</tr>							
								<c:forEach items="${commodityOrder.commodities}" var="commodity">
									<tr>
									<td>${commodity.model}</td>
									<td>${commodity.category.categoryName}</td>
									<td>${commodity.producer.producerName}</td>									
									<td>${commodity.price}</td>									
									<td>${commodity.warranty}</td>
									<td><a href="/admin/order/delete/${commodityOrder.id}/${commodity.id}">delete</a></td>			
									</tr>
								</c:forEach>							
							<tr>
								<td>Order sum</td><td></td><td></td><td>${commodityOrder.sum}</td>
							</tr>
						</table>
					</c:otherwise>
		</c:choose>		
		<input type="submit" value="Save order">
	</form:form><br>
	<h3>Current orders:</h3>
	<table>
		<tr>
			<th>User name</th>
			<th>Order Status</th>
			<th>Order Sum</th>
			<th>Order Date</th>
			<th>Pay Date</th>
			<th>Delivery Date</th>
			<th>Commodities</th>				
		</tr>
	<c:forEach items="${commodityOrders}" var="order">
		<tr>
			<td>${order.user.fullName}</td>
			<td>${order.orderStatus.orderStatusName}</td>
			<td>${order.sum}</td>
			<td>${order.orderDate}</td>
			<td>${order.payDate}</td>
			<td>${order.deliveryDate}</td>
			<td>
				<ul>
					<c:forEach items="${order.commodities}" var="commodity">
						<li>${commodity.model}</li>
					</c:forEach>
				</ul>
			</td>
			<td><a href="/admin/order/delete/${order.id}">delete</a></td>
			<td><a href="/admin/order/update/${order.id}">update</a></td>			
		</tr>			
	</c:forEach>	
	</table><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>	
</body>
</html>