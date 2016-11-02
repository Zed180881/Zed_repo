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
			<c:forEach items="${commodities.content}" var="commodity">			
				<div class="col-md-3">			    
					<img src="/images/commodity/${commodity.id}${commodity.path}?version=${commodity.version}" height="100" class="img-fluid" alt="${commodity.model}">		
					<h5>${commodity.category.categoryName}</h5>
				    <h4><strong><a href="/commodity/${commodity.id}">${commodity.producer.producerName}<br>${commodity.model}</a></strong></h4>
				  	<span class="left">${commodity.price} грн.</span>
				</div>
			</c:forEach>
		</div>		
		<ul class="pager">
			<c:if test="${commodities.number ne 0}">
	  			<li><a href="/categoryView/?page=${commodities.number}&size=${commodities.size}">Попередня</a></li>
	  		</c:if>
	  		<c:if test="${commodities.number ne commodities.totalPages-1}">
	  			<li><a href="/categoryView/?page=${commodities.number+2}&size=${commodities.size}">Наступна</a></li>
	  		</c:if>
		</ul>
		<button class="btn btn-success" onclick="goBack()">Назад</button>		
	</div>
	<div class="col-md-3">
		<button class="btn btn-success" data-toggle="collapse" data-target="#findcommodity">Шукати товар</button>
		<div class="collapse" id="findcommodity">		
			<c:if test="${filter ne null}">
				<h3>Пошук товарів:</h3>
				<form:form role="form" action="/categoryView" method="get" modelAttribute="filter" id="filterForm">							
					<div class="form-group">
						<label for="model">Назва товару</label>
						<form:input class="form-control input-lg" type="text" path="model" id="model" placeholder="назва"/>
					</div>
					<div class="form-group">
						<label for="categoryFilter">Категорія</label>	
						<form:select class="form-control" path="categoryId" id="categoryFilter">						
							<option value="0"> </option>
							<c:forEach items="${categories}" var="category">
								<option value="${category.id}">${category.categoryName}</option>	
							</c:forEach>			
						</form:select>
					</div>							
					<div class="form-group">
						<label for="producerId">Виробник</label>
							<form:select path="producerId" class="form-control" id="producerId">
								<option value="0"> </option>
								<c:forEach items="${producers}" var="producer">
									<option value="${producer.id}">${producer.producerName}</option>	
								</c:forEach>			
							</form:select>	
					</div>
					<div class="form-group">
						<label for="minPrice">Ціна</label>
						<form:input type="number" class="form-control" path="minPrice" id="minPrice" step="0.01"/>
						<p class="help-block">Мінімальна</p>
						<form:input type="number" class="form-control" path="maxPrice" step="0.01"/>
						<p class="help-block">Максимальна</p>
					</div>				
					<input class="btn btn-primary" type="submit" value="Фільтрувати">														
				</form:form>			
			</c:if>
		</div>
		<br>
		<br>		
		<a class="btn btn-primary" href="/categoryView/?page=1&size=12">Скинути фільтр</a>
		<br>
		<br>
		<p><b>Кількість товарів на сторінці</b></p>
		<a class="btn btn-info" href="/categoryView/?page=1&size=12">12</a>
		<a class="btn btn-info" href="/categoryView/?page=1&size=48">48</a><br>
	</div>
</div>	
	
<script>
	function goBack() {
	    window.history.back();
	}
</script>