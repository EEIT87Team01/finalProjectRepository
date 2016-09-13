<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- Bootstrap CSS --> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/runninglife/Login/CreateAccount" method="post">
<table>
		<thead>
			<tr>
				<th>新增會員</th>
			</tr>
		</thead>
		<tbody>
			<tr><td>帳號:<input type="text" name="memberAccount" class="form-control"></td></tr>
			<tr><td>密碼:<input type="password" name="password" class="form-control"></td></tr>
			<tr><td>姓:<input type="text" name="firstName" class="form-control"></td></tr>
			<tr><td>名:<input type="text" name="lastName" class="form-control"></td></tr>
			<tr><td>暱稱:<input type="text" name="nickname" class="form-control"></td></tr>
			<tr><td>性別:<input type="radio" name="gender" value="1">男 <input type="radio" name="gender" value="0"> 女</td></tr>
			<tr><td>email:<input type="text" name="email" class="form-control"></td></tr>
			<tr><td>生日:<input type="text" name="birthday" class="form-control"></td></tr>
			<tr><td>居住地:<input type="text" name="location" class="form-control"></td></tr>
			<tr><td>地址:<input type="text" name="address" class="form-control"></td></tr>
			<tr><td>身分證字號:<input type="text" name="identityID" class="form-control"></td></tr>
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