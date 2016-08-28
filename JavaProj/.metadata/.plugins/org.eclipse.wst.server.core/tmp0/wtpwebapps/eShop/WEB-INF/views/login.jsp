<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<form:form action="/login" method="post">
		<div class="col-md-12">
			<label for="username">Логін</label>
			<input name="username" id="username">
		</div>
		<div class="col-md-12">
			<label for="password">Пароль</label>
			<input name="password" id="password" type="password">
		</div>
		<div class="col-md-12">
			<input type="submit" value="Увійти">
		</div>
	</form:form>
</div>