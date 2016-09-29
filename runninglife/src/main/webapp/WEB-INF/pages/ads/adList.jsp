<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>廣告列表</title>
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/static/images/icon.png">
<style >
table{
    color:white;
}

</style>

<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/static/css/sb-admin.css" rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="<%=request.getContextPath()%>/static/css/server/plugins/morris.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="<%=request.getContextPath()%>/static/font-awesome/server/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- Morris Charts JavaScript -->
<script src="<%=request.getContextPath()%>/static/js/plugins/morris/raphael.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/plugins/morris/morris.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/plugins/morris/morris-data.js"></script>
<script>
	$(document).ready(function() {
		searchAdList();
	});
	function searchAdList() {
		var adList = ajax('GET', null, 'searchAds.do', 'json', false);
		console.log(adList);
		for ( var i in adList) {
			var adColumn = $($('.list').find('.adColumn').clone()).clone();
			$(adColumn).find('.adID').text(adList[i].adID);
			$(adColumn).find('.adName').text(adList[i].adName);
			$(adColumn).find('.division').text(adList[i].division);
			$(adColumn).find('.link').text(adList[i].link);
			$(adColumn).find('.adStartTime').text(adList[i].adStartTime);
			$(adColumn).find('.adEndTime').text(adList[i].adEndTime);
			$(adColumn).find('.priority').text(adList[i].priority);
			$(adColumn).find('.image').text(adList[i].image);
			$(adColumn).find('.modify').attr('adID', adList[i].adID);
			$(adColumn).find('.delete').attr('adID', adList[i].adID);
			$(adColumn).removeClass().addClass('adShow');
			$('.list').append(adColumn);

// 					console.log('adID:'+adList[i].adID);
// 					console.log('adName:'+adList[i].adName);
// 					console.log('division:'+adList[i].division);
// 					console.log('link:'+adList[i].link);
					console.log('adStartTime:'+adList[i].adStartTime);
// 					console.log('adStartTime:'+adList[i].adStartTime.getDate());
// 					console.log('adEndTime:'+adList[i].adEndTime);
// 					console.log('priority:'+adList[i].priority);
// 					console.log('image:'+adList[i].image);
			var myDate = new Date(adList[i].adStartTime);
			console.log((myDate.getMonth() + 1) + "-" + myDate.getDate() + "-" + myDate.getFullYear());
			adDetail();		
		}

	}
	
    function adDetail(){

        $(document).on('click',".modify",function(){
            
            console.log('y');
            window.location.href = "adDetail/"+$(this).attr('adID') + ".do";
    	});
    }
	
    function adDelete(){

        $(document).on('click',".delete",function(){
            
            console.log('y');
            ajax('DELETE', {'adID':$(this).attr('adID')}, 'deleteAds.do', 'json', false);
    	});
    }
    
	function ajax(Method, Data, Url, Datetype, Async) {
		var result;
		$.ajax({
			type : Method,
			data : Data,
			url : Url,
			dataType : Datetype,
			async : Async,
			success : function(response) {

				result = response;
			}
		});
		return result;
	}
</script>

</head>
<body>
<div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav">
				<li><a href="<%=request.getContextPath()%>/AdminLogin/CreateWriterPage.do"><i class="fa fa-fw fa-bar-chart-o"></i> 維護駐台作家</a></li>
				<li class="active"><a href="<%=request.getContextPath()%>/ads/adList.do"><i	class="fa fa-fw fa-table"></i> 廣告設置</a></li><li><a href="forms.html">
				<i class="fa fa-fw fa-edit"></i>活動賽事</a></li>
				<li><a href="../reportController/reportList.do"><i class="fa fa-fw fa-desktop"></i>檢舉審核</a></li>
			</ul>
		</div>
                <!-- /.navbar-collapse -->
            </nav>
            <h1 style="color:white;">廣告管理列表</h1>
	<div class='container'>
		<div class='row'>
			<table class='table'>
				<thead>
					<tr>
						<th>編號</th>
						<th>標題</th>
						<th>刊登</th>
						<th>網址</th>
						<th>起始時間</th>
						<th>結束時間</th>
						<th>優先</th>
						<th>圖片</th>
						<th>編輯</th>
					</tr>
				</thead>
				<tbody class='list'>
					<tr class='adColumn hidden'>
						<td><span class='adID'></span></td>
						<td><span class='adName'></span></td>
						<td><span class='division'></span></td>
						<td style="word-break:break-all;"><span class='link'></span></td>
						<td><span class='adStartTime'></span></td>
						<td><span class='adEndTime'></span></td>
						<td><span class='priority'></span></td>
						<td><span class='image'></span></td>
						<td><button class='btn btn-primary modify'>修改</button></td>
					</tr>
				</tbody>
			</table>
			<p align="right">
				<a href='adCreate.jsp' class='btn btn-info'>新增廣告</a>
			</p>
		</div>
	</div>

</body>
</html>