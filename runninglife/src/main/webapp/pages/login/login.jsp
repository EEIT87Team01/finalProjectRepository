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
<!-- 	get || post -->
	<form action="<c:url value="/LoginServlet" />" method="post">
	<table>
		<thead>
			<tr>
				<th>
				</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><input type="text" name="memberAccount" value="${param.memberAccount}"></td>
			</tr>
			<tr>
				<td><input type="text" name="password" value="${param.password}"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="送出">
				</td>
			</tr>
		</tbody>
	</table>
		
	</form>

</body>
</html>