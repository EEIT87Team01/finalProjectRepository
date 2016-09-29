<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Running Life</title>
<!-- ico	 -->
	<link rel="icon" type="image/png" href="/runninglife/static/images/icon.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
<meta name="keywords" content="free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="FreeHTML5.co" />
<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />
<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

<link href="https://fonts.googleapis.com/css?family=Raleway:200,300,400,700" rel="stylesheet">
<!-- Animate.css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/animate.css">
<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/icomoon.css">
<!-- Bootstrap  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/bootstrap.css">
<!-- Flexslider  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/flexslider.css">
<!-- Owl Carousel  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/owl.carousel.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/owl.theme.default.min.css">
<!-- Theme style  -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/web/style.css">
<!-- Modernizr JS -->
	<script src="<%=request.getContextPath()%>/static/js/web/modernizr-2.6.2.min.js"></script>
<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/static/js/web/jquery.min.js"></script>
<!-- jQuery Easing -->
	<script src="<%=request.getContextPath()%>/static/js/web/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
	<script src="<%=request.getContextPath()%>/static/js/web/bootstrap.min.js"></script>
<!-- Waypoints -->
	<script src="<%=request.getContextPath()%>/static/js/web/jquery.waypoints.min.js"></script>
<!-- Owl Carousel -->
	<script src="<%=request.getContextPath()%>/static/js/web/owl.carousel.min.js"></script>
<!-- Flexslider -->
	<script src="<%=request.getContextPath()%>/static/js/web/jquery.flexslider-min.js"></script>
<!-- MAIN JS -->
	<script src="<%=request.getContextPath()%>/static/js/web/main.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    searchArticleList();
});

function searchArticleList() {
	var ArticleData = ajax('GET', null, 'searchArticles.do', 'json', false);
	console.log(ArticleData);
	for ( var i in ArticleData) {
		var articleColumn = $($('.list').find('.articleList').clone()).clone();
		$(articleColumn).find('.Thumbnail').attr('src','<%=request.getContextPath() %>/photoController/getPhoto.do?photoID='+ArticleData[i].photoPath);
		$(articleColumn).find('.title').text(ArticleData[i].title);
		$(articleColumn).find('.writerAccount').text(ArticleData[i].writerAccount.name);
		$(articleColumn).find('.createTime').text(ArticleData[i].createTime);
		$(articleColumn).find('.link').attr('href','detail/'+ArticleData[i].articleID);
		console.log(ArticleData[i].articleID);
		
		$(articleColumn).removeClass().addClass('articleShow');
		$('.list').append(articleColumn);
	}
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
$(document).on("click",".back",function(){

    history.back();
})


</script>	
</head>
<body>
<div id="fh5co-page">
		<%@ include file="/WEB-INF/pages/header.jsp"%>
	<div class="container">
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>縮圖</th>
						<th>標題</th>
						<th>作者</th>
						<th>發表時間</th>
					</tr>
				</thead>
				<tbody class="list">
					<tr class="articleList hidden">
						<td><a class="link"><img src="" style="width:30px;height:30px;" class="Thumbnail"></a></td>
						<td><a class="link"><span class="title"></span></a></td>
						<td><a class="link"><span class="writerAccount"></span></a></td>
						<td><a class="link"><span class="createTime"></span></a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	

	<%@ include file="/WEB-INF/pages/footer.jsp"%>
	</div>
</body>
</html>