<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:choose>
	<c:when test="${cart eq null or cart.commodities.isEmpty()}">
		<p class="text-danger lead">Кошик поки що порожній</p><br>
	</c:when>
	<c:otherwise>
		<h3>Корзина товарів:</h3>
		<div class="table-responsive">
			<table class="table table-hover">	
				<tr>
					<th>Назва</th>
					<th>Категорія</th>
					<th>Виробник</th>				
					<th>Ціна</th>				
					<th>Гарантія</th>
					<th></th>
					<th></th>					
				</tr>
			<c:forEach items="${cart.commodities}" var="commodity">
				<tr>
					<td>${commodity.model}</td>
					<td>${commodity.category.categoryName}</td>
					<td>${commodity.producer.producerName}</td>				
					<td>${commodity.price}</td>				
					<td>${commodity.warranty}</td>
					<td><img src="/images/commodity/${commodity.id}${commodity.path}?version=${commodity.version}" height="100"/></td>
					<td><a class="btn btn-danger" href="/cart/commodity/delete/${commodity.id}">видалити</a></td>				
				</tr>			
			</c:forEach>				
			</table>
		</div>				
		<p class="text-success lead">Сума замовлення <fmt:formatNumber value="${cart.sum}" maxFractionDigits="2"/> грн.</p>
		<div class="row">	
			<a class="btn btn-success" href="/cart/submit">Підтвердити замовлення</a>
			<a class="btn btn-danger" href="/cart/delete">Очистити корзину</a><br>
		</div>
	</c:otherwise>
</c:choose>
<div class="row">
	<p>&nbsp;</p>
</div>
<div class="row">		
		<a class="btn btn-success" href="/">На головну</a>
	</div>
	