<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/runninglife/WriterLogin/Logout.do" method="get">
<table border='1'>
<tr>
  <td>
       ${errorMessage}
  </td>
</tr> 
<tr>
	<td>
		帳號:<input type="text" value="${writerVO.writerAccount}"/><br/>
		密碼:<input type="text" value="${writerVO.password}"/><br/>
		名子:<input type="text" value="${writerVO.name}"/><br/>
		Email:<input type="text" value="${writerVO.email}"/><br/>
		地址:<input type="text" value="${writerVO.address}"/><br/>
		狀態:<input type="text" value="${writerVO.status}"/><br/>
	</td>
</tr>
<tr>
	<td>
		<input type="submit" class="btn btn-primary" value="登出">
	</td>
</tr>
</table>
</form>
</body>
</html>