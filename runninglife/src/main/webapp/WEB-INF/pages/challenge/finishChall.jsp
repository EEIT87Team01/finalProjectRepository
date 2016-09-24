<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flew &mdash; Free HTML5 Bootstrap Website Template by FreeHTML5.co</title>
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
	<link rel="stylesheet" href="../css/web/animate.css">
<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="../css/web/icomoon.css">
<!-- Bootstrap  -->
	<link rel="stylesheet" href="../css/web/bootstrap.css">
<!-- Flexslider  -->
	<link rel="stylesheet" href="../css/web/flexslider.css">
<!-- Owl Carousel  -->
	<link rel="stylesheet" href="../css/web/owl.carousel.min.css">
	<link rel="stylesheet" href="../css/web/owl.theme.default.min.css">
<!-- Theme style  -->
	<link rel="stylesheet" href="../css/web/style.css">
<!-- Modernizr JS -->
	<script src="../js/web/modernizr-2.6.2.min.js"></script>
<!-- jQuery -->
	<script src="../js/web/jquery.min.js"></script>
<!-- jQuery Easing -->
	<script src="../js/web/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
	<script src="../js/web/bootstrap.min.js"></script>
<!-- Waypoints -->
	<script src="../js/web/jquery.waypoints.min.js"></script>
<!-- Owl Carousel -->
	<script src="../js/web/owl.carousel.min.js"></script>
<!-- Flexslider -->
	<script src="../js/web/jquery.flexslider-min.js"></script>
<!-- MAIN JS -->
	<script src="../js/web/main.js"></script>	
<script>

$(document).on("click",".back",function(){

    history.back();
})
</script>
</head>
<body>
<div id="fh5co-page">
		<header id="fh5co-header" role="banner">
			<div class="container">
				<div class="header-inner">
					<h1><a href="index.html">Flew</a></h1>
					<nav role="navigation">
						<ul>
							<li><a href="work.html">Work</a></li>
							<li><a href="services.html">Services</a></li>
							<li><a href="pricing.html">Pricing</a></li>
							<li><a href="about.html">About</a></li>
							<li><a href="contact.html">Contact</a></li>
							<li class="cta"><a href="#">Get started</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>

		<div class="container">
            <h1>已結束的挑戰</h1>
		</div>
		
		<c:forEach var="challenData" items="${challengeDataList}">
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
						<h4>${challenge.challenDistance}公里<p align="right"><a href="finishChallDetail/${challenge.challenID}.do" class="btn btn-success" >挑戰結果</a></p></h4>
					</div>
				</div>
			</div>

		</div>
		</c:forEach>

		<div class="fh5co-cta" style="background-image: url(../images/slide_2.jpg);">
			<div class="overlay"></div>
			<div class="container">
				<div class="col-md-12 text-center animate-box">
					<h3>We Try To Update The Site Everyday</h3>
					<p><a href="#" class="btn btn-primary btn-outline with-arrow">Get started now! <i class="icon-arrow-right"></i></a></p>
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