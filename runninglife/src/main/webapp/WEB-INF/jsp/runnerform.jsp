<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="/runninglife/resources/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"
	type="text/css">
<body>

	<div class="container">
		<%-- 		<form:form   --%>
		<%-- 			modelAttribute="runnerForm"> --%>
		<!-- 			<table class="class=" table table-striped -->
		<!-- 				table-bordered" -->
		<!-- 							width="100%" " id="runnerForm"> -->
		<!-- 				<thead> -->
		<!-- 					<tr> -->
		<!-- 						<th>編號</th> -->
		<!-- 						<th>會員姓名</th> -->
		<!-- 						<th>賽事名稱</th> -->
		<!-- 						<th class="hidden">(隱藏)memberID</th> -->
		<!-- 						<th class="hidden">(隱藏)contestID</th> -->
		<!-- 						<th class="hidden">(隱藏)teamID</th> -->
		<!-- 						<th class="hidden">(隱藏)eventID</th> -->
		<!-- 						<th>競賽項目</th> -->
		<!-- 						<th>紀念衣尺寸</th> -->
		<!-- 						<th>成績</th> -->
		<!-- 					</tr> -->
		<!-- 				</thead> -->
		<!-- 				<tbody> -->
		<%-- 					<c:forEach items="${runnerForm.runners}" var="runner" --%>
		<%-- 						varStatus="status"> --%>
		<!-- 						<tr> -->
		<%-- 							<td align="center">${status.count}</td> --%>
		<%-- 							<td align="center">${runner.pk.memberID}</td> --%>
		<%-- 							<td align="center">${runner.contest.contestName}</td> --%>
		<!-- 							<td align="center"><input -->
		<%-- 								name="runners[${status.index}].pk.memberID" --%>
		<%-- 								value="${runner.pk.memberID}" /></td> --%>
		<!-- 							<td align="center"><input -->
		<%-- 								name="runners[${status.index}].pk.contestID" --%>
		<%-- 								value="${runner.pk.contestID}" /></td> --%>
		<!-- 							<td align="center"><input -->
		<%-- 								name="runners[${status.index}].teamID" value="${runner.teamID}" /></td> --%>
		<%-- 												<td align="center"><input name="runners[${status.index}].eventID" value="${runner.eventID}"/></td> --%>
		<%-- 							<td align="center">${runner.eventID}</td> --%>

		<%-- 							<td><select name="runners[${status.index}].eventID"> --%>
		<%-- 									<option value="${runner.eventID}">${runner.event.eventName}</option> --%>
		<!-- 									<option value="">==========</option> -->
		<%-- 									<c:forEach var='event' items="${events}"> --%>
		<%-- 										<option value="${event.eventID}">${event.eventName}</option> --%>
		<%-- 									</c:forEach> --%>
		<!-- 							</select></td> -->
		<%-- 							<td><select name="runners[${status.index}].clothesSize"> --%>
		<%-- 									<option value="${runner.clothesSize}">${runner.clothesSize}</option> --%>
		<!-- 									<option value="">=======</option> -->
		<%-- 									<c:forEach var='clothes' items="${clothes}"> --%>
		<%-- 										<option value="${clothes.clothesSize}">${clothes.clothesSize}</option> --%>
		<%-- 									</c:forEach> --%>
		<!-- 							</select></td> -->
		<%-- 							<td><input name="runners[${status.index}].runTime" --%>
		<%-- 								value="${runner.runTime}" /></td> --%>
		<!-- 						</tr> -->
		<%-- 					</c:forEach> --%>
		<!-- 				</tbody> -->
		<!-- 			</table> -->
		<!-- 			<br /> -->
		<!-- 			<input type="submit" value="Save" /> -->

		<%-- 		</form:form> --%>

		<h2></h2>
		<div class="row">
			<form name="runnerForm" method="post"
				action="/runninglife/runner/update">
				<table name="runnerForm" id="test"
					class="table table-striped table-bordered" width="100%">
					<thead>
						<tr class="success">
							<th>編號</th>
							<th>會員姓名</th>
							<th>賽事名稱</th>
							<th class="hidden">(隱藏)memberID</th>
							<th class="hidden">(隱藏)contestID</th>
							<th class="hidden">(隱藏)teamID</th>
							<th class="hidden">(隱藏)eventID</th>
							<th>報名狀態</th>
							<th>競賽項目</th>
							<th>紀念衣尺寸</th>
							<th>成績</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${runnerForm.runners}" var="runner"
							varStatus="status">
							<tr>
								<td align="center">${status.count}</td>
								<td align="center">${runner.pk.memberID}</td>
								<td align="center">${runner.contest.contestName}</td>
								<td class="hidden" align="center"><input
									name="runners[${status.index}].pk.memberID"
									value="${runner.pk.memberID}" /></td>
								<td class="hidden" align="center"><input
									name="runners[${status.index}].pk.contestID"
									value="${runner.pk.contestID}" /></td>
								<td class="hidden" align="center"><input
									name="runners[${status.index}].teamID" value="${runner.teamID}" /></td>
								<%-- 					<td align="center"><input name="runners[${status.index}].eventID" value="${runner.eventID}"/></td> --%>
								<td class="hidden" align="center">${runner.eventID}</td>

								<td><select name="runners[${status.index}].status">
										<option value="${runner.status}">${runner.status}</option>
										<option value="">==========</option>
										<option value="已繳費">已繳費</option>
										<option value="尚未繳費">尚未繳費</option>
										<option value="退費">取消報名</option>
								</select></td>
								<td><select name="runners[${status.index}].eventID">
										<option value="${runner.eventID}">${runner.event.eventName}</option>
										<option value="">==========</option>
										<c:forEach var='event' items="${events}">
											<option value="${event.eventID}">${event.eventName}</option>
										</c:forEach>
								</select></td>
								<td><select name="runners[${status.index}].clothesSize">
										<option value="${runner.clothesSize}">${runner.clothesSize}</option>
										<option value="">=======</option>
										<c:forEach var='clothes' items="${clothes}">
											<option value="${clothes.clothesSize}">${clothes.clothesSize}</option>
										</c:forEach>
								</select></td>
								<td><input name="runners[${status.index}].runTime"
									value="${runner.runTime}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form />
				<input id="test" type="submit" value="查詢" />
		</div>

	</div>

</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="/runninglife/resources/js/bootstrap.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#runnerForm').DataTable({

			"lengthMenu" : [ [ 5, 10, 15, -1 ], [ 5, 10, 15, "全部" ] ],
			"language" : {
				"info" : "",
				"infoEmpty" : "沒有資料",
				"infoFiltered" : "",
				"zeroRecords" : "沒有符合的結果",
				"lengthMenu" : "顯示 _MENU_ 筆資料",
				"search" : "搜尋",
				"paginate" : {
					"first" : "首頁",
					"previous" : "上一頁",
					"next" : "下一頁",
					"last" : "尾頁"
				}
			}

		});
		$('#test').DataTable({

			"lengthMenu" : [ [ 5, 10, 15, -1 ], [ 5, 10, 15, "全部" ] ],
			"language" : {
				"info" : "",
				"infoEmpty" : "沒有資料",
				"infoFiltered" : "",
				"zeroRecords" : "沒有符合的結果",
				"lengthMenu" : "顯示 _MENU_ 筆資料",
				"search" : "搜尋",
				"paginate" : {
					"first" : "首頁",
					"previous" : "上一頁",
					"next" : "下一頁",
					"last" : "尾頁"
				}
			},

		});
		$('#update')
				.click(
						function() {
							var data = table.$('input, select').serialize();
							alert("The following data would have been submitted to the server: \n\n"
									+ data.substr(0, 120) + '...');
							return false;
						});
	})
</script>
</html>