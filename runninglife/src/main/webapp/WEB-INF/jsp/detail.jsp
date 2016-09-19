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
	href="/runninglife/resources/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet"
	href="/runninglife/resources/css/jquery.countdown.css" type="text/css">
<link rel="stylesheet" href="/runninglife/resources/css/apply.css"
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="/runninglife/resources/js/jquery.countdown.min.js"></script>
<script src="/runninglife/resources/js/bootstrap.min.js"></script>
<script src="/runninglife/resources/js/jquery.confirm.min.js"></script>


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
									<td class="text-left">${contest.registrationBegin}起至~${contest.registrationEnd}止額滿為止</td>
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

									<th class="col-xs-1">編號</th>
									<th class="col-xs-2">項目名稱</th>
									<th class="col-xs-2">距離</th>
									<th class="col-xs-2">報名費用</th>
									<th class="col-xs-2">開放名額</th>
									<th class="col-xs-2">起跑時間</th>
									<th class="col-xs-2">限制時間(分)</th>
									<th class="col-xs-4"></th>
									<!-- 								<th class="col-xs-2"></th> -->
								</tr>
							</thead>
							<tbody id="eventBody">
								<c:forEach var="event" items="${events}">
									<tr>
										<td>${event.eventID}</td>
										<td>${event.eventName}</td>
										<td>${event.distance}</td>
										<td>${event.fee}</td>
										<td>${event.quota}</td>
										<td>${event.whenToRun}</td>
										<td>${event.limitTime }</td>
										<td><a id="/runninglife/event/${event.eventID}/delete"
											class="btn btn-danger  delete" role="button"
											data-text="真的要刪除此項目嗎?" data-confirm-button="是的"
											data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a></td>
										<td><a class="btn btn-warning  edit" role="button">修改</a></td>


										<!-- 									<td> -->
										<!-- 										<div class="dropdown"> -->
										<!-- 											<button class="btn btn-primary dropdown-toggle" type="button" -->
										<!-- 												data-toggle="dropdown"> -->
										<!-- 												編輯<span class="caret"></span> -->
										<!-- 											</button> -->
										<!-- 											<ul class="dropdown-menu"> -->
										<%-- 												<li><a id="/runninglife/event/${event.eventID}/delete" --%>
										<!-- 										class="btn btn-danger  delete" role="button" -->
										<!-- 										data-text="真的要刪除此項目嗎?" data-confirm-button="是的" -->
										<!-- 										data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a></li> -->
										<!-- 												<li><a class="btn btn-warning  delete" role="button">修改</a></li> -->
										<!-- 											</ul> -->
										<!-- 										</div> -->
										<!-- 									</td> -->
									</tr>
								</c:forEach>
								<tr>
									<form id="eventForm"
										action="/runninglife/${contest.contestID}/event/add">
										<td><input type="text"
											class="form-group form-control readonly" id="eventID"
											name="eventID" placeholder="標號" readonly /></td>
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
										<td><input type="number" class="form-control"
											id="limitTime" name="limitTime" placeholder="90" /></td>
										<td><input type="submit"
											class="form-control  btn-success" name="submit" value="更新" /></td>
									</form>
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
						<p>依性別及年齡分組，詳如下表</p>
					</div>
					<div class="table-responsive">
						<table class="table table-hover table-bordered text-center ">
							<thead>
								<tr class="info">

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
										<td><a class="btn btn-warning  edit" role="button">修改</a></td>
									</tr>
								</c:forEach>
								<tr>
									<form id="teamForm">
										<td><input type="text" class="form-control" name="teamID"
											id="teamID" placeholder="" readonly /></td>
										<td><input type="text" class="form-control"
											name="teamName" id="teamName" placeholder="男甲組" /></td>
										<td><input type="number" class="form-control"
											name="ageRange" id="ageRange" placeholder="19" /></td>
										<td><input type="submit"
											class="form-control  btn-success" name="submit" value="新增" /></td>
									</form>
								</tr>

							</tbody>
						</table>
					</div>
					<!-- 衣服尺寸 -->
					<div class=" margin-top-40">
						<h4 class="bs-callout bs-callout-info">
							<span style="color: #5bc0de">紀念衣尺寸</span>
						</h4>
						<p>尺寸詳如下表</p>
					</div>
					<div class="table-responsive">
						<table
							class="table table-hover table-bordered  text-center table-reflow">
							<tr>
								<td class="info">尺寸</td>
								<c:forEach var='aClothes' items='${clothes}'>
									<td>${aClothes.clothesSize}</td>
								</c:forEach>
							</tr>
							<tr>
								<td class="info">胸圍(cm)</td>
								<c:forEach var='aClothes' items='${clothes}'>
									<td>${aClothes.breast}</td>
								</c:forEach>
							</tr>
							<tr>
								<td class="info">衣長(cm)</td>
								<c:forEach var='aClothes' items='${clothes}'>
									<td>${aClothes.length}</td>
								</c:forEach>
							</tr>
						</table>
					</div>
					<!-- 報名辦法 -->
					<div
						class="heading-title heading-border heading-color margin-top-40">
						<h4>
							<span>報名辦法</span>
						</h4>
					</div>
					<ol>
						<li>本次賽會僅採用網路報名，不接受現場報名。</li>
						<li>填寫網路報名資料後系統會產生一組繳費帳號，每組帳號均為唯一帳號，不會與它人或其它參賽團隊重複，請依照指定時間內進行繳費才算完成報名。</li>
						<li>繳費方式：7-ELEVEN超商ibon繳費、ATM繳款</li>
						<li>繳費完成後約30分鐘後即可到報名系統查詢報名及繳費狀態。</li>
						<li>繳費帳號逾期未繳者，若已逾報名時間，視同放棄報名資格。</li>
						<li>RunningLife僅代收報名費，代收的報名費全數轉交主辦(承辦)單位，收據或發票皆由賽事主辦(承辦)單位開立。倘若報名者對報名費的處理方式有疑慮請洽該主辦(承辦)單位。</li>
						<li>報名時請詳加評估自身實力，報名手續完成者不得改參加比賽項目。</li>
						<li>請注意已完成報名手續並轉帳或匯款成功之選手，報名網路上之資料即無法修改。請於轉帳前先行確認報名資料是否正確，並於轉帳後至原報名網頁確認繳費是否成功。</li>
						<li>大會保有更改所有參賽禮物品樣式之權利。</li>
						<li>若您有網路報名、繳費操作問題請洽【樂活資訊】 <br>電話：(05)533-6010 <br>聯絡時間：週一至週五(08:30~12:00、13:30~17:00)
						</li>
					</ol>
					<!--退費說明 -->
					<div
						class="heading-title heading-border heading-color margin-top-40">
						<h4>
							<span>退費說明</span>
						</h4>
					</div>
					<p>退費請致電承辦單位05-5336010提出取消申請，一旦確認取消即喪失參賽權，物資所有權，依照申請時間而有不同的退費標準，請斟酌情況再提出申請。</p>
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
									href="/runninglife/resources/${contest.contestID}route.jpg"
									target="blank"> <img class="img-responsive"
									src="/runninglife/resources/${contest.contestID}route.jpg">
								</a> </figure>
							</div>
						</div>
					</div>
				</div>

				<div id="runnerList" class="tab-pane fade">
					<div class="bs-callout bs-callout-info">
						<h4 class="">
							<span style="color: #5bc0de">參賽名單</span>
						</h4>
					</div>
					<div class="row">
						<table class="table table-hover table-bordered lohas-table text-center">
							<thead>
								<tr role="row">
									<th width="10%" class="sorting_disabled" rowspan="1"
										colspan="1" style="width: 10px;">姓名</th>
									<th width="10%" class="sorting_disabled" rowspan="1"
										colspan="1" style="width: 10px;">性別</th>
									<th width="10%" class="sorting_disabled" rowspan="1"
										colspan="1" style="width: 10px;">項目</th>
									<th width="10%" class="sorting_disabled" rowspan="1"
										colspan="1" style="width: 10px;">分組</th>
									<th width="10%" class="sorting_disabled" rowspan="1"
										colspan="1" style="width: 10px;">衣服</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var='runner' items="${contest.runners}">
									<tr>
										<td>${runner.pk.memberID}</td>
										<td>2</td>
										<td>${runner.event.eventName}</td>
										<td>${runner.team.teamName}</td>
										<td>${runner.clothesSize}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					
				</div>

			</div>
			<!-- 11 -->
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3" id="activity-sidebar">
			<div id="countdown" class="countdownHolder breadcrumb size-10"></div>
			<!-- 籃圈 -->
			<div class="panel-group text-center margin-bottom-40"
				style="min-height: 351px;">
				<div class="panel panel-primary"
					style="min-height: 351px; background-color: rgb(115, 185, 220);">
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
		<div id="popupApply" class="">
			<!-- 報名表單 -->
			<form action="/runninglife/apply" id="runnerForm" method="post"
				name="runner">
				<img id="close" src="/runninglife/resources/images/Close-2-icon.png"
					onclick="div_hide()">
				<h3>報名賽事</h3>
				<hr>
				<div>
					<label for="disabledTextInput">會員帳號(測試用)</label> <input type="text"
						class="form-control" name="pk.memberID" value="${member.memberID}" />
				</div>
				<div>
					<label for="disabledTextInput">賽事編號(測試用)</label> <input type="text"
						class="form-control" name="pk.contestID"
						value="${contest.contestID}">
				</div>

				<div>
					<label for="disabledTextInput">項目</label> <select
						class="form-control" name="eventID">
						<option value="0">請選擇</option>
						<c:forEach var="event" items="${events}">
							<option value="${event.eventID}">${event.eventName}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<label for="disabledTextInput">紀念衣尺寸</label> <select
						class="form-control" name="clothesSize">
						<option value="0">請選擇</option>
						<c:forEach var="aClothes" items="${clothes}">
							<option value="${aClothes.clothesSize}">${aClothes.clothesSize}</option>
						</c:forEach>
					</select>
				</div>
				<div>
					<input class="btn btn-info" type="submit" />
				</div>

			</form>
		</div>
		<!-- Popup Div Ends Here -->
	</div>

	<!-- 	<div id="eventPopForm"> -->
	<!-- 		<!-- 彈出報名 -->
	<!-- 		<div id="popupEvent" class="form-group"> -->
	<!-- 			<!-- 報名表單 -->
	<%-- 			<form action="/runninglife/event/add" id="eventFormNew" method="post" --%>
	<%-- 				name="event"> --%>
	<!-- 				<img id="closeEvent" -->
	<!-- 					src="/runninglife/resources/images/Close-2-icon.png" -->
	<!-- 					onclick="div_hide()"> -->
	<!-- 				<h2>編輯項目</h2> -->
	<!-- 				<hr> -->
	<!-- 				<div class="form-group"> -->
	<!-- 					<label for="disabledTextInput"></label> <input type="text" -->
	<!-- 						class="form-control" id="contestID" name="contestID" value=""> -->
	<!-- 				</div> -->
	<!-- 				<div class="form-group"> -->
	<!-- 					<label for="disabledTextInput">賽事名稱</label> <input type="text" -->
	<!-- 						class="form-control" id="contestName" name="contestName" value=""> -->
	<!-- 				</div> -->
	<!-- 				<div class="form-group"> -->
	<!-- 					<label for="disabledTextInput">距離</label> <input type="text" -->
	<!-- 						class="form-control" id="distance" name="distance" value=""> -->
	<!-- 				</div> -->
	<!-- 				<div class="form-group"> -->
	<!-- 					<label for="disabledTextInput">費用</label> <input type="text" -->
	<!-- 						class="form-control" id="fee" name="fee" value=""> -->
	<!-- 				</div> -->
	<!-- 				<div class="form-group"> -->
	<!-- 					<label for="disabledTextInput">名額</label> <input type="text" -->
	<!-- 						class="form-control" id="quota" name="quota" value=""> -->
	<!-- 				</div> -->
	<!-- 				<div class="form-group"> -->
	<!-- 					<label for="disabledTextInput">起跑時間</label> <input type="text" -->
	<!-- 						class="form-control" id="whenToRun" name="whenToRun" value=""> -->
	<!-- 				</div> -->
	<!-- 				<div class="form-group"> -->
	<!-- 					<label for="disabledTextInput">時間限制</label> -->
	<!-- 				</div> -->
	<!-- 				<div class="form-group"> -->
	<!-- 					<input type="text" class="form-control" id="limitTime" -->
	<!-- 						name="limitTime" value=""> -->
	<!-- 				</div> -->


	<%-- 			</form> --%>
	<!-- 		</div> -->
	<!-- 		<!-- Popup Div Ends Here -->
	<!-- 	</div> -->



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

	var eventMark = $('#contestID');
	var teamMark = $('#contestID');
	$(function() {
		//項目刪除按鈕綁定
		$("#eventBody")
				.on(
						"click",
						".btn-danger",
						function() {
							var eventIDUrl = $(this).attr("id");
							console.log($(this).attr("id"));
							var eventRow = $(this).parent().parent();
							$(this)
									.confirm(
											{
												post : true,
												confirmButtonClass : "btn-danger btn-sm",
												cancelButtonClass : "btn-default btn-sm",
												dialogClass : "modal-dialog modal-sm", // Bootstrap classes for large modal
												confirm : function(button) {
													console.log(123);
													$
															.ajax({
																mimeType : "text/html; charset=UTF-8", //alert可以show出物件內容
																type : "POST",
																url : eventIDUrl,
																contentType : "application/x-www-form-urlencoded;charset=UTF-8",
																success : function(
																		data) {
																	alert(data)
																	eventRow
																			.remove();
																}
															});
												},
												cancel : function(button) {
													console.log(12345);// nothing to do
												}
											});

						});
		//項目更新按鈕榜定
		$("#eventBody").on(
				"click",
				".btn-warning",
				function() {
					if (eventMark.length) {
						eventMark.parent().parent().removeClass("warning");
					}
					var eventID = $(this).parent().parent().children(
							"td:nth-child(1)").text();
					var eventName = $(this).parent().parent().children(
							"td:nth-child(2)").text();
					var distance = $(this).parent().parent().children(
							"td:nth-child(3)").text();
					var fee = $(this).parent().parent().children(
							"td:nth-child(4)").text();
					var quota = $(this).parent().parent().children(
							"td:nth-child(5)").text();
					var whenToRun = $(this).parent().parent().children(
							"td:nth-child(6)").text();
					var limitTime = $(this).parent().parent().children(
							"td:nth-child(7)").text();
					$(this).parent().parent().addClass("warning");
					console.log("eventID:" + eventID);

					eventMark = $(this);
					$('#eventID').val(eventID);
					$('#eventName').val(eventName);
					$('#distance').val(distance);
					$('#fee').val(fee);
					$('#quota').val(quota);
					$('#whenToRun').val(whenToRun);
					$('#limitTime').val(limitTime);
				})

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
		//分組更新按鈕榜定
		$("#teamBody").on(
				"click",
				".btn-warning",
				function() {
					if (teamMark.length) {
						teamMark.parent().parent().removeClass("warning");
					}

					var teamID = $(this).parent().parent().children(
							'td:nth-child(1)').text();
					var teamName = $(this).parent().parent().children(
							'td:nth-child(2)').text();
					var ageRange = $(this).parent().parent().children(
							'td:nth-child(3)').text().substr(0, 2);

					$(this).parent().parent().addClass("warning");

					teamMark = $(this);
					$('#teamID').val(teamID);
					$('#teamName').val(teamName);
					$('#ageRange').val(ageRange);

				})

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
	//送出分組
	$('#teamForm').submit(function(e) {
		e.preventDefault();
		var JsonObj = $(this).serializeFormJSON();
		var JsonStr = JSON.stringify(JsonObj);
		var contestID = $("#contestID").text();
		alert(JsonStr);

		// 		if ($('#teamName').val() == "" || $('#ageRange').val() == "") {
		// 			alert("請輸入完整資料");
		// 		}
		if ($.trim($('#teamID').val()) == "") {
			alert('新增');
			$.ajax({
				type : "POST",
				url : "/runninglife/" + contestID + "/team/add",
				contentType : "application/json",
				data : JsonStr,
				mimeType : "application/json; charset=UTF-8",
				success : addTeam
			});
		} else {
			alert("更新");
			$.ajax({
				type : "POST",
				url : "/runninglife/" + contestID + "/team/add",
				contentType : "application/json",
				data : JsonStr,
				mimeType : "application/json; charset=UTF-8",
				success : updateTeam
			});
		}
	})
	function addTeam(team) {
		var upper = team.ageRange + 9;
		alert("新增成功");
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

		$('#teamID').val("");
		$('#teamName').val("");
		$('#ageRange').val("");
	}
	function updateTeam(team) {
		alert("更新成功");
		teamMark.parent().parent().children('td:nth-child(2)').text(
				team.teamName);
		teamMark.parent().parent().children('td:nth-child(3)').text(
				team.ageRange);
		teamMark.parent().parent().removeClass("warning");

		$('#teamID').val("");
		$('#teamName').val("");
		$('#ageRange').val("");
	}

	//送出event
	$('#eventForm').submit(function(e) {
		e.preventDefault();
		if ($('#eventName').val() == "") {
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

		if ($.trim($('#eventID').val()) == "") {
			alert("新增");
			$.ajax({
				type : "POST",
				url : "/runninglife/${contest.contestID}/event/add",
				contentType : "application/json",
				data : data2,
				mimeType : "application/json; charset=UTF-8",
				success : addEvent
			});
		} else {
			alert("更新");
			$.ajax({
				type : "POST",
				url : "/runninglife/${contest.contestID}/event/add",
				contentType : "application/json",
				data : data2,
				mimeType : "application/json; charset=UTF-8",
				success : updateEvent
			});

		}

	});
	function addEvent(event) {
		alert("更新成功")
		$('#eventForm')
				.parent()
				.before(
						'<tr><td>'
								+ event.eventID
								+ '</td><td>'
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
								+ '/delete"class="btn btn-danger  delete" role="button"data-text="真的要刪除此項目嗎?" data-confirm-button="是的"data-cancel-button="不了"data-confirm-button-class: "btn-danger">刪除</a></td>'
								+ '<td><a class="btn btn-warning  delete" role="button">修改</a></td></tr>');

		$('#eventID').val("");
		$('#even' + 'tName').val("");
		$('#distance').val("");
		$('#fee').val("");
		$('#quota').val("");
		$('#limitTime').val("");
		$('#whenToRun').val("");
	}
	function updateEvent(event) {
		alert("更新成功");
		eventMark.parent().parent().children("td:nth-child(1)").text(
				event.eventID);
		eventMark.parent().parent().children("td:nth-child(2)").text(
				event.eventName);
		eventMark.parent().parent().children("td:nth-child(3)").text(
				event.distance);
		eventMark.parent().parent().children("td:nth-child(4)").text(event.fee);
		eventMark.parent().parent().children("td:nth-child(5)").text(
				event.quota);
		eventMark.parent().parent().children("td:nth-child(6)").text(
				event.whenToRun);
		eventMark.parent().parent().children("td:nth-child(7)").text(
				event.limitTime);
		eventMark.parent().parent().removeClass("warning");

		$('#eventID').val("");
		$('#even' + 'tName').val("");
		$('#distance').val("");
		$('#fee').val("");
		$('#quota').val("");
		$('#limitTime').val("");
		$('#whenToRun').val("");
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
	// 	$(".delete").confirm({
	// 		post : true,
	// 		confirmButtonClass : "btn-danger btn-sm",
	// 		cancelButtonClass : "btn-default btn-sm",
	// 		dialogClass : "modal-dialog modal-sm", // Bootstrap classes for large modal
	// 		confirm: function(button) {

	// 		    },
	// 		cancel: function(button) {
	// 		        // nothing to do
	// 		    }
	// 	});
</script>
</html>