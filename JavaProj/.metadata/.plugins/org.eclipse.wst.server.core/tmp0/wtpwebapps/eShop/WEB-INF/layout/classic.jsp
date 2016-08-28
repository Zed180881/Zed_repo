<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="/resources/img/favicon.ico" rel="shortcut icon">
<!-- <link rel="stylesheet" href="/resources/css/main.css"/> -->
<link rel="stylesheet" 
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
crossorigin="anonymous">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	<!-- Основной контент сторінки -->
	<div class="container">
		<tiles:insertAttribute name="body" />
	</div>
	<div class="footer">
		<!-- футер сторінки -->
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>