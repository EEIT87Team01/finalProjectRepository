<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="/runninglife/resources/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet"
	href="/runninglife/resources/css/jquery.countdown.css" type="text/css">
<link rel="stylesheet" href="/runninglife/resources/css/apply.css"
	type="text/css">

</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="/runninglife/resources/js/jquery.countdown.min.js"></script>
<script src="/runninglife/resources/js/bootstrap.min.js"></script>

<body class="smoothscroll enable-animation">
	<div id="msg">message:${status}</div>
	<div id="contestID" class="hidden">${contest.contestID}</div>
	<div id="timer" class="hidden">${timer}</div>
	<section id="slider">
	<div>
		<img class="img-responsive "
			src="/runninglife/resources/${contest.contestID}banner.jpg"
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
			<div class="tab-content size-16">
				<div class="heading-title heading-dotted text-center margin-top-20">
					<h4>
						競賽規程<span class="margin-left-8">COMPETITION RULES</span>
					</h4>
				</div>
				<div class="table-responsive">
					<table id="example"
						class="table table-hover table-bordered lohas-table text-center">
						<tbody>
							<tr>
								<td class="col-xs-2">活動日期</td>
								<td class="col-xs-10 text-left">${start}</td>
							</tr>
							<tr>
								<td>報名時間</td>
								<td class="text-left">${begin}起至~${end}止額滿為止</td>
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
				<div
					class="heading-title heading-border heading-color margin-top-40">
					<h4>
						<span>競賽項目</span>
					</h4>
				</div>
				<div class="table-responsive">
					<table
						class="table table-hover table-bordered lohas-table text-center">
						<thead>
							<tr>
								<th class="col-xs-2">項目名稱</th>
								<th class="col-xs-2">距離</th>
								<th class="col-xs-2">報名費用</th>
								<th class="col-xs-2">開放名額</th>
								<th class="col-xs-2">起跑時間</th>
								<th class="col-xs-2">限制時間(分)</th>
								<th class="col-xs-2"></th>
							</tr>
						</thead>
						<tbody id="eventBody">
							<c:forEach var="event" items="${events}">
								<tr>
									<td>${event.eventName}</td>
									<td>${event.distance}km</td>
									<td>$${event.fee}</td>
									<td>${event.quota}</td>
									<td>${event.whenToRun}</td>
									<td>${event.limitTime }</td>
									<td><a id="/runninglife/event/${event.eventID}/delete"
										class="btn btn-danger  delete" role="button"
										data-text="真的要刪除此項目嗎?" data-confirm-button="是的"
										data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a></td>
								</tr>
							</c:forEach>
							<tr>
								<form id="eventForm"
									action="/runninglife/${contest.contestID}/event/add">
									<td><input type="text" class="form-group form-control has-error has-feedback" id="eventName"
										name="eventName" placeholder="項目名稱" /></td>
									<td><input type="number" class="form-control"
										id="distance" name="distance" placeholder="距離" /></td>
									<td><input type="number" class="form-control" id="fee"
										name="fee" placeholder="報名費用" /></td>
									<td><input type="number" class="form-control" id="quota"
										name="quota" placeholder="開放名額" /></td>
									<td><input type="datetime" class="form-control"
										id="whenToRun" name="whenToRun" placeholder="06:50:00" /></td>
									<td><input type="number" class="form-control"
										id="limitTime" name="limitTime" placeholder="90" /></td>

									<td><input type="submit" class="form-control  btn-success"
										name="submit" value="新增" /></td>
								</form>
							</tr>
						</tbody>
					</table>
				</div>
				<!--競賽分組-->
				<div
					class="heading-title heading-border heading-color margin-top-40">
					<h4>
						<span>競賽分組</span>／全程馬拉松組、半程馬拉松組
					</h4>
					<p>依性別及年齡分組，詳如下表</p>
				</div>
				<div class="table-responsive">
					<table
						class="table table-hover table-bordered lohas-table text-center ">
						<thead>
							<tr>

								<th class="col-xs-1">組別編號</th>
								<th class="col-xs-5">組別</th>
								<th class="col-xs-5">年齡範圍</th>
								<th class="col-xs-1"></th>
							</tr>
						</thead>
						<tbody id="teamBody">
							<c:forEach var='team' items='${teams}'>
								<tr>
									<td class="teamID">${team.teamID}</td>
									<td>${team.teamName}</td>
									<td>${team.ageRange}~${team.ageRange + 9}</td>
									<td><a class="btn btn-danger  delete" role="button"
										data-text="真的要刪除此項目嗎?" data-confirm-button="是的"
										data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a></td>
								</tr>
							</c:forEach>
							<tr>
								<form id="teamForm">
									<td><input type="text" class="form-control" name="teamID"
										id="teamID" disabled="disabled" placeholder="" /></td>
									<td><input type="text" class="form-control"
										name="teamName" id="teamName" placeholder="男甲組" /></td>
									<td><input type="number" class="form-control"
										name="ageRange" id="ageRange" placeholder="19" /></td>
									<td><input type="submit" class="form-control  btn-success"
										name="submit" value="新增" /></td>
								</form>
							</tr>

						</tbody>
					</table>
				</div>
				<!-- 衣服尺寸 -->
				<div
					class="heading-title heading-border heading-color margin-top-40">
					<h4>
						<span>紀念衣尺寸</span>
					</h4>
					<p>尺寸詳如下表</p>
				</div>
				<div class="table-responsive">
					<table
						class="table table-hover table-bordered lohas-table text-center ">
						<tr>
							<td>尺寸</td>
							<c:forEach var='aClothes' items='${clothes}'>
								<td>${aClothes.clothesSize}</td>
							</c:forEach>
						</tr>
						<tr>
							<td>胸圍(cm)</td>
							<c:forEach var='aClothes' items='${clothes}'>
								<td>${aClothes.breast}</td>
							</c:forEach>
						</tr>
						<tr>
							<td>衣長(cm)</td>
							<c:forEach var='aClothes' items='${clothes}'>
								<td>${aClothes.length}</td>
							</c:forEach>
						</tr>
					</table>
				</div>
				<!--退費說明 -->
				<div
					class="heading-title heading-border heading-color margin-top-40">
					<h4>
						<span>退費說明</span>
					</h4>
				</div>
				<ol>
					<li>開報後14天內(報名費全額退費，另酌收100元手續費)。</li>
					<li>開報後14至28天(退還報名費50%，另酌收100元手續費)。</li>
					<li>開報28天後無法取消名額與退費。</li>
				</ol>
				<!-- 注意事項 -->
				<div
					class="heading-title heading-border heading-color margin-top-40">
					<h4>
						<span>注意事項</span>
					</h4>
				</div>
				<ol>
					<li>進入終點前裁判會檢視信物，請選手配合。</li>
					<li>成績證明：完跑立即發給，請務必現場領取，如未領取恕不補寄。（若遇大風大雨、停電、當機、網路斷線等意外，完賽證書改由完賽一週後，於大會網路下載自行列印。）成績於賽後一週內公佈於網站。</li>
					<li>競賽途中選手不得搭乘車輛或由他人代跑；參賽選手於時間內無法跑完全程者，請遵照裁判人員指示，搭乘巡迴車輛返回終點。</li>
					<li>選手出發及到達終點均應進入感應區，方能記錄時間；沿途競賽靠右側進行，並注意安全，沿線遵從裁判或巡迴裁判指示。</li>
					<li>大會有權將此項比賽之錄影、相片及成績，於世界各地播放、展出、登錄於本會網站與本會刊物上暨參賽者，必須同意肖像與成績，用於相關比賽之宣傳與播放活動上。</li>
					<li>安全第一，大會裁判或醫師有權視選手體能狀況，中止選手繼續比賽資格，選手不得有異議。</li>
					<li>比賽前如遇颱風或其他不可抗力之天災，由大會以選手安全為考量，有權決定是否取消或擇期比賽或改用其他替代路線，參賽選手不得有議；若因故取消活動，大會將扣除已經產生之費用及匯款手續費後退費給選手。</li>
					<li>請隨身攜帶身分證明(身分證)備查。</li>
					<li>賽後歸還晶片退100元晶片押金。</li>
					<li>代跑或轉讓者，如有意外發生應負連帶保險理賠及法律責任。</li>
				</ol>
				<!-- 違規罰則 -->
				<div
					class="heading-title heading-border heading-color margin-top-40">
					<h4>
						<span>違規罰則</span>
					</h4>
				</div>
				<ol>
					<li>違反下列規定者，取消比賽成績處理之。</li>
					<ul>
						<li>無本次活動號碼者。</li>
						<li>不遵守競賽規則及裁判指揮，經判定者失格者。</li>
						<li>未將號碼布完整佩掛在胸前者。</li>
						<li>未將晶片掛在鞋面者。</li>
					</ul>
					<li>有下列情形之一者，取消比賽成績並禁止參加本會舉辦之活動一年。</li>
					<ul>
						<li>比賽進行中選手借助他人之幫助而獲利者(如補給、扶持…)。</li>
						<li>報名組別與身分證明資格不符者。</li>
						<li>違反運動精神和道德(如打架、辱罵裁判等)。</li>
						<li>私自塗改、更換號碼布或與參賽資料不符者。</li>
					</ul>
				</ol>
				<!--大會免責說明  -->
				<div
					class="heading-title heading-border heading-color margin-top-40">
					<h4>
						<span>大會免責說明</span>
					</h4>
				</div>
				<ol>
					<li>參加者因任何原因受傷、財物損失或死亡皆不得向指導單位、主辦單位、協辦單位及執行單位要求任何形式之賠償。</li>
					<li>參加者一旦報名，視同同意本規程所有規定。</li>
					<li>本規程如有未盡事宜，得由大會修正並公佈(請隨時注意大會網站資訊)。</li>
				</ol>
			</div>

		</div>
		<div class="col-lg-3 col-md-3 col-sm-3" id="activity-sidebar">
			<div id="countdown" class="countdownHolder breadcrumb size-10"></div>
			<!-- 籃圈 -->
			<div
				class="panel-group text-center margin-bottom-40"
				style="min-height: 351px;">
				<div class="panel panel-primary"
					style="min-height:351px; background-color: rgb(115, 185, 220);">
					<div class="box-icon-title">
						<i class="fa fa-pencil-square-o"></i>
					</div>
					<div class="row margin-bottom-0 panel-body">
						<p class="size-18">
							賽事問題請洽<br>${contest.organizer}
						</p>
						<p class="size-18">報名問題請洽樂活資訊</p>
						<p class="size-14">
							<i class="fa fa-phone margin-right-10"></i>05-5336010 <br>聯絡時間：週一至週五
							<br>(08:30~12:00、13:30~17:00)
						</p>
						<p class="size-14">
							<i class="fa fa-envelope margin-right-10"></i>lohasnet.tw@gmail.com
						</p>
					</div>
					<div class="panel-footer">
					<a id="applyLink" class="btn btn-lg btn-default btn-bordered">
						<span>立即報名</span>
					</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	<div id="applyForm">
		<!-- 彈出報名 -->
		<div id="popupContact">
			<!-- 報名表單 -->
			<form action="/runninglife/apply" id="runnerForm" method="post" name="runner">
				<img id="close" src="/runninglife/resources/images/Close-2-icon.png"
					onclick="div_hide()">
				<h2>${contest.contestName}</h2>
				<hr>
				<div>
				<label for="disabledTextInput">會員帳號(測試用)</label>
				<input type="text" class="form-control" name="pk.memberID" value="${member.memberID}"/>
				</div>
				<input type="text" class="form-control" name="pk.contestID"  value="${contest.contestID}" >
<%-- 				<input type="text" class="form-control" name="eventID" value="${contest.contestName}"/> --%>
				<select class="form-control" name="eventID" >
					<option value="0">項目</option>
					<c:forEach var="event" items="${events}">
						<label class="control-label">項目</label>
						<option value="${event.eventID}">${event.eventName}</option>
					</c:forEach>
				</select> <select class="form-control" name="teamID">
					<option value="0">組別</option>
					<c:forEach var="team" items="${teams}">
						<option value="${team.teamID}">${team.teamName}</option>
					</c:forEach>
				</select> <select class="form-control" name="clothesSize">
					<option value="0">衣服尺寸</option>
					<c:forEach var="aClothes" items="${clothes}">
						<option value="${aClothes.clothesSize}">${aClothes.clothesSize}</option>
					</c:forEach>
<%-- 				<a href="/runninglife/contest/apply?id=${contest.contestID}" --%>
<!-- 					id="submit">Send</a> -->
					<input class="form-control btn btn-info" type="submit"/>
			</form>
		</div>
		<!-- Popup Div Ends Here -->
	</div>
	<button id="popup" onclick="div_show()">Popup</button>
</body>

<script src="/runninglife/resources/js/time.js"></script>
<script src="/runninglife/resources/js/jquery.countdown.js"></script>
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
	
	function getParameterByName(name, url) {
	    if (!url) url = window.location.href;
	    name = name.replace(/[\[\]]/g, "\\$&");
	    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
	        results = regex.exec(url);
	    if (!results) return null;
	    if (!results[2]) return '';
	    return decodeURIComponent(results[2].replace(/\+/g, " "));
	}
	$(function() {
		
		var msg = getParameterByName('msg');
		if(msg!=null){alert(msg)}else{alert(nothing)}
		
		//項目刪除按鈕綁定
		$("#eventBody")
				.on(
						"click",
						".btn-danger",
						function() {
							var eventIDUrl = $(this).attr("id");
							console.log($(this).attr("id"));
							var eventRow = $(this).parent().parent();
							$
									.ajax({
										mimeType : "text/html; charset=UTF-8", //alert可以show出物件內容
										type : "POST",
										url : eventIDUrl,
										contentType : "application/x-www-form-urlencoded;charset=UTF-8",
										success : function(data) {
											alert(data)
											eventRow.remove();
										}
									});
						});
		//分組刪除按鈕綁定
		$("#teamBody").on("click", ".btn-danger", function() {
			var teamID = $(this).parent().parent().children(".teamID").text();
// 			alert(teamID);
			var teamRow = $(this).parent().parent();
			$.ajax({
				mimeType : "text/html; charset=UTF-8", //alert可以show出物件內容
				type : "POST",
				url : "/runninglife/team/delete",
				data : {
					id : teamID
				},
				success : function(data) {
					alert(data)
					teamRow.remove();
				}
			});
		});

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
	//ㄒㄧㄣ
	$('#teamForm').submit(function(e) {
		e.preventDefault();
		var JsonObj = $(this).serializeFormJSON();
		var JsonStr = JSON.stringify(JsonObj);
		var contestID = $("#contestID").text();
		alert(JsonStr);
		alert(contestID);
		
		if($('#teamName').val()==""||$('#ageRange').val()==""){
			alert("請輸入完整資料");
		}else{
		$.ajax({
			type : "POST",
			url : "/runninglife/" + contestID + "/team/add",
			contentType : "application/json",
			data : JsonStr,
			mimeType : "application/json; charset=UTF-8",
			success : showTeam
		});
		}
	})
	function showTeam(team) {
		var upper = team.ageRange + 9;
		alert("showTeam");
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
	}

	//新增event
	$('#eventForm').submit(function(e) {
		e.preventDefault();
		if ($('#eventName').val() == "") {
			$('#eventName').switchClass()
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

		$.ajax({
			type : "POST",
			url : "/runninglife/${contest.contestID}/event/add",
			contentType : "application/json",
			data : data2,
			mimeType : "application/json; charset=UTF-8",
			success : showEvent
		});

	});
	function showEvent(event) {
		alert(event);
		console.log(event.fee);
		$('#eventForm')
				.parent()
				.before(
						'<tr><td>'
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
								+ '/delete"class="btn btn-danger  delete" role="button"data-text="真的要刪除此項目嗎?" data-confirm-button="是的"data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a></td></tr>');

	}
	
	$("#applyLink").on("click", function() {
		document.getElementById('applyForm').style.display = "block";
	})

	//Function To Display Popup
	function div_show() {
		document.getElementById('applyForm').style.display = "block";
	}
	//Function to Hide Popup
	function div_hide() {
		document.getElementById('applyForm').style.display = "none";
	}
</script>
</html>