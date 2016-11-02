<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-md-4">
		<form:form role="form" action="/login" method="post">
			<div class="form-group">
				<label for="username">Логін</label>
				<input class="form-control" name="username" id="username">
			</div>
			<div class="form-group">
				<label for="password">Пароль</label>
				<input class="form-control" name="password" id="password" type="password">
			</div>
			<div class="form-group">
				<input type="checkbox" name="remember-me" checked="checked"> Запам'ятати мене
			</div>			
			<input type="submit" class="btn btn-primary" value="Увійти">
			<button class="btn btn-success" onclick="goBack()">Назад</button>			
		</form:form>
	</div>
</div>

<script>
	function goBack() {
	    window.history.back();
	}
</script>