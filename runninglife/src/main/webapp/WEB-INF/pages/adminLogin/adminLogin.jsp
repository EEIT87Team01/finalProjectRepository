
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/pages/header-admin.jsp"%>
<title>後端檢舉頁面</title>
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/static/images/icon.png">
<link rel="stylesheet" href="/runninglife/static/css/bootstrap.min.css" />
<link rel="stylesheet" href="/runninglife/static/css/bootstrap-theme.min.css"></link>
<link rel="stylesheet" href="/runninglife/static/css/mainStyle.css"></link>
<script src="/runninglife/static/js/jquery-3.1.0.min.js"></script>
<script src="/runninglife/static/js/bootstrap.min.js"></script>

<<<<<<< HEAD
<title></title>
=======

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/css/server/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/css/server/sb-admin.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/font-awesome/server/css/font-awesome.min.css">
	
<style>
.adminLogin-label{
	color:white;
}
</style>
>>>>>>> branch 'final' of https://github.com/EEIT87Team01/finalProjectRepository.git
</head>
<body>


<!-- Small modal -->

<div class="modal fade bs-example-modal-sm col-md-offset-5" id="myModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
<!--   <div class="modal-dialog modal-sm"> -->
<!--     <div class="modal-content"> -->
      
	    <div class="container " style="margin-top:40px"> 
		<div class="row">
			<div class="col-sm-6 col-md-4 ">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong id="gridSystemModalLabel">登入</strong>
					</div>
					<div class="panel-body">
						<form action="/runninglife/AdminLogin/AdminAccountCheck.do" method="post">
							<fieldset>
								<div class="row">
									<div class="center-block">
									</div>
								</div> 
								<div class="row">
									<div class="col-sm-12 col-md-10  col-md-offset-1 ">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span> 
												<label for="name" class=" control-label">帳號:</label>
												<input type="text" id="account" class="form-control col-sm-12 col-md-10" name="adminAccount" value="${param.adminAccount}">
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-lock" style="width:20px; height:20px;"></i>
												</span>
												<label for="name" class=" control-label ">密碼:</label>
												<input type="text" class="form-control col-sm-12 col-md-10" name="password" value="${param.password}">
											</div>
										</div>
										
										<div class="dropdown">
										  <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
										   	 選擇登入方式
										    <span class="caret"></span>
										  </button>
										  <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
										   	<li><a href="#">管理者</a></li>
										   	<li class="divider"></li>
										    <li><a href="#">作家</a></li>
										  </ul>
										</div>
										
										<div class="form-group">
											<input type="submit" class="btn btn-lg btn-primary btn-block" value="登入">
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="panel-footer ">
						<a href="CreateAdminPage.do">新增管理員</a>
					</div>
                </div>
			</div>
		</div>
    </div>

    </div>
<!--   </div> -->
<!-- </div> -->







<!-- <div class="modal fade bs-example-modal-sm" tabindex="-1" id="myModal" role="dialog" aria-labelledby="mySmallModalLabel"> -->
<!--   <div class="modal-dialog modal-sm" role="document"> -->
  
<!--       	get || post -->
<!-- 	  <!-- /Login/DBCheck -->
<!--       <div class="container" style="margin-top:40px"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-sm-6 col-md-4 "> -->
<!-- 				<div class="panel panel-default"> -->
<!-- 					<div class="panel-heading"> -->
<!-- 						<strong id="gridSystemModalLabel">登入</strong> -->
<!-- 					</div> -->
<!-- 					<div class="panel-body"> -->
<!-- 						<form action="/runninglife/AdminLogin/AdminAccountCheck.do" method="post"> -->
<!-- 							<fieldset> -->
<!-- <!-- 								<div class="row"> -->
<!-- <!-- 									<div class="center-block"> -->
<!-- <!-- 									</div> -->
<!-- <!-- 								</div> --> 
<!-- 								<div class="row"> -->
<!-- 									<div class="col-sm-12 col-md-10  col-md-offset-1 "> -->
<!-- 										<div class="form-group"> -->
<!-- 											<div class="input-group"> -->
<!-- 												<span class="input-group-addon"> -->
<!-- 													<i class="glyphicon glyphicon-user"></i> -->
<!-- 												</span>  -->
<!-- 												<label for="name" class=" control-label adminLogin-label">帳號:</label> -->
<%-- 												<input type="text" id="account" class="form-control" name="adminAccount" value="${param.adminAccount}"> --%>
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 										<div class="form-group"> -->
<!-- 											<div class="input-group"> -->
<!-- 												<span class="input-group-addon"> -->
<!-- 													<i class="glyphicon glyphicon-lock"></i> -->
<!-- 												</span> -->
<!-- 												<label for="name" class=" control-label adminLogin-label">密碼:</label> -->
<%-- 												<input type="text" class="form-control" name="password" value="${param.password}"> --%>
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 										<div class="form-group"> -->
<!-- 											<input type="submit" class="btn btn-lg btn-primary btn-block" value="登入"> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</fieldset> -->
<!-- 						</form> -->
<!-- 					</div> -->
<!-- 					<div class="panel-footer "> -->
<!-- 						<a href="CreateAdminPage.do">新增管理員</a> -->
<!-- 					</div> -->
<!--                 </div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
<!-- <script> -->

<!-- </script> -->
<!-- <div class="container col-md-offset-2"> -->
<!-- 		<div class="main-login main-center"> -->
<!-- 		<div class="row main"> -->
			
				
		
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->
</body>
</html>