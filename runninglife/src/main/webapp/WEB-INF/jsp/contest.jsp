<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<div id="countPage" class="hidden">${countPage}</div>
	<div>共有${countPage}頁</div>
	<div>memberID:${member.memberID}</div>
	<div id="auth" class="">admin</div>

	<!-- 	載入列表	 -->
	<section>
	<div class="container">

		<form class="text-center form-control" id="queryContest" method="get"
			action="/runninglife/contest/">
			<div>
				<label>搜尋 <select class="selectpicker" id="year" name="year">
						<option value="0">年</option>
						<option value="2000">列出全部</option>
						<option value="2016">2016</option>
						<option value="2017">2017</option>
				</select>
				</label><select class="selectpicker hidden" id="month" name="month">
					<option value="0">月</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select> <input class="hidden" id="dateQuery" type="submit" value="查詢" />
			</div>
		</form>

		<c:forEach var="contest" items="${contests}">
			<br>
			<div class="col-lg-9 col-md-9 col-sm-9">
				<div class="col-lg-2 col-md-2 col-sm-3 col-xs-3 nopadding-right">
					<a href="/runninglife/contest/${contest.contestID}" target="_blank"><img
						class="img-responsive thumbnail"
						src="/runninglife/resources/${contest.contestPhotoPath}"></a>
				</div>
				<div class="col-lg-10 col-md-10 col-sm-9 col-xs-9 margin-bottom-0">
					<div class="size-17 contest${contest.contestID} ">
						<span
							class="label ${contest.start ? 'label-success size-15' : 'label label-default'}">${contest.start ? '開放報名' : '結束報名'}</span>
						<a class="text-muted"
							href="/runninglife/contest/${contest.contestID}" target="_blank">${contest.contestName}</a>
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
					class="col-lg-10 col-md-10 col-sm-9 col-xs-9 margin-bottom-10 hidden-sm hidden-xs">${contest.goal}</div>
				<div class="col-lg-10 col-md-10 col-sm-9 col-xs-12">
					<a href="contest/${contest.contestID}"
						class="btn btn-3d btn-xs btn-reveal btn-red" target="_blank"><i
						class="fa fa-info-circle"></i><span class="size-14">簡章</span></a><span
						class="text-danger"> 報名時間：${contest.begin} ~ ${contest.end}</span>
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="divider margin-top-0 margin-bottom-10"></div>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3">
				<a href="/runninglife/contest/edit?id=${contest.contestID}"
					class="btn btn-info edit" role="button"">編輯</a>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3">
				<a href="/runninglife/contest/${contest.contestID}/delete"
					class="btn btn-danger  delete" role="button" data-text="真的要刪除此賽事嗎?"
					data-confirm-button="是的" data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a>
			</div>

		</c:forEach>
		<div class="col-lg-10 col-md-10 col-sm-9 col-xs-9 ">
			<ul class="text-center" id="pagination" class="pagination-sm"></ul>
		</div>
		<div class="col-lg-10 col-md-10 col-sm-9 col-xs-9 text-center">
			<ul class="text-center" id="pagination-query" class="pagination-sm"></ul>
		</div>


	</div>

	</section>
	<script></script>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="/runninglife/resources/js/jquery.confirm.min.js"></script>
<script src="/runninglife/resources/js/bootstrap.min.js"></script>
<script src="/runninglife/resources/js/jquery.twbsPagination.js"></script>
<script>
	$(document).ready(auth());
	function auth() {
		if ($('#auth').text() == 1) {
			$("#auth").addClass("hidden");
		}
	}
	//隱藏刪除編輯按鈕分頁	
	$(function() {
		if ($('#auth').text() != "admin") {
			$('.delete').addClass("hidden");
			$('.edit').addClass("hidden");
		}
		var year = getParameterByName('year');
		var month = getParameterByName('month');
		console.log('result:' + year + '/' + month);
		if (getParameterByName('year') && getParameterByName('month')) {
			$('#pagination').addClass("hidden");
		} else {
			$('#pagination-query').addClass("hidden");
		}

		$('#year').change(function() {
			
			if ($('#year').val() == 2000) {
				window.location.href = "/runninglife/contest";
				return;
			} else if ($('#year').val() != 0 && $('#month').val() != 0) {
				$('#queryContest').submit();
			}
			$('#month').removeClass('hidden');
		});

		$('#month').change(function() {
			console.log(year);
			console.log(month);
			if ($('#year').val() != 0 && $('#month').val() != 0) {
				$('#queryContest').submit();
			}

		});
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
	// 	    confirm: function(button) {
	// 	        delete();
	// 	    },
	// 	    cancel: function(button) {
	// 	        // nothing to do
	// 	    },
	//     confirmButton: "Yes I am",
	//     cancelButton: "No",
	//     post: true,
	//     confirmButtonClass: "btn-danger",
	//     cancelButtonClass: "btn-default",
	//     dialogClass: "modal-dialog modal-lg" // Bootstrap classes for large modal
	// });

	// 	$('#queryContest').submit(function(e) {
	// 		e.preventDefault();
	// 		$.ajax({
	// 			mimeType : "text/html; charset=UTF-8", //alert可以show出物件內容
	// 			type : "POST",
	// 			url : "/runninglife/contest/search",
	// 			 		data : {
	// 			 			id : teamID
	// 			 		},
	// 			 		success : function(data) {
	// 			 			alert(data)
	// 			 			teamRow.remove();
	// 			 		}
	// 		});

	// 	});
	//日期搜尋
	//分個頁
	$('#pagination').twbsPagination({
		totalPages : $('#countPage').text(),
		visiblePages : $('#countPage').text(),
		href : '?page={{pageNumber}}',
		hrefVariable : '{{pageNumber}}',
	});
	$('#pagination-query').twbsPagination(
			{
				totalPages : $('#countPage').text(),
				visiblePages : $('#countPage').text(),
				href : (window.location.href + '&page={{pageNumber}}')
						.substring(0,
								(window.location.href + '&page={{pageNumber}}')
										.indexOf("page"))
						+ 'page={{pageNumber}}',
				hrefVariable : '{{pageNumber}}',
				first : '第一頁',
				prev : '上一頁',
				next : '下一頁',
				last : '最後一頁'
			});
	//js拿取queryStr
	function getParameterByName(name, url) {
		if (!url)
			url = window.location.href;
		name = name.replace(/[\[\]]/g, "\\$&");
		var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"), results = regex
				.exec(url);
		if (!results)
			return null;
		if (!results[2])
			return '';
		return decodeURIComponent(results[2].replace(/\+/g, " "));
	}
</script>
</html>