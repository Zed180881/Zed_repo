<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<c:if test="${param.die eq 'true'}">
		<p class="text-danger lead">Неможливо видалити статус ордеру, так як з ним є звязані ордери!</p>
	</c:if>
	<div class="col-md-4">		
		<button class="btn btn-success" data-toggle="collapse" data-target="#addorderstatus">Додати статус ордера</button>
		<c:choose>
				<c:when test="${orderStatus.id eq 0}">
					<div class="collapse" id="addorderstatus">
				</c:when>
				<c:otherwise>
					<div class="collapse in" id="addorderstatus">
				</c:otherwise>
		</c:choose>
			<form:form action="/admin/ordstatus" method="post" modelAttribute="orderStatus">
				<form:errors path="orderStatusName"/>
				<form:input path="id" type="hidden"/>
				<div class="form-group">
					<label for="orderStatusName">Назва статусу ордера:</label>
					<form:input type="text" class="form-control" path="orderStatusName" id="orderStatusName" placeholder="назва статусу" required="true"/>
				</div>
				<input type="submit" class="btn btn-primary" value="Зберегти статус">
				<a class="btn btn-danger" href="/admin/ordstatus">Очистити форму</a>
			</form:form>
		</div>
	</div>
</div>	
<h3>Наявні статуси ордерів:</h3>
<div class="table-responsive">
	<table class="table table-hover">	
		<c:forEach items="${orderStatuses}" var="orderStatus">
			<tr>
				<td>${orderStatus.orderStatusName}</td>
				<td><a class="btn btn-danger" href="/admin/ordstatus/delete/${orderStatus.id}">видалити</a></td>
				<td><a class="btn btn-success" href="/admin/ordstatus/update/${orderStatus.id}">редагувати</a></td>
			</tr>
		</c:forEach>		
	</table>	
</div>
<div class="row">		
		<button class="btn btn-success" onclick="goBack()">Назад</button>
	</div>
<script>
	function goBack() {
	    window.history.back();
	}
</script>