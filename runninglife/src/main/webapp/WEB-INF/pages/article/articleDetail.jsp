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
		<h1 class='title'></h1>
		<h4><span style="margin-right:5%" class="writerAccount"></span><span class="createTime"></span></h4>
		<hr>
	</div>
	<div class="container">
		<div style="text-align: center;">
	<!-- 	<img src="../images/article1.jpg" class="img-thumbnail img-responsive" alt="Responsive image" width="75%" height="75%">  -->
	    </div>
	    <br>
	    <span class="content"></span>
	<!-- 	<p style="font-size:150%;">不知道大家知不知道：「跑步的時候我們的雙腳承受的是自己體重約三倍的重量。」</p> -->
	<!--     <p style="font-size:150%;"> 這就是為什麼新進的菜鳥跑者常常跑步跑一跑就這裡一下膝蓋痛、一下腳踝痛的， -->
	<!--                      原因很簡單就是肌力不夠啊！所以針對像我一樣的新進跑者，大部分運動品牌都會 -->
	<!--                      建議穿著鞋底柔軟的避震型鞋款，利用鞋底的緩衝效果降低對雙腳的衝擊。</p> -->
	
	<!--     <p style="font-size:150%;">只是非常可惜的是避震性佳的慢跑鞋幾乎都有一個共通問題是：「重量較重，重的 -->
	<!--                      跑鞋穿久了對雙腳的負擔也比較大。」同樣的道理，如果說想要輕量化的鞋款，不可 -->
	<!--                      避免的就是一定會降低避震性，這就是標準的「有一好，沒兩好」。</p> -->
	
	<!--     <p style="font-size:150%;">Mizuno號稱他們要顛覆大家對跑鞋的認知：「誰說避震性佳的慢跑鞋一定要重翻天， -->
	<!--                     就是要避震性跟輕量化兩者兼備！」，因此首次在WAVE RIDER系列搭載「U4ic」 -->
	<!--                     輕量中底，讓「WAVE RIDER17」較前代了減重25g (265g，27CM) ，不只 -->
	<!--                     顧及肌力不足的新進跑者需要的避震性，更是WAVE RIDER史上最輕量的鞋款 (全馬 -->
	<!--                     完賽時間4小時以上者皆適用WAVE RIDER17。可參考MIZUNO官網：跑步鞋選購 -->
	<!--                     指南。)</p> -->
	
	<!--     <p style="font-size:150%;">Mizuno似乎對「WAVE RIDER17」非常的有自信，還在上市的初期在日本展開「1 -->
	<!--       000万人??挑????????」的活動，活動期間買了之後「不滿意全額退費」，也太有氣 -->
	<!--                   魄了吧！ (很可惜活動早已結束，而且也只有日本有) 。以上雖然全部都是廣告台詞，但是 -->
	<!--                   我必須承認這一連串的介紹真的是看得我蠢蠢欲動，迫不及待想要穿出門跑步體驗一下到底 -->
	<!--                   「WAVE RIDER17」是怎樣的跑鞋可以讓Mizuno有膽作出這麼豪氣的宣言。</p> -->
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