<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:200,300,400,700"
	rel="stylesheet">


</head>
<body>
	<%@ include file="header.jsp"%>


	<h3>
		<a href="<c:url value="/contest" />">賽事首頁</a>
	</h3>
	<h3>
		<a href="<c:url value="/email" />">註冊email</a>
	</h3>

	<img src="resources/01.jpg">
	<img src="resources/02.jpg">
	<%-- <img  src="<c:url value="/resources/01.jpg" />"> --%>
</body>
</html>