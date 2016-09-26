<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Running Life</title>
<!-- ico	 -->
	<link rel="icon" type="image/png" href="/runninglife/static/images/icon.png">
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
<link href="../../css/server/sb-admin.css" rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="../../css/server/plugins/morris.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="../../font-awesome/server/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- Morris Charts JavaScript -->
<script src="../../js/server/plugins/morris/raphael.min.js"></script>
<script src="../../js/server/plugins/morris/morris.min.js"></script>
<script src="../../js/server/plugins/morris/morris-data.js"></script>
<script>
$(document).ready(function(){
// 	var dataId = location.search ;
//     var getSearch = dataId.split("?adid=");
    var adID = "${adid}";
	searchAdDetail(adID);
// 	searchAdDetail('2016080100002');
	
});

function searchAdDetail(adID) {
	var adDetail = ajax('GET', {'adID':adID}, '../searchAd.do', 'json', false);
	console.log(adDetail);
	$('.adID').val(adDetail.adID);
	$('.adName').val(adDetail.adName);
	$('.division').val(adDetail.division);
	$('.adStartTime').val(adDetail.adStartTime);
	$('.adEndTime').val(adDetail.adEndTime);
	$('.site').val(adDetail.link);
	$('.priority').val(adDetail.priority);
	$('.modify').attr('adID',adDetail.adID)
}



$(document).on('click',".modify",function(){
    console.log($('.adID').val()) ; 
    console.log($('.adName').val()) ; 
    console.log($('.division').val()) ; 
    console.log($('.adStartTime').val()) ; 
    console.log($('.adEndTime').val()) ; 
    console.log($('.site').val()) ; 
    console.log($('.priority').val()) ; 
    console.log($(this).attr('adID')) ; 
    ajax('POST', {'adID':$(this).attr('adID'),'adName':$('.adName').val(),'division':$('.division').val(),'adStartTime':$('.adStartTime').val(),'adEndTime':$('.adEndTime').val(),'site':$('.site').val(),'priority':$('.priority').val()}, '../updateAd.do', 'json', false);
});

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

$(document).on("click",".cancel",function(){

    history.back();
})

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
            <h1>廣告內容修改</h1>
            <div id="page-wrapper">

                <div class="container-fluid">

                    <img style="width:500px;height:400px;"/>
                    <button class="btn btn-info chooseimg" style="margin-top:300px;">更改圖片</button>
                    <!-- Page Heading -->
                    <table class = "table" id="adslist" rules="all" >
                        <tr>
                            <th>廣告編號</th>
                            <td><input type="text" class='adID'/></td>
                        </tr>
                        <tr>
                            <th>廣告標題</th>
                            <td><input type="text" class='adName'/></td>
                        </tr>
                        <tr>
                            <th>刊登位置</th>
                            <td>
                                <select class='division'>
                                    <option >首頁</option>
                                    <option >專區</option>
                                    <option >廣告區</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th>起始時間</th>
                            <td><input type="text" class='adStartTime'/></td>
                        </tr>
                        <tr>
                            <th>結束時間</th>
                            <td><input type="text" class='adEndTime'/></td>
                        </tr>
                        <tr>
                            <th>廣告網址</th>
                            <td><input type="text" class='site' style="width:300px;"/></td>
                        </tr>
                        <tr>
                            <th>優先性</th>
                            <td>
                                <select class='priority'>
                                    <option value='1'>底</option>
                                    <option value='2'>低</option>
                                    <option value='3'>中</option>
                                    <option value='4'>高</option>
                                    <option value='5'>頂</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <button class="btn btn-primary modify" >確認修改</button>
                                <a href="../adList.do" class="btn btn-danger cancel">取消</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <!-- /.row -->

                
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->
</body>
</html>