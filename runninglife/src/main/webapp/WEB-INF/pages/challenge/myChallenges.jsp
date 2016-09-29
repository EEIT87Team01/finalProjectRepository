<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://iii.runningLife.com/util" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RunningLife - 我的挑戰</title>
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
<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

<link href="https://fonts.googleapis.com/css?family=Raleway:200,300,400,700" rel="stylesheet">
<!-- Animate.css -->
	<link rel="stylesheet" href="../static/css/web/animate.css">
<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="../static/css/web/icomoon.css">
<!-- Bootstrap  -->
	<link rel="stylesheet" href="../static/css/web/bootstrap.css">
<!-- Flexslider  -->
	<link rel="stylesheet" href="../static/css/web/flexslider.css">
<!-- Owl Carousel  -->
	<link rel="stylesheet" href="../static/css/web/owl.carousel.min.css">
	<link rel="stylesheet" href="../static/css/web/owl.theme.default.min.css">
<!-- Theme style  -->
	<link rel="stylesheet" href="../static/css/web/style.css">
<!-- Modernizr JS -->
	<script src="../static/js/web/modernizr-2.6.2.min.js"></script>
<!-- jQuery -->
	<script src="../static/js/web/jquery.min.js"></script>
<!-- jQuery Easing -->
	<script src="../static/js/web/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
	<script src="../static/js/web/bootstrap.min.js"></script>
<!-- Waypoints -->
	<script src="../static/js/web/jquery.waypoints.min.js"></script>
<!-- Owl Carousel -->
	<script src="../static/js/web/owl.carousel.min.js"></script>
<!-- Flexslider -->
	<script src="../static/js/web/jquery.flexslider-min.js"></script>
<!-- MAIN JS -->
	<script src="../static/js/web/main.js"></script>	
<script>

$(document).on("click",".back",function(){

    history.back();
})
</script>
</head>
<body>
<div id="fh5co-page">
		<%@ include file="/WEB-INF/pages/header.jsp"%>
		<div class="container" style='margin-top: 50px;'>
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
		  <li role="presentation" class="active"><a href="#foundedChallengeList" aria-controls="foundedChallengeList" role="tab" data-toggle="tab">我建立的</a></li>
		  <li role="presentation"><a href="#ingChallengeList" aria-controls="ingChallengeList" role="tab" data-toggle="tab">進行中的</a></li>
		  <li role="presentation"><a href="#finishChallengeList" aria-controls="finishChallengeList" role="tab" data-toggle="tab">已結束的</a></li>
		  <li role="presentation"><a href="#reservedChallengeList" aria-controls="reservedChallengeList" role="tab" data-toggle="tab">預定的</a></li>
		  <li role="presentation"><a href="#receivedRequestChallengeList" aria-controls="receivedRequestChallengeList" role="tab" data-toggle="tab">收到邀請的</a></li>
		</ul>
		<a href="<%=request.getContextPath()%>/challenge/createChallPage.do" class='btn btn-warning' style="float: right; margin-top:20px;" >新增挑戰</a>
		<div class="tab-content">
		<!-- 我建立的挑戰區塊  #foundedChallengeList-->
		<div role="tabpanel" class="tab-pane active" id="foundedChallengeList">
        
		<c:forEach var="challenge" items="${foundedChallengeList}">
		<div class="container">
			<div class="row">
				<div class="list">
			    	<div class="challColumn">	
						<h2>${challenge.challenName}</h2>
						<hr style="border:1px solid blue;">
						<h4>${challenge.founderID.firstName}, ${challenge.founderID.lastName}</h4>
						<h4>${challenge.comment}</h4>
						<h4>${challenge.locationID}</h4>
						<h4>${challenge.challenStartTime} - ${challenge.challenEndTime}</h4>
						<h4>${challenge.challenDistance}公里<p align="right"><a href="detail/${challenge.challenID}.do" class="btn btn-success" >詳細</a></p></h4>
					</div>
				</div>
			</div>
		</div>
		</c:forEach>
		</div>
		
		<!-- 進行中的挑戰區塊  #ingChallengeList-->
		<div role="tabpanel" class="tab-pane" id="ingChallengeList">

		<c:forEach var="challenData" items="${ingChallengeList}">
		<c:set var="challenge" value="${challenData.challDataPK.challenID}"/>
		<div class="container">
		<div class="row">
		<div class="list">
		<div class="challColumn">	    
			<h2>${challenge.challenName}<span class="day" style="float:right;">${r:day(challenge.challenEndTime)} 天後結束</span></h2>
			<hr style="border:1px solid blue;">
			<h4>${challenge.founderID.firstName}, ${challenge.founderID.lastName}</h4>
			<h4>${challenge.comment}</h4>
			<h4>${challenge.challenStartTime} - ${challenge.challenEndTime}</h4>
			<h4>${challenge.challenDistance}公里 <a href="detail/${challenge.challenID}.do" class="btn btn-info" style="float:right;">詳細</a></h4>
		</div>
		</div>
		</div>
		</div>
		</c:forEach>
		</div>

		
		<!-- 已結束的挑戰區塊  #finishChallengeList-->
		<div role="tabpanel" class="tab-pane" id = "finishChallengeList">
		
		<c:forEach var="challenData" items="${finishChallengeList}">
		<c:set var="challenge" value="${challenData.challDataPK.challenID}"/>
		<div class="container">
			<div class="row">
				<div class="list">
			    	<div class="challColumn">	
						<h2>${challenge.challenName}</h2>
						<hr style="border:1px solid blue;">
						<h4>${challenge.founderID.firstName}, ${challenge.founderID.lastName}</h4>
						<h4>${challenge.comment}</h4>
						<h4>${challenge.locationID}</h4>
						<h4>${challenge.challenStartTime} - ${challenge.challenEndTime}</h4>
						<h4>${challenge.challenDistance}公里<a href="detail/${challenge.challenID}.do" class="btn btn-success"  style="float:right;">詳細</a></h4>
					</div>
				</div>
			</div>

		</div>
		</c:forEach>
		</div>
		
		<!-- 預定的挑戰區塊  #reservedChallengeList-->
		<div role="tabpanel" class="tab-pane" id = "reservedChallengeList">
		
		<c:forEach var="challenData" items="${reservedChallengeList}">
		<c:set var="challenge" value="${challenData.challDataPK.challenID}"/>
		<div class="container">
			<div class="row">
				<div class="list">
			    	<div class="challColumn">	
						<h2>${challenge.challenName}<span style="float:right;">${r:day(challenge.challenStartTime)}天後開始</span></h2>
						<hr style="border:1px solid blue;">
						<h4>${challenge.founderID.firstName}, ${challenge.founderID.lastName}</h4>
						<h4>${challenge.comment}</h4>
						<h4>${challenge.locationID}</h4>
						<h4>${challenge.challenStartTime} - ${challenge.challenEndTime}</h4>
						<h4>${challenge.challenDistance}公里<a href="detail/${challenge.challenID}.do" class="btn btn-success"  style="float:right;">詳細</a></h4>
					</div>
				</div>
			</div>

		</div>
		</c:forEach>
		</div>
		
		<!-- 收到邀請的挑戰區塊  #receivedRequestChallengeList-->
		<div role="tabpanel" class="tab-pane" id = "receivedRequestChallengeList">
		
		<c:forEach var="challenData" items="${receivedRequestChallengeList}">
		<c:set var="challenge" value="${challenData.challDataPK.challenID}"/>
		<div class="container">
			<div class="row">
				<div class="list">
			    	<div class="challColumn">	
						<h2>${challenge.challenName}</h2>
						<hr style="border:1px solid blue;">
						<h4>${challenge.founderID.firstName}, ${challenge.founderID.lastName}</h4>
						<h4>${challenge.comment}</h4>
						<h4>${challenge.locationID}</h4>
						<h4>${challenge.challenStartTime} - ${challenge.challenEndTime}</h4>
						<h4>${challenge.challenDistance}公里<a href="detail/${challenge.challenID}.do" class="btn btn-success"  style="float:right;">詳細</a></h4>
					</div>
				</div>
			</div>

		</div>
		</c:forEach>
		</div>
		
		
		</div>
		</div>




		<footer id="fh5co-footer" role="contentinfo">

			<div class="container">
				<div class="col-md-3 col-sm-12 col-sm-push-0 col-xs-12 col-xs-push-0">
					<h3>About Us</h3>
					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
					<p><a href="#" class="btn btn-primary btn-outline with-arrow btn-sm">Join Us <i class="icon-arrow-right"></i></a></p>
				</div>
				<div class="col-md-6 col-md-push-1 col-sm-12 col-sm-push-0 col-xs-12 col-xs-push-0">
					<h3>Our Services</h3>
					<ul class="float">
						<li><a href="#">Web Design</a></li>
						<li><a href="#">Branding &amp; Identity</a></li>
						<li><a href="#">Free HTML5</a></li>
						<li><a href="#">HandCrafted Templates</a></li>
					</ul>
					<ul class="float">
						<li><a href="#">Free Bootstrap Template</a></li>
						<li><a href="#">Free HTML5 Template</a></li>
						<li><a href="#">Free HTML5 &amp; CSS3 Template</a></li>
						<li><a href="#">HandCrafted Templates</a></li>
					</ul>

				</div>

				<div class="col-md-2 col-md-push-1 col-sm-12 col-sm-push-0 col-xs-12 col-xs-push-0">
					<h3>Follow Us</h3>
					<ul class="fh5co-social">
						<li><a href="#"><i class="icon-twitter"></i></a></li>
						<li><a href="#"><i class="icon-facebook"></i></a></li>
						<li><a href="#"><i class="icon-google-plus"></i></a></li>
						<li><a href="#"><i class="icon-instagram"></i></a></li>
					</ul>
				</div>


				<div class="col-md-12 fh5co-copyright text-center">
					<p>&copy; 2016 Free HTML5 template. All Rights Reserved. <span>Designed with <i class="icon-heart"></i> by <a href="http://freehtml5.co/" target="_blank">FreeHTML5.co</a> Demo Images by <a href="http://unsplash.com/" target="_blank">Unsplash</a></span></p>	
				</div>

			</div>
		</footer>
	</div>
</body>
</html>