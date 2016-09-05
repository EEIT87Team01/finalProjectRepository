<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr><th>FirstName</th><th>LastName</th><th></th>
<c:forEach var="memberRequest" items="${sessionScope.member.friendReceive}">
	<tr><td>${memberRequest.firstName}</td><td>${memberRequest.lastName}</td><td><a href="/runninglife_test/friend/accept/${memberRequest.memberID}&${sessionScope.member.memberID}">接受</a></td></tr>
</c:forEach>
</table>

</body>
</html>