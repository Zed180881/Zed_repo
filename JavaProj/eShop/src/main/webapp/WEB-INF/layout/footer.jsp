<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	
	<br>
	<p>(С) 2016 Зельонка Петро</p>
	<p>zed180881@gmail.com</p>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a class="btn btn-success" href="/admin">Панель керування</a>
	</sec:authorize>