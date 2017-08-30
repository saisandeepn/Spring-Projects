<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		
		<a href="admin">Click to Admin area</a>
		<form action="Logout" method="post">
		<input type="submit" value="logout">
		<input type="hidden" name= "${_csrf.parameterName}" value="${_csrf.token }">
		</form>
	</body>
</html>
