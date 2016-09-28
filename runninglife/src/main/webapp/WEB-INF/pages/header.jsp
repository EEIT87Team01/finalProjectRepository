<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:200,300,400,700"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css_global/animate.css"/>">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="<c:url value="/resources/css_global/icomoon.css"/>">
<!-- Bootstrap  -->
<!-- 	<link rel="stylesheet" href="/runninglife/resources/css_global/bootstrap.css"> -->
<!-- Flexslider  -->
<link rel="stylesheet"
	href="<c:url value="/resources/css_global/flexslider.css"/>">
<!-- Owl Carousel  -->
<link rel="stylesheet"
	href="<c:url value="/resources/css_global/owl.carousel.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css_global/owl.theme.default.min.css"/>">
<!-- Theme style  -->
<link rel="stylesheet"
	href="<c:url value="/resources/css_global/style.css"/>">
</head>
<body>
	<header id="fh5co-header" role="banner">
	<div class="container">
		<div class="header-inner">
			<h1>
				<a href="index.jsp">RunningLife</a>
			</h1>
			<nav role="navigation">
			<ul>
				<li><a href="<c:url value="/postsController/posts.do"/>">塗鴉牆</a></li>
				<li><a href="<c:url value="/challenge/page.do"/>">挑戰</a></li>
				<li><a href="<c:url value="/contest"/>">賽事活動</a></li>
				<li><a href="<c:url value="/calendar.do"/>">行事曆</a></li>
				<li><a href="<c:url value="/article/page"/>">文章</a></li>
				<li class="cta"><a href="<c:url value="/logout"/>">登入</a></li>
			</ul>
			</nav>
		</div>
	</div>
	</header>
</body>
</html>