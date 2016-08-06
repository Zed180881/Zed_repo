<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Commodity Order Management</title>
</head>
<body>
	<h3>Add commodity order:</h3>
	<form action="/admin/order" method="post">
		<label for="userName">User full name:</label><br> 
		<input type="text" name="userName" placeholder="input username here" required><br>
		<label for="orderStatusName">Order Status:</label><br> 
		<input type="text" name="orderStatusName" placeholder="input order status here" required><br>
		<label for="orderDate">Order Date:</label><br> 
		<input type="text" name="orderDate" placeholder="dd.mm.yyyy" required><br>
		<label for="payDate">Pay Date:</label><br> 
		<input type="text" name="payDate" placeholder="dd.mm.yyyy"><br>
		<label for="deliveryDate">Delivery Date:</label><br> 
		<input type="text" name="deliveryDate" placeholder="dd.mm.yyyy"><br>
		<label for="commodityModel1">Commodities List:</label><br> 
		<input type="text" name="commodityModel1" placeholder="input model here" required><br>
		<input type="text" name="commodityModel2" placeholder="input model here"><br>
		<input type="text" name="commodityModel3" placeholder="input model here"><br>
		<input type="text" name="commodityModel4" placeholder="input model here"><br>
		<input type="text" name="commodityModel5" placeholder="input model here"><br>
		<input type="submit" value="Add order">
	</form><br>
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
		</tr>			
	</c:forEach>	
	</table><br>
	<a href="/admin"><b><i>Back to administrator panel</i></b></a>	
</body>
</html>