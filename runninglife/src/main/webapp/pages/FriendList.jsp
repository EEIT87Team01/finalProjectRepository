<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
	<link rel="stylesheet" href="/runninglife/static/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="/runninglife/static/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="/runninglife/static/css/bootstrap.css">
	<!-- Flexslider  -->
	<link rel="stylesheet" href="/runninglife/static/css/flexslider.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="/runninglife/static/css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- jQuery -->
	<script src="/runninglife/static/js/jquery-3.1.0.min.js"></script>
	<!-- jQuery Easing -->
	<script src="/runninglife/static/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="/runninglife/static/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="/runninglife/static/js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="/runninglife/static/js/jquery.flexslider-min.js"></script>
	<!-- Stellar -->
	<script src="/runninglife/static/js/jquery.stellar.min.js"></script>
	<!-- MAIN JS -->
	<script src="/runninglife/static/js/main.js"></script>


	</head>
	<body>
	
	<!-- Modal 登入視窗-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="position: absolute; top: 30%;">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Login</h4>
	      </div>
	      <form action="../member/login.do" method="post">
	      <div class="modal-body" style="text-align: center;">
	      <label for="account">帳號</label>
		        <input type="text" name="account" id="account" placeholder="account"><br>
		  <label for="password">密碼</label>
		        <input type="password" name="password" id="password" placeholder="password">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
	        <button type="submit" class="btn btn-primary">登入</button>
	      </div>
	      </form>
	    </div>
	  </div>
	</div>
	<script type="text/javascript">
	$(function(){
		$('#myModal').on('shown.bs.modal', function () {
			  $('#account').focus()
		})
	})
	</script>
	
	<!-- Modal end-->
	
	
	<div id="fh5co-page">
	<header id="fh5co-header" role="banner">
		<div class="container">
			<div class="header-inner">
				<h1><a href="index.html">RunningLife</a></h1>
				<nav role="navigation">
					<ul>
						<li class="active"><a href="work.html">Work</a></li>
						<li><a href="services.html">Services</a></li>
						<li><a href="pricing.html">Pricing</a></li>
						<li><a href="about.html">About</a></li>
						<li><a href="contact.html">Contact</a></li>
						<!-- 判斷是否已登入 -->
						<c:choose>
						<c:when test="${member != null}">
							<li>Hello, ${member.firstName}</li>
							<li class="cta"><a href="../member/logout.do">Logout</a></li>
						</c:when>
						<c:otherwise>
							<li class="cta" data-toggle="modal" data-target="#myModal"><a href="#">Login</a></li> <!-- 登入視窗按鈕 -->
						</c:otherwise>	
						</c:choose>
					</ul>
				</nav>
			</div>
		</div>
	</header>
	<div class="col-md-12 label" id="bannermenu">
	<ul class="list-inline">
		<li>塗鴉牆</li>
		<li><a href="/runninglife/friend/listFriend.do">朋友名單</a></li>
		<li><a href="/runninglife/friend/listFriendRequest.do">接受邀請</a></li>
		<li><a href="/runninglife/friend/sendRequest.do">邀請好友</a></li>
	</ul>
	</div>
	
	<div class="col-md-2 col-md-offset-2">
		<ul class="list-unstyled">
		<c:if test="${member != null}">
		  <li>${member.firstName}, ${member.lastName}</li>
		  <li>${sessionScope.member.firstName}, ${sessionScope.member.lastName}</li>
		</c:if>
		</ul>
	</div>
	
	<div class="col-md-6">
	<c:if test="${friends != null}">
		<table  class="table" id="receivedList" style="width: 300px">
		<tr><th>FirstName</th><th>LastName</th><th></th></tr>
		<c:forEach var="friend" items="${friends}">
			<tr><td>${friend.friendRelationshipPK.friendID.firstName}</td>
				<td>${friend.friendRelationshipPK.friendID.lastName}</td>
				<td>
				<button class="btn btn-danger" id="${friend.friendRelationshipPK.friendID.memberID}">刪除</button>
			</tr>
		</c:forEach>
		</table>
	</c:if>
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
	<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			var deletefriend = $(this).attr("id");
			var btn = $(this);
			$.ajax({
				type: "post", 
				datatype: "json",
				data : { "friendID" : deletefriend },
				url: "/runninglife/friend/deletefriend.do",
				success: function(){
					$(btn).parents("tr").remove();
				}
			});
		});
	});
	</script>
	
	
	
	</body>
</html>

