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
<form action="/runninglife/WriterLogin/WriterAccountCheck.do" method="post">
	<table>
		<thead>
			<tr>
				<th>
				</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
				帳號:<input type="text" id="account" class="form-control" name="writerAccount" value="${param.writerAccount}">
				<span  id="span1" class="glyphicon glyphicon-question-sign"></span>
				</td>
			</tr>
			<tr>
				<td>
				密碼:<input type="text" class="form-control" name="password" value="${param.password}">
				<span class="glyphicon glyphicon-question-sign"></span>
				</td>
			</tr>
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