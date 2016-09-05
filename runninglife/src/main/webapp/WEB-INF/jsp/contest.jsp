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
<link rel="stylesheet"
	href="/runninglife/resources/css/bootstrap.min.css">


</head>
<body>


	<div id="auth" class="">admin</div>
	<!-- 	<div id="auth" class="">${member.auth}</div> -->
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
					<a href="/runninglife/contest/${contest.contestID}" target="_blank"><img
						class="img-responsive thumbnail"
						src="/runninglife/resources/${contest.contestPhotoPath}"></a>
				</div>
				<div class="col-lg-10 col-md-10 col-sm-9 col-xs-9 margin-bottom-0">
					<div class="size-17 contest${contest.contestID} ">
						<span class="badge badge-blue size-15">開放報名</span> <a
							class="text-muted" href="/runninglife/contest/${contest.contestID}"
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
				<a href="/runninglife/contest/${contest.contestID}/edit"
					class="btn btn-info edit" role="button"">編輯</a>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3">
				<a href="/runninglife/contest/${contest.contestID}/delete"
					class="btn btn-danger  delete" role="button" data-text="真的要刪除此賽事嗎?"
					data-confirm-button="是的" data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3">
				<form method="post" action="/runninglife/contest/${contest.contestID}/upload"
					enctype="multipart/form-data">
					<table border="0">
						<tr>
							<td><input type="file" name="fileUpload" size="50" /></td>
						</tr>
<!-- 						<tr> -->
<!-- 							<td>Pick file #2:</td> -->
<!-- 							<td><input type="file" name="fileUpload" size="50" /></td> -->
<!-- 						</tr> -->
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="Upload" /></td>
						</tr>
					</table>
				</form>
			</div>

		</c:forEach>
	</div>
	</section>
	<script></script>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="/runninglife/resources/js/jquery.confirm.min.js"></script>
<script src="/runninglife/resources/js/bootstrap.min.js"></script>
<script>
	$(document).ready(auth());
	function auth() {
		if ($('#auth').text() == 1) {
			$("#auth").addClass("hidden");
			console.log(2);
		}
	}
	//隱藏刪除編輯按鈕	
	$(function() {
		if ($('#auth').text() != "admin") {
			$('.delete').addClass("hidden");
			$('.edit').addClass("hidden");
		}
	});
	//刪除確認視窗
	$(".delete").confirm({
		post : true,
		confirmButtonClass : "btn-danger btn-sm",
		cancelButtonClass : "btn-default btn-sm",
		dialogClass : "modal-dialog modal-sm" // Bootstrap classes for large modal
	});
	//$('selector').confirm()
	// $(".delete").confirm({
	//     text: "Are you sure you want to delete that comment?",
	//     title: "Confirmation required",
	//     confirm: function(button) {
	//         delete();
	//     },
	//     cancel: function(button) {
	//         // nothing to do
	//     },
	//     confirmButton: "Yes I am",
	//     cancelButton: "No",
	//     post: true,
	//     confirmButtonClass: "btn-danger",
	//     cancelButtonClass: "btn-default",
	//     dialogClass: "modal-dialog modal-lg" // Bootstrap classes for large modal
	// });
	var currentdate = new Date();
	if (currentdate < new Date('2016-08-09')){
		console.log("yes");
	}
</script>
</html>