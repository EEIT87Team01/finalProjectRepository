<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="r" uri="http://iii.runningLife.com/util" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>行事曆</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
		<meta name="keywords" content="free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
		<meta name="author" content="FreeHTML5.co" />
		
	  <!-- 
		//////////////////////////////////////////////////////
	
		FREE HTML5 TEMPLATE 
		DESIGNED & DEVELOPED by FreeHTML5.co
			
		Website: 		http://freehtml5.co/
		Email: 			info@freehtml5.co
		Twitter: 		http://twitter.com/fh5co
		Facebook: 		https://www.facebook.com/fh5co
	
		//////////////////////////////////////////////////////
		 -->

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
			background-image: url('<%=request.getContextPath()%>/static/images/calendarBG.jpg');
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
		<script src="<%=request.getContextPath()%>/static/js/main.js"></script>

	</head>
	<body>
		<div id="fh5co-page">
			<header id="fh5co-header" role="banner">
				<div class="container">
					<div class="header-inner">
						<h1><a href="<%=request.getContextPath() %>/index.jsp">RunningLife</a></h1>
						<nav role="navigation">
							<ul>
								<li><a href="<%=request.getContextPath()%>/postsController/posts.do">塗鴉牆</a></li>
								<li><a href="<%=request.getContextPath()%>/challenge/page.do">挑戰</a></li>
								<li><a href="<%=request.getContextPath()%>/contest.do">賽事活動</a></li>
								<li class="active">><a href="<%=request.getContextPath()%>/calendar.do">行事曆</a></li>
								<li><a href="<%=request.getContextPath()%>/article/page.do">文章</a></li>
								<li><img src="data:image/png;base64,${r:byteToBase64(memberVO.photo)}" style='width:50px;height:50px;'></li>
								<li>Hello, ${memberVO.firstName}</li>
								<li class="cta"><a href="<%=request.getContextPath()%>/Login/Logout.do">登出</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</header>
			
			<div style="height:20px"></div>
			<div class="container">
<!-- 				<div class="col-md-1"></div> -->
				<div class="col-md-12 background-image" id='calendar'></div>
<!-- 				<div class="col-md-1"></div> -->
			</div>
			<div style="height:20px"></div>
			
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
		
		<script>
			$(document).ready(function() {
				$('#calendar').fullCalendar({ 
					header: {//設定Header
			            left: 'title', 
			            center: '', 
			            right: 'today agendaWeek,month prev,next' 
			        }, 
			        height: '1000px',
			        theme: false,
			        firstDay:0,//第一天為星期日 
			        editable: false,//是否可拖動 
			        defaultView: 'month',
	 		        eventSources: '<%=request.getContextPath()%>/calendar/get_calendar_json_data.do?memberID=${memberVO.memberID}'    //事件数据	         
			    }) 
			});	  
		</script> 
	
	</body>

</html>

