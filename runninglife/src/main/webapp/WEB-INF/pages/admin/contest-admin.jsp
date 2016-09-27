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
					<ul class="nav navbar-nav side-nav" style="position: absolute;left: 0%;height: 1000px">
						<li><a href="charts.html"><i class="fa fa-fw fa fa-money"></i>刊登廣告</a>
						</li>
						<li><a href="tables.html"><i class="fa fa-fw fa-table"></i>賽事編輯</a>
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
					<div class="col-lg-12">
						<jsp:include page="${request.contextPath}/admin/contest/data" />
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
