<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="/runninglife/static/css/bootstrap.min.css" />
<link rel="stylesheet" href="/runninglife/static/css/bootstrap-theme.min.css"></link>
<link rel="stylesheet" href="/runninglife/static/css/mainStyle.css"></link>
<script src="/runninglife/static/js/jquery-3.1.0.min.js"></script>
<script src="/runninglife/static/js/bootstrap.min.js"></script>

	<!-- Animate.css -->
	<style type="text/css">@import url("<c:url value="/static/css/animate.css" />");</style>
	<!-- Icomoon Icon Fonts-->
	<style type="text/css">@import url("<c:url value="/static/css/icomoon.css" />");</style>
	<!-- Flexslider  -->
	<style type="text/css">@import url("<c:url value="/static/css/flexslider.css" />");</style>
	<!-- Theme style  -->
	<style type="text/css">@import url("<c:url value="/static/css/style.css" />");</style>
	<!-- Modernizr JS -->
	<script type="text/javascript" src="<c:url value="/static/js/modernizr-2.6.2.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/static/js/login.js" />"></script>
	
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js"></script>
	
</head>
<body style="background-image: url('../static/images/create.jpg');
 			background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            background-size: cover;">
<div id="fh5co-page">
	<%@ include file="/WEB-INF/pages/header.jsp"%>
</div>
<div class="col-md-offset-2 col-md-5">
		<div class="row">
			<form action="/runninglife/Login/UpdateAccountPage.do" method="get" class="form-horizontal">
			 	
				<table class="table" style="color:black;">
				<tr><td>姓氏:${membersVO.lastName}</td></tr>
				<tr><td>名子:${membersVO.firstName}</td></tr>
				<tr><td>暱稱:${membersVO.nickname}</td></tr>
				<tr><td>生日:${membersVO.birthday}</td></tr>
				<tr><td>Email:${membersVO.email}</td></tr>
				<tr><td>國家:${membersVO.locationID.locationID.cityID.cityID.countryID.country}</td></tr>
				<tr><td>城市:${membersVO.locationID.locationID.cityID.cityName}</td></tr>
				<tr><td>地區:${membersVO.locationID.locationName}</td></tr>
				<tr><td>身高:${membersVO.height}</td></tr>
				<tr><td>體重:${membersVO.weight}</td></tr>
				<tr><td>電話:${membersVO.phone}</td></tr>
				<tr><td>地址:${membersVO.address}</td></tr>
				<tr><td>身分證字號:${membersVO.identityID}</tr>
				<tr><td>緊急連絡人:${membersVO.emergencyContact}</td></tr>
				<tr><td>緊急聯絡人電話:${membersVO.emergencyPhone}</td></tr>
				<tr><td>緊急連絡人關係:${membersVO.emergencyRelation.relationName}</td></tr>

				<tr class="col-md-offset-7 col-md-4" style="padding-left: 100px;">
					<td>
						<input type="submit" class="btn btn-primary" value="修改資料">
					</td>
				</tr>
				</table>
			</form>
		</div>
</div>

</body>
</html>