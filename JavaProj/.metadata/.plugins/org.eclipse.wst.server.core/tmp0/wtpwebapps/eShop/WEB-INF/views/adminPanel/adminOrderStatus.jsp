<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<h3>Додати статус ордера:</h3>
	<form:form action="/admin/ordstatus" method="post" modelAttribute="orderStatus">
		<form:errors path="orderStatusName"/><br>
		<form:input path="id" type="hidden"/>
		<label for="orderStatusName">Назва статусу ордера:</label><br> 
		<form:input type="text" path="orderStatusName" id="orderStatusName" placeholder="назва статусу" required="true"/><br>
		<input type="submit" value="Зберегти статус">
	</form:form><br>	
	<h3>Наявні статуси ордерів:</h3>	
	<table>
		<c:forEach items="${orderStatuses}" var="orderStatus">
		<tr>
			<td>${orderStatus.orderStatusName}</td>
			<td><a href="/admin/ordstatus/delete/${orderStatus.id}">&nbsp;&nbsp;видалити</a></td>
			<td><a href="/admin/ordstatus/update/${orderStatus.id}">&nbsp;&nbsp;редагувати</a></td>
		</tr>
		</c:forEach>		
	</table><br>	
	<a href="/admin"><b><i>До панелі керування</i></b></a>