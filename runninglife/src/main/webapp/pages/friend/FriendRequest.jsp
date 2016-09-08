<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/runninglife/static/css/bootstrap.min.css" />
<link rel="stylesheet" href="/runninglife/static/css/bootstrap-theme.min.css"></link>
<script src="/runninglife/static/js/jquery-3.1.0.min.js"></script>
<script src="/runninglife/static/js/bootstrap.min.js"></script>
<title>ListRequestFriend</title>
</head>
<body>
<table  class="table" id="receivedList" style="width: 300px">
<tr><th>FirstName</th><th>LastName</th><th></th></tr>
<c:forEach var="memberRequest" items="${member}">
	<tr><td>${memberRequest.friendRequestPK.requesterID.firstName}</td>
		<td>${memberRequest.friendRequestPK.requesterID.lastName}</td>
		<td>
		<button class="btn btn-success" id="${memberRequest.friendRequestPK.requesterID.memberID}&receiverid=${memberRequest.friendRequestPK.receiverID.memberID}">接受</button>
	</tr>
</c:forEach>
</table>

<script type="text/javascript">
$(function(){
	$("button").click(function(){
		var requesterID = $(this).attr("id");
		var btn = $(this);
		console.log(requesterID);
		$.ajax({
			type: "get", 
			datatype: "json",
			url: "/runninglife/friend/acceptRequest_requestid=" + requesterID,
			success: function(){
				$(btn).parents("tr").remove();
			}
		});
	});
});
</script>
</body>
</html>