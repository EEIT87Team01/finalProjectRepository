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
	<style type="text/css">@import url("<c:url value="/static/css/login.css" />");</style>
	<!-- Modernizr JS -->
	<script type="text/javascript" src="<c:url value="/static/js/modernizr-2.6.2.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/static/js/login.js" />"></script>
	
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js"></script>
	
<title>Running Life</title>
<!-- ico	 -->
	<link rel="icon" type="image/png" href="/runninglife/images/icon.png">
	
<style type="text/css">
ol, ul {
    margin-top: 0;
    margin-bottom: 10px;
}

.show1 {
	color: red;
}

.show2 {
	color: green;
}

.login-label {
	color: black;
}

.test-text {
	color: #E63F00;
}
</style>
</head>
<body style="background-image: url('../static/images/create.jpg') ;
 			background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            background-size: cover;">
            
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
						<li><a href="calendar.do">行事曆</a></li>
						<li><a href="contact.html">運動文章</a></li>
						<li><a href="Login/ShowPage.do">個人資料</a></li>
						<!-- 判斷是否已登入 -->
						<c:choose>
						<c:when test="${!empty membersVO}">
							<li><img src="data:image/png;base64,${r:byteToBase64(membersVO.photo)}" style='width:50px;height:50px;'></li>
							<li>Hello, ${membersVO.lastName}</li>
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
  </div>
<div class="container">
		<div class="main-login main-center">
		<div class="row main">
			<form action="/runninglife/Login/CreateAccount.do" method="post" class="form-horizontal" enctype="multipart/form-data">
			<table>
				<thead>
					<tr>
						<th>
							<div class="page">
	  							<h1 class="login-label">新增會員</h1>
							</div>
<!-- 							<h2 class="dark-grey login-label"></h2> -->
						</th>
					</tr>
				</thead>
				<tbody>
					<tr class="form-group col-lg-12">
						<td style="margin-right: 30px; ">
							<label for="name" class=" control-label login-label">帳號</label>
							<input type="text" id="memberAccount" name="memberAccount" class="form-control cols-sm-5" placeholder="請輸入帳號"/>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText1"></span>
						</td>
						<td class="form-group col-lg-2"></td>
<!-- 						<td><span class="form-group col-lg-2"></span></td> -->
						<td style="padding-top:6px; ">
							<label for="name" class="control-label login-label">姓氏</label>
							<input type="text" id="firstName" name="firstName" class="form-control cols-sm-5"/>
							<span class="form-group col-lg-2"></span>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText4"></span><br/>
						</td>
					</tr>
					
					<tr class="form-group col-lg-12">
						<td>
							<label for="name" class="control-label login-label">密碼</label>
							<input type="text" id="password" name="password" class="form-control cols-sm-5" id="name"  placeholder="請輸入密碼"/>
							<span class="test-text">(請輸入長度不小於6密碼)</span><br/>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText2"></span>
						</td>
						<td class="form-group col-lg-2"></td>
						<td>
							<label for="name" class="control-label login-label">名子</label>
							<input type="text" id="lastName" name="lastName" class="form-control cols-sm-5" />
							<span class="form-group col-lg-2"></span>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText5"></span>
						</td>
					</tr>
					
					<tr class="form-group col-lg-12">
						<td style="margin-right: 30px; ">
							<label for="name" class="control-label login-label">電話</label>
							<input type="text" id="phone" name="phone" class="form-control cols-sm-5"/>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText6"></span>
						</td>
						<td class="form-group col-lg-2"></td>
						<td>
							<label for="name" class="control-label login-label">email</label>
							<input type="text" id="email" name="email" class="form-control cols-sm-5"/>
							<span class="test-text">(範例:XXX@gmial.com)</span><br/>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText3"></span>
						</td>
					</tr>
					<tr class="form-group col-lg-12">
						<td style="margin-right: 30px; ">
							<label for="name" class="control-label login-label">生日</label>
							<input type="text" id="createBirthday" name="birthday" class="form-control cols-sm-5"/>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText7"></span>
						</td>
						<td class="form-group col-lg-2"></td>
						<td class="login-label">
							<label for="name" class="ccontrol-label login-label">性別</label>
							<input type="radio" name="gender" value="1" class="login-label">男
							<input type="radio" name="gender" value="0" class="login-label"> 女
							<input type="radio" name="gender" value="2" checked="checked" class="login-label"> 不公開
						</td>
					</tr>
					<tr class="form-group col-lg-12">
						<td style="margin-right: 30px; ">
							<input type="submit" id="btn" class="btn btn-primary" value="送出">
						</td>
					</tr>
					<tr class="form-group col-lg-12">
					   <td>
					     <label for="name" class="ccontrol-label login-label">大頭貼:</label><br/>
					     <input id="input-2" name="file1" type="file" class="file" multiple="" data-show-upload="false" data-show-caption="true"/>
					   </td>
					</tr>
				</tbody>
			</table>
			</form>
		</div>
		</div>
	</div>
<script>
$(function(){
	var flag = true;
	$("#btn").attr("disabled", flag);
	$('#memberAccount').focusout(function(){
		var inAccount = $('#memberAccount').val();
		var AccountLength = inAccount.length;
		if(AccountLength == 0){
			$('#showText1').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("帳號未填");
			flag = true;
		}else{
			//ajax
			var myUrl = '/runninglife/Login/AccountCheck.do';
			var type = 'post';
			var dataType = 'json';
			var data = { "memberAccount" : $('#memberAccount').val() };
			
			var response = ajaxFunction(myUrl,type,data,dataType);
			console.log(response);
			if(response == "fail"){
				$('#showText1').removeClass().addClass('glyphicon glyphicon-remove-sign show1').text("帳號不可使用");
				flag = true;
			}else{
				$('#showText1').removeClass().addClass("glyphicon glyphicon-ok-sign show2").text("可使用");
				flag = false;
			}
		}
	})
	
	$('#password').focusout(function(){
		var inPassword = $('#password').val();
		var paswdLength = inPassword.length;
		if(paswdLength == 0){
			$('#showText2').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("密碼未填");
			flag = true;
		}else{
			if(paswdLength <= 6){
				$('#showText2').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("密碼長度不可小於6");
				flag = true;
			}else{
				var regx = /^[\w][^\s]{6,20}$/;
				var test = inPassword.match(regx);
				if(test){
					$('#showText2').removeClass().addClass("glyphicon glyphicon-ok-sign show2").text("正確");
					flag = false;
				}else{
					$('#showText2').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("請輸入正確密碼");
					flag = true;
				}
			}
		}
	})
	
	$('#email').focusout(function(){
		var inEmail = $('#email').val();
		var emailLength = inEmail.length;
		if(emailLength == 0){
			$('#showText3').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("Eamil未填");
			flag = true;
		}else{
			var regx = /^.+@.+\..{2,4}$/;
			var test = inEmail.match(regx);
			
			if(test){
				$('#showText3').removeClass().addClass("glyphicon glyphicon-ok-sign show2").text("正確");
				flag = false;
			}else{
				$('#showText3').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("Email格式不正確");
				flag = true;
			}
			
		}
	})
	
	$('#firstName').focusout(function(){
		var inFirstName = $('#firstName').val();
		var firstNameLength = inFirstName.length;
		if(firstNameLength == 0){
			$('#showText4').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("姓氏未填");
			flag = true;
		}else{
			$('#showText4').removeClass().addClass("hidden");
			flag = false;
		}
	})
	
	$('#lastName').focusout(function(){
		var inLastName = $('#lastName').val();
		var lastNameLength = inLastName.length;
		if(lastNameLength == 0){
			$('#showText5').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("名子未填");
			flag = true;
		}else{
			$('#showText5').removeClass().addClass("hidden");
			flag = false;
		}
	})
	
	$('#phone').focusout(function(){
		var inPhone = $('#phone').val();
		var phoneLength = inPhone.length;
		if(phoneLength == 0){
			$('#showText6').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("電話未填");
			flag = true;
		}else{
			$('#showText6').removeClass().addClass("hidden");
			flag = false;
		}
	})
	
	
	$("#createBirthday").datepicker({
		dateFormat:"yy-mm-dd"
	});
	
	$('#memberAccount,#password,#email,#firstName,#lastName,#phone,#createBirthday').change(function(){
		var inAccount = $('#memberAccount').val();
		var accountLen = inAccount.length;
		var inPassword = $('#password').val();
		var passLen = inPassword.length;
		var inEmail = $('#email').val();
		var emailLen = inEmail.length;
		var inFirstName = $('#firstName').val();
		var firstLen = inFirstName.length;
		var inLastName = $('#lastName').val();
		var lastLen = inLastName.length;
		var inPhone = $('#phone').val();
		var phoneLen = inPhone.length;
		var inBirthday = $('#createBirthday').val();
		var birthLen = inBirthday.length;
		
		if(accountLen == 0 && passLen == 0 && emailLen == 0 && firstLen == 0 && lastLen == 0 && phoneLen == 0 && birthLen == 0){
			$("#btn").attr("disabled", flag);
		}else{
			$("#btn").attr("disabled", flag);
		}
	})
});
</script>
</body>
</html>