<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
$(function(){
	$("select[name=category]").chosen({width: "50%"});
	$("select[name=producer]").chosen({width: "50%"});
	$("select[name=commodityStatus]").chosen({width: "50%"});
	$("select[name=categoryId]").chosen({width: "50%"});
	$("select[name=producerId]").chosen({width: "50%"});
	$("select[name=commodityStatusId]").chosen({width: "50%"});
})
</script>

	<div class="row">
		<c:if test="${param.die eq 'true'}">
			<p class="text-danger lead">Неможливо видалити товар, так як з ним є звязані ордери!</p>
		</c:if>		
		<div class="col-md-6">
			<button class="btn btn-success" data-toggle="collapse" data-target="#addcommodity">Додати товар</button>
			<c:choose>
				<c:when test="${commodity.id eq 0}">
					<div class="collapse" id="addcommodity">
				</c:when>
				<c:otherwise>
					<div class="collapse in" id="addcommodity">
				</c:otherwise>
			</c:choose>					
				<form:form role="form" action="/admin/commodity" method="post" modelAttribute="commodity" enctype="multipart/form-data">
					<form:errors path="*"/>
					<form:input path="id" type="hidden"/>
					<form:hidden path="version"/>
					<form:hidden path="path"/>
					<div class="form-group">
						<label for="model">Назва товару:</label>
						<form:input class="form-control" type="text" path="model" id="model" placeholder="назва" required="true"/>
					</div>
					<div class="form-group">
						<label for="description">Опис товару:</label>
						<form:textarea class="form-control" path="description" id="description" placeholder="опис товару" rows="10" required="true"/>
					</div>
					<div class="form-group">
						<label for="file">Зображення товару</label>
						<input class="form-control btn btn-warning" type="file" name="file" id="file">
					</div>
					<div class="form-group">
						<label for="category">Категорія:</label> 
						<form:select class="form-control" path="category" id="category">
							<c:forEach items="${categories}" var="category">
								<c:choose>
									<c:when test="${commodity.category.id eq category.id}">
										<option value="${category.id}" selected="selected">${category.categoryName}</option>
									</c:when>
									<c:otherwise>
										<option value="${category.id}">${category.categoryName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>			
						</form:select>
					</div>
					<div class="form-group">
						<label for="producer">Виробник:</label>
						<form:select class="form-control" path="producer" id="producer">
							<c:forEach items="${producers}" var="producer">
								<c:choose>
									<c:when test="${commodity.producer.id eq producer.id}">
										<option value="${producer.id}" selected="selected">${producer.producerName}</option>
									</c:when>
									<c:otherwise>
										<option value="${producer.id}">${producer.producerName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</form:select>
					</div>
					<div class="form-group">		
						<label for="quantity">Кількість:</label> 
						<form:input class="form-control" type="number" path="quantity" id="quantity" min="1" step="1" required="true"/>
					</div>
					<div class="form-group">
						<label for="price">Ціна:</label> 
						<form:input class="form-control" type="number" path="price" id="price" min="0.01" step="0.01" required="true"/>
					</div>
					<div class="form-group">
						<label for="commodityStatus">Статус товару:</label>
						<form:select class="form-control" path="commodityStatus" id="commodityStatus">
							<c:forEach items="${commodityStatuses}" var="commodityStatus">
								<c:choose>
									<c:when test="${commodity.commodityStatus.id eq commodityStatus.id}">
										<option value="${commodityStatus.id}" selected="selected">${commodityStatus.commodityStatusName}</option>
									</c:when>
									<c:otherwise>
										<option value="${commodityStatus.id}">${commodityStatus.commodityStatusName}</option>
									</c:otherwise>
								</c:choose>			
							</c:forEach>
						</form:select>
					</div>
					<div class="form-group">		
						<label for="warranty">Гарантія (місяці):</label> 
						<form:input class="form-control" type="number" path="warranty" id="warranty" min="0" step="1" required="true"/>
					</div>
					<input class="btn btn-primary" type="submit" value="Зберегти товар">
					<a class="btn btn-danger" href="/admin/commodity?page=1&size=10">Очистити форму</a>
				</form:form>
			</div>
		</div>		
		<div class="col-md-6">
			<button class="btn btn-success" data-toggle="collapse" data-target="#filtrcommodity">Фільтр товарів</button>
			<a class="btn btn-primary" href="/admin/commodity?page=1&size=10">Скинути фільтр</a>
			<div class="collapse" id="filtrcommodity">		
				<c:if test="${filter ne null}">				
					<form:form role="form" action="/admin/commodity" method="get" modelAttribute="filter">				
						<div class="form-group">
							<label for="modelFilter">Назва товару</label>
							<form:input class="form-control" type="text" path="model" id="modelFilter" placeholder="назва"/>
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
							<label for="producerFilter">Виробник</label>	
							<form:select class="form-control" path="producerId" id="producerFilter">
								<option value="0"> </option>
								<c:forEach items="${producers}" var="producer">
									<option value="${producer.id}">${producer.producerName}</option>	
								</c:forEach>			
							</form:select>
						</div>
						<div class="form-group">
							<label for="statusFilter">Статус</label>					
							<form:select class="form-control" path="commodityStatusId" id="statusFilter">
								<option value="0"> </option>
								<c:forEach items="${commodityStatuses}" var="commodityStatus">
									<option value="${commodityStatus.id}">${commodityStatus.commodityStatusName}</option>	
								</c:forEach>			
							</form:select>
						</div>
						<div class="form-group">
							<label for="minQuantity">Кількість</label>
							<form:input class="form-control" type="number" path="minQuantity" id="minQuantity" step="1"/>
							<p class="help-block">Мінімальна</p>
							<form:input class="form-control" type="number" path="maxQuantity" step="1"/>
							<p class="help-block">Максимальна</p>
						</div>
						<div class="form-group">
							<label for="minPrice">Ціна</label>
							<form:input type="number" class="form-control" path="minPrice" id="minPrice" step="0.01"/>
							<p class="help-block">Мінімальна</p>
							<form:input type="number" class="form-control" path="maxPrice" step="0.01"/>
							<p class="help-block">Максимальна</p>
						</div>
						<div class="form-group">
							<label for="minWarranty">Гарантія</label>
							<form:input type="number" class="form-control" path="minWarranty" id="minWarranty" step="1"/>
							<p class="help-block">Мінімальна</p>
							<form:input type="number" class="form-control" path="maxWarranty" step="1"/>
							<p class="help-block">Максимальна</p>
						</div>						
						<input type="submit" class="btn btn-primary" value="Фільтрувати">										
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
	<h3>Наявні товари:</h3>
	<div class="table-responsive">
		<table class="table table-hover">	
			<tr>
				<th>Назва</th>
				<th>Категорія</th>
				<th>Виробник</th>
				<th>Кількість</th>
				<th>Ціна</th>
				<th>Статус</th>
				<th>Гарантія</th>
				<th></th>
				<th></th>
				<th></th>	
			</tr>
		<c:forEach items="${commodities.content}" var="commodity">
			<tr>
				<td>${commodity.model}</td>
				<td>${commodity.category.categoryName}</td>
				<td>${commodity.producer.producerName}</td>
				<td>${commodity.quantity}</td>
				<td>${commodity.price}</td>
				<td>${commodity.commodityStatus.commodityStatusName}</td>
				<td>${commodity.warranty}</td>
				<td><img src="/images/commodity/${commodity.id}${commodity.path}?version=${commodity.version}" height="100"/></td>
				<td><a class="btn btn-danger" href="/admin/commodity/delete/${commodity.id}">видалити</a></td>
				<td><a class="btn btn-success" href="/admin/commodity/update/${commodity.id}">редагувати</a></td>
			</tr>			
		</c:forEach>				
		</table>
	</div>
	<ul class="pager">
		<c:if test="${commodities.number ne 0}">
  			<li><a href="/admin/commodity?page=${commodities.number}&size=${commodities.size}">Попередня</a></li>
  		</c:if>
  		<c:if test="${commodities.number ne commodities.totalPages -1}">
  			<li><a href="/admin/commodity?page=${commodities.number+2}&size=${commodities.size}">Наступна</a></li>
  		</c:if>
	</ul>	
	<a class="btn btn-success" href="/admin/commodity?page=1&size=10">10</a>
	<a class="btn btn-success" href="/admin/commodity?page=1&size=50">50</a>
	<button class="btn btn-success" onclick="goBack()">Назад</button>

<script>
	function goBack() {
	    window.history.back();
	}
</script>