<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Running Life</title>
<!-- ico	 -->
	<link rel="icon" type="image/png" href="/runninglife/static/images/icon.png">
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

</style>	
	
<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

<link href="https://fonts.googleapis.com/css?family=Raleway:200,300,400,700" rel="stylesheet">
<!-- Animate.css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/animate.css">
<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/icomoon.css">
<!-- Bootstrap  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/bootstrap.css">
<!-- Flexslider  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/flexslider.css">
<!-- Owl Carousel  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/owl.carousel.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/owl.theme.default.min.css">
<!-- Theme style  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/style.css">
<!-- Modernizr JS -->
	<script src="<%=request.getContextPath()%>/static/js/web/modernizr-2.6.2.min.js"></script>
<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/static/js/web/jquery.min.js"></script>
<!-- jQuery Easing -->
	<script src="<%=request.getContextPath()%>/static/js/web/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
	<script src="<%=request.getContextPath()%>/static/js/web/bootstrap.min.js"></script>
<!-- Waypoints -->
	<script src="<%=request.getContextPath()%>/static/js/web/jquery.waypoints.min.js"></script>
<!-- Owl Carousel -->
	<script src="<%=request.getContextPath()%>/static/js/web/owl.carousel.min.js"></script>
<!-- Flexslider -->
	<script src="<%=request.getContextPath()%>/static/js/web/jquery.flexslider-min.js"></script>
<!-- MAIN JS -->
	<script src="<%=request.getContextPath()%>/static/js/web/main.js"></script>	
<script type="text/javascript">
$(document).ready(function(){
	var dataId = location.search ;
    var getSearch = dataId.split("?articleid=");
    var articleID = getSearch[1];
    searchArticleDetail(articleID);
});

function searchArticleDetail(articleID) {
	var articleDetail = ajax('GET', {'articleID':articleID}, '../searchArticle.do', 'json', false);
	console.log(articleDetail.content);
	$('.writerAccount').text(articleDetail.writerAccount);
	$('.content').html(articleDetail.content);
	$('.title').text(articleDetail.title);
	$('.createTime').text(articleDetail.createTime);
	
}
function ajax(Method, Data, Url, Datetype, Async) {
	var result;
	$.ajax({
		type : Method,
		data : Data,
		url : Url,
		dataType : Datetype,
		async : Async,
		success : function(response) {

			result = response;
		}
	});
	return result;
}
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
				<h1><a href="index.html">RunningLife</a></h1>
				<nav role="navigation">
					<ul>
						<li><a href="work.html">塗鴉牆</a></li>
						<li><a href="challenge.jsp">挑戰</a></li>
						<li><a href="pricing.html">賽事活動</a></li>
						<li><a href="about.html">行事曆</a></li>
						<li><a href="contact.html">文章</a></li>
						<li class="cta"><a href="#">登入</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>
	
	<div class="container" style="margin-bottom: 10%;">
		
	</div>
	<div class="container">
		<h1 class='title'>${article.title}</h1>
		<h4><span style="margin-right:5%" class="writerAccount">${article.writerAccount.name}</span><span class="createTime">${article.createTime}</span></h4>
		<hr>
	</div>
	<div class="container">
		<div style="text-align: center;">
	<!-- 	<img src="../images/article1.jpg" class="img-thumbnail img-responsive" alt="Responsive image" width="75%" height="75%">  -->
	<img src="<%=request.getContextPath() %>/photoController/getPhoto.do?photoID=${article.photoPath}" style="width:40%" />
	    </div>
	    <br>
	    <span class="content">${content}</span>
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