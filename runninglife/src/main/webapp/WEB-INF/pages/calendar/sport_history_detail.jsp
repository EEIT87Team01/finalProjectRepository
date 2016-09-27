<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="r" uri="http://iii.runningLife.com/util" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="UTF-8">
    <title>運動紀錄</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
		<meta name="keywords" content="free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
		<meta name="author" content="FreeHTML5.co" />
  	<!-- Facebook and Twitter integration -->
		<meta property="og:title" content=""/>
		<meta property="og:image" content=""/>
		<meta property="og:url" content=""/>
		<meta property="og:site_name" content=""/>
		<meta property="og:description" content=""/>
		<meta name="twitter:title" content="" />
		<meta name="twitter:image" content="" />
		<meta name="twitter:url" content="" />
		<meta name="twitter:card" content="" />
		
		<style>
		
			.background-image {
				background-image: url('<%=request.getContextPath()%>/static/images/calendarDetailBG.jpg');
				background-repeat: no-repeat;
				background-attachment: fixed;
	        	background-position: center;
	        	background-size: cover;
			}

		</style>
	
		<link rel="shortcut icon" href="favicon.ico">
		
		<link href="https://fonts.googleapis.com/css?family=Raleway:200,300,400,700" rel="stylesheet">

		<!-- Animate.css -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/animate.css">
		<!-- Icomoon Icon Fonts-->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/icomoon.css">
		<!-- Bootstrap  -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.css">
		<!-- Flexslider  -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/flexslider.css">
		<!-- Owl Carousel  -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/owl.carousel.min.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/owl.theme.default.min.css">
		<!-- Theme style  -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/style.css">
		<!-- 	fullcalendar  -->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/fullcalendar.css">	
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
</head>
<body>
<div id="fh5co-page">
	<header id="fh5co-header" role="banner">
		<div class="container">
			<div class="header-inner">
				<h1><a href="../index.jsp">RunningLife</a></h1>
				<nav role="navigation">
					<ul>
						<li><a href="../postsController/posts.do">塗鴉牆</a></li>
						<li><a href="../challenge/page.do">挑戰</a></li>
						<li><a href="">賽事活動</a></li>
						<li class="active">><a href="../calendar.do">行事曆</a></li>
						<li><a href="contact.html">運動文章</a></li>
						<li><img src="data:image/png;base64,${r:byteToBase64(memberPhoto)}" style='width:50px;height:50px;'></li>
						<li>Hello, ${memberFirstName}</li>
						<li class="cta"><a href="../Login/Logout.do">Logout</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>
	<div class="container background-image" style="margin-top: 50px;">
	<h1>運動紀錄</h1>
		<div class="row">
			<table class="table">
				<tr>
					<td>開始時間:</td>
					<td>${startDateTime}</td>
				</tr>
				<tr>
					<td>結束時間:</td>
					<td>${endDateTime}</td>
				</tr>
				<tr>
					<td>持續時間:</td>
					<td>${duration}</td>
				</tr>
				<tr>
					<td>總距離:</td>
					<td>${length}</td>
				</tr>
				<tr>
					<td>平均速度:</td>
					<td>${avgSpeed}</td>
				</tr>
				<tr>
					<td>路線圖:</td>
					<td></td>
				</tr>
			</table>
		</div>
		<div id="map"></div>
	</div>
</div>
    <script>
		var map;
		function initMap() {
			var linePath = ${paths};
			var zoom = ${Zoom};
			var center = ${center};
			var map = new google.maps.Map(document.getElementById('map'),{
		    	zoom:zoom,
		    	center: center
			});
		  	
			var flightPath = new google.maps.Polyline({
				path:linePath,
				geodesic:true,
				strokeColor:"#FF0000",
				strokeOpacity:1.0,
				strokeWeight:4
			});
		    flightPath.setMap(map);
		}
    </script>
    
    	
	<!-- Modernizr JS -->
	<script src="<%=request.getContextPath()%>/static/js/modernizr-2.6.2.min.js"></script>
	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/static/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="<%=request.getContextPath()%>/static/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="<%=request.getContextPath()%>/static/js/jquery.waypoints.min.js"></script>
	<!-- Owl Carousel -->
	<script src="<%=request.getContextPath()%>/static/js/owl.carousel.min.js"></script>
	<!-- Flexslider -->
	<script src="<%=request.getContextPath()%>/static/js/jquery.flexslider-min.js"></script>
	<!-- 	Moment -->
	<script src="<%=request.getContextPath()%>/static/js/moment.min.js"></script>
	<!-- 	fullcalendar  -->
	<script src="<%=request.getContextPath()%>/static/js/fullcalendar.min.js"></script>
	<!-- 	jQuery-UI  -->
	<script src="<%=request.getContextPath()%>/static/js/jquery-ui-1.12.0.min.js"></script>
	<!-- MAIN JS -->
	<script src="<%=request.getContextPath()%>/static/js/jquery.flexslider-min.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/main.js"></script>

    
    <script src="<%=request.getContextPath()%>/static/js/jquery-3.1.0.min.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBCmOChQ6jjB4VB9Q1vptGEmkcAcNiJZuk&callback=initMap"
   		async defer></script>
</body>
</html>