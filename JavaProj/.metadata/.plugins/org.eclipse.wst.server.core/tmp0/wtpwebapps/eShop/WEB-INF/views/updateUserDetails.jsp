<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Оновлення даних користувача:</h3>
<div class="col-md-6">
	<form:form role="form" action="/updateUserDetails" method="post" modelAttribute="user">
			<form:errors path="*"/>
			<form:hidden path="id"/>	
			<form:hidden path="role"/>
			<div class="form-group">
				<label for="fullName">Прізвище та ім'я:</label>
				<form:input type="text" class="form-control" path="fullName" id="fullName" placeholder="ПІБ" required="true"/>
			</div>
			<div class="form-group">
				<label for="login">Логін:</label>
				<form:input type="text" class="form-control" path="login" id="login" placeholder="логін" required="true"/>
			</div>
			<div class="form-group">
				<label for="password">Пароль:</label>
				<form:input type="text" class="form-control" path="password" id="password" placeholder="пароль" required="true"/>
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
			<input type="submit" class="btn btn-primary" value="Зберегти">
			<button class="btn btn-success" onclick="goBack()">Назад</button>
	</form:form>
</div>

<script>
	function goBack() {
	    window.history.back();
	}
</script>