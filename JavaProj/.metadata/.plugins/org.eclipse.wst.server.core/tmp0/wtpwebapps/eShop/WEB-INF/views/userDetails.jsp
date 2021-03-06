<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Дані користувача:</h3>
<div class="table-responsive">
		<table class="table table-hover">	
			<tr>
				<td>ПІБ</td>
				<td>${user.fullName}</td>
			</tr>
			<tr>				
				<td>Логін</td>
				<td>${user.login}</td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td>${user.mail}</td>
			</tr>
			<tr>
				<td>Телефон</td>
				<td>${user.phone}</td>
			</tr>
			<tr>
				<td>Адреса</td>
				<td>${user.address}</td>			
			</tr>
		</table>
		<a class="btn btn-success" href="/updateUserDetails">редагувати</a>
		<button class="btn btn-success" onclick="goBack()">Назад</button>
</div>	
		
<script>
	function goBack() {
	    window.history.back();
	}
</script>