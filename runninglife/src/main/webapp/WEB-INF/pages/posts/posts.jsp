<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="r" uri="http://iii.runningLife.com/util" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.io.File" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


	<head>
		<title>RunningLife貼文頁面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<script src="<%=request.getContextPath()%>/static/js/jquery-3.1.0.min.js"></script>
		<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
		<script src="<%=request.getContextPath()%>/static/js/fileinput.min.js"></script>
		<script src="<%=request.getContextPath()%>/static/js/jquery.blockUI.js"></script>


		
			<!-- Animate.css -->
			<style type="text/css">@import url("<c:url value="/static/css/animate.css" />");</style>
			<!-- Icomoon Icon Fonts -->
			<style type="text/css">@import url("<c:url value="/static/css/icomoon.css" />");</style>
			<!-- Flexslider  -->
			<style type="text/css">@import url("<c:url value="/static/css/flexslider.css" />");</style>
			<!-- Theme style  -->
			<style type="text/css">@import url("<c:url value="/static/css/style.css" />");</style>
			
			
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/mainStyle.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/bootstrap-theme.min.css"/>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/fileinput.min.css"/>

	</head>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	    	<form:form method="post" action="../reportController/newReport.do">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">檢舉單</h4>
		      </div>
		      
		      <div class="modal-body">
		     	<div class="form-group">
		     		<div class='zz'>
				<input type="hidden" id="memberID" name="reporterID" value="${membersVO.memberID}">			
				<input type="hidden" id="reportPostID" name="reportPostID" value="">	
						<div class="form-group">
							<select class="typeID" name="typeID">
								<option class="option" value="1">這令人噁心或討厭	</option>
								<option class="option" value="2">我認為這不應該出現在RunningLife的頁面上</option>
								<option class="option" value="3">這是垃圾訊息</option>
								<option class="option" value="3">有性別歧視字眼</option>
							</select>
						</div>
				<textarea id="textarea" name="reportComment" class="form-control col-xs-12" rows="3"></textarea>	
					</div>	
				</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		        <button type="submit" class="btn btn-primary">送出</button>
		      </div>
		     </form:form>
	    </div>
	  </div>
	</div>
<body>

<%@ include file="/WEB-INF/pages/header.jsp"%>
		<div class="container"></div>
<aside>
${onePosts.postID}
<div id = "sss" ></div>
	<div id="question" style="display:none; cursor: default;"> 
      <form method="get" action="postsController/posts.do">
		<div class="col-md-12" style="border-style:solid;border-color:#EDEDED"> 
			<textarea id="textarea" name="postsContent" class="form-control col-xs-12" rows="15"></textarea>
			<div class="col-md-12">
				<button id="btn_update" type="submit" class="btn btn-success">發文</button>
				<button id="no">取消</button>
			</div>
			<input type="hidden" id="memberID" name="memberID" value="${membersVO.memberID}">
		</div>		
       </form>
	</div> 
	<div class="col-md-2"></div> 	
	<div class="col-md-8">	
		<ul class="nav nav-tabs">
			<li role="presentation"><a href="<%=request.getContextPath()%>/postsController/posts.do">塗鴉牆</a></li>
			<li role="presentation" class="dropdown">
		        <a id="drop4" href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
		          	好友資訊<span class="caret"></span>
		        </a>
		        <ul id="menu1" class="dropdown-menu" role="menu" aria-labelledby="drop4">
		          <li role="presentation"><a role="menuitem" tabindex="-1" href="<%=request.getContextPath()%>/friend/listFriend.do">好友列表</a></li>
		          <li role="presentation"><a role="menuitem" tabindex="-1" href="<%=request.getContextPath()%>/friend/listFriendRequest.do">收到的邀請</a></li>
		          <li role="presentation"><a role="menuitem" tabindex="-1" href="<%=request.getContextPath()%>/friend/sendRequest.do">邀請好友</a></li>
		        </ul>
			</li>
		</ul>
		
		<form:form method="post" action="newPosts.do" enctype="multipart/form-data">
			<div class="col-md-12" style="border-style:solid;border-color:#EDEDED;padding:20px">
				<textarea id="textarea" name="postsContent" class="form-control col-xs-12" rows="5"></textarea>
				<div class="col-md-10"><input id="input-2" name="file1" type="file" class="file" multiple="" data-show-upload="false" data-show-caption="true"></div>
				<div class="col-md-2"><button id="btn_posts" type="submit" class="btn btn-primary">發文</button></div>
				<input type="hidden" id="memberID" name="memberID" value="${membersVO.memberID}">
	</div>					
		</form:form>
		<c:forEach var="posts" items="${postsVO}"> 
			<div class="col-md-12">
				<c:if test="${posts.parent==null&&posts.status==1}">	
					<div>
						<div  class="col-md-12" style="border-style:solid;border-color:#EDEDED">							
							<div  class="col-md-12" style="border-style:solid;border-color:#EDEDED">	
								<div class="col-md-1"><a href="<%=request.getContextPath()%>/postsController/personalPosts.do?membersID=${posts.postMemberID.memberID}"><img style="width:99%" src="data:image/png;base64,${r:byteToBase64(posts.postMemberID.photo)}"></a></div>
								<div class="col-md-10"><h4>${posts.postMemberID.lastName}</h4>${posts.time}</div>	
								<div class="col-md-1">
							</div>	
								<div class="btn-group ">
								  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								   	 <span class="caret"></span>
								  </button>
									 <ul class="dropdown-menu" role="menu">
											<c:if test="${posts.postMemberID.memberID==membersVO.memberID}">
										  <li class ="deletePosts" postID="${posts.postID}">刪除</li>
											</c:if>    
											<c:if test="${posts.postMemberID.memberID!=memberVO.memberID}">
										  <li class ="reportPosts" postID="${posts.postID}" data-toggle="modal" data-target="#myModal">檢舉</li>
											</c:if>
									 </ul>
								</div>
							</div>
							<div class="col-md-12" style="font-size:20px;font-family:Microsoft JhengHei"><%--留言內容 --%>
								<div class="col-md-12 div_content">${posts.content}</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-2"><button type="button" class="btn btn btn-success btn_good" postID= "${posts.postID}" value="value" >讚${posts.good}</button></div>
								<div class="col-md-10"></div>
								<div class="col-md-12"></div>
							</div>
						</div>	
						<form method="post" action="responsePosts.do">
							<div class="col-md-12" style="border-style:solid;border-color:#EDEDED">
								<div class="col-md-1"><a href="<%=request.getContextPath()%>/postsController/personalPosts.do?membersID=${posts.postMemberID.memberID}"><img  style="width:80%" src="data:image/png;base64,${r:byteToBase64(membersVO.photo)}"></a></div>
								<div class="col-md-9"><textarea id="textarea" name="responsePosts_content" class="form-control col-xs-12" rows="1"></textarea></div>
								<div class="col-md-2"><button type="submit" class="btn btn btn-primary">回覆</button></div>	
								<input type="hidden" name="memberID" value="${membersVO.memberID}">
								<input type="hidden" name="postID" value="${posts.postID}">
								<input type="hidden" name="action" value="responsePosts">
							</div>
						</form>													
					</div>
				</c:if>
					<c:forEach var="response" items="${responseVO}"> 
						<c:if test="${response.parent==posts.postID&&response.status==1}">
							<div class="col-md-12" style="border-style:solid;border-color:#EDEDED">
								<div class="col-md-1"><a href="<%=request.getContextPath()%>/postsController/personalPosts.do?membersID=${response.postMemberID.memberID}"><img  style="width:80%" src="data:image/png;base64,${r:byteToBase64(membersVO.photo)}"></a></div>
								<div class="col-md-10"><span>${response.content}</span></div>
								<div class="col-md-1">  
									<div class="btn-group ">
										<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
											<span class="caret"></span>
										</button>
											<ul class="dropdown-menu" role="menu">
												<li class="deleteResponsePosts" postID="${response.postID}">刪除</li>
											</ul>
									</div>
								</div>
							</div>		
						</c:if>
					</c:forEach>
			</div>
				<div class="col-md-12"></div>
		</c:forEach>			
	</div>
	<div class="col-md-2"></div>	


	
<script>
$(function(){
	$('.dropdown-toggle').dropdown();
	$('.deletePosts').click(function(){
		$.post("delete.do",{"postID":$(this).attr('postID'),"memberID":$('#memberID').val()},
				function (deletePosts){ location.reload();
		});
	});
	$('.deleteResponsePosts').click(function(){
		$.post("deleteResponsePosts.do",{"postID":$(this).attr('postID'),"memberID":$('#memberID').val()},
				function (deleteResponsePosts){ location.reload();
		});
	});
 	$('.btn_good').click(function(){
 		var sef=$(this);
		$.ajax({
			  url: "goodOperation.do",
			  type: "post",
			  data: {"goodCount":$(this).attr('value'),"postID":$(this).attr('postID'),"memberID":$('#memberID').val()},
			  dataType: "json",
			  success: function(goodCount) {
				  sef.text("讚"+goodCount);
				  $(this).val("讚"+goodCount);
			  },
			  error:function() {
				  console.log("error");
			  }
			});
	});
	$('.reportPosts').click(function(){
 		var sef=$(this);
		$.ajax({
			  url: "onePost.do",
			  type: "post",
			  data: {"postID":sef.attr('postID')},
			  dataType: "json",
			  success: function(res) {
				  $('#reportPostID').attr("value",res.postID);	
				 },
			  error:function() {
				  console.log("error");
				  console.log(sef.attr('postID'));
			  }
		});
	});
});	
</script>
</aside>
</body>


</html>
