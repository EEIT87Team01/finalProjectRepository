<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://iii.runningLife.com/util" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:200,300,400,700"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet"
	href="<c:url value="/static/css/animate.css"/>">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet"
	href="<c:url value="/static/css/icomoon.css"/>">
<!-- Bootstrap  -->
<!-- 	<link rel="stylesheet" href="/runninglife/resources/css_global/bootstrap.css"> -->
<!-- Flexslider  -->
<link rel="stylesheet"
	href="<c:url value="/static/css/flexslider.css"/>">
<!-- Owl Carousel  -->
<link rel="stylesheet"
	href="<c:url value="/static/css/owl.carousel.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/static/css/owl.theme.default.min.css"/>">
<!-- Theme style  -->
<link rel="stylesheet"
	href="<c:url value="/static/css/style.css"/>">
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
						<c:choose>
						<c:when test="${!empty membersVO}">
						<li><a href="<%=request.getContextPath()%>/postsController/posts.do">塗鴉牆</a></li>
						<li><a href="<%=request.getContextPath()%>/challenge/page.do">挑戰</a></li>
						<li><a href="<%=request.getContextPath()%>/contest">賽事活動</a></li>
						<li><a href="<%=request.getContextPath()%>/calendar.do">行事曆</a></li>
						<li><a href="<%=request.getContextPath()%>/article/page">運動文章</a></li>
							<li><img src="data:image/png;base64,${r:byteToBase64(membersVO.photo)}" style='width:50px;height:50px;'></li>
							<li>你好, ${membersVO.lastName}</li>
							<li class="cta"><a href="<%=request.getContextPath()%>/Login/Logout.do">登出</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="<%=request.getContextPath()%>/contest">賽事活動</a></li>
							<li><a href="Login/CreateAccountPage.do">新增用戶，開始屬於你的RunningLife</a></li>
							<li> 或是 </li>
							<li class="cta" data-toggle="modal" data-target="#myModal"><a id="loginModalBtn" href="#">登入</a></li> <!-- 登入視窗按鈕 -->
						</c:otherwise>	
						</c:choose>
			</ul>
			</nav>
		</div>
	</div>
	</header>
</body>
</html>