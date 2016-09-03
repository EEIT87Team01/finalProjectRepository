<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>賽事資訊</title>

<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="/runninglife/resources/css/bootstrap.min.css">


</head>
<body>
	<h2>${events}</h2>



	<c:url var="saveUrl" value="/event//${contest.contestID}" />

	<%-- 				<td><a href="<c:url  value="/contest/${contest.contestID}" />">${contest.contestName}</a></td> --%>
	<%-- 				<td>${contest.place}</td> --%>
	<%-- 				<td>${contest.startDate}</td> --%>
	<%-- 				<td>${contest.organizer}</td> --%>
	<%-- 				<td>${contest.coorganizer}</td> --%>

	<!-- 	載入列表	 -->
	<section>
	<div class="container">
		<c:forEach var="contest" items="${contests}">
			<div class="col-lg-9 col-md-9 col-sm-9">
				<div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 nopadding-right">
					<a href="contest/${contest.contestID}" target="_blank"><img
						class="img-responsive thumbnail"
						src="/runninglife/resources/${contest.contestID}.jpg"></a>
				</div>
				<div class="col-lg-10 col-md-10 col-sm-9 col-xs-9 margin-bottom-0">
					<div class="size-17 contest${contest.contestID} ">
						<span class="badge badge-blue size-15">尚未開報</span> <a
							class="text-muted" href="contest/${contest.contestID}"
							target="_blank">${contest.contestName}</a>
					</div>
				</div>
				<div
					class="col-lg-3 col-md-3 col-sm-4 col-xs-9 margin-bottom-0 size-16">
					<i class="fa fa-calendar"></i> <span class="text-success"
						data-toggle="tooltip" title="" data-original-title="活動日期">${contest.startDate}</span>
				</div>
				<div
					class="col-lg-10 col-md-10 col-sm-9 col-xs-9 size-16 margin-bottom-0">
					<i class="fa fa-map-marker"></i> <a class="text-warning"
						href="https://goo.gl/maps/NFJZ7s6pG5p" data-toggle="tooltip"
						title="" target="_blank" data-original-title="活動地點">${contest.place}</a>
				</div>
				<div
					class="col-lg-10 col-md-10 col-sm-9 col-xs-9 margin-bottom-10 hidden-sm hidden-xs"></div>
				<div class="col-lg-10 col-md-10 col-sm-9 col-xs-12">
					<a href="contest/${contest.contestID}"
						class="btn btn-3d btn-xs btn-reveal btn-red" target="_blank"><i
						class="fa fa-info-circle"></i><span class="size-14">簡章</span></a><span
						class="text-danger"> 報名時間：敬請期待</span>
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="divider margin-top-0 margin-bottom-10"></div>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3">
				<a href="/runninglife/contest/${contest.contestID}/delete" class="btn btn-info" role="button">刪除</a>
			</div>
		</c:forEach>

	</div>
	</section>
	<script></script>
</body>
</html>