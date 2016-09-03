<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="/runninglife/resources/css/bootstrap.min.css">
<script src="/runninglife/resources/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
</head>
<body>

	${contest.place} ${contest.startDate} ${contestName} ${begin}${end}
	${contest.goal}${contest.organizer}${contest.coorganizer}
	${contest.contestPhotoPath}


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
								<td class="text-left">敬請期待</td>
							</tr>
							<tr>
								<td>地區簡介</td>
								<td class="text-left">神岡區早期為粵籍人士所開發，因此舊稱「新廣莊」，似有「新闢的廣大平原」之意，而「神岡」與「新廣」的粵語發音頗為相似，可能後來由於閩人入墾，加上日久口誤，而沿用「神岡」之名。清道光二十二年，神岡置莊，泉州人來此構居，於是遂成泉州人聚落。臺灣割讓日本後，日本把此地分為「神岡」、「社口」、「三角仔」等三個區域。神岡有「早期中部開發中心」之稱，先人入豐原、東勢、后里等地開墾，都需經由本地；因此古蹟很多，這些文化資產已成為神岡擁有發展觀光事業潛力。民國九年三區統一改為「神岡庄」，隸屬臺中州豐原郡神岡庄。臺灣光復後始設「神岡鄉」，民國九十九年十二月二十五日改為神岡區。</td>
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
				<div
					class="heading-title heading-border heading-color margin-top-40">
					<h4>
						<span>競賽分組</span>∕全程馬拉松組、半程馬拉松組
					</h4>
					<p>依性別及年齡共分為12組，詳如下表</p>
				</div>
				<div class="table-responsive">
					<table 
						class="table table-hover table-bordered lohas-table text-center">
						<thead>
							<tr>
								<th class="col-xs-2">組別</th>
								<th class="col-xs-4">年齡範圍</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var='team' items='${teams}'>
								<tr>
									<td>${team.teamName}</td>
									<td>${team.ageRange}~${team.ageRange + 10}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		
<script>$(document).ready(function() {
    $('#example').DataTable();
} );
</script>

	</div>
</body>
</html>