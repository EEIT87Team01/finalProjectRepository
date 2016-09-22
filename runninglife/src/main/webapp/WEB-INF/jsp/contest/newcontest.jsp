<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
					<ul class="nav navbar-nav side-nav">
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
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> Dashboard
							</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-8">
						<spring:url value="/contest/${contest.contestID}"
							var="updateContest" />
						<spring:url value="/contest/edit" var="addContest" />

						<form:form class="form-horizontal" method="post"
							acceptCharset="UTF-8" modelAttribute="contest"
							enctype="multipart/form-data" action="${addContest}">

							<form:hidden path="contestID" />

							<spring:bind path="contestName">
								<div
									class="form-group ${status.error ? 'has-error' : 'has-success'}">
									<label class="col-sm-2 control-label">賽事名稱</label>
									<div class="col-sm-10">
										<form:input path="contestName" type="text"
											class="form-control" id="contestName" placeholder="" />
										<form:errors path="contestName" class="control-label" />
									</div>
								</div>
							</spring:bind>

							<spring:bind path="startDate">
								<div
									class="form-group ${status.error ? 'has-error' : 'has-success'}">
									<label class="col-sm-2 control-label">比賽日期</label>
									<div class="col-sm-10">
										<form:input path="startDate" class="form-control"
											id="startDate" placeholder="2016-09-30" />
										<form:errors path="startDate" class="control-label" />
									</div>
								</div>
							</spring:bind>

							<spring:bind path="place">
								<div
									class="form-group ${status.error ? 'has-error' : 'has-success'}">
									<label class="col-sm-2 control-label">比賽地點</label>
									<div class="col-sm-10">
										<form:input path="place" class="form-control" id="place"
											placeholder="台北市政府捷運站" />
										<form:errors path="place" class="control-label" />
									</div>
								</div>
							</spring:bind>

							<%-- 			<spring:bind path="contestPhotoPath"> --%>
							<%-- 				<div class="form-group ${status.error ? 'has-error' : ''}"> --%>
							<!-- 					<label class="col-sm-2 control-label">圖片</label> -->
							<!-- 					<div class="col-sm-10"> -->
							<%-- 						<form:input path="contestPhotoPath" class="form-control" --%>
							<%-- 							id="contestPhotoPath" placeholder="1.jpg" /> --%>
							<%-- 						<form:errors path="contestPhotoPath" class="control-label" /> --%>
							<!-- 					</div> -->
							<!-- 				</div> -->
							<%-- 			</spring:bind> --%>

							<spring:bind path="registrationBegin">
								<div
									class="form-group ${status.error ? 'has-error' : 'has-success'}">
									<label class="col-sm-2 control-label">報名開始</label>
									<div class="col-sm-10">
										<form:input path="registrationBegin" rows="5"
											class="form-control" id="registrationBegin"
											placeholder="2016-03-14" cssErrorClass="" />
										<form:errors path="registrationBegin" class="control-label" />
									</div>
								</div>
							</spring:bind>

							<spring:bind path="registrationEnd">
								<div
									class="form-group ${status.error ? 'has-error' : 'has-success'}">
									<label class="col-sm-2 control-label">報名截止</label>
									<div class="col-sm-10">
										<form:input path="registrationEnd" rows="5"
											class="form-control" id="registrationEnd"
											placeholder="2016-07-14" cssErrorClass="" />
										<form:errors path="registrationEnd" class="control-label" />
									</div>
								</div>
							</spring:bind>

							<spring:bind path="organizer">
								<div
									class="form-group ${status.error ? 'has-error' : 'has-success'}">
									<label class="col-sm-2 control-label">主辦單位</label>
									<div class="col-sm-10">
										<form:textarea path="organizer" rows="5" class="form-control"
											id="organizer" placeholder="主辦單位" />
										<form:errors path="organizer" class="control-label" />
									</div>
								</div>
							</spring:bind>
							<spring:bind path="coorganizer">
								<div
									class="form-group ${status.error ? 'has-error' : 'has-success'}">
									<label class="col-sm-2 control-label">協辦單位</label>
									<div class="col-sm-10">
										<form:textarea path="coorganizer" rows="5"
											class="form-control" id="coorganizer" placeholder="協辦單位" />
										<form:errors path="coorganizer" class="control-label" />
									</div>
								</div>
							</spring:bind>

							<spring:bind path="goal">
								<div
									class="form-group ${status.error ? 'has-error' : 'has-success'}">
									<label class="col-sm-2 control-label">活動宗旨</label>
									<div class="col-sm-10">
										<form:textarea path="goal" rows="5" class="form-control"
											id="goal" placeholder="活動宗旨" />
										<form:errors path="goal" class="control-label" />
									</div>
								</div>
							</spring:bind>

							<spring:bind path="contestPhotoPath">
								<div
									class="form-group ${status.error ? 'has-error' : 'has-success'} hidden">
									<label class="col-sm-2 control-label">圖片</label>
									<div class="col-sm-10">
										<form:input path="contestPhotoPath" rows="5"
											class="form-control" id="goal" placeholder="圖片檔案" />
										<form:errors path="contestPhotoPath" class="control-label" />
									</div>
								</div>
							</spring:bind>

							<div
								class="form-group ${status.error ? 'has-error' : 'has-success'}">
								<label class="col-sm-2 control-label">封面</label>
								<div class="col-sm-10">
									<input class="form-control" type="file" id="fileUpload"
										name=fileUpload />
									<%-- 						<form:errors path="*" class="control-label" /> --%>
								</div>
								<label class="col-sm-2 control-label">橫幅</label>
								<div class="col-sm-10">
									<input class="form-control" type="file" id="fileUpload"
										name=fileUpload />
								</div>
								<label class="col-sm-2 control-label">路徑圖</label>
								<div class="col-sm-10">
									<input class="form-control" type="file" id="fileUpload"
										name=fileUpload />
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn-md btn-primary pull-right">確定
									</button>
								</div>
							</div>
						</form:form>
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

</body>

</html>
