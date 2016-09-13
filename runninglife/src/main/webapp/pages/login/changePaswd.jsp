<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- Bootstrap CSS --> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style>
	.show{
		color:red;
	}
</style>
</head>
<body>
	<form action="/runninglife/Login/ChangePassword" method="post">
		<table>
			<thead>
				<tr>
					<td><h4>密碼變更</h4></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>新密碼:<input type="password" class="form-control" id="password" name="password" placeholder="請輸入密碼碼"/>
					<span style="color:gray">(請輸入英文和數字且長度不小於6的密碼)</span>
					<span class="hidden" id="showText1">請輸入密碼</span>
					</td>
				</tr>
				<tr>
					<td>確認密碼:<input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="請重新輸入密碼"/>
					<span class="hidden" id="showText2">密碼不符</span>
					</td>
					<td>
						<input type="text" class="hidden" id="newPassword" value="${param.memberAccount}" name="memberAccount"/>
					</td>
				</tr>
				<tr>
					<td><input type="submit" class="btn btn-primary" value="送出"></td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<script>
		$(function(){
			$('#password').focusout(function(){
				var inpassword = $('#password').val();
				var paswdLength = inpassword.length;
				if(paswdLength == 0){
					$('#showText').removeClass("hidden").addClass("show");
					console.log('請輸入密碼');
				}else{
					if(paswdLength <= 6){
						$('#showText').removeClass("hidden").addClass("show").text("密碼長度不可小於6");
					}else{
						var regx = /^[\w][^\s]{6,20}$/;
						var test = inpassword.match(regx);
						if(test){
							$('#showText1').removeClass("hidden").addClass("show").text("正確");
						}else{
							$('#showText1').removeClass("hidden").addClass("show").text("請輸入正確密碼");
						}
					}
				}
			});
			
			$('#newPassword').focusout(function(){
				var inpassword = $('#password').val();
				var newPassword = $('#newPassword').val();
				if(inpassword == newPassword){
					$('#showText2').removeClass("hidden").addClass("show").text("正確");
				}else{
					$('#showText2').removeClass("hidden").addClass("show");
				}			
			});
		});
	</script>
</body>
</html>