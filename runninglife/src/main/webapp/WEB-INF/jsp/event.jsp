<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>賽事資訊</title>
</head>
<body>
	<h2>${events}</h2>
	<div>
	
		
		<c:url var="saveUrl" value="/event//${contest.contestID}" />
		<table>
			<c:forEach var="contest" items="${contests}">
			<tr>
				<td><a href="<c:url  value="/contest/${contest.contestID}" />">${contest.contestName}</a></td>
				<td>${contest.place}</td>
				<td>${contest.startDate}</td>
				<td>${contest.organizer}</td>
				<td>${contest.coorganizer}</td>
			</tr>
			</c:forEach>











		</table>
	</div>
</body>
</html>