<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">


		<spring:url value="/contest/${contest.contestID}" var="updateContest" />
		<spring:url value="/contest" var="addContestUrl" />

		<form:form class="form-horizontal" method="post" acceptCharset="UTF-8"
			modelAttribute="contest" action="${updateContest}">

			<form:hidden path="contestID" />

			<spring:bind path="contestName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">賽事名稱</label>
					<div class="col-sm-10">
						<form:input path="contestName" type="text" class="form-control"
							id="contestName" placeholder="Name" />
						<form:errors path="contestName" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<spring:bind path="startDate">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">比賽日期</label>
					<div class="col-sm-10">
						<form:input path="startDate" class="form-control" id="startDate"
							placeholder="Email" />
						<form:errors path="startDate" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<spring:bind path="place">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">比賽地點</label>
					<div class="col-sm-10">
						<form:input path="place" class="form-control" id="place"
							placeholder="password" />
						<form:errors path="place" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<spring:bind path="contestPhotoPath">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">圖片</label>
					<div class="col-sm-10">
						<form:password path="contestPhotoPath" class="form-control"
							id="password" placeholder="password" />
						<form:errors path="contestPhotoPath" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<%-- 			<spring:bind path="address"> --%>
			<%-- 				<div class="form-group ${status.error ? 'has-error' : ''}"> --%>
			<!-- 					<label class="col-sm-2 control-label">Address</label> -->
			<!-- 					<div class="col-sm-10"> -->
			<%-- 						<form:textarea path="address" rows="5" class="form-control" --%>
			<%-- 							id="address" placeholder="address" /> --%>
			<%-- 						<form:errors path="address" class="control-label" /> --%>
			<!-- 					</div> -->
			<!-- 				</div> -->
			<%-- 			</spring:bind> --%>

			<%-- 			<spring:bind path="newsletter"> --%>
			<%-- 				<div class="form-group ${status.error ? 'has-error' : ''}"> --%>
			<!-- 					<label class="col-sm-2 control-label">Newsletter</label> -->
			<!-- 					<div class="col-sm-10"> -->
			<!-- 						<div class="checkbox"> -->
			<%-- 							<label> <form:checkbox path="newsletter" id="newsletter" /> --%>
			<!-- 							</label> -->
			<%-- 							<form:errors path="newsletter" class="control-label" /> --%>
			<!-- 						</div> -->
			<!-- 					</div> -->
			<!-- 				</div> -->
			<%-- 			</spring:bind> --%>

			<%-- 			<spring:bind path="framework"> --%>
			<%-- 				<div class="form-group ${status.error ? 'has-error' : ''}"> --%>
			<!-- 					<label class="col-sm-2 control-label">Web Frameworks</label> -->
			<!-- 					<div class="col-sm-10"> -->
			<%-- 						<form:checkboxes path="framework" items="${frameworkList}" --%>
			<%-- 							element="label class='checkbox-inline'" /> --%>
			<!-- 						<br /> -->
			<%-- 						<form:errors path="framework" class="control-label" /> --%>
			<!-- 					</div> -->
			<!-- 				</div> -->
			<%-- 			</spring:bind> --%>

			<%-- 			<spring:bind path="sex"> --%>
			<%-- 				<div class="form-group ${status.error ? 'has-error' : ''}"> --%>
			<!-- 					<label class="col-sm-2 control-label">Sex</label> -->
			<!-- 					<div class="col-sm-10"> -->
			<%-- 						<label class="radio-inline"> <form:radiobutton path="sex" --%>
			<%-- 								value="M" /> Male --%>
			<%-- 						</label> <label class="radio-inline"> <form:radiobutton path="sex" --%>
			<%-- 								value="F" /> Female --%>
			<!-- 						</label> <br /> -->
			<%-- 						<form:errors path="sex" class="control-label" /> --%>
			<!-- 					</div> -->
			<!-- 				</div> -->
			<%-- 			</spring:bind> --%>

			<%-- 			<spring:bind path="number"> --%>
			<%-- 				<div class="form-group ${status.error ? 'has-error' : ''}"> --%>
			<!-- 					<label class="col-sm-2 control-label">Number</label> -->
			<!-- 					<div class="col-sm-10"> -->
			<%-- 						<form:radiobuttons path="number" items="${numberList}" --%>
			<%-- 							element="label class='radio-inline'" /> --%>
			<!-- 						<br /> -->
			<%-- 						<form:errors path="number" class="control-label" /> --%>
			<!-- 					</div> -->
			<!-- 				</div> -->
			<%-- 			</spring:bind> --%>

			<%-- 			<spring:bind path="country"> --%>
			<%-- 				<div class="form-group ${status.error ? 'has-error' : ''}"> --%>
			<!-- 					<label class="col-sm-2 control-label">Country</label> -->
			<!-- 					<div class="col-sm-5"> -->
			<%-- 						<form:select path="country" class="form-control"> --%>
			<%-- 							<form:option value="NONE" label="--- Select ---" /> --%>
			<%-- 							<form:options items="${countryList}" /> --%>
			<%-- 						</form:select> --%>
			<%-- 						<form:errors path="country" class="control-label" /> --%>
			<!-- 					</div> -->
			<!-- 					<div class="col-sm-5"></div> -->
			<!-- 				</div> -->
			<%-- 			</spring:bind> --%>

			<%-- 			<spring:bind path="skill"> --%>
			<%-- 				<div class="form-group ${status.error ? 'has-error' : ''}"> --%>
			<!-- 					<label class="col-sm-2 control-label">Java Skills</label> -->
			<!-- 					<div class="col-sm-5"> -->
			<%-- 						<form:select path="skill" items="${javaSkillList}" multiple="true" --%>
			<%-- 							size="5" class="form-control" /> --%>
			<%-- 						<form:errors path="skill" class="control-label" /> --%>
			<!-- 					</div> -->
			<!-- 					<div class="col-sm-5"></div> -->
			<!-- 				</div> -->
			<%-- 			</spring:bind> --%>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn-lg btn-primary pull-right">Add
					</button>
					<button type="submit" class="btn-lg btn-primary pull-right">Update
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