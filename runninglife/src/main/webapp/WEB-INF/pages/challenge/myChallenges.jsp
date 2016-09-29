<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://iii.runningLife.com/util" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RunningLife - 我的挑戰</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
<meta name="keywords" content="free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="FreeHTML5.co" />
<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />
<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

<link href="https://fonts.googleapis.com/css?family=Raleway:200,300,400,700" rel="stylesheet">
<!-- Animate.css -->
	<link rel="stylesheet" href="../static/css/web/animate.css">
<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="../static/css/web/icomoon.css">
<!-- Bootstrap  -->
	<link rel="stylesheet" href="../static/css/web/bootstrap.css">
<!-- Flexslider  -->
	<link rel="stylesheet" href="../static/css/web/flexslider.css">
<!-- Owl Carousel  -->
	<link rel="stylesheet" href="../static/css/web/owl.carousel.min.css">
	<link rel="stylesheet" href="../static/css/web/owl.theme.default.min.css">
<!-- Theme style  -->
	<link rel="stylesheet" href="../static/css/web/style.css">
<!-- Modernizr JS -->
	<script src="../static/js/web/modernizr-2.6.2.min.js"></script>
<!-- jQuery -->
	<script src="../static/js/web/jquery.min.js"></script>
<!-- jQuery Easing -->
	<script src="../static/js/web/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
	<script src="../static/js/web/bootstrap.min.js"></script>
<!-- Waypoints -->
	<script src="../static/js/web/jquery.waypoints.min.js"></script>
<!-- Owl Carousel -->
	<script src="../static/js/web/owl.carousel.min.js"></script>
<!-- Flexslider -->
	<script src="../static/js/web/jquery.flexslider-min.js"></script>
<!-- MAIN JS -->
	<script src="../static/js/web/main.js"></script>	
<script>

$(document).on("click",".back",function(){

    history.back();
})
</script>
</head>
<body>
<div id="fh5co-page">
		<%@ include file="/WEB-INF/pages/header.jsp"%>
		<div class="container" style='margin-top: 50px;'>
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
		  <li role="presentation" class="active"><a href="#foundedChallengeList" aria-controls="foundedChallengeList" role="tab" data-toggle="tab">我建立的</a></li>
		  <li role="presentation"><a href="#ingChallengeList" aria-controls="ingChallengeList" role="tab" data-toggle="tab">進行中的</a></li>
		  <li role="presentation"><a href="#finishChallengeList" aria-controls="finishChallengeList" role="tab" data-toggle="tab">已結束的</a></li>
		  <li role="presentation"><a href="#reservedChallengeList" aria-controls="reservedChallengeList" role="tab" data-toggle="tab">預定的</a></li>
		  <li role="presentation"><a href="#receivedRequestChallengeList" aria-controls="receivedRequestChallengeList" role="tab" data-toggle="tab">收到邀請的</a></li>
		</ul>
		<a href="<%=request.getContextPath()%>/challenge/createChallPage.do" class='btn btn-warning' style="float: right; margin-top:20px;" >新增挑戰</a>
		<div class="tab-content">
		<!-- 我建立的挑戰區塊  #foundedChallengeList-->
		<div role="tabpanel" class="tab-pane active" id="foundedChallengeList">
        
		<c:forEach var="challenge" items="${foundedChallengeList}">
		<div class="container">
			<div class="row">
				<div class="list">
			    	<div class="challColumn">	
						<h2>${challenge.challenName}</h2>
						<hr style="border:1px solid blue;">
						<h4>${challenge.founderID.firstName}, ${challenge.founderID.lastName}</h4>
						<h4>${challenge.comment}</h4>
						<h4>${challenge.locationID}</h4>
						<h4>${challenge.challenStartTime} - ${challenge.challenEndTime}</h4>
						<h4>${challenge.challenDistance}公里<p align="right"><a href="detail/${challenge.challenID}.do" class="btn btn-success" >詳細</a></p></h4>
					</div>
				</div>
			</div>
		</div>
		</c:forEach>
		</div>
		
		<!-- 進行中的挑戰區塊  #ingChallengeList-->
		<div role="tabpanel" class="tab-pane" id="ingChallengeList">

		<c:forEach var="challenData" items="${ingChallengeList}">
		<c:set var="challenge" value="${challenData.challDataPK.challenID}"/>
		<div class="container">
		<div class="row">
		<div class="list">
		<div class="challColumn">	    
			<h2>${challenge.challenName}<span class="day" style="float:right;">${r:day(challenge.challenEndTime)} 天後結束</span></h2>
			<hr style="border:1px solid blue;">
			<h4>${challenge.founderID.firstName}, ${challenge.founderID.lastName}</h4>
			<h4>${challenge.comment}</h4>
			<h4>${challenge.challenStartTime} - ${challenge.challenEndTime}</h4>
			<h4>${challenge.challenDistance}公里 <a href="detail/${challenge.challenID}.do" class="btn btn-info" style="float:right;">詳細</a></h4>
		</div>
		</div>
		</div>
		</div>
		</c:forEach>
		</div>

		
		<!-- 已結束的挑戰區塊  #finishChallengeList-->
		<div role="tabpanel" class="tab-pane" id = "finishChallengeList">
		
		<c:forEach var="challenData" items="${finishChallengeList}">
		<c:set var="challenge" value="${challenData.challDataPK.challenID}"/>
		<div class="container">
			<div class="row">
				<div class="list">
			    	<div class="challColumn">	
						<h2>${challenge.challenName}</h2>
						<hr style="border:1px solid blue;">
						<h4>${challenge.founderID.firstName}, ${challenge.founderID.lastName}</h4>
						<h4>${challenge.comment}</h4>
						<h4>${challenge.locationID}</h4>
						<h4>${challenge.challenStartTime} - ${challenge.challenEndTime}</h4>
						<h4>${challenge.challenDistance}公里<a href="detail/${challenge.challenID}.do" class="btn btn-success"  style="float:right;">詳細</a></h4>
					</div>
				</div>
			</div>

		</div>
		</c:forEach>
		</div>
		
		<!-- 預定的挑戰區塊  #reservedChallengeList-->
		<div role="tabpanel" class="tab-pane" id = "reservedChallengeList">
		
		<c:forEach var="challenData" items="${reservedChallengeList}">
		<c:set var="challenge" value="${challenData.challDataPK.challenID}"/>
		<div class="container">
			<div class="row">
				<div class="list">
			    	<div class="challColumn">	
						<h2>${challenge.challenName}<span style="float:right;">${r:day(challenge.challenStartTime)}天後開始</span></h2>
						<hr style="border:1px solid blue;">
						<h4>${challenge.founderID.firstName}, ${challenge.founderID.lastName}</h4>
						<h4>${challenge.comment}</h4>
						<h4>${challenge.locationID}</h4>
						<h4>${challenge.challenStartTime} - ${challenge.challenEndTime}</h4>
						<h4>${challenge.challenDistance}公里<a href="detail/${challenge.challenID}.do" class="btn btn-success"  style="float:right;">詳細</a></h4>
					</div>
				</div>
			</div>

		</div>
		</c:forEach>
		</div>
		
		<!-- 收到邀請的挑戰區塊  #receivedRequestChallengeList-->
		<div role="tabpanel" class="tab-pane" id = "receivedRequestChallengeList">
		
		<c:forEach var="challenData" items="${receivedRequestChallengeList}">
		<c:set var="challenge" value="${challenData.challDataPK.challenID}"/>
		<div class="container">
			<div class="row">
				<div class="list">
			    	<div class="challColumn">	
						<h2>${challenge.challenName}</h2>
						<hr style="border:1px solid blue;">
						<h4>${challenge.founderID.firstName}, ${challenge.founderID.lastName}</h4>
						<h4>${challenge.comment}</h4>
						<h4>${challenge.locationID}</h4>
						<h4>${challenge.challenStartTime} - ${challenge.challenEndTime}</h4>
						<h4>${challenge.challenDistance}公里<a href="detail/${challenge.challenID}.do" class="btn btn-success"  style="float:right;">詳細</a></h4>
					</div>
				</div>
			</div>

		</div>
		</c:forEach>
		</div>
		
		
		</div>
		</div>



<%@ include file="/WEB-INF/pages/footer.jsp"%>
	</div>
</body>
</html>