
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>後端檢舉頁面</title>
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/static/images/icon.png">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/css/server/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/css/server/sb-admin.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/font-awesome/server/css/font-awesome.min.css">

</head>




<body>


	<div id="wrapper">

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
			<a class="navbar-brand" href="index.html">RunningLife後台</a>
		</div>
		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><i class="fa fa-envelope"></i> <b
					class="caret"></b></a>
				<ul class="dropdown-menu message-dropdown">
					<li class="message-preview">
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
					</li>
					<li class="message-preview">
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
					</li>
					<li class="message-preview">
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
					</li>
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
					<li><a href="#">Alert Name <span class="label label-info">Alert
								Badge</span></a></li>
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
					<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a></li>
					<li><a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
					</li>
					<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
					</li>
					<li class="divider"></li>
					<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
							Out</a></li>
				</ul></li>
		</ul>
		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav">
				<li><a href="<%=request.getContextPath()%>/AdminLogin/CreateWriterPage.do"><i class="fa fa-fw fa-bar-chart-o"></i> 維護駐台作家</a></li>
				<li ><a href="<%=request.getContextPath()%>/ads/adList.do"><i	class="fa fa-fw fa-table"></i> 廣告設置</a></li><li><a href="forms.html">
				<i class="fa fa-fw fa-edit"></i>活動賽事</a></li>
				<li class="active"><a href="../reportController/reportList.do"><i class="fa fa-fw fa-desktop"></i>檢舉審核</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse --> </nav>
<div id="page-wrapper">
<!-- 			<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"> -->
<!-- 			  Launch demo modal -->
<!-- 			</button> -->
			<div class="container-fluid">
				<div class="col-lg-12">
					<h1 class="page-header">檢舉審核</h1>
				</div>
				

				<ul class="nav nav-pills" style='text-align:center'>
				   <li role="presentation" id="btn_not"><a href="#">尚未處理</a></li>
				   <li role="presentation" id="btn_fin"><a href="#">處理完成</a></li>
				</ul>
				
				
				
				<div class="col-lg-12">
<!-- 					<input type="button" id="btn_not" name="report_not" class="btn btn-sm btn-default" value="尚未處理"> -->
<!-- 					<input type="button" id="btn_fin" name=report_finish class="btn btn-sm btn-default" value="處理完成"> -->
				<div id="div_untreated" class="table-responsive">
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>處理狀態</th>
								<th>檢舉時間</th>
								<th>文章ID</th>
								<th>檢舉人ID</th>
								<th>檢舉原因</th>
								<th>處理狀況</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="untreatedReportList" items="${untreatedReportListVO}">
								<c:if test="${untreatedReportList.status==0}">
									<c:set var="label" value="未處理" />
								</c:if>
								<c:if test="${untreatedReportList.status!=0}">
									<c:set var="label" value="處理完成" />
								</c:if>
								<tr>
									<td>${label}</td>
									<td><span class="td_URL_time">${untreatedReportList.time}</span></td>
									<td><span class="td_URL_postID">${untreatedReportList.reportListPK.postID}</span></td>
									<td><span class="td_URL_reporterID">${untreatedReportList.reportListPK.reporterID}</span></td>
									<td><span class="td_URL_comment">${untreatedReportList.comment}</span></td>
									<td>
										<div class="form-group">
											<select class="status">
												<option class="option" value="1">審核通過</option>
												<option class="option" value="2">禁止發言三天</option>
												<option class="option" value="3">停權</option>
											</select>
										</div>
									</td>
								<c:if test="${untreatedReportList.status==0}">
									<td style="text-align: center"><button name="report_submit" class="btn btn-sm btn-default btn_submit">送出</button></td>
								</c:if>			
								</tr>			
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div id="div_finish" class="table-responsive" style="display:none;">
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>處理狀態</th>
								<th>檢舉時間</th>
								<th>文章ID</th>
								<th>檢舉人ID</th>
								<th>檢舉原因</th>
								<th>處理狀況</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="finishReportList" items="${finishReportListVO}">
								<c:if test="${finishReportList.status==0}">
									<c:set var="label" value="未處理" />
								</c:if>
								<c:if test="${finishReportList.status!=0}">
									<c:set var="label" value="處理完成" />
								</c:if>
								<tr>
									<td>${label}</td>
									<td><span  class="td_FRL_time">${finishReportList.time}</span></td>
									<td><span  class="td_FRL_postID">${finishReportList.reportListPK.postID}</span></td>
									<td><span  class="td_FRL_reporterID">${finishReportList.reportListPK.reporterID}</span></td>
									<td><span  class="td_FRL_comment">${finishReportList.comment}</span></td>
									<c:if test="${finishReportList.status==1}">
											<c:set var="status" value="審核通過" />
									</c:if>	
									<c:if test="${finishReportList.status==2}">
											<c:set var="status" value="禁止發言三天" />
									</c:if>	
									<c:if test="${finishReportList.status==3}">
											<c:set var="status" value="停權" />
									</c:if>	
									<td><span class="td_FRL_status">${status}</span></td>
								</tr>			
							</c:forEach>
						</tbody>
					</table>
				</div>
				</div>
			</div>
		</div>
	</div>
	<script language="JavaScript" src="<%=request.getContextPath()%>/static/js/jquery.js"></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			
			
			
			$('.btn_submit').click(function(){
			
					$.ajax({
						  url: "reportListCheck.do",
						  type: "post",
						  data: {"postID":$(this).parent().parent().find('.td_URL_postID').text(),"reporterID":$(this).parent().parent().find('.td_URL_reporterID').text(),"status":$(this).parent().parent().find('.status').val()},
						  dataType: "json",
						  success: function(res) {
							  location.reload();
							 },
						  error:function() {
							  location.reload();
						  }
						});
					
			});
			
			
			
			
// 			$('.btn_submit').click(function(){
// 				$.post("reportListCheck.do",{"postID":$(this).parent().parent().find('.td_URL_postID').text(),"reporterID":$(this).parent().parent().find('.td_URL_reporterID').text(),"status":$(this).parent().parent().find('.status').val()},
// 						function (goodCount){
// 				});
// 			});
			
			$('#btn_not').click(function(){
				$('#div_finish').hide();
				$('#div_untreated').show();
			});
			$('#btn_fin').click(function(){
				$('#div_finish').show();
				$('#div_untreated').hide();
			});
			$('#test').click(function() { 
	            $.blockUI({ message: $('#question'), css: {width:'600px',height:'400px'}}); 
	        }); 
	 
	        $('#yes').click(function() { 
	            // update the block message 
	            $.blockUI({ message: "<h1>Remote call in progress...</h1>" }); 
	 
	            $.ajax({ 
	                url: 'wait.php', 
	                cache: false, 
	                complete: function() { 
	                    // unblock when remote call returns 
	                    $.unblockUI(); 
	                } 
	            }); 
	        }); 
	 
	        $('#no').click(function() { 
	            $.unblockUI(); 
	            return false; 
	        }); 
		
		
		
		
		});
	</script>
			<div id="question" style="display:none; cursor: default;"> 
		      <form method="get" action="postsController/posts.do">
			        <h3>檢舉頁面</h3> 
			        <input type="button" id="yes" value="輸入你想輸入的值" /> 
			        <input type="button" id="no" value="取消" /> 
			        <input type="submit" value="test">
		       </form>
			</div> 
</body>
</html>