<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap-theme.min.css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/mainStyle.css"></link>
<script src="<%=request.getContextPath()%>/static/js/jquery-3.1.0.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>


	
	<!-- Animate.css -->
	<style type="text/css">@import url("<c:url value="/static/css/animate.css" />");</style>
	<!-- Icomoon Icon Fonts-->
	<style type="text/css">@import url("<c:url value="/static/css/icomoon.css" />");</style>
	<!-- Flexslider  -->
	<style type="text/css">@import url("<c:url value="/static/css/flexslider.css" />");</style>
	<!-- Theme style  -->
	<style type="text/css">@import url("<c:url value="/static/css/style.css" />");</style>
	<!-- Modernizr JS -->
	<script type="text/javascript" src="<c:url value="<%=request.getContextPath()%>/static/js/modernizr-2.6.2.min.js" />"></script>
	
<title>Running Life</title>
<!-- ico	 -->
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/static/images/icon.png">
	
<style type="text/css">
ol, ul {
    margin-top: 0;
    margin-bottom: 10px;
}
</style>
</head>


<!-- 彈出式窗 -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" id="myModal" role="dialog" aria-labelledby="mySmallModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="gridSystemModalLabel">登入</h4>
      </div>
      
      <!-- 	get || post -->
	  <!-- /Login/DBCheck -->
      <form action="<%=request.getContextPath()%>/Login/DBCheck.do" method="post">
      	<div style="padding-left:50px;">
			<table >
				<thead>
					<tr>
						<th>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="cols-sm-6">
						<label class="control-label">帳號:</label>
						<input type="text" id="account" class="form-control" name="memberAccount" value="${param.memberAccount}">
						</td>
					</tr>
					<tr>
						<td>
						<label class="control-label">密碼:</label>
						<input type="text" class="form-control" id="password" name="password" value="${param.password}">
						</td>
					</tr>

					<tr>
						<td>
							<a href="<%=request.getContextPath()%>/Login/ChangeForgetPage.do">忘記密碼?</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="<%=request.getContextPath()%>/Login/CreateAccountPage.do">新增用戶</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="modal-footer">
			<button type="button" id="loginBtn" class="btn btn-primary">登入</button>
			<button type="submit" id="loginBtn1" class="btn btn-primary hidden"></button>
		    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		</div>
      </form>
    </div>
  </div>
</div>
	
<script type="text/javascript">
$(function(){
	console.log('${membersVO.memberID}');
	$('#myModal').on('shown.bs.modal', function () {
		  $('#account').focus();
	})
	searchads();
	$(function() {
		// ---------------------------------------------------------------------------
		// login.jsp
		// ---------------------------------------------------------------------------
		$('#loginBtn').click(function(){
			var account = $('#account').val();
			var password = $('#password').val();
			var myUrl = '<%=request.getContextPath()%>/Login/LoginCheck.do';
			var type = 'post';
			var dataType = 'json';
			var data = { "memberAccount" : account , "password" : password };
			var response = ajaxFunction(myUrl,type,data,dataType);
			console.log(response);
			for ( var i in response) {
				switch(response[i]){
					case "WrongPassword":
						$('#gridSystemModalLabel').text('密碼錯誤');
						break;
					case "NotExistAccount":
						$('#gridSystemModalLabel').text('查無此帳號');
						break;
					case "LoginFail":
						$('#gridSystemModalLabel').text('登入失敗');
						break;
					case "LoginOK":
						$('#loginBtn1').click();
						break;
				}
			}
		});
	});
	//ajax
	function ajaxFunction(url,type,data,dataType){
		var result;
		$.ajax({
			url : url,
			type : type,
			dataType : dataType,
			data : data,
			async : false,
			success : function(response){
				result = response;
			},
			error : function(response) {
				console.log("error");
			}
		});
			return result;
	}
})

function searchads() {
	var adsData = ajax('GET', null, '<%=request.getContextPath()%>/ads/searchDisplayAds.do', 'json', false);
	console.log(adsData);
	for ( var i in adsData) {
		if(i==0){
			$('.slides').find('.adName').text(adsData[i].adName);
			$('.slides').find('a').attr('href',adsData[i].link);
			$('.slides').find('.adli').attr('style',"background-image: url(<c:url value='photoController/getPhoto.do?photoID="+adsData[i].image+"'/>);");
		}else{
			var adsli=$($('.slides').find('.adli').clone()).clone();
			$(adsli).find('.adName').text(adsData[i].adName);
			$(adsli).find('a').attr('href',adsData[i].link);
			$(adsli).attr('style',"background-image: url(<c:url value='photoController/getPhoto.do?photoID="+adsData[i].image+"'/>);");
			$(adsli).removeClass().addClass('adShow');
			$('.slides').append(adsli);
		}
	}
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
</script>
<!-- Modal end-->


<body>
	
	
	<div id="fh5co-page">
	<header id="fh5co-header" role="banner">
		<div class="container">
			<div class="header-inner">
				<h1><a href="index.html">RunningLife</a></h1>
				<nav role="navigation">
					<ul>
						<li><a href="friend/page.do">塗鴉牆</a></li>
						<li><a href="challenge/.do">挑戰</a></li>
						<li><a href="">賽事活動</a></li>
						<li><a href="about.html">行事曆</a></li>
						<li><a href="contact.html">運動文章</a></li>
						<!-- 判斷是否已登入 -->
						<c:choose>
						<c:when test="${!empty membersVO}">
							<li>Hello, ${membersVO.firstName}</li>
							<li class="cta"><a href="Login/Logout.do">Logout</a></li>
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
	
	<div class="container">
	
	</div>
	<aside id="fh5co-hero" class="js-fullheight">
		<div class="flexslider js-fullheight">
			<ul class="slides">
		   	<li style="background-image: url(<c:url value="/static/images/slide_1.jpg"/>);" class='adli'>
		   		<div class="overlay-gradient"></div>
		   		<div class="container">
		   			<div class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
		   				<div class="slider-text-inner">
		   					<h2 class='adName'>Start Your Startup With This Template</h2>
		   					<p><a href="#" class="btn btn-primary btn-lg">馬上購買！！</a></p>
		   				</div>
		   			</div>
		   		</div>
		   	</li>
		  	</ul>
	  	</div>
	</aside>
	<div id="fh5co-services-section">
		<div class="container">

			<div class="row">
				<div class="col-md-4 animate-box">
					<div class="services">
						<i class="icon-map-marker"></i>
						<div class="desc">
							<h3>紀錄</h3>
							<p>提供會員觀看自己的運動情況，藉以調整自身的運動頻率、運動時間及運動強度。</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div class="services">
						<i class="icon-comments"></i>
						<div class="desc">
							<h3>與好友互動</h3>
							<p>提供會員擁有自己的塗鴉牆，可以在塗鴉牆上聊天、分享運動紀錄及運動資訊。</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div class="services">
						<i class="icon-trophy"></i>
						<div class="desc">
							<h3>挑戰</h3>
							<p>可以藉此為自身設立目標，亦可做為好友間的小型競賽，與互相激勵以維持良好的運動習慣。</p>
						</div>
					</div>
				</div>
				<div class="col-md-offset-2 col-md-4 animate-box">
					<div class="services">
						<i class="icon-flag-checkered"></i>
						<div class="desc">
							<h3>賽事參與</h3>
							<p>由廠商與相關機構所不定期舉辦的大型賽事活動，可以評測自己過去努力是否有所成長，是會員間互相認識、互相交流最好活動。</p>
						</div>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div class="services">
						<i class="icon-calendar"></i>
						<div class="desc">
							<h3>日曆</h3>
							<p>可以記錄會員過去的運動時間、也可記錄會員所參加或將參加的挑戰及賽事活動。</p>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>


	<div class="fh5co-cta" style="background-image: url(images/slide_2.jpg);">
		<div class="overlay"></div>
		<div class="container">
			<div class="col-md-12 text-center animate-box">
				<h3>We Try To Update The Site Everyday</h3>
				<p><a href="#" class="btn btn-primary btn-outline with-arrow">回到頂端<i class="icon-arrow-up"></i></a></p>
			</div>
		</div>
	</div>

	
	<footer id="fh5co-footer" role="contentinfo">
	
		<div class="container">
			<div class="col-md-3 col-sm-12 col-sm-push-0 col-xs-12 col-xs-push-0">
				<h3>關於我們</h3>
				<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
				<p><a href="#" class="btn btn-primary btn-outline with-arrow btn-sm">Join Us <i class="icon-arrow-right"></i></a></p>
			</div>
			<div class="col-md-6 col-md-push-1 col-sm-12 col-sm-push-0 col-xs-12 col-xs-push-0">
				<h3>聯絡我們</h3>
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
	
	
	<!-- jQuery Easing -->
	<script type="text/javascript" src="<c:url value="/static/js/jquery.easing.1.3.js" />"></script>
	<!-- Waypoints -->
	<script type="text/javascript" src="<c:url value="/static/js/jquery.waypoints.min.js" />"></script>
	<!-- Owl Carousel -->
	<script type="text/javascript" src="<c:url value="/static/js/owl.carousel.min.js" />"></script>
	<!-- Flexslider -->
	<script type="text/javascript" src="<c:url value="/static/js/jquery.flexslider-min.js" />"></script>
	<!-- MAIN JS -->
	<script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
	
	</body>
</html>