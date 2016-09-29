<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="r" uri="http://iii.runningLife.com/util" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RunningLife - 挑戰資訊</title>
<!-- ico	 -->
	<link rel="icon" type="image/png" href="/runninglife/images/icon.png">
	
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
	<link rel="stylesheet" href="/runninglife/static/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="/runninglife/static/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="/runninglife/static/css/bootstrap.css">
	<!-- Flexslider  -->
	<link rel="stylesheet" href="/runninglife/static/css/flexslider.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="/runninglife/static/css/style.css">

	<!-- Modernizr JS -->
	<script src="/runninglife/static/js/modernizr-2.6.2.min.js"></script>
	<!-- jQuery -->
	<script src="/runninglife/static/js/jquery-3.1.0.min.js"></script>
	<!-- jQuery Easing -->
	<script src="/runninglife/static/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="/runninglife/static/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="/runninglife/static/js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="/runninglife/static/js/jquery.flexslider-min.js"></script>
	<!-- Stellar -->
	<script src="/runninglife/static/js/jquery.stellar.min.js"></script>
	<!-- LIST JS -->
	<script src="/runninglife/static/js/list.min.js"></script>
	<!-- MAIN JS -->
	<script src="/runninglife/static/js/main.js"></script>
	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="/runninglife/static/css/web/owl.carousel.min.css">
	<link rel="stylesheet" href="/runninglife/static/css/web/owl.theme.default.min.css">
	<!-- Owl Carousel -->
	<script src="/runninglife/static/js/web/owl.carousel.min.js"></script>

</head>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">參加者名單</h4>
      </div>
      <div class="modal-body">
       <table class="table">
			<c:if test="${challengeDataList != null}">
				<c:forEach var="challengeData" items="${challengeDataList}">
				<c:set var="attender" value="${challengeData.challDataPK.memberID}" />
					<tr><td><i class="icon-trophy2"></i></td>
						<td><img src="data:image/png;base64,${r:byteToBase64(attender.photo)}" style='width:50px;height:50px;'></td>
						<td>${attender.firstName}</td>
						<td>${attender.lastName}</td>
						<td>
						<c:choose>
							<c:when test="${challengeData.isFounder eq '1'}">發起者123</c:when>
							<c:otherwise>
								<c:if test="${challengeData.status eq '0'}">未接受邀請</c:if>
								<c:if test="${challengeData.status eq '1' || challengeData.status eq '2'}">參加者</c:if>
							</c:otherwise>
						</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${challengeData.isFounder eq '1'||challengeData.status eq '1' || challengeData.status eq '2'}">${challengeData.processLength}公里</c:when>
							</c:choose>	
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal requestFriend-->
<c:if test="${myChallengeData.isFounder == '1'}">
<div class="modal fade" id="requestFriend" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">邀請好友</h4>
      </div>
      <div class="modal-body">
       <table class="table">
			<c:if test="${friends != null}">
				<c:forEach var="friend" items="${friends}">
					<tr><td><img src="data:image/png;base64,${r:byteToBase64(friend.photo)}" style='width:50px;height:50px;'></td>
						<td class="firstName">${friend.firstName}</td>
						<td class="lastName">${friend.lastName}</td>
						<td><button class="btn btn-accept sendRquest" id="${friend.memberID}" >邀請挑戰</button></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</c:if>
<!-- friendRequest Modal END -->

<body>
<div id="fh5co-page">
		<%@ include file="/WEB-INF/pages/header.jsp"%>

		<div class="container" style="margin-top: 50px;">
			<div class="row">
				<h1>挑戰資訊<span style="float:right; font-size: 20px;">${r:day(challenge.challenEndTime)} 天後結束</span></h1>
				<table class="table">
					<tr>
						<td class="col-md-4">挑戰名稱：</td>
						<td><span class="challenName">${challenge.challenName}</span></td>
					</tr>               
					<tr>
						<td>挑戰地區：</td>
						<td><span class="locationID">${challenge.locationID}</span></td>
					</tr>                
					<tr>
						<td>挑戰距離：</td>
						<td><span class="challenDistance">${challenge.challenDistance}</span></td>
					</tr>                
					<tr>
						<td>起始時間：</td>
						<td><span class="challenStartTime">${challenge.challenStartTime}</span></td>
					</tr>                
					<tr>
						<td>結束時間：</td>
						<td><span class="challenEndTime">${challenge.challenEndTime}</span></td>
					</tr>                
					<tr>
						<td>挑戰目的：</td>
						<td><span class="comment">${challenge.comment}</span></td>
					</tr>    
					<tr>
						<td>挑戰發起人：</td>
						<td><img src="data:image/png;base64,${r:byteToBase64(challenge.founderID.photo)}" style='width:50px;height:50px;'>
							${challenge.founderID.firstName}, ${challenge.founderID.lastName}
						</td>
						
					</tr>               
					<tr>
						<td><!-- Button trigger modal -->
						<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
						參加者名單
						</button>
						</td>
						<c:if test="${myChallengeData.isFounder == '1'}">
						<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#requestFriend">
						邀請好友加入挑戰
						</button>
						</c:if>
					</tr>
					<tr><td colspan="2"><p align="right">
					<c:if test="${myChallengeData.isFounder == '1'}"><button class="btn btn-danger" onclick="location.href='../deleteChall/${challenge.challenID}.do'">刪除</button></c:if>
					<c:if test="${myChallengeData.isFounder == '0' && myChallengeData.status == '0'}"><button class="btn btn-info acceptRequest">
					接受邀請</button></c:if>
					<button class="btn btn-success back">返回</button></p></td></tr>
				</table>
			</div>
		</div>

		<footer id="fh5co-footer" role="contentinfo">
			
			<div class="container" style="padding-top:20px;">
				<div class="col-md-3 col-sm-12 col-sm-push-0 col-xs-12 col-xs-push-0">
					<h3>About Us</h3>
					<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
				</div>
				<div class="col-md-6 col-md-push-1 col-sm-12 col-sm-push-0 col-xs-12 col-xs-push-0">
					<h3>Our Services</h3>
					<ul class="float">
						<li><a href="#">Web Design</a></li>
						<li><a href="#">Branding &amp; Identity</a></li>
						<li><a href="#">Free HTML5</a></li>
						<li><a href="#">HandCrafted Templates</a></li>
					</ul>
					<ul class="float">
						<li><a href="#">Free Bootstrap Template</a></li>
						<li><a href="#">Free HTML5 Template</a></li>
						<li><a href="#">Free HTML5 &amp; CSS3 Template</a></li>
						<li><a href="#">HandCrafted Templates</a></li>
					</ul>

				</div>

				<div class="col-md-2 col-md-push-1 col-sm-12 col-sm-push-0 col-xs-12 col-xs-push-0">
					<h3>Follow Us</h3>
					<ul class="fh5co-social">
						<li><a href="#"><i class="icon-twitter"></i></a></li>
						<li><a href="#"><i class="icon-facebook"></i></a></li>
						<li><a href="#"><i class="icon-google-plus"></i></a></li>
						<li><a href="#"><i class="icon-instagram"></i></a></li>
					</ul>
				</div>


				<div class="col-md-12 fh5co-copyright text-center">
					<p>&copy; 2016 Free HTML5 template. All Rights Reserved. <span>Designed with <i class="icon-heart"></i> by <a href="http://freehtml5.co/" target="_blank">FreeHTML5.co</a> Demo Images by <a href="http://unsplash.com/" target="_blank">Unsplash</a></span></p>	
				</div>

			</div>
		</footer>
	</div>
</body>
<script>
$(document).ready(function(){
	var options = {valueNames: [ 'firstName', 'lastName' ]};
	var userList = new List('friends', options);
	$(".sendRquest").click(function(){
		var btn = $(this);
		var friend = $(this).attr("id");
		$.ajax({
			type: "post", 
			datatype: "json",
			data : { "memberID" : friend, "challenID" : '${challenge.challenID}'},
			url: '../challenRequestFriend.do',
			success: function(){
				btn.text("已邀請").attr("class","btn btn-primary");
				btn.off();
			}
		});
	});
	$(".acceptRequest").click(function(){
		var btn = $(this);
		$.ajax({
			type: "get", 
			datatype: "json",
			data : { "challenID" : '${challenge.challenID}', "memberID" : '${membersVO.memberID}'},
			url: '<%=request.getContextPath()%>/challenge/acceptRequest.do',
			success: function(){
				btn.text("已接受").attr("class","btn btn-primary");
				btn.off();
			}
		});
	});
});

$(document).on("click",".back",function(){
    history.back();
})

</script>	
</html>