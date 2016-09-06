<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<table id="receivedList">
<tr><th>FirstName</th><th>LastName</th><th></th>
<c:forEach var="memberRequest" items="${sessionScope.member.friendReceive}">
	<tr><td>${memberRequest.firstName}</td>
		<td>${memberRequest.lastName}</td>
		<td>
		<button class="accept" id="${memberRequest.memberID}">接受</button></td>
	</tr>
</c:forEach>
</table>

<script type="text/javascript">
	$(function(){
		$(".accept").css('font-size','20px');

		$("#receivedList").on('click','.accept',function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/friend/accepter?requestId="+$(this).attr('id'),
				type:'get',
				dataType:'json',
				success: function(data){
					$(this).parents("tr").remove();
				}
			});
		});
	});
</script>
</body>
</html>