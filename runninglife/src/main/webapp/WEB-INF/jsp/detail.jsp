<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="/runninglife/resources/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet"
	href="/runninglife/resources/css/jquery.countdown.css" type="text/css">


</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script> 
<script src="/runninglife/resources/js/jquery.countdown.min.js"></script>
<script src="/runninglife/resources/js/bootstrap.min.js"></script>


<body class="smoothscroll enable-animation">

	<%-- 	${contest.place} ${contest.startDate} ${contestName} ${begin}${end} --%>
	<%-- 	${contest.goal}${contest.organizer}${contest.coorganizer} --%>
	<%-- 	${contest.contestPhotoPath} --%>
	<div id="timer">${timer}</div>

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
								<th class="col-xs-2">報名金額</th>
								<th class="col-xs-2">晶片押金</th>
								<th class="col-xs-2">開放名額</th>
								<th class="col-xs-2">起跑時間</th>
								<th class="col-xs-2">限制時間</th>
								<th class="col-xs-2"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="event" items="${events}">
								<tr>
									<td>${event.eventName}</td>
									<td>${event.fee}</td>
									<td>100</td>
									<td>$${event.quota}</td>
									<td>${event.whenToRun}</td>
									<td>${event.limitTime }</td>
									<td><a
										href="/runninglife/contest/event/${event.eventID}/delete"
										class="btn btn-danger  delete" role="button"
										data-text="真的要刪除此項目嗎?" data-confirm-button="是的"
										data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a></td>
								</tr>
							</c:forEach>
							<tr>
								<form id="jsonForm" onsubmit="ajax2()" action="/runninglife/contest/${contest.contestID}/event/add">
									<td><input type="text" class="form-control" type="file"
										id="eventName" name="eventName" /></td>
									<td><input type="text" class="form-control" type="file"
										id="fee" name="fee" /></td>
									<td><input type=submit name="submit" value="click" /></td>
									<td><input type="text" class="form-control" type="file"
										id="quota" name="quota" /></td>
									<td><input type="text" class="form-control" type="file"
										id="whenToRun" name="whenToRun" /></td>
									<td><input type="text" class="form-control" type="file"
										id="limitTime" name="limitTime" /></td>
									<td class="col-xs-2"><a
										href="/runninglife/contest/${contest.contestID}/event/add"
										class="btn btn-primary  delete" role="button">新增</a></td>
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
					<p>依性別及年齡共分為10組，詳如下表</p>
				</div>
				<div class="table-responsive">
					<table
						class="table table-hover table-bordered lohas-table text-center ">
						<thead>
							<tr>
								<th class="col-xs-2">組別</th>
								<th class="col-xs-4">年齡範圍</th>
								<th style="display: none">年齡範圍</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var='team' items='${teams}'>
								<tr>
									<td>${team.teamName}</td>
									<td>${team.ageRange}~${team.ageRange + 9}</td>
								</tr>
							</c:forEach>
						</tbody>
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
			<!-- 			<div id="note"></div> -->
			<a href="#"
				class="btn btn-featured btn-green btn-inverse margin-bottom-30 size-25">
				<span>立即報名</span> <i class="fa fa-pencil-square-o"></i>
			</a>

			<div
				class="box-flip box-color box-icon box-icon-center box-icon-round box-icon-large text-center margin-bottom-40"
				style="min-height: 451px;">
				<div class="box1"
					style="min-height: 451px; background-color: rgb(115, 185, 220);">
					<div class="box-icon-title">
						<i class="fa fa-pencil-square-o"></i>
					</div>
					<div class="row margin-bottom-0">
						<p class="size-18">
							賽事問題請洽<br>神豐國際同濟會
						</p>
						<hr>
						<p class="size-18">報名問題請洽樂活資訊</p>
						<p class="size-14">
							<i class="fa fa-phone margin-right-10"></i>05-5336010 <br>聯絡時間：週一至週五
							<br>(08:30~12:00、13:30~17:00)
						</p>
						<p class="size-14">
							<i class="fa fa-envelope margin-right-10"></i>lohasnet.tw@gmail.com
						</p>
					</div>
					<hr>
					<a href="#" class="btn btn-lg btn-default btn-bordered"> <span>立即報名</span>
					</a>
				</div>
			</div>

		</div>
	</div>
	</section>
</body>

<script src="/runninglife/resources/js/time.js"></script>
<script src="/runninglife/resources/js/jquery.countdown.js"></script>
<script type="text/javascript">

$('#jsonForm').ajaxForm({
    type: 'post',
    success: processJson
});
function processJson(data) {
    //debugger;
    alert("it worked" + data);
    console.log("respose: " + data);
}
</script>
</html>