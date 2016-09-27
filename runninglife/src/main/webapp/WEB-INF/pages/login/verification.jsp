<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<form action="CheckVerification.do" method="post">
		<table>
			<thead>
				<tr>
					<td><h4>驗證</h4></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>驗證碼:<input type="text" class="form-control" name="status" 
											value="${param.status}" placeholder="請輸入驗證碼"/>
							<input type="text" class="form-control hidden" name="memberAccount" 
											value="${param.memberAccount}"/>
					<span class="glyphicon glyphicon-question-sign"></span></td>
				</tr>
				<tr>
					<td><input type="submit" class="btn btn-primary" value="送出"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>