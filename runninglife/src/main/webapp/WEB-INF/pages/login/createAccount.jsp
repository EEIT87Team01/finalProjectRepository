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
	<link rel="stylesheet"	href="<%=request.getContextPath()%>/static/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet"	href="<%=request.getContextPath()%>/static/css/icomoon.css">
	<!-- Flexslider  -->
	<link rel="stylesheet"	href="<%=request.getContextPath()%>/static/css/flexslider.css">
	<!-- Theme style  -->
	<link rel="stylesheet"	href="<%=request.getContextPath()%>/static/css/style.css">
	<!-- Modernizr JS -->
	<link rel="stylesheet"	href="<%=request.getContextPath()%>/static/js/modernizr-2.6.2.min.js">
	
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
<body style="background-image: url('<%=request.getContextPath()%>/static/images/create.jpg') ;
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
<div class="container">
		<div class="main-login main-center">
		<div class="row main">
			<form action="/runninglife/Login/CreateAccount.do" method="post" class="form-horizontal" enctype="multipart/form-data">
			<table>
				<thead>
					<tr>
						<th>
							<div class="page" style="margin-top:20px;">
	  							<h1 class="login-label">新增會員</h1>
							</div>
<!-- 							<h2 class="dark-grey login-label"></h2> -->
						</th>
					</tr>
				</thead>
				<tbody>
					<tr class="form-group col-lg-12">
						<td>
<!-- 							<label for="name" class=" control-label login-label">帳號</label> -->
							<input type="text" id="memberAccount" name="memberAccount" class="alert alert-dismissible cols-sm-5 input-group" placeholder="請輸入帳號"/>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText1"></span>
						</td>
						<td class="form-group col-lg-2"></td>
<!-- 						<td><span class="form-group col-lg-2"></span></td> -->
						<td>
<!-- 							<label for="name" class="control-label login-label">名子</label> -->
							<input type="text" id="lastName" name="lastName" class="alert alert-dismissible cols-sm-5 input-group" placeholder="請輸入姓氏"/>
							<span class="form-group col-lg-2"></span>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText5"></span>
						</td>
	
					</tr>
					
					<tr class="form-group col-lg-12">
						<td style="top:-20px; ">
<!-- 							<label for="name" class="control-label login-label">密碼</label> -->
							<input type="password" id="createPassword" name="password" class="alert alert-dismissible cols-sm-5 input-group" id="name"  placeholder="請輸入密碼"/>
							<span class="test-text">(請輸入長度不小於6密碼)</span><br/>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText2"></span>
						</td>
						<td class="form-group col-lg-2"></td>
						<td style="padding-top:6px; ">
<!-- 							<label for="name" class="control-label login-label">姓氏</label> -->
							<input type="text" id="firstName" name="firstName" class="alert alert-dismissible cols-sm-5 input-group" placeholder="請輸入名子"/>
							<span class="form-group col-lg-2"></span>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText4"></span><br/>
						</td>
					</tr>
					
					<tr class="form-group col-lg-12">
						<td >
<!-- 							<label for="name" class="control-label login-label">電話</label> -->
							<input type="text" id="phone" name="phone" class="alert alert-dismissible cols-sm-5 input-group" placeholder="請輸入電話"/>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText6"></span>
						</td>
						<td class="form-group col-lg-2"></td>
						<td>
<!-- 							<label for="name" class="control-label login-label">email</label> -->
							<input type="text" id="email" name="email" class="alert alert-dismissible cols-sm-5 input-group" placeholder="請輸入Email"/>
							<span class="test-text">(範例:XXX@gmial.com)</span><br/>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText3"></span>
						</td>
					</tr>
					<tr class="form-group col-lg-12">
						<td >
<!-- 							<label for="name" class="control-label login-label">生日</label> -->
							<input type="text" id="createBirthday" name="birthday" class="alert alert-dismissible cols-sm-5" placeholder="請選擇生日"/>
							<span class="glyphicon glyphicon-question-sign hidden" id="showText7"></span>
						</td>
						<td class="form-group col-lg-3"></td>
						<td class="login-label">
							<label for="name" class="control-label">性別</label>
							<input type="radio" name="gender" value="1" >男
							<input type="radio" name="gender" value="0"> 女
							<input type="radio" name="gender" value="2" checked="checked" > 不公開
						</td>
					</tr>
					<tr class="form-group col-lg-12">
						<td>
							<label for="name" class="ccontrol-label login-label">大頭貼:</label><br/>
							<input id="input-2" name="file1" type="file" class="file" multiple="" data-show-upload="false" data-show-caption="true"/>
						</td>
					</tr>
					<tr class="form-group col-lg-12">
						<td >
							<input type="submit" id="btn" class="btn btn-primary" disabled="disabled" value="送出">
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
	var accountFlag = false;
	var passwordFlag = false;
	var firstNameFlag = false;
	var lastNameFlag = false;
	var phoneFlag = false;
	var eMailFlag = false;
	var birthdayFlag = false;
	
	$('#memberAccount').change(function(){
		var inAccount = $('#memberAccount').val();
		if(inAccount.length == 0){
			$('#showText1').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("帳號未填");
			accountFlag = false;
		}else{
			var myUrl = '/runninglife/Login/AccountCheck.do';
			var type = 'post';
			var dataType = 'json';
			var data = { "memberAccount" : $('#memberAccount').val() };
			
			var response = ajaxFunction(myUrl,type,data,dataType);
			if(response == "fail"){
				$('#showText1').removeClass().addClass('glyphicon glyphicon-remove-sign show1').text("帳號不可使用");
				accountFlag = false;
			}else{
				$('#showText1').removeClass().addClass("glyphicon glyphicon-ok-sign show2").text("可使用");
				accountFlag = true;
			}
		}
	})
	
	$('#createPassword').keyup(function(){
		var inPassword = $('#createPassword').val();
		if(inPassword.length == 0){
			$('#showText2').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("密碼未填");
			passwordFlag = false;
		}else{
			if(inPassword.length < 6){
				$('#showText2').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("密碼長度不可小於6");
				passwordFlag = false;
			}else{
				var regx = /^[\w][^\s]{5,20}$/;
				if(inPassword.match(regx)){
					$('#showText2').removeClass().addClass("glyphicon glyphicon-ok-sign show2").text("正確");
					passwordFlag = true;
				}else{
					$('#showText2').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("請輸入正確密碼");
					passwordFlag = false;
				}
			}
		}
	})
	
	$('#email').keyup(function(){
		var inEmail = $('#email').val();
		if(inEmail.length == 0){
			$('#showText3').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("Eamil未填");
			eMailFlag = false;
		}else{
			var regx = /^.+@.+\..{2,4}$/;
			if(inEmail.match(regx)){
				$('#showText3').removeClass().addClass("glyphicon glyphicon-ok-sign show2").text("正確");
				eMailFlag = true;
			}else{
				$('#showText3').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("Email格式不正確");
				eMailFlag = false;
			}
			
		}
	})
	
	$('#firstName').keyup(function(){
		var inFirstName = $('#firstName').val();
		if(inFirstName.length == 0){
			$('#showText4').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("姓氏未填");
			firstNameFlag = false;
		}else{
			$('#showText4').removeClass().addClass("hidden");
			firstNameFlag = true;
		}
	})
	
	$('#lastName').keyup(function(){
		var inLastName = $('#lastName').val();
		if(inLastName.length == 0){
			$('#showText5').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("名子未填");
			lastNameFlag = false;
		}else{
			$('#showText5').removeClass().addClass("hidden");
			lastNameFlag = true;
		}
	})
	
	$('#phone').keyup(function(){
		var inPhone = $('#phone').val();
		if(inPhone.length == 0){
			$('#showText6').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("電話未填");
			phoneFlag = false;
		}else{
			var regx = /^[0-9]*[^\s]$/;
			if(inPhone.match(regx)){
				$('#showText6').removeClass().addClass("hidden");
				phoneFlag = true;	
			}else{
				$('#showText6').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("請輸入正確電話號碼");
				phoneFlag = false;
			}
		}
	})
	
	$('#createBirthday').keyup(function(){
		var inBirthday = $('#createBirthday').val();
		if(inBirthday.length == 0){
			birthdayFlag = false;
		}else{
			birthdayFlag = true;	
		}
	})
	
	$("#createBirthday").datepicker({
		changeMonth: true,
	    changeYear: true,
		dateFormat:"yy-mm-dd",
		onSelect: function(dateText) {
			$(this).keyup();
		}
	});
	
	$('#memberAccount,#createPassword,#email,#firstName,#lastName,#phone,#createBirthday').keyup(function(){
		
		if(accountFlag && passwordFlag && firstNameFlag && lastNameFlag && phoneFlag && eMailFlag && birthdayFlag){
			$("#btn").prop("disabled", false);
		}else{
			$("#btn").prop("disabled", true);
		}
	})
});

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
</script>
</body>
</html>