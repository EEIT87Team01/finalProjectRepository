<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/runninglife/static/css/bootstrap.min.css" />
<link rel="stylesheet" href="/runninglife/static/css/bootstrap-theme.min.css"></link>
<script src="/runninglife/static/js/jquery-3.1.0.min.js"></script>
<script src="/runninglife/static/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<form action="member/Login" method="post">
	<h3>Login</h3>
	帳號：<input type="text" name="account" /><br>
	密碼：<input type="password" name="pass" /><br>
	<button type="submit">login</button><br>
</form>

</body>
</html>