<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<c:if test="${param.die eq 'true'}">
		<p class="text-danger lead">Неможливо видалити користувача, так як з ним є звязані ордери!</p>
	</c:if>		
		<div class="col-md-6">
			<button class="btn btn-success" data-toggle="collapse" data-target="#adduser">Додати користувача</button>
			<c:choose>
				<c:when test="${user.id eq 0}">
					<div class="collapse" id="adduser">
				</c:when>
				<c:otherwise>
					<div class="collapse in" id="adduser">
				</c:otherwise>
		</c:choose>			
				<form:form role="form" action="/admin/user" method="post" modelAttribute="user">
					<form:errors path="*"/>
					<form:input path="id" type="hidden"/>
					<div class="form-group">
						<label for="fullName">ПІБ користувача:</label>
						<form:input type="text" class="form-control" path="fullName" id="fullName" placeholder="ПІБ" required="true"/>
					</div>
					<div class="form-group">
						<label for="login">Логін користувача:</label> 
						<form:input type="text" class="form-control" path="login" id="login" placeholder="логін" required="true"/>
					</div>
					<div class="form-group">
						<label for="password">Пароль користувача:</label> 
						<form:input type="text" class="form-control" path="password" id="password" placeholder="пароль" required="true"/>
					</div>
					<div class="form-group">
					<label for="role">Роль користувача:</label> 
						<form:select path="role" class="form-control" id="role">
							<c:forEach items="${roles}" var="role">
								<c:choose>
									<c:when test="${user.role eq role}">
										<option value="${role}" selected="selected">${role}</option>
									</c:when>
									<c:otherwise>
										<option value="${role}">${role}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>			
						</form:select>
					</div>
					<div class="form-group">
						<label for="mail">E-mail:</label> 
						<form:input type="email" class="form-control" path="mail" id="mail" placeholder="e-mail" required="true"/>
					</div>
					<div class="form-group">
						<label for="phone">Телефон:</label> 
						<form:input type="tel" class="form-control" path="phone" id="phone" placeholder="телефон" required="true"/>
					</div>
					<div class="form-group">
						<label for="address">Адреса:</label> 
						<form:input type="text" class="form-control" path="address" id="address" placeholder="адреса" required="true"/>
					</div>		
					<input type="submit" class="btn btn-primary" value="Зберегти користувача">
					<a class="btn btn-danger" href="/admin/user?page=1&size=10">Очистити форму</a>
				</form:form>
			</div>
		</div>
		<div class="col-md-6">
			<button class="btn btn-success" data-toggle="collapse" data-target="#filtruser">Фільтр користувачів</button>
			<a class="btn btn-primary" href="/admin/user?page=1&size=10">Скинути фільтр</a>
			<div class="collapse" id="filtruser">
				<c:if test="${filter ne null}">
				<form:form role="form" action="/admin/user" method="get" modelAttribute="filter">					
					<div class="form-group">
						<label for="fullNameFilter">ПІБ користувача:</label>
						<form:input class="form-control" path="fullName" id="fullNameFilter"/>
					</div>
					<div class="form-group">
						<label for="mailFilter">E-mail:</label>
						<form:input class="form-control" path="mail" id="mailFilter"/>
					</div>
					<div class="form-group">
						<label for="phoneFilter">Телефон:</label>
						<form:input class="form-control" id="phoneFilter" path="phone"/>
					</div>
					<div class="form-group">
						<label for="addressFilter">Адреса:</label>
						<form:input class="form-control" id="addressFilter" path="address"/>
					</div>						
					<input type="submit" class="btn btn-primary" value="Фільтрувати">					
				</form:form>
				</c:if>
			</div>
		</div>
</div>
<h3>Наявні користувачі:</h3>
<div class="table-responsive">
		<table class="table table-hover">	
			<tr>
				<th>ПІБ</th>
				<th>Логін</th>
				<th>Роль</th>
				<th>E-mail</th>
				<th>Телефон</th>
				<th>Адреса</th>
				<th></th>
				<th></th>				
			</tr>
			<c:forEach items="${users.content}" var="user">
				<tr>
					<td>${user.fullName}</td>
					<td>${user.login}</td>
					<td>${user.role}</td>
					<td>${user.mail}</td>
					<td>${user.phone}</td>
					<td>${user.address}</td>
					<td><a class="btn btn-danger" href="/admin/user/delete/${user.id}">видалити</a></td>
					<td><a class="btn btn-success" href="/admin/user/update/${user.id}">редагувати</a></td>			
				</tr>			
			</c:forEach>				
		</table>
</div>
	<ul class="pager">
		<c:if test="${users.number ne 0}">
  			<li><a href="/admin/user?page=${users.number}&size=${users.size}">Попередня</a></li>
  		</c:if>
  		<c:if test="${users.number ne users.totalPages-1}">
  			<li><a href="/admin/user?page=${users.number+2}&size=${users.size}">Наступна</a></li>
  		</c:if>
	</ul>	
	<a class="btn btn-success" href="/admin/user?page=1&size=10">10</a>
	<a class="btn btn-success" href="/admin/user?page=1&size=50">50</a>
	<button class="btn btn-success" onclick="goBack()">Назад</button>
	
<script>
	function goBack() {
	    window.history.back();
	}
</script>