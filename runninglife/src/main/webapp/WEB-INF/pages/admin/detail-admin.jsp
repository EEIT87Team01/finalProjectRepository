<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>編輯賽事資訊</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/resources/css/sb-admin.css"/>"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="<c:url value="/resources/css/plugins/morris.css"/>"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">



		<div id="page-wrapper">
			<!-- Navigation -->
			<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">SB Admin</a>
				</div>
				<!-- Top Menu Items -->
				<ul class="nav navbar-right top-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-envelope"></i> <b
							class="caret"></b></a>
						<ul class="dropdown-menu message-dropdown">
							<li class="message-preview"><a href="#">
									<div class="media">
										<span class="pull-left"> <img class="media-object"
											src="http://placehold.it/50x50" alt="">
										</span>
										<div class="media-body">
											<h5 class="media-heading">
												<strong>John Smith</strong>
											</h5>
											<p class="small text-muted">
												<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
											</p>
											<p>Lorem ipsum dolor sit amet, consectetur...</p>
										</div>
									</div>
							</a></li>
							<li class="message-preview"><a href="#">
									<div class="media">
										<span class="pull-left"> <img class="media-object"
											src="http://placehold.it/50x50" alt="">
										</span>
										<div class="media-body">
											<h5 class="media-heading">
												<strong>John Smith</strong>
											</h5>
											<p class="small text-muted">
												<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
											</p>
											<p>Lorem ipsum dolor sit amet, consectetur...</p>
										</div>
									</div>
							</a></li>
							<li class="message-preview"><a href="#">
									<div class="media">
										<span class="pull-left"> <img class="media-object"
											src="http://placehold.it/50x50" alt="">
										</span>
										<div class="media-body">
											<h5 class="media-heading">
												<strong>John Smith</strong>
											</h5>
											<p class="small text-muted">
												<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
											</p>
											<p>Lorem ipsum dolor sit amet, consectetur...</p>
										</div>
									</div>
							</a></li>
							<li class="message-footer"><a href="#">Read All New
									Messages</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-bell"></i> <b
							class="caret"></b></a>
						<ul class="dropdown-menu alert-dropdown">
							<li><a href="#">Alert Name <span
									class="label label-default">Alert Badge</span></a></li>
							<li><a href="#">Alert Name <span
									class="label label-primary">Alert Badge</span></a></li>
							<li><a href="#">Alert Name <span
									class="label label-success">Alert Badge</span></a></li>
							<li><a href="#">Alert Name <span
									class="label label-info">Alert Badge</span></a></li>
							<li><a href="#">Alert Name <span
									class="label label-warning">Alert Badge</span></a></li>
							<li><a href="#">Alert Name <span
									class="label label-danger">Alert Badge</span></a></li>
							<li class="divider"></li>
							<li><a href="#">View All</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
							</li>
							<li><a href="#"><i class="fa fa-fw fa-envelope"></i>
									Inbox</a></li>
							<li><a href="#"><i class="fa fa-fw fa-gear"></i>
									Settings</a></li>
							<li class="divider"></li>
							<li><a href="#"><i class="fa fa-fw fa-power-off"></i>
									Log Out</a></li>
						</ul></li>
				</ul>
				<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav side-nav"
						style="position: absolute; left: 0%; height: 1000px">
						<li class="active"><a href="index.html"><i
								class="fa fa-fw fa-bar-chart-o"></i>統計報表</a></li>
						<li><a href="charts.html"><i
								class="fa fa-fw fa-space-shuttle"></i>挑戰編輯</a></li>
						<li><a href="charts.html"><i class="fa fa-fw fa fa-money"></i>刊登廣告</a>
						</li>
						<li><a href="tables.html"><i class="fa fa-fw fa-table"></i>賽事編輯</a>
						</li>
						<li><a href="forms.html"><i class="fa fa-fw fa-edit"></i>文章編輯</a>
						</li>
						<li><a href="bootstrap-elements.html"><i
								class="fa fa-fw fa-desktop"></i>處理檢舉</a></li>
						<li><a href="bootstrap-grid.html"><i
								class="fa fa-fw fa-wrench"></i> Bootstrap Grid</a></li>
						<li><a href="javascript:;" data-toggle="collapse"
							data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i>維護使用者<i
								class="fa fa-fw fa-caret-down"></i></a>
							<ul id="demo" class="collapse">
								<li><a href="#">維護管理員</a></li>
								<li><a href="#">維護駐台作家</a></li>
							</ul></li>
						<li><a href="blank-page.html"><i class="fa fa-fw fa-file"></i>
								Blank Page</a></li>
						<li><a href="index-rtl.html"><i
								class="fa fa-fw fa-dashboard"></i> RTL Dashboard</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</nav>
			<!-- 內容開始 -->





			<div class="container">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							賽事修改</small>
						</h1>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<jsp:include
							page="${request.contextPath}/admin/contest/${contest.contestID}/data" />
					</div>
				</div>
				<!-- /.row -->


			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="<c:url value="/resources/js/jquery.js"/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

	<!-- Morris Charts JavaScript -->
	<script
		src="<c:url value="/resources/js/plugins/morris/raphael.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/plugins/morris/morris.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/plugins/morris/morris-data.js"/>"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/jquery.countdown.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.confirm.min.js"/>"></script>
	<script src="<c:url value="/resources/js/time.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.countdown.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>
	<script type="text/javascript">
		// 	$('#eventForm').ajaxForm({
		// 		type : 'post',
		// 		contentType: "application/jason;charset=UTF-8",
		// 		success : processJson,
		// 		processData : false,
		// 		dataType : 'json'
		// 	});
		function processJson(data) {
			//debugger;
			alert(data);
			console.log("respose: " + data);
		}
		var eventID;
		var eventRow;
		var eventMark = $('#contestID');
		var teamMark = $('#contestID');
		$(function() {

			//項目刪除按鈕綁定
			$("#eventBody").on(
					"click",
					".btn-danger",
					function() {
						eventID = $(this).parent().parent()
								.children(".eventID").text();
						console.log($(this).attr("id"));
						eventRow = $(this).parent().parent();
					});
			$(".eventDelete")
					.confirm(
							{
								post : true,
								confirmButtonClass : "btn-danger btn-sm",
								cancelButtonClass : "btn-default btn-sm",
								dialogClass : "modal-dialog modal-sm", // Bootstrap classes for large modal
								confirm : function(button) {
									// 								console.log("確認刪除!");
									$
											.ajax({
												mimeType : "text/html; charset=UTF-8", //alert可以show出物件內容
												type : "POST",
												url : "${pageContext.request.contextPath}/event/delete",
												data : {
													id : eventID
												},
												contentType : "application/x-www-form-urlencoded;charset=UTF-8",
												success : function(data) {
													alert(data)
													eventRow.remove();
												}
											});
								},
								cancel : function(button) {
									// 								console.log("取消刪除");
								}
							});
			//項目更新按鈕榜定
			$("#eventBody").on(
					"click",
					".btn-warning",
					function() {
						if (eventMark.length) {
							eventMark.parent().parent().removeClass("warning");
						}
						var eventID = $(this).parent().parent().children(
								"td:nth-child(1)").text();
						var eventName = $(this).parent().parent().children(
								"td:nth-child(2)").text();
						var distance = $(this).parent().parent().children(
								"td:nth-child(3)").text();
						var fee = $(this).parent().parent().children(
								"td:nth-child(4)").text();
						var quota = $(this).parent().parent().children(
								"td:nth-child(5)").text();
						var whenToRun = $(this).parent().parent().children(
								"td:nth-child(6)").text();
						var limitTime = $(this).parent().parent().children(
								"td:nth-child(7)").text();
						$(this).parent().parent().addClass("warning");
						console.log("eventID:" + eventID);

						eventMark = $(this);
						$('#eventID').val(eventID);
						$('#eventName').val(eventName);
						$('#distance').val(distance);
						$('#fee').val(fee);
						$('#quota').val(quota);
						$('#whenToRun').val(whenToRun);
						$('#limitTime').val(limitTime);

						$('#eventName').focus();

					})
			var teamRow;
			var teamID;
			//分組刪除按鈕綁定
			$("#teamBody").on("click", ".btn-danger", function() {
				teamID = $(this).parent().parent().children(".teamID").text();
				teamRow = $(this).parent().parent();
			});
			$(".teamDelete").confirm({
				post : true,
				confirmButtonClass : "btn-danger btn-sm",
				cancelButtonClass : "btn-default btn-sm",
				dialogClass : "modal-dialog modal-sm", // Bootstrap classes for large modal
				confirm : function(button) {
					console.log("確認刪除!");
					$.ajax({
						mimeType : "text/html; charset=UTF-8", //alert可以show出物件內容
						type : "POST",
						url : "${pageContext.request.contextPath}/team/delete",
						data : {
							id : teamID
						},
						success : function(data) {
							alert(data)
							teamRow.remove();
						}
					});
				},
				cancel : function(button) {
					console.log("取消刪除");
				}
			});
			//分組更新按鈕榜定
			$("#teamBody").on(
					"click",
					".btn-warning",
					function() {
						if (teamMark.length) {
							teamMark.parent().parent().removeClass("warning");
						}

						var teamID = $(this).parent().parent().children(
								'td:nth-child(1)').text();
						var teamName = $(this).parent().parent().children(
								'td:nth-child(2)').text();
						var ageRange = $(this).parent().parent().children(
								'td:nth-child(3)').text().substr(0, 2);

						$(this).parent().parent().addClass("warning");

						teamMark = $(this);
						$('#teamID').val(teamID);
						$('#teamName').val(teamName);
						$('#ageRange').val(ageRange);

						$('#teamName').focus();

					})
			$('#runnerTable').DataTable({

				"lengthMenu" : [ [ 5, 10, 15, -1 ], [ 5, 10, 15, "全部" ] ],
				"language" : {
					"info" : "",
					"infoEmpty" : "沒有資料",
					"infoFiltered" : "",
					"zeroRecords" : "沒有符合的結果",
					"lengthMenu" : "顯示 _MENU_ 筆資料",
					"search" : "搜尋",
					"paginate" : {
						"first" : "首頁",
						"previous" : "上一頁",
						"next" : "下一頁",
						"last" : "尾頁"
					}
				}

			});
			$('#myContestTable').DataTable({

				"lengthMenu" : [ [ 5, 10, 15, -1 ], [ 5, 10, 15, "全部" ] ],
				"language" : {
					"info" : "",
					"infoEmpty" : "沒有資料",
					"infoFiltered" : "",
					"zeroRecords" : "沒有符合的結果",
					"lengthMenu" : "顯示 _MENU_ 筆資料",
					"search" : "搜尋",
					"paginate" : {
						"first" : "首頁",
						"previous" : "上一頁",
						"next" : "下一頁",
						"last" : "尾頁"
					}
				}

			});
			//成績查詢
			// 		$('#querySubmit').on(
			// 				"click",
			// 				function() {

			// 					var contestID = $("#contestID").text();
			// 					var eventItem = $('#select_eventItem').val();
			// 					var teamItem = $('#select_teamItem').val();

			// 					if (eventItem != 0 && teamItem != 0) {
			// 						console.log(eventItem);
			// 						console.log(teamItem);

			// 								$('#testTable').dataTable().fnDestroy();
			// 								$('#testTable').DataTable(
			// 										{
			// 											"ajax" : {
			// 												url : "/runninglife/api/score/"
			// 														+ contestID + "/" + eventItem
			// 														+ "/" + teamItem,
			// 												// 									url : "/runninglife/resources/abc.txt",
			// 												dataSrc : ''
			// 											},
			// 											// 				rowId: 'pk.memberID',
			// 											"processing" : false,
			// 											// 								"serverSide" : true,
			// 											"columns" : [ {
			// 												data : 'pk.memberID'
			// 											}, {
			// 												data : 'event.eventName'
			// 											}, {
			// 												data : 'team.teamName'
			// 											}, {
			// 												data : 'runTime'
			// 											}, {
			// 												data : 'runTime'
			// 											} ],
			// 											"order" : [ [ 4, "asc" ] ],
			// 											"lengthMenu" : [ [ 5, 10, 15, -1 ],
			// 													[ 5, 10, 15, "全部" ] ],
			// 											"language" : {
			// 												"info" : "",
			// 												"infoEmpty" : "沒有資料",
			// 												"infoFiltered" : "",
			// 												"zeroRecords" : "沒有符合的結果",
			// 												"lengthMenu" : "顯示 _MENU_ 筆資料",
			// 												"search" : "搜尋",
			// 												"paginate" : {
			// 													"first" : "首頁",
			// 													"previous" : "上一頁",
			// 													"next" : "下一頁",
			// 													"last" : "尾頁"
			// 												}
			// 											}

			// 										});
			// 							}
			// 				})

			//自動搜尋
			var contestID = $("#contestID").text();
			var eventItem = $('#select_eventItem').val();
			var teamItem = $('#select_teamItem').val();
			$('#select_eventItem')
					.change(
							function() {
								eventItem = $('#select_eventItem').val();
								teamItem = $('#select_teamItem').val();
								if (eventItem != 0 && teamItem != 0) {
									$('#testTable').dataTable().fnDestroy();
									$('#testTable')
											.DataTable(
													{
														"ajax" : {
															url : "${pageContext.request.contextPath}/api/score/"
																	+ contestID
																	+ "/"
																	+ eventItem
																	+ "/"
																	+ teamItem,
															// 									url : "/runninglife/resources/abc.txt",
															dataSrc : ''
														},
														// 				rowId: 'pk.memberID',
														"processing" : false,
														// 								"serverSide" : true,
														"columns" : [
																{
																	data : 'pk.memberID'
																},
																{
																	data : 'event.eventName'
																},
																{
																	data : 'team.teamName'
																},
																{
																	data : 'runTime'
																},
																{
																	data : 'runTime'
																} ],
														"order" : [ [ 4, "asc" ] ],
														"lengthMenu" : [
																[ 5, 10, 15, -1 ],
																[ 5, 10, 15,
																		"全部" ] ],
														"language" : {
															"info" : "",
															"infoEmpty" : "沒有資料",
															"infoFiltered" : "",
															"zeroRecords" : "沒有符合的結果",
															"lengthMenu" : "顯示 _MENU_ 筆資料",
															"search" : "搜尋",
															"paginate" : {
																"first" : "首頁",
																"previous" : "上一頁",
																"next" : "下一頁",
																"last" : "尾頁"
															}
														}

													});
								}
							});

			$('#select_teamItem')
					.change(
							function() {
								eventItem = $('#select_eventItem').val();
								teamItem = $('#select_teamItem').val();

								if (eventItem != 0 && teamItem != 0) {

									$('#testTable').dataTable().fnDestroy();
									$('#testTable')
											.DataTable(
													{
														"ajax" : {
															url : "${pageContext.request.contextPath}/api/score/"
																	+ contestID
																	+ "/"
																	+ eventItem
																	+ "/"
																	+ teamItem,
															// 									url : "/runninglife/resources/abc.txt",
															dataSrc : ''
														},
														// 				rowId: 'pk.memberID',
														"processing" : false,
														// 								"serverSide" : true,
														"columns" : [
																{
																	data : 'pk.memberID'
																},
																{
																	data : 'event.eventName'
																},
																{
																	data : 'team.teamName'
																},
																{
																	data : 'runTime'
																},
																{
																	data : 'runTime'
																} ],
														"order" : [ [ 4, "asc" ] ],
														"lengthMenu" : [
																[ 5, 10, 15, -1 ],
																[ 5, 10, 15,
																		"全部" ] ],
														"language" : {
															"info" : "",
															"infoEmpty" : "沒有資料",
															"infoFiltered" : "",
															"zeroRecords" : "沒有符合的結果",
															"lengthMenu" : "顯示 _MENU_ 筆資料",
															"search" : "搜尋",
															"paginate" : {
																"first" : "首頁",
																"previous" : "上一頁",
																"next" : "下一頁",
																"last" : "尾頁"
															}
														}

													});
								}
							});

			//報名驗證	
			$('#runnerForm')
					.submit(
							function(e) {
								if ($('#runnerForm > div:nth-child(6) > select')
										.val() == 0) {
									alert('請選擇比賽項目!');
									e.preventDefault();
								} else if ($(
										'#runnerForm > div:nth-child(7) > select')
										.val() == 0) {
									alert('請選擇紀念衣尺寸!');
									e.preventDefault();
								}
							})

			var status = getParameterByName("status");
			if (status == "fail") {
				alert("報名失敗");
				window.location.href = "${pageContext.request.contextPath}/contest/${contest.contestID}";
				return;
			} else if (status == "success") {
				alert("報名成功，請到信箱查看繳費資訊。");
				window.location.href = "${pageContext.request.contextPath}/contest/${contest.contestID}";
			}

		});

		//轉成json函式
		(function($) {
			$.fn.serializeFormJSON = function() {

				var o = {};
				var a = this.serializeArray();
				$.each(a, function() {
					if (o[this.name]) {
						if (!o[this.name].push) {
							o[this.name] = [ o[this.name] ];
						}
						o[this.name].push(this.value || "");
					} else {
						o[this.name] = this.value || "";
					}
				});
				return o;
			};
		})(jQuery);
		//送出分組
		$('#teamForm').submit(
				function(e) {
					e.preventDefault();
					var JsonObj = $(this).serializeFormJSON();
					var JsonStr = JSON.stringify(JsonObj);
					var contestID = $("#contestID").text();
					// 		alert(JsonStr);

					if ($('#teamName').val() == ""
							|| $('#ageRange').val() == "") {
						alert("請輸入完整資料");
					} else if ($.trim($('#teamID').val()) == "") {
						// 			alert('新增');
						$.ajax({
							type : "POST",
							url : "${pageContext.request.contextPath}/"
									+ contestID + "/team/add",
							contentType : "application/json",
							data : JsonStr,
							mimeType : "application/json; charset=UTF-8",
							success : addTeam
						});
					} else {
						// 			alert("更新");
						$.ajax({
							type : "POST",
							url : "${pageContext.request.contextPath}/"
									+ contestID + "/team/add",
							contentType : "application/json",
							data : JsonStr,
							mimeType : "application/json; charset=UTF-8",
							success : updateTeam
						});
					}
				})
		function addTeam(team) {
			var upper = team.ageRange + 9;
			alert("新增成功");
			$('#teamForm')
					.parent()
					.before(
							'<tr><td class="teamID">'
									+ team.teamID
									+ '</td><td>'
									+ team.teamName
									+ '</td><td>'
									+ team.ageRange
									+ '~'
									+ upper
									+ '</td><td><a class="btn btn-danger  delete" role="button"data-text="真的要刪除此項目嗎?" data-confirm-button="是的"data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a></td></tr>');

			$('#teamID').val("");
			$('#teamName').val("");
			$('#ageRange').val("");
		}
		function updateTeam(team) {
			alert("更新成功");
			teamMark.parent().parent().children('td:nth-child(2)').text(
					team.teamName);
			teamMark.parent().parent().children('td:nth-child(3)').text(
					team.ageRange + "~" + (team.ageRange));
			teamMark.parent().parent().removeClass("warning");

			$('#teamID').val("");
			$('#teamName').val("");
			$('#ageRange').val("");
		}

		//送出項目
		$('#eventForm')
				.submit(
						function(e) {
							e.preventDefault();
							if ($('#eventName').val() == "") {
								alert("請輸入名稱");
							} else if ($('#distance').val() == "") {
								alert("請輸入距離");
							} else if ($('#fee').val() == "") {
								alert("請輸入報名費用");
							} else if ($('#quota').val() == "") {
								alert("請輸入開放名額");
							} else if ($('#whenToRun').val() == "") {
								alert("請輸入起跑時間");
							} else if ($('#limitTime').val() == "") {
								alert("請輸入限制時間");
							}

							var data = $(this).serializeFormJSON();
							var data2 = JSON.stringify(data);

							console.log(data.eventName);
							console.log(data.whenToRun);
							console.log(data.distance);
							console.log(data.quota);
							console.log(data2);

							if ($.trim($('#eventID').val()) == "") {
								alert("新增");
								$
										.ajax({
											type : "POST",
											url : "${pageContext.request.contextPath}/${contest.contestID}/event/add",
											contentType : "application/json",
											data : data2,
											mimeType : "application/json; charset=UTF-8",
											success : addEvent
										});
							} else {
								alert("更新");
								$
										.ajax({
											type : "POST",
											url : "${pageContext.request.contextPath}/${contest.contestID}/event/add",
											contentType : "application/json",
											data : data2,
											mimeType : "application/json; charset=UTF-8",
											success : updateEvent
										});

							}

						});
		function addEvent(event) {
			alert("更新成功")
			$('#eventForm')
					.parent()
					.before(
							'<tr><td>'
									+ event.eventID
									+ '</td><td>'
									+ event.eventName
									+ '</td><td>'
									+ event.distance
									+ 'km</td><td>$'
									+ event.fee
									+ '</td><td>'
									+ event.quota
									+ '</td><td>'
									+ event.whenToRun
									+ '</td><td>'
									+ event.limitTime
									+ '</td><td><a id="/runninglife/event/'
									+ event.eventID
									+ '/delete"class="btn btn-danger  delete" role="button"data-text="真的要刪除此項目嗎?" data-confirm-button="是的"data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a></td>'
									+ '<td><a class="btn btn-warning  delete" role="button">修改</a></td></tr>');

			$('#eventID').val("");
			$('#even' + 'tName').val("");
			$('#distance').val("");
			$('#fee').val("");
			$('#quota').val("");
			$('#limitTime').val("");
			$('#whenToRun').val("");
		}
		function updateEvent(event) {
			alert("更新成功");
			eventMark.parent().parent().children("td:nth-child(1)").text(
					event.eventID);
			eventMark.parent().parent().children("td:nth-child(2)").text(
					event.eventName);
			eventMark.parent().parent().children("td:nth-child(3)").text(
					event.distance);
			eventMark.parent().parent().children("td:nth-child(4)").text(
					event.fee);
			eventMark.parent().parent().children("td:nth-child(5)").text(
					event.quota);
			eventMark.parent().parent().children("td:nth-child(6)").text(
					event.whenToRun);
			eventMark.parent().parent().children("td:nth-child(7)").text(
					event.limitTime);
			eventMark.parent().parent().removeClass("warning");

			$('#eventID').val("");
			$('#even' + 'tName').val("");
			$('#distance').val("");
			$('#fee').val("");
			$('#quota').val("");
			$('#limitTime').val("");
			$('#whenToRun').val("");
		}

		$("#applyLink").on("click", function() {

			if ($('#runnerForm > div:nth-child(4) > input').val() == "") {
				window.location.replace("<c:url value="/index.jsp"/>");
			} else {
				document.getElementById('applyForm').style.display = "block";
			}

		})

		//Function To Display Popup
		function div_show() {
			document.getElementById('applyForm').style.display = "block";
		}
		//Function to Hide Popup
		function div_hide() {
			document.getElementById('applyForm').style.display = "none";
		}
		// 	$(".delete").confirm({
		// 		post : true,
		// 		confirmButtonClass : "btn-danger btn-sm",
		// 		cancelButtonClass : "btn-default btn-sm",
		// 		dialogClass : "modal-dialog modal-sm", // Bootstrap classes for large modal
		// 		confirm: function(button) {

		// 		    },
		// 		cancel: function(button) {
		// 		        // nothing to do
		// 		    }
		// 	});
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

</body>

</html>
