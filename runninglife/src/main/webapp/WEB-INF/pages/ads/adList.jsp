<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>廣告列表</title>
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
<link href="../css/server/sb-admin.css" rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="../css/server/plugins/morris.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="../font-awesome/server/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- Morris Charts JavaScript -->
<script src="../js/server/plugins/morris/raphael.min.js"></script>
<script src="../js/server/plugins/morris/morris.min.js"></script>
<script src="../js/server/plugins/morris/morris-data.js"></script>
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
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">SB Admin</a>
                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                        <ul class="dropdown-menu message-dropdown">
                            <li class="message-preview">
                                <a href="#">
                                    <div class="media">
                                        <span class="pull-left">
                                            <img class="media-object" src="http://placehold.it/50x50" alt="">
                                        </span>
                                        <div class="media-body">
                                            <h5 class="media-heading"><strong>John Smith</strong>
                                            </h5>
                                            <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                            <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="message-preview">
                                <a href="#">
                                    <div class="media">
                                        <span class="pull-left">
                                            <img class="media-object" src="http://placehold.it/50x50" alt="">
                                        </span>
                                        <div class="media-body">
                                            <h5 class="media-heading"><strong>John Smith</strong>
                                            </h5>
                                            <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                            <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="message-preview">
                                <a href="#">
                                    <div class="media">
                                        <span class="pull-left">
                                            <img class="media-object" src="http://placehold.it/50x50" alt="">
                                        </span>
                                        <div class="media-body">
                                            <h5 class="media-heading"><strong>John Smith</strong>
                                            </h5>
                                            <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                            <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="message-footer">
                                <a href="#">Read All New Messages</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                        <ul class="dropdown-menu alert-dropdown">
                            <li>
                                <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                            </li>
                            <li>
                                <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                            </li>
                            <li>
                                <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                            </li>
                            <li>
                                <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                            </li>
                            <li>
                                <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                            </li>
                            <li>
                                <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">View All</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li class="active">
                            <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="charts.html"><i class="fa fa-fw fa-bar-chart-o"></i> Charts</a>
                        </li>
                        <li>
                            <a href="tables.html"><i class="fa fa-fw fa-table"></i> Tables</a>
                        </li>
                        <li>
                            <a href="forms.html"><i class="fa fa-fw fa-edit"></i> Forms</a>
                        </li>
                        <li>
                            <a href="bootstrap-elements.html"><i class="fa fa-fw fa-desktop"></i> Bootstrap Elements</a>
                        </li>
                        <li>
                            <a href="bootstrap-grid.html"><i class="fa fa-fw fa-wrench"></i> Bootstrap Grid</a>
                        </li>
                        <li>
                            <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Dropdown <i class="fa fa-fw fa-caret-down"></i></a>
                            <ul id="demo" class="collapse">
                                <li>
                                    <a href="#">Dropdown Item</a>
                                </li>
                                <li>
                                    <a href="#">Dropdown Item</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="blank-page.html"><i class="fa fa-fw fa-file"></i> Blank Page</a>
                        </li>
                        <li>
                            <a href="index-rtl.html"><i class="fa fa-fw fa-dashboard"></i> RTL Dashboard</a>
                        </li>
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
						<td><button class='btn btn-primary modify'>修改</button>
							<button class='btn btn-danger delete'>刪除</button></td>
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