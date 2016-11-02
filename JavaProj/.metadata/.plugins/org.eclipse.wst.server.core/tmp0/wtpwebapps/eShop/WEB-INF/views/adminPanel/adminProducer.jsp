<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<c:if test="${param.die eq 'true'}">
		<p class="text-danger lead">Неможливо видалити виробника товару, так як з ним є звязані товари!</p>
	</c:if>
	<div class="col-md-6">
		<button class="btn btn-success" data-toggle="collapse" data-target="#addproducer">Додати виробника</button>
		<c:choose>
				<c:when test="${producer.id eq 0}">
					<div class="collapse" id="addproducer">
				</c:when>
				<c:otherwise>
					<div class="collapse in" id="addproducer">
				</c:otherwise>
		</c:choose>		
			<form:form role="form" action="/admin/producer" method="post" modelAttribute="producer" enctype="multipart/form-data">
				<form:errors path="producerName"/><br>
				<form:input path="id" type="hidden"/>
				<form:hidden path="version"/>
				<form:hidden path="path"/>
				<div class="form-group">
					<label for="producerName">Назва виробника:</label>
					<form:input type="text" class="form-control" path="producerName" id="producerName" placeholder="назва виробника" required="true"/>
				</div>
				<div class="form-group">
					<label for="file">Вибрати лого виробника:</label>
					<input type="file" class="form-control btn btn-warning" name="file" id="file">
				</div>
				<input type="submit" class="btn btn-primary" value="Зберегти виробника">
				<a class="btn btn-danger" href="/admin/producer?page=1&size=10">Очистити форму</a>
			</form:form>
		</div>
	</div>
	<div class="col-md-6">
		<button class="btn btn-success" data-toggle="collapse" data-target="#filtrproducer">Фільтр виробників</button>
		<a class="btn btn-primary" href="/admin/producer?page=1&size=10">Скинути фільтр</a>
		<div class="collapse" id="filtrproducer">
			<c:if test="${filter ne null}">
			<form:form role="form" action="/admin/producer" method="get" modelAttribute="filter">
				<div class="form-group">
					<label for="producerFilter">Назва категорії:</label>
					<form:input class="form-control" path="producerName" id="producerFilter"/>
				</div>
				<input type="submit" class="btn btn-primary" value="Фільтрувати">				
			</form:form>
			</c:if>
		</div>
	</div>
</div>
<h3>Наявні виробники:</h3>
<div class="table-responsive">
	<table class="table table-hover">	
		<c:forEach items="${producers.content}" var="producer">
			<tr>
				<td>${producer.producerName}</td>
				<td><img src="/images/producer/${producer.id}${producer.path}?version=${producer.version}" height="100" width="100"/></td>
				<td><a class="btn btn-danger" href="/admin/producer/delete/${producer.id}">видалити</a></td>
				<td><a class="btn btn-success" href="/admin/producer/update/${producer.id}">редагувати</a></td>
			</tr>
		</c:forEach>			
	</table>
</div>
	<ul class="pager">
		<c:if test="${producers.number ne 0}">
  			<li><a href="/admin/producer?page=${producers.number}&size=${producers.size}">Попередня</a></li>
  		</c:if>
  		<c:if test="${producers.number ne producers.totalPages-1}">
  			<li><a href="/admin/producer?page=${producers.number+2}&size=${producers.size}">Наступна</a></li>
  		</c:if>
	</ul>
	
	<a class="btn btn-success" href="/admin/producer?page=1&size=10">10</a>
	<a class="btn btn-success" href="/admin/producer?page=1&size=50">50</a>
	<button class="btn btn-success" onclick="goBack()">Назад</button>

<script>
	function goBack() {
	    window.history.back();
	}
</script>
