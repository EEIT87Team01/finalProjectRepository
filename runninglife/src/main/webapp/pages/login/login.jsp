<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- Bootstrap CSS --> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<!-- <script src="/runninglife/js/jquery-3.1.0.min.js"></script> -->

<!-- <link rel="stylesheet" href="/runninglife/css/bootstrap.min.css"> -->
<!-- <script src="/runninglife/css/bootstrap-theme.min.css"></script> -->
<!-- <script src="/runninglife/js/bootstrap.min.js"></script> -->


<title>Insert title here</title>
</head>
<body>
<!-- 	get || post -->
	<form action='<c:url value="/LoginServlet" />' method="post">
	<table>
		<thead>
			<tr>
				<th>
				</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
				帳號:<input type="text" id="username" class="form-control" name="memberAccount" value="${param.memberAccount}">
				<span  id="span1" class="glyphicon glyphicon-question-sign"></span>
				</td>
			</tr>
			<tr>
				<td>
				密碼:<input type="text" class="form-control" name="password" value="${param.password}">
				<span class="glyphicon glyphicon-question-sign"></span>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" class="btn btn-primary" value="送出">
				</td>
			</tr>
			<tr>
				<td>
					<a href="forgetPwsd.jsp">忘記密碼?</a>
				</td>
			</tr>
		</tbody>
	</table>
		
	</form>
	
<!-- 	jquery -->
	<script>
// 	$(function(){
		
// 		$('#username').focusout(function(){
// 			var input = $('#username').val();
// 			$.get("../../../../main/java/_01/controller/loginController/LoginServlet",{'name':input},function(data){
// 				switch(data){
// 				case "查無此帳號":
// 					$('#span1').removeClass().addClass('glyphicon glyphicon-ok-sign');
// 					break;
// 				case "帳號已存在":
// 					$('#span1').removeClass().addClass('glyphicon glyphicon-remove-sign');
// 					break;
// 				}
// 			});
// 		});
		
// 	});
	</script>
</body>
</html>