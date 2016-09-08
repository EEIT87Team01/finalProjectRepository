<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/runninglife/static/css/bootstrap.min.css" />
<link rel="stylesheet" href="/runninglife/static/css/bootstrap-theme.min.css"></link>
<script src="/runninglife/static/js/jquery-3.1.0.min.js"></script>
<script src="/runninglife/static/js/bootstrap.min.js"></script>
<title>FriendList</title>
</head>
<body>

<table  class="table" id="receivedList" style="width: 300px">
<tr><th>FirstName</th><th>LastName</th><th></th></tr>
<c:forEach var="friend" items="${friends}">
	<tr><td>${friend.friendRelationshipPK.friendID.firstName}</td>
		<td>${friend.friendRelationshipPK.friendID.lastName}</td>
		<td>
		<button class="btn btn-danger" id="memberid=${friend.friendRelationshipPK.memberID.memberID}&friendid=${friend.friendRelationshipPK.friendID.memberID}">刪除</button>
	</tr>
</c:forEach>
</table>

<script type="text/javascript">
$(function(){
	$("button").click(function(){
		var deletefriend = $(this).attr("id");
		var btn = $(this);
		console.log(deletefriend);
		$.ajax({
			type: "get", 
			datatype: "json",
			url: "/runninglife/friend/deletefriend_" + deletefriend,
			success: function(){
				$(btn).parents("tr").remove();
			}
		});
	});
});
</script>
</body>
</html>