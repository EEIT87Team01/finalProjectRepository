<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${contest.contestName }</title>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/jquery.countdown.css"/>"
	type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/apply.css"/>"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/jquery.dataTables.min.css"/>"
	type="text/css">
<style>
.bs-callout {
	padding: 10px;
	margin: 20px 0;
	border-left: 1px solid #eee;
	border-left-width: 5px;
	border-radius: 3px;
}

.bs-callout h4 {
	margin-top: 0;
	margin-bottom: 5px;
}

.bs-callout p:last-child {
	margin-bottom: 0;
}

.bs-callout code {
	border-radius: 3px;
}

.bs-callout+.bs-callout {
	margin-top: -5px;
}

.bs-callout-default {
	border-left-color: #777;
}

.bs-callout-default h4 {
	color: #777;
}

.bs-callout-primary {
	border-left-color: #428bca;
}

.bs-callout-primary h4 {
	color: #428bca;
}

.bs-callout-success {
	border-left-color: #5cb85c;
}

.bs-callout-success h4 {
	color: #5cb85c;
}

.bs-callout-danger {
	border-left-color: #d9534f;
}

.bs-callout-danger h4 {
	color: #d9534f;
}

.bs-callout-warning {
	border-left-color: #f0ad4e;
}

.bs-callout-warning h4 {
	color: #f0ad4e;
}

.bs-callout-info {
	border-left-color: #5bc0de;
}

.bs-callout-info h4 {
	color: #5bc0de;
}

h2 {
	font: 33px sans-serif;
	margin-top: 30px;
	text-align: center;
	text-transform: uppercase;
}

h2.background {
	position: relative;
	z-index: 1; &: before { border-top : 2px solid #dfdfdf;
	content: "";
	margin: 0 auto; /* this centers the line to the full width specified */
	position: absolute;
	/* positioning must be absolute here, and relative positioning must be applied to the parent */
	top: 50%;
	left: 0;
	right: 0;
	bottom: 0;
	width: 95%;
	z-index: -1;
}

span {
	/* to hide the lines from behind the text, you have to set the background color the same as the container */
	background: #fff;
	padding: 0 15px;
}

}
h2.double:before {
	/* this is just to undo the :before styling from above */
	border-top: none;
}

h2.double:after {
	border-bottom: 1px solid blue;
	-webkit-box-shadow: 0 1px 0 0 red;
	-moz-box-shadow: 0 1px 0 0 red;
	box-shadow: 0 1px 0 0 red;
	content: "";
	margin: 0 auto; /* this centers the line to the full width specified */
	position: absolute;
	top: 45%;
	left: 0;
	right: 0;
	width: 95%;
	z-index: -1;
}

h2.no-background {
	position: relative;
	overflow: hidden; span { display : inline-block;
	vertical-align: baseline;
	zoom: 1;
	*display: inline;
	*vertical-align: auto;
	position: relative;
	padding: 0 20px; &: before , & : after {
            content : '';
	display: block;
	width: 1000px;
	position: absolute;
	top: 0.73em;
	border-top: 1px solid red;
}

&
:before {
	right: 100%;
}

&
:after {
	left: 100%;
}

}
}
h2.no-span {
	display: table;
	white-space: nowrap; &: before , & : after {
      border-top : 1px solid green;
	content: '';
	display: table-cell;
	position: relative;
	top: 0.5em;
	width: 45%;
}

&
:before {
	right: 1.5%;
}

&
:after {
	left: 1.5%;
}
}
</style>
</head>



<body class="smoothscroll enable-animation">
	<div>context:${pageContext.request.contextPath}</div>
	<div>身分:${not empty adminsVO ? "admin" : "guest" }</div>

	<div id="contestID" class="hidden">${contest.contestID}</div>
	<div id="timer" class="hidden">${timer}</div>
	<section id="slider">
	<div>
		<img class="img-responsive "
			src="${pageContext.request.contextPath}/resources/${contest.contestID}banner.jpg"
			alt="banner">
	</div>

	</section>
	<section class="page-header page-header-md">
	<div class="container">
		<h1>${contest.contestName }</h1>
	</div>
	</section>

	<section>
	<div class="container">
		<div class="col-lg-9 col-md-9 col-sm-9 letter-spacing-1">
			<ul class="nav nav-tabs nav-pills">
				<li role="presentation" class="active"><a href="#rule"
					data-toggle="tab">競賽規程</a></li>
				<li role="presentation"><a href="#map" data-toggle="tab">競賽路線</a></li>
				<li role="presentation"><a href="#runnerList" data-toggle="tab">參賽名單</a></li>
			</ul>
			<div class="tab-content size-16">
				<div id="rule" class="tab-pane fade in active">
					<div class="bs-callout bs-callout-info">
						<h4 class="">
							<span style="color: #5bc0de">競賽規程</span>
						</h4>
					</div>
					<div class="table-responsive">
						<table id="example"
							class="table table-hover table-bordered  text-center">
							<tbody>
								<tr>
									<td class="col-xs-2">活動日期</td>
									<td class="col-xs-10 text-left">${start}</td>
								</tr>
								<tr>
									<td>報名時間</td>
									<td class="text-left">${contest.begin}起至~${contest.end}止額滿為止</td>
									<!-- <td class="text-left">2016 年 6 月 17 日 11:00 起 至 2016 年 7 月 17 日 23:59止 額滿為止</td> -->
								</tr>
								<tr>
									<td>活動宗旨</td>
									<td class="text-left">${contest.goal}</td>
								</tr>
								<tr>
									<td>主辦單位</td>
									<td class="text-left">${contest.organizer}</td>
								</tr>
								<tr>
									<td>協辦單位</td>
									<td class="text-left">${contest.coorganizer}</td>
								</tr>
								<tr>
									<td>會場地點</td>
									<td class="text-left">${contest.place}</td>
								</tr>
								<tr>
									<td>報名資格</td>
									<td class="text-left">未滿17歲，欲參加全程馬拉松組與半程馬拉松組比賽之選手，須繳交<a
										href="assets/家長同意書.doc" class="label label-success">家長同意書</a>並經大會核可後方得報名，否則不予受理。同意書簽名後請Email至：陳撼宇
										總幹事<a class="text-info"
										href="mailto:cck0936392333@yahoo.com.tw" target="_blank">cck0936392333@yahoo.com.tw</a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- 競賽項目 -->
					<div class="">
						<h4 class="bs-callout bs-callout-info">
							<span style="color: #5bc0de" class="">競賽項目</span>
						</h4>
					</div>
					<div class="table-responsive">
						<table
							class="table table-hover table-bordered lohas-table text-center">
							<thead>
								<tr class="info">
									<th class="col-xs-1 ${not empty adminsVO ? '':'hidden' }">編號</th>
									<!-- 隱藏 -->
									<th class="col-xs-2">項目名稱</th>
									<th class="col-xs-2">距離</th>
									<th class="col-xs-2">報名費用</th>
									<th class="col-xs-2">開放名額</th>
									<th class="col-xs-2">起跑時間</th>
									<th class="col-xs-2">限制時間(分)</th> ${not empty adminsVO ?'<th colspan="2" class="col-xs-2"></th>':'' }
									<!-- 隱藏 -->

									<!-- 								<th class="col-xs-2"></th> -->
								</tr>
							</thead>
							<tbody id="eventBody">
								<c:forEach var="event" items="${events}">
									<tr>
										<td class="eventID ${not empty adminsVO ? '':'hidden' }">${event.eventID}</td>
										<!-- 隱藏 -->
										<td>${event.eventName}</td>
										<td>${event.distance}</td>
										<td>${event.fee}</td>
										<td>${event.quota}</td>
										<td>${event.whenToRun}</td>
										<td>${event.limitTime }</td> ${not empty adminsVO ? '<td><a id="/runninglife/event/${event.eventID}/delete"    
											class="btn btn-danger btn-xs  eventDelete" role="button"
											data-text="真的要刪除此項目嗎?" data-confirm-button="是的"
											data-cancel-button="不了"data-confirm-button-class: "btn-danger ">刪除</a></td>
										<td><a class="btn btn-warning btn-xs edit" role="button">修改</a></td>':''}
										<!-- 隱藏 -->
									</tr>
								</c:forEach>
								<!-- 隱藏 -->

								<tr class="${member.memberID == 'admin' ? '':'hidden' }">
									<form id="eventForm"
										action="/runninglife/${contest.contestID}/event/add">
										<td><input type="text"
											class="form-group form-control readonly" id="eventID"
											name="eventID" placeholder="" readonly /></td>
										<td><input type="text" class="form-group form-control"
											id="eventName" name="eventName" placeholder="項目名稱" /></td>
										<td><input type="number" class="form-control"
											id="distance" name="distance" placeholder="距離" /></td>
										<td><input type="number" class="form-control" id="fee"
											name="fee" placeholder="報名費用" /></td>
										<td><input type="number" class="form-control" id="quota"
											name="quota" placeholder="開放名額" /></td>
										<td><input type="datetime" class="form-control"
											id="whenToRun" name="whenToRun" placeholder="06:50:00" /></td>
										<td><input type="" class="form-control"
											id="limitTime" name="limitTime" placeholder="90" /></td>
										<td colspan="2"><input type="submit"
											class="form-control  btn-success" name="submit" value="更新" /></td>
									</form>
									<!-- 隱藏 -->
								</tr>
							</tbody>
						</table>
					</div>
					<!--競賽分組-->
					<div
						class="heading-title heading-border heading-color margin-top-40">
						<h4 class="bs-callout bs-callout-info">
							<span style="color: #5bc0de">競賽分組</span>
						</h4>
						<p>依年齡分組，詳如下表</p>
					</div>
					<div class="table-responsive">
						<table class="table table-hover table-bordered text-center ">
							<thead>
								<tr class="info">
									<th class="col-xs-1 ${not empty adminsVO ? '':'hidden' }">組別編號</th>
									<th class="col-xs-5 text-center">組別</th>
									<th class="col-xs-5 text-center">年齡範圍</th>
									<th colspan="2"
										class="col-xs-1 ${not empty adminsVO ? '':'hidden' }"></th>
								</tr>
							</thead>
							<tbody id="teamBody">
								<c:forEach var='team' items='${teams}'>
									<tr>
										<td class="teamID ${not empty adminsVO ? '':'hidden' }">${team.teamID}</td>
										<td>${team.teamName}</td>
										<td>${team.ageRange}~${team.ageRange + 9}</td> ${not empty adminsVO ? '<td><a class="btn btn-danger btn-xs teamDelete" role="button"
											data-text="真的要刪除此項目嗎?" data-confirm-button="是的"
											data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a></td>
										<td><a class="btn btn-warning btn-xs edit" role="button">修改</a></td>':'' }
									</tr>
								</c:forEach>
								<tr class="${member.memberID == 'admin' ? '':'hidden' }">
									<form id="teamForm">
										<td><input type="text"
											class="form-control ${member.memberID == 'admin' ? '':'hidden' }"
											name="teamID" id="teamID" placeholder="" readonly /></td>
										<td><input type="text" class="form-control"
											name="teamName" id="teamName" placeholder="甲組" /></td>
										<td><input type="number" class="form-control"
											name="ageRange" id="ageRange" placeholder="年齡下限，輸入19範圍19-28" /></td>
										<td colspan="2"><input type="submit"
											class="form-control  btn-success" name="submit" value="更新" /></td>
									</form>
								</tr>

							</tbody>
						</table>
					</div>

				</div>


				<!-- tab#map -->
				<div id="map" class="tab-pane fade">
					<div class="bs-callout bs-callout-info">
						<h4 class="">
							<span style="color: #5bc0de">競賽路線</span>
						</h4>
					</div>
					<div class="row">
						<div class="col-md-9 col-md-offset-1">
							<div class="item-box">
								<figure> <a
									href="${pageContext.request.contextPath}/resources/${contest.contestID}route.jpg"
									target="blank"> <img class="img-responsive"
									src="${pageContext.request.contextPath}/resources/${contest.contestID}route.jpg">
								</a> </figure>
							</div>
						</div>
					</div>
				</div>
				<!-- tab參賽名單 -->
				<div id="runnerList" class="tab-pane fade">
					<jsp:include
						page="${request.contextPath}/admin/runner/${contest.contestID}" />
				</div>
			</div>
			<!-- 11 -->
		</div>

	</div>
	</section>

	<br>
	<%@ include file="/footer.jsp"%>

</body>
</html>