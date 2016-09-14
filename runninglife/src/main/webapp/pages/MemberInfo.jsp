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
<h1>Hello, ${member.firstName} (By Model)</h1><br>
<h1>Hello, ${sessionScope.member.firstName} (By Session)</h1><br>
<a href="../friend/listFriend.do" >好友名單</a><br>
<a href="../friend/listFriendRequest.do">收到的邀請</a><br>
<a href="../pages/friend/SendRequest.jsp">邀請好友</a><br>


</body>
</html>