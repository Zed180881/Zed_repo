<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<c:if test="${param.die eq 'true'}">
		<p class="text-danger lead">Неможливо видалити статус товару, так як з ним є звязані товари!</p>
	</c:if>
	<div class="col-md-4">
		<button class="btn btn-success" data-toggle="collapse" data-target="#addcommoditystatus">Додати статус товару</button>
		<c:choose>
				<c:when test="${commodityStatus.id eq 0}">
					<div class="collapse" id="addcommoditystatus">
				</c:when>
				<c:otherwise>
					<div class="collapse in" id="addcommoditystatus">
				</c:otherwise>
		</c:choose>		
			<form:form role="form" action="/admin/comstatus" method="post" modelAttribute="commodityStatus">
				<form:errors path="commodityStatusName"/>
				<form:input path="id" type="hidden"/>
				<div class="form-group">
					<label for="commodityStatusName">Назва статусу:</label>
					<form:input type="text" class="form-control" path="commodityStatusName" id="commodityStatusName" placeholder="назва статусу" required="true"/>
				</div>
				<input type="submit" class="btn btn-primary" value="Зберегти статус">
				<a class="btn btn-danger" href="/admin/comstatus">Очистити форму</a>
			</form:form>
		</div>
	</div>
</div>
<h3>Наявні статуси товарів:</h3>
<div class="table-responsive">
	<table class="table table-hover">	
		<c:forEach items="${commodityStatuses}" var="commodityStatus">
			<tr>
				<td>${commodityStatus.commodityStatusName}</td>
				<td><a class="btn btn-danger" href="/admin/comstatus/delete/${commodityStatus.id}">видалити</a></td>
				<td><a class="btn btn-success" href="/admin/comstatus/update/${commodityStatus.id}">редагувати</a></td>
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