<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/static/images/icon.png">
</head>
<body>
<form action="/runninglife/AdminLogin/Logout.do" method="get">
<table border='1'>
<tr>
  <td>
       ${errorMessage}
  </td>
</tr> 
<tr>
	<td>
		帳號:<input type="text" value="${adminsVO.adminAccount}"/><br/>
		密碼:<input type="text" value="${adminsVO.password}"/><br/>
		名子:<input type="text" value="${adminsVO.name}"/><br/>
		階級:<input type="text" value="${adminsVO.levelID.levelID}"/><br/>
		狀態:<input type="text" value="${adminsVO.status}"/><br/>
	</td>
</tr>
<tr>
	<td>
		<input type="submit" class="btn btn-primary" value="登出">
	</td>
</tr>
<tr>
	<td>
		<a href="writerCreateAccount.jsp">新增作家</a>
	</td>
</tr>

</table>
</form>

</body>
</html>