<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編輯賽事</title>
</head>
<body>
	<div class="container ">
		<div class="col-lg-9 col-md-9 col-sm-9 letter-spacing-1">
			<div class="text-center">
				<h2>編輯賽事</h2>
			</div>
			${action}

<%-- 			<c:choose> --%>
<%-- 				<c:when test="${action == 1 }"> --%>
<!--       						 Salary is very low to survive. -->
<%--   				</c:when> --%>
<%-- 				<c:otherwise> --%>
<!--       					  No comment sir... -->
<%--    			 	</c:otherwise> --%>
<%-- 			</c:choose> --%>


			<spring:url value="/contest/${contest.contestID}" var="updateContest" />
			<spring:url value="/contest/edit" var="addContest" />

			<form:form class="form-horizontal" method="post"
				acceptCharset="UTF-8" modelAttribute="contest"
				enctype="multipart/form-data" action="${addContest}">

				<form:hidden path="contestID" />

				<spring:bind path="contestName">
					<div class="form-group ${status.error ? 'has-error' : 'has-success'}">
						<label class="col-sm-2 control-label">賽事名稱</label>
						<div class="col-sm-10">
							<form:input path="contestName" type="text" class="form-control"
								id="contestName" placeholder="" />
							<form:errors path="contestName" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="startDate">
					<div class="form-group ${status.error ? 'has-error' : 'has-success'}">
						<label class="col-sm-2 control-label">比賽日期</label>
						<div class="col-sm-10">
							<form:input path="startDate" class="form-control" id="startDate"
								placeholder="2016-09-30" />
							<form:errors path="startDate" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="place">
					<div class="form-group ${status.error ? 'has-error' : 'has-success'}">
						<label class="col-sm-2 control-label">比賽地點</label>
						<div class="col-sm-10">
							<form:input path="place" class="form-control" id="place"
								placeholder="台北市政府捷運站" />
							<form:errors path="place" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<%-- 			<spring:bind path="contestPhotoPath"> --%>
				<%-- 				<div class="form-group ${status.error ? 'has-error' : ''}"> --%>
				<!-- 					<label class="col-sm-2 control-label">圖片</label> -->
				<!-- 					<div class="col-sm-10"> -->
				<%-- 						<form:input path="contestPhotoPath" class="form-control" --%>
				<%-- 							id="contestPhotoPath" placeholder="1.jpg" /> --%>
				<%-- 						<form:errors path="contestPhotoPath" class="control-label" /> --%>
				<!-- 					</div> -->
				<!-- 				</div> -->
				<%-- 			</spring:bind> --%>

				<spring:bind path="registrationBegin">
					<div class="form-group ${status.error ? 'has-error' : 'has-success'}">
						<label class="col-sm-2 control-label">報名開始</label>
						<div class="col-sm-10">
							<form:input path="registrationBegin" rows="5"
								class="form-control" id="registrationBegin"
								placeholder="2016-03-14" cssErrorClass="" />
							<form:errors path="registrationBegin" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="registrationEnd">
					<div class="form-group ${status.error ? 'has-error' : 'has-success'}">
						<label class="col-sm-2 control-label">報名截止</label>
						<div class="col-sm-10">
							<form:input path="registrationEnd" rows="5" class="form-control"
								id="registrationEnd" placeholder="2016-07-14" cssErrorClass="" />
							<form:errors path="registrationEnd" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="organizer">
					<div class="form-group ${status.error ? 'has-error' : 'has-success'}">
						<label class="col-sm-2 control-label">主辦單位</label>
						<div class="col-sm-10">
							<form:textarea path="organizer" rows="5" class="form-control"
								id="organizer" placeholder="主辦單位" />
							<form:errors path="organizer" class="control-label" />
						</div>
					</div>
				</spring:bind>
				<spring:bind path="coorganizer">
					<div class="form-group ${status.error ? 'has-error' : 'has-success'}">
						<label class="col-sm-2 control-label">協辦單位</label>
						<div class="col-sm-10">
							<form:textarea path="coorganizer" rows="5" class="form-control"
								id="coorganizer" placeholder="協辦單位" />
							<form:errors path="coorganizer" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="goal">
					<div class="form-group ${status.error ? 'has-error' : 'has-success'}">
						<label class="col-sm-2 control-label">活動宗旨</label>
						<div class="col-sm-10">
							<form:textarea path="goal" rows="5" class="form-control"
								id="goal" placeholder="活動宗旨" />
							<form:errors path="goal" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<spring:bind path="contestPhotoPath">
					<div class="form-group ${status.error ? 'has-error' : 'has-success'} hidden">
						<label class="col-sm-2 control-label">圖片</label>
						<div class="col-sm-10">
							<form:input path="contestPhotoPath" rows="5" class="form-control"
								id="goal" placeholder="圖片檔案" />
							<form:errors path="contestPhotoPath" class="control-label" />
						</div>
					</div>
				</spring:bind>

				<div class="form-group ${status.error ? 'has-error' : 'has-success'}">
					<label class="col-sm-2 control-label">封面</label>
					<div class="col-sm-10">
						<input class="form-control" type="file" id="fileUpload"
							name=fileUpload />
						<%-- 						<form:errors path="*" class="control-label" /> --%>
					</div>
					<label class="col-sm-2 control-label">橫幅</label>
					<div class="col-sm-10">
						<input class="form-control" type="file" id="fileUpload"
							name=fileUpload />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn-md btn-primary pull-right">確定
						</button>
					</div>
				</div>
			</form:form>
			<%-- 		<form> --%>
			<!-- 			<input type="file" name="file" /> <input type="submit" -->
			<!-- 				value="upload" /> -->
			<%-- 		</form> --%>
			<%-- 		<form action="demo_form.asp" method="get"> --%>
			<!-- 			First name: <input type="text" name="fname"><br> Last -->
			<!-- 			name: <input type="text" name="lname"><br> <input -->
			<!-- 				type="submit" value="Submit"> -->
			<%-- 		</form> --%>
			<!-- 	</div> -->
			<!-- 	<div id="uploadForm"> -->
			<!-- 		<input id="file" type="file" multiple="multiple"/> -->
			<!-- 		<button id="upload" type="button">upload</button> -->
			<!-- 	</div> -->
		</div>
	</div>
</body>
<script type="text/javascript">
	var formData = new FormData();
	formData.append('file', $('#file')[0].files[0]);
	$.ajax({
		url : '/upload',
		type : 'POST',
		cache : false,
		data : formData,
		processData : false,
		contentType : false
	}).done(function(res) {
	}).fail(function(res) {
	});
</script>
</html>