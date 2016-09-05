<%@page import="_02.model.members.MembersDAO"%>
<%@page import="_02.model.members.MembersVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
<%
	MembersDAO mdao = new MembersDAO();
    List<MembersVO> mvos = mdao.getAll();
    pageContext.setAttribute("mvos",mvos);
%>
<table>
<tr><th>FirstName</th><th>LastName</th><th></th>
<c:forEach var="memberR" items="${mvos}">
	<tr><td>${memberR.firstName}</td><td>${memberR.lastName}</td><td><a href="/runninglife_test/friend/invite/${memberR.memberID}&${member.memberID}">邀請</a></td></tr>
</c:forEach>
</table>

</body>
</html>