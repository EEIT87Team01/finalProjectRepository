<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 最新編譯和最佳化的 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<!-- 選擇性佈景主題 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
	<!-- 最新編譯和最佳化的 JavaScript -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<title>SendRequest</title>
</head>
<body>
<form id="searchRestrictions">
名稱：<input type="text" name="name" id="name"/>
<button type="button" id="search">查詢</button>
</form>

<table class="table table-striped">
<tr><th>查詢結果</th></tr>
<tbody id="searchResult">


</tbody>
</table>

<script>
$(function(){
	$('#name').keypress(function(event){
	    if (event.keyCode === 10 || event.keyCode === 13){
	        event.preventDefault();
		    $("#search").click();
		    }
	  });
	$("#search").on("click", function(event) {
		$.post("/runninglife/member/searchmembers",$("#searchRestrictions").serialize(),function(data){
			$("#searchResult").empty();
			for (var x in data){
				var display = $("<tr></tr>").text( data[x].firstName + "," + data[x].lastName );
				$("#searchResult").append(display);
				}
			}
		)
	})
})
</script>

</body>

</html>

