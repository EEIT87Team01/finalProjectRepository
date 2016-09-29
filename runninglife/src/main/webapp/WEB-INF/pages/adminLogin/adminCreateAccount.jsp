<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/static/images/icon.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- Bootstrap CSS --> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</head>
<body>
<form action="/runninglife/AdminLogin/CreateAccount.do" method="post">
<table>
		<thead>
			<tr>
				<th>新增管理員</th>
			</tr>
		</thead>
		<tbody>
			<tr><td>帳號:<input type="text" name="adminAccount" value="${adminsVO.adminAccount}" class="form-control"/></td></tr>
			<tr><td>密碼:<input type="text" name="password" value="${adminsVO.password}" class="form-control"/></td></tr>
			<tr><td>名子:<input type="text" name="name" value="${adminsVO.name}" class="form-control"/></td></tr>
			<tr><td>階級:<input type="text" name="levelID" value="${adminsVO.levelID.levelID}" class="form-control"/></td></tr>
			<tr><td>狀態:<input type="text" name="status" value="${adminsVO.status}" class="form-control"/></td></tr>
			<tr>
				<td>
					<input type="submit" class="btn btn-primary" value="送出">
				</td>
			</tr>
		</tbody>
</table>
</form>

</body>
</html>