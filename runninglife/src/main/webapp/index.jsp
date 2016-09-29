<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="r" uri="http://iii.runningLife.com/util" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="/runninglife/static/css/bootstrap.min.css" />
<link rel="stylesheet" href="/runninglife/static/css/bootstrap-theme.min.css"></link>
<link rel="stylesheet" href="/runninglife/static/css/mainStyle.css"></link>
<script src="/runninglife/static/js/jquery-3.1.0.min.js"></script>
<script src="/runninglife/static/js/bootstrap.min.js"></script>


	
	<!-- Animate.css -->
	<style type="text/css">@import url("<c:url value="/static/css/animate.css" />");</style>
	<!-- Icomoon Icon Fonts-->
	<style type="text/css">@import url("<c:url value="/static/css/icomoon.css" />");</style>
	<!-- Flexslider  -->
	<style type="text/css">@import url("<c:url value="/static/css/flexslider.css" />");</style>
	<!-- Theme style  -->
	<style type="text/css">@import url("<c:url value="/static/css/style.css" />");</style>
	<!-- Modernizr JS -->
	<script type="text/javascript" src="<c:url value="/static/js/modernizr-2.6.2.min.js" />"></script>
	
<title>Running Life</title>

	<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/images/icon.png">
	
<style type="text/css">
ol, ul {
    margin-top: 0;
    margin-bottom: 10px;
}
</style>
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
		
		$('#username').focusout(function(){
			var input = $('#username').val();
			$.get("../../../../main/java/_01/controller/loginController/LoginSpring/Login",{'name':input},function(data){
				switch(data){
				case "查無此帳號":
					$('#span1').removeClass().addClass('glyphicon glyphicon-ok-sign');
					break;
				case "帳號已存在":
					$('#span1').removeClass().addClass('glyphicon glyphicon-remove-sign');
					break;
				}
			});
		});
		
		$('#loginBtn').click(function(){
			var account = $('#account').val();
			var password = $('#password').val();
			var myUrl = '/runninglife/Login/LoginCheck.do';
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
	var adsData = ajax('GET', null, 'ads/searchDisplayAds.do', 'json', false);
	console.log(adsData);
	for ( var i in adsData) {
		if(i==0){
// 			$('.slides').find('.adName').text(adsData[i].adName);
			$('.slides').find('a').attr('href',adsData[i].link);
			$('.slides').find('.adli').attr('style',"background-image: url(<c:url value='photoController/getPhoto.do?photoID="+adsData[i].image+"'/>);");
		}else{
			var adsli=$($('.slides').find('.adli').clone()).clone();
// 			$(adsli).find('.adName').text(adsData[i].adName);
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
</head>


<!-- 彈出式窗 -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" id="myModal" role="dialog" aria-labelledby="mySmallModalLabel">
  <div class="modal-dialog modal-sm" role="document">
  
      <!-- 	get || post -->
	  <!-- /Login/DBCheck -->
      <div class="container" style="margin-top:40px">
		<div class="row">
			<div class="col-sm-6 col-md-4 ">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong id="gridSystemModalLabel">登入</strong>
					</div>
					<div class="panel-body">
						<form role="form" action="/runninglife/Login/DBCheck.do" method="post">
							<fieldset>
<!-- 								<div class="row"> -->
<!-- 									<div class="center-block"> -->
<!-- 									</div> -->
<!-- 								</div> -->
								<div class="row">
									<div class="col-sm-12 col-md-10  col-md-offset-1 ">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span> 
												<input type="text" id="account" class="form-control" name="memberAccount" value="${param.memberAccount}" placeholder="帳號" autofocus>
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-lock"></i>
												</span>
												<input type="password" class="form-control" id="password" name="password" value="${param.password}" placeholder="密碼">
											</div>
										</div>
										<div class="form-group">
											<input type="button" id="loginBtn" class="btn btn-lg btn-primary btn-block" value="登入">
											<input type="submit" id="loginBtn1" class="btn btn-lg btn-primary btn-block hidden" value="登入">
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="panel-footer ">
						<a href="/runninglife/Login/ChangeForgetPage.do"> 忘記密碼? </a><br/>
						<a href="/runninglife/Login/CreateAccountPage.do"> 新增用戶 </a>
					</div>
                </div>
			</div>
		</div>
    </div>
  </div>
</div>
	

<!-- Modal end-->

<body>
<div id="fh5co-page">
	<%@ include file="/WEB-INF/pages/header.jsp"%>
	<div class="container"></div>
	<aside id="fh5co-hero" class="js-fullheight">
		<div class="flexslider js-fullheight">
			<ul class="slides">
		   	<li style="background-image: url(<c:url value="/static/images/slide_1.jpg"/>);" class='adli'>
		   		<div class="overlay-gradient"></div>
		   		<div class="container">
		   			<div class="col-md-10 col-md-offset-1 text-center js-fullheight slider-text">
		   				<div class="slider-text-inner">
<!-- 		   					<h2 class='adName'>Start Your Startup With This Template</h2> -->
		   					<p style='margin-top: 400px;'><a href="#" class="btn btn-primary btn-lg">馬上購買！！</a></p>
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
	
	<%@ include file="/WEB-INF/pages/footer.jsp"%>
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