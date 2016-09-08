<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SendRequest</title>
<link rel="stylesheet" href="/runninglife/static/css/bootstrap.min.css" />
<link rel="stylesheet" href="/runninglife/static/css/bootstrap-theme.min.css"></link>
<script src="/runninglife/static/js/jquery-3.1.0.min.js"></script>
<script src="/runninglife/static/js/bootstrap.min.js"></script>
</head>
<body>
<form id="searchRestrictions">
名稱：<input type="text" name="name" id="name"/>
<button type="button" id="search">查詢</button>
</form>

<table class="table table-striped">
<tr><th>查詢結果</th><th></th></tr>
<tbody id="searchResult">


</tbody>
</table>

<script>
$(function(){
	var member = '1B98BB09-4904-4FDA-9C14-A65FB4C03973';
	$('#name').keypress(function(event){
	    if (event.keyCode === 10 || event.keyCode === 13){
	        event.preventDefault();
		    $("#search").click();
		    }
	  });
	$("#search").on("click", function(event) {
		$.post("/runninglife/member/searchmembersforrequestfriend",
				{ "name" : $("#name").val(), "memberID" : member},
				function(data){
			$("#searchResult").empty();
			for (var x in data){
				var tr = $("<tr></tr>"),
				display = $("<td></td>").text( data[x].firstName + "," + data[x].lastName ),
				requestbtn = $("<button></button>").text("邀請").attr("id", data[x].memberID).attr("class","btn btn-success"),
				td = $("<td></td>");
				requestbtn.bind("click", function(event){
					$.post("/runninglife/friend/sendRequest", {"requestID" : member , "receiveID" : $(this).attr("id")});
						$(this).text("已邀請").attr("class","btn btn-primary");
						$(this).off();
					});
				td.append(requestbtn);
				$("#searchResult").append(tr.append(display, td));
				}
			}
		);
	});
})
</script>

</body>

</html>

