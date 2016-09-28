<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script type="text/javascript" src="<c:url value="/static/js/login.js" />"></script>
	
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js"></script>
	

<style>
	.showColorRed{
		color:red;
	}
	
	.showColorGreen{
		color:green;
	}
	
	.test-text {
	color: #AA0000;
}
</style>
</head>
<body style="background-image: url('../static/images/create.jpg');
 			background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            background-size: cover;">
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
						<li><a href="<%=request.getContextPath()%>/calendar.do">行事曆</a></li>
						<li><a href="<%=request.getContextPath()%>/article/page.do">文章</a></li>
						<!-- 判斷是否已登入 -->
						<c:choose>
						<c:when test="${!empty membersVO}">
							<li>Hello, ${membersVO.lastName}</li>
							<li class="cta"><a href="Login/Logout.do">登出</a></li>
						</c:when>
						<c:otherwise>
							<li class="cta" data-toggle="modal" data-target="#myModal"><a href="#">登入</a></li> <!-- 登入視窗按鈕 -->
						</c:otherwise>	
						</c:choose>
					</ul>
				</nav>
			</div>
		</div>
	</header>
  </div>
<div class="col-md-offset-2 col-md-5">
  <div class="row">
	<form action="ChangePassword.do" method="post">
		<table>
			<thead>
				<tr>
					<td>
						<div class="page" style="margin-top:20px;">
		  							<h1 class="login-label">密碼變更</h1>
						</div>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="password" class="alert alert-dismissible cols-sm-5 input-group" id="password" name="password" placeholder="請輸入密碼碼"/>
					<span class="test-text">(請輸入英文和數字且長度不小於6的密碼)</span><br/>
					<span class="hidden" id="showText1"></span>
					</td>
				</tr>
				<tr>
					<td><input type="password" class="alert alert-dismissible cols-sm-5 input-group" id="newPassword" name="newPassword" placeholder="請重新輸入密碼" style="margin-top:30px;"/>
					<span class="hidden" id="showText2"></span>
					<br/>
					</td>
					<td>
						<input type="hidden" class="hidden" value="${param.memberAccount}" name="memberAccount"/>
					</td>
				</tr>
				<tr>
					<td><input type="submit" id="btn" class="btn btn-primary" disabled="disabled" value="送出"></td>
				</tr>
			</tbody>
		</table>
	</form>
  </div>
</div>
	<script>
		$(function(){
			$('#password').focusout(function(){
				var inpassword = $('#password').val();
				var paswdLength = inpassword.length;
				if(paswdLength == 0){
					$('#showText1').removeClass().addClass("glyphicon glyphicon-remove-sign showColorRed").text("請輸入密碼");
				}else{
					if(paswdLength < 6){
						$('#showText1').removeClass().addClass("glyphicon glyphicon-remove-sign showColorRed").text("密碼長度不可小於6");
					}else{
						var regx = /^[\w][^\s]{5,20}$/;
						if(inpassword.match(regx)){
							$('#showText1').removeClass().addClass("glyphicon glyphicon-ok-sign showColorGreen").text("正確");
						}else{
							$('#showText1').removeClass().addClass("glyphicon glyphicon-remove-sign showColorRed").text("請輸入正確密碼");
						}
					}
				}
			});
			
			$('#password,#newPassword').focusout(function(){
				var inpassword = $('#password').val();
				var newPassword = $('#newPassword').val();
				if(inpassword == newPassword){
					$('#showText2').removeClass().addClass("glyphicon glyphicon-ok-sign showColorGreen").text("密碼相符");
					$('#btn').prop("disabled",false);
				}else{
					$('#showText2').removeClass().addClass("glyphicon glyphicon-remove-sign showColorRed").text("密碼不相符");
					$('#btn').prop("disabled",true);
				}			
			});
		});
	</script>
</body>
</html>