<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h1>Привіт</h1>

<h3>Реєстрація нового користувача:</h3>
<form:form action="/admin/user" method="post" modelAttribute="user">
		<form:errors path="*"/><br>		
		<form:input path="role" type="hidden" value="1"/>
		<label for="fullName">Введіть Ваше прізвище та ім'я:</label><br> 
		<form:input type="text" path="fullName" id="fullName" placeholder="ПІБ" required="true"/><br>
		<label for="login">Введіть логін:</label><br> 
		<form:input type="text" path="login" id="login" placeholder="логін" required="true"/><br>
		<label for="password">Введіть пароль:</label><br> 
		<form:input type="text" path="password" id="password" placeholder="пароль" required="true"/><br>		
		<label for="mail">E-mail:</label><br> 
		<form:input type="email" path="mail" id="mail" placeholder="e-mail" required="true"/><br>
		<label for="phone">Телефон:</label><br> 
		<form:input type="tel" path="phone" id="phone" placeholder="телефон" required="true"/><br>
		<label for="address">Адреса:</label><br> 
		<form:input type="text" path="address" id="address" placeholder="адреса" required="true"/><br>		
		<input type="submit" value="Зареєструватися">
</form:form>

<c:if test="${param.fail eq true}">
	<p>Помилка авторизації</p>
</c:if>

<!-- <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8" useBodyEncodingGorURI="true"/> -->