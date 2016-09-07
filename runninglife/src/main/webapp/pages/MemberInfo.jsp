<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello, ${member.firstName}</h1><br>
<a href="/runninglife/friend/listFriend_id=${member.memberID}">好友名單</a><br>
<a href="pages/friend/FriendRequest.jsp">邀請好友</a><br>
<a href="/runninglife/friend/listFriendRequest_id=${member.memberID}">收到的邀請</a><br>


</body>
</html>