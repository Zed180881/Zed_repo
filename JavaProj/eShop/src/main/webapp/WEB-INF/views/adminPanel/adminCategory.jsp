<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<div class="row">
		<c:if test="${param.die eq 'true'}">
			<p class="text-danger lead">Неможливо видалити категорію, так як з нею є звязані товари!</p>
		</c:if>
		<div class="col-md-6">
			<button class="btn btn-success" data-toggle="collapse" data-target="#addcategory">Додати категорію</button>			
			<c:choose>
				<c:when test="${category.id eq 0}">
					<div class="collapse" id="addcategory">
				</c:when>
				<c:otherwise>
					<div class="collapse in" id="addcategory">
				</c:otherwise>
			</c:choose>			
					<form:form role="form" action="/admin/category" method="post" modelAttribute="category" enctype="multipart/form-data">
						<form:errors path="categoryName"/>	
						<form:input path="id" type="hidden"/>
						<form:hidden path="version"/>
						<form:hidden path="path"/>
						<div class="form-group">
							<label for="categoryName">Назва категорії:</label>
							<form:input type="text" class="form-control" path="categoryName" id="categoryName" placeholder="назва категорії" required="true"/>
						</div>
						<div class="form-group">
							<label for="file">Зображення для категорії</label>
							<input class="form-control btn btn-warning" type="file" name="file" id="file">
						</div>			
						<input class="btn btn-primary" type="submit" value="Зберегти категорію">
						<a class="btn btn-danger" href="/admin/category?page=1&size=10">Очистити форму</a>
					</form:form>
				</div>
			
		</div>		
		<div class="col-md-6">
			<button class="btn btn-success" data-toggle="collapse" data-target="#filtrcategory">Фільтр категорій</button>
			<a class="btn btn-primary" href="/admin/category?page=1&size=10">Скинути фільтр</a>
			<div class="collapse" id="filtrcategory">			
				<c:if test="${filter ne null}">				
				<form:form role="form" action="/admin/category" method="get" modelAttribute="filter">		
					<div class="form-group">
						<label for="categoryFilter">Назва категорії:</label>					
						<form:input class="form-control" id="categoryFilter" path="categoryName"/>
					</div>
					<input class="btn btn-primary" type="submit" value="Фільтрувати">		
				</form:form>
				</c:if>
			</div>
		</div>
	</div>
	<h3>Наявні категорії:</h3>
	<div class="table-responsive">
		<table class="table table-hover">
			<c:forEach items="${categories.content}" var="category">
			<tr>
				<td class="text-success lead">${category.categoryName}</td>
				<td><img src="/images/category/${category.id}${category.path}?version=${category.version}" height="100"/></td>			
				<td><a class="btn btn-danger" href="/admin/category/delete/${category.id}">видалити</a></td>
				<td><a class="btn btn-success" href="/admin/category/update/${category.id}">редагувати</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	<ul class="pager">
		<c:if test="${categories.number ne 0}">
  			<li><a href="/admin/category?page=${categories.number}&size=${categories.size}">Попередня</a></li>
  		</c:if>
  		<c:if test="${categories.number ne categories.totalPages-1}">
  			<li><a href="/admin/category?page=${categories.number+2}&size=${categories.size}">Наступна</a></li>
  		</c:if>
	</ul>
			
	<a class="btn btn-success" href="/admin/category?page=1&size=10">10</a>
	<a class="btn btn-success" href="/admin/category?page=1&size=50">50</a>
	<button class="btn btn-success" onclick="goBack()">Назад</button>	
	
<script>
	function goBack() {
	    window.history.back();
	}
</script>