<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js"></script>
<style type="text/css">
.login-label{
	color:black;
}
</style>
</head>
<body style="background-image: url('../static/images/create.jpg');
 			background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            background-size: cover;">
   
<!-- 彈出式窗 -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" id="myModal" role="dialog" aria-labelledby="mySmallModalLabel">
  <div class="modal-dialog modal-sm" role="document">
  
      <!-- 	get || post -->
	  <!-- /Login/DBCheck -->
      <div class="container" style="margin-top:40px">
		<div class="row">
			<div class="col-sm-6 col-md-4 ">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong id="gridSystemModalLabel">登入</strong>
					</div>
					<div class="panel-body">
						<form role="form" action="/runninglife/Login/DBCheck.do" method="post">
							<fieldset>
<!-- 								<div class="row"> -->
<!-- 									<div class="center-block"> -->
<!-- 									</div> -->
<!-- 								</div> -->
								<div class="row">
									<div class="col-sm-12 col-md-10  col-md-offset-1 ">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span> 
												<input type="text" id="account" class="form-control" name="memberAccount" value="${param.memberAccount}" placeholder="帳號" autofocus>
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-lock"></i>
												</span>
												<input type="password" class="form-control" id="password" name="password" value="${param.password}" placeholder="密碼">
											</div>
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
						<a href="/runninglife/Login/ChangeForgetPage.do"> 忘記密碼? </a><br/>
						<a href="/runninglife/Login/CreateAccountPage.do"> 新增用戶 </a>
					</div>
                </div>
			</div>
		</div>
    </div>
  </div>
</div>
   
<div id="fh5co-page">
	<%@ include file="/WEB-INF/pages/header.jsp"%>
</div>
  <div class="container">
	 <div class="main-login main-center">
		<div class="row main">
			<form:form modelAttribute="memberForm" action="UpdateAccount.do" method="post" acceptCharset="UTF-8">
			<table>
				<thead>
					<tr>
						<th>
							<div class="page" style="margin-left:30px; margin-top:20px;">
	  							<h1 class="login-label">修改會員</h1>
							</div>
<!-- 							<h2 class="dark-grey login-label"></h2> -->
						</th>
					</tr>
				</thead>
				<tbody>
					<form:input type="hidden" path="memberID" class="form-control" value="${membersVO.memberID}"/>
				<tr class="form-group col-lg-12">
					<td class="form-group col-lg-6">
						<label class="login-label">姓氏:</label>
						<form:input type="text" path="firstName" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.firstName}"/>
					</td>
					<td class="form-group col-lg-6">
						<label class="login-label">身高:</label>
						<form:input type="number" path="height" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.height}"/>
					</td>
				</tr>
				<tr class="form-group col-lg-12">
					<td class="form-group col-lg-6">
						<label class="login-label">名子:</label>
						<form:input type="text" path="lastName" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.lastName}"/>
					</td>
					<td class="form-group col-lg-6">
						<label class="login-label">體重:</label>
						<form:input type="number" path="weight" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.weight}"/>
					</td>
				</tr>
				<tr class="form-group col-lg-12">
					<td class="form-group col-lg-6">
						<label class="login-label">暱稱:</label>
						<form:input type="text"  path="nickname" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.nickname}"/>
					</td>
					<td class="form-group col-lg-6">
						<label class="login-label">電話:</label>
						<form:input type="text" path="phone" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.phone}"/>
					</td>
				</tr>
				<tr class="form-group col-lg-12">
					<td class="form-group col-lg-6">
						<label class="login-label">Email:</label>
						<form:input type="text" path="email" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.email}"/>
					</td>
					<td class="form-group col-lg-6">
						<label class="login-label">身分證字號:</label>
						<form:input type="text" path="identityID" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.identityID}"/>
					</td>
				</tr>
				<tr class="form-group col-lg-12">
					<td class="form-group col-lg-6" class="login-label">
						<label class="login-label">性別:</label><br/>
						<form:radiobutton path="gender" value="1" class="login-label"/>
						<label class="login-label">男</label>
						<form:radiobutton path="gender" value="0"/> 
						<label class="login-label">女</label>
						<form:radiobutton path="gender" value="2" checked="checked"/> 
						<label class="login-label">不公開</label>
					</td>
					<td class="form-group col-lg-6">
						<label class="login-label">緊急連絡人:</label>
						<form:input type="text" path="emergencyContact" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.emergencyContact}"/>
					</td>
				</tr>
				<tr class="form-group col-lg-12">
					<td class="form-group col-lg-6">
						<label class="login-label">生日:</label>
						<form:input type="text"  path="birthday" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.birthday}"/>
					</td>
					<td class="form-group col-lg-6">
						<label class="login-label">緊急聯絡人電話:</label>
						<form:input type="text" path="emergencyPhone" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.emergencyPhone}"/>
					</td>
				</tr>
									
				<tr class="form-group col-lg-12">
					<td class="form-group col-lg-8 "  >
						<label class="login-label">國家:</label>
						<form:select id="select1" path="locationID.locationID.cityID.cityID.countryID.countryID"  class="alert alert-dismissible cols-sm-5 input-group">
		    		   	</form:select>
					</td>
					<td class="form-group col-lg-6 col-md-offset-1" style="margin-left:300px;" >
						<label class="login-label">緊急連絡人關係:</label>
						<form:select id="select4" path="emergencyRelation.relationID" class="alert alert-dismissible cols-sm-5 input-group">
					   	</form:select>
					</td>
				</tr>
									
				<tr class="form-group col-lg-12">
					<td class="form-group col-lg-6">
						<label class="login-label">城市:</label>
						<form:select id="select2" path="locationID.locationID.cityID.cityID.cityID" class="alert alert-dismissible cols-sm-5 input-group">
					   	</form:select>
					</td>
				</tr>
				<tr class="form-group col-lg-6">
					<td class="form-group col-lg-6">
						<label class="login-label">居住地:</label>
						<form:select id="select3" path="locationID.locationID.locationID" class="alert alert-dismissible cols-sm-5 input-group">
					    </form:select>
					</td>
										
				</tr>
				
				<tr class="form-group col-lg-12">
					<td class="form-group col-lg-6">
						<label class="login-label">地址:</label>
						<form:input type="text" path="address" class="alert alert-dismissible cols-sm-5 input-group" value="${membersVO.address}"/>
					</td>
				</tr>
									
				<form:input type="number" path="competenceID.competenceID" class="form-control hidden" value="1"/>
				<form:input type="hidden" path="createDate" class="form-control" value="${membersVO.createDate}"/>
				<form:input type="hidden" path="lastOnlineDateTime" class="form-control" value="${membersVO.lastOnlineDateTime}"/>
				<tr class="col-md-1" style="margin-left:10px;">
					<td>
						<input type="submit" class="btn btn-primary" value="送出">
					</td>
				</tr>
			  </tbody>
			</table>
			</form:form>
		</div>
	</div>
</div>
<script>
$(function(){
	var mCountry = '${membersVO.locationID.locationID.cityID.cityID.countryID.countryID}';
	var mCity = '${membersVO.locationID.locationID.cityID.cityID.cityID}';
	var mLocation = '${membersVO.locationID.locationID.locationID}';
	$('#select1').empty();
	//country
	$.ajax({
		url: 'Country.do',	type: 'get', dataType: 'json', success:function(response){
			$('#select1').empty();
			for (var i in response)
			{
				var opt = $("<option></option>");
				opt.text(response[i].country).val(response[i].countryID);
				if (response[i].countryID == mCountry) { opt.attr("selected","selected"); }
				$('#select1').append(opt);
			}
			
			$('#select2').empty();
			$.ajax({
				url: 'City.do', type: 'post', dataType: 'json', data: {"countryID" : $('#select1').val()},
				success:function(response){
					for (var i in response)
					{
						var opt = $("<option></option>");
						opt.text(response[i].cityName).val(response[i].cityID.cityID);
						if (response[i].cityID.cityID == mCity) { opt.attr("selected","selected"); }
						$('#select2').append(opt);
					}
					$('#select3').empty();
					$.ajax({
						url: 'Location.do', type: 'post', dataType: 'json', data: {"cityID" : $('#select2').val()},
						success:function(response){
							for (var i in response)
							{
								var opt = $("<option></option>");
								opt.text(response[i].locationName).val(response[i].locationID.locationID);
								if (response[i].locationID.locationID == mLocation) { opt.attr("selected","selected"); }
								$('#select3').append(opt);
							}
						}
					})
				}
			})
		}
	})
	//city
	$('#select1').change(function(){
		$('#select2').empty();
		$.ajax({
			url: 'City.do', type: 'post', dataType: 'json', data: {"countryID" : $('#select1').val()},
			success:function(response){
				for (var i in response)
				{
					var opt = $("<option></option>");
					opt.text(response[i].cityName).val(response[i].cityID.cityID);
					$('#select2').append(opt);
				}
			}
		})
	})
	//location
	$('#select2').change(function(){
		$('#select3').empty();
		$.ajax({
			url: 'Location.do', type: 'post', dataType: 'json', data: {"cityID" : $('#select2').val()},
			success:function(response){
				for (var i in response)
				{
					var opt = $("<option></option>");
					opt.text(response[i].locationName).val(response[i].locationID.locationID);
					$('#select3').append(opt);
				}
			}
		})
	})
	
	$('#select4').empty();
	$.ajax({
		url: '/runninglife/Login/EmergencyRelation.do',
		type: 'get',
		dataType: 'json',
		data: null,
		success:function(response){
			for ( var i in response) {
				var opt = $("<option></option>");
				opt.text(response[i].relationName).val(response[i].relationID);
				$('#select4').append(opt);
			}
		}
	})
});

</script>
</body>
</html>