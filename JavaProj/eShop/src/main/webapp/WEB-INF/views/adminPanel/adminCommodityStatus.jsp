<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<h3>Додати статус товару:</h3>
	<form:form action="/admin/comstatus" method="post" modelAttribute="commodityStatus">
		<form:errors path="commodityStatusName"/><br>
		<form:input path="id" type="hidden"/>
		<label for="commodityStatusName">Назва статусу:</label><br> 
		<form:input type="text" path="commodityStatusName" id="commodityStatusName" placeholder="назва статусу" required="true"/><br>
		<input type="submit" value="Зберегти статус">
	</form:form><br>
	
	<h3>Наявні статуси товарів:</h3>	
	<table>
		<c:forEach items="${commodityStatuses}" var="commodityStatus">
		<tr>
			<td>${commodityStatus.commodityStatusName}</td>
			<td><a href="/admin/comstatus/delete/${commodityStatus.id}">&nbsp;&nbsp;видалити</a></td>
			<td><a href="/admin/comstatus/update/${commodityStatus.id}">&nbsp;&nbsp;редагувати</a></td>
		</tr>
		</c:forEach>
	</table><br>	
	<a href="/admin"><b><i>До панелі керування</i></b></a>