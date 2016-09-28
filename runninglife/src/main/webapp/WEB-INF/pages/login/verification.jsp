<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>verifyCode</title>
</head>
<body style="background-image: url('../static/images/create.jpg');
 			background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            background-size: cover;">
            
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
											<input type="submit" class="btn btn-lg btn-primary btn-block" value="登入">
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
            
<div id="fh5co-page">
	<%@ include file="/WEB-INF/pages/header.jsp"%>
</div>
<div class="col-md-offset-2 col-md-5">
  <div class="row">
	<form action="CheckVerification.do" method="post">
		<table>
			<thead>
				<tr>
					<td>
						<div class="page" style="margin-top:20px;">
		  							<h1 class="login-label">驗證</h1>
						</div>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" id="verifyCode" class="alert alert-dismissible cols-sm-5 input-group" name="status" 
											value="${param.status}" placeholder="請輸入驗證碼"/>
							<input type="text" class="form-control hidden" name="memberAccount" 
											value="${param.memberAccount}"/>
					</td>
				</tr>
				<tr>
					<td><input type="submit" id="btn" class="btn btn-primary" value="送出"></td>
				</tr>
			</tbody>
		</table>
	</form>
  </div>
</div>
<script>
$(function(){
	$('#verifyCode').focusout(function(){
		if($('#verifyCode').val().length == 0){
			$('#btn').prop("disabled",true);
		}else{
			$('#btn').prop("disabled",false);
		}
	});	
});
</script>
</body>
</html>