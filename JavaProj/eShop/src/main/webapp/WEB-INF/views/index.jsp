<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
$(function(){	
	$("select[name=categoryId]").chosen({width: "100%"});
	$("select[name=producerId]").chosen({width: "100%"});	
})
</script>

<div class="row">	
	<div class="col-md-9">
		<div class="row">
			<c:forEach items="${categories.content}" var="category">			
				<div class="col-md-4">			    
					<img src="/images/category/${category.id}${category.path}?version=${category.version}" height="100" class="img-fluid" alt="${category.categoryName}">
				    <h4><strong><a href="/categoryView/${category.id}">${category.categoryName}</a></strong></h4>				  	
				</div>
			</c:forEach>
		</div>
		<ul class="pager">
			<c:if test="${categories.number ne 0}">
	  			<li><a href="/?page=${categories.number}&size=${categories.size}">Попередня</a></li>
	  		</c:if>
	  		<c:if test="${categories.number ne categories.totalPages-1}">
	  			<li><a href="/?page=${categories.number+2}&size=${categories.size}">Наступна</a></li>
	  		</c:if>
		</ul>		
	</div>
	<div class="col-md-3">
		<button class="btn btn-success" data-toggle="collapse" data-target="#findcategory">Пошук категорій</button>
		<div class="collapse" id="findcategory">
			<c:if test="${filter ne null}">				
				<form:form role="form" action="/" method="get" modelAttribute="filter">		
					<div class="form-group">
						<label for="categoryFilter">Назва категорії:</label>					
						<form:input class="form-control" id="categoryFilter" path="categoryName"/>
					</div>
					<input class="btn btn-primary" type="submit" value="Шукати">							
				</form:form>
			</c:if>
		</div>
		<br>
		<br>
		<a class="btn btn-primary" href="/?page=1&size=12">Скинути фільтр</a>
		<br>
		<br>
		<p><b>Кількість категорій на сторінці</b></p>
		<a class="btn btn-info" href="/?page=1&size=12">12</a>
		<a class="btn btn-info" href="/?page=1&size=48">48</a><br>		
	</div>
</div>

<c:if test="${param.fail eq true}">
	<p>Помилка авторизації</p>
</c:if>


<!-- <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8" useBodyEncodingGorURI="true"/> -->