<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, th, td { 
   border: 1px solid blue; 
} 
</style>
</head>
<body>
<form action="/runninglife/Login/Logout" method="get">
<table border='1'>
<tr>
  <td>
       ${errorMessage}
  </td>
</tr> 
<tr>
	<td>
		姓氏:<input type="text" value="${membersVO.firstName}"/><br/>
		名子:<input type="text" value="${membersVO.lastName}"/><br/>
		綽號:<input type="text" value="${membersVO.nickname}"/><br/>
		email:<input type="text" value="${membersVO.email}"/><br/>
		性別:<input type="text" value="${membersVO.gender}"/><br/>
		生日:<input type="text" value="${membersVO.birthday}"/><br/>
		地區:<input type="text" value="${membersVO.locationID.locationID.locationID}"/><br/>
		城市:<input type="text" value="${membersVO.locationID.locationID.cityID.cityID.cityID}"/><br/>
		國家:<input type="text" value="${membersVO.locationID.locationID.cityID.cityID.countryID.countryID}"/><br/>
		地址:<input type="text" value="${membersVO.address}"/><br/>
		身高:<input type="text" value="${membersVO.height}"/><br/>
		體重:<input type="text" value="${membersVO.weight}"/><br/>
		電話:<input type="text" value="${membersVO.phone}"/><br/>
		大頭照:<input type="text" value="${membersVO.photo}"/><br/>
		權限:<input type="text" value="${membersVO.competenceID}"/><br/>
		身分證字號:<input type="text" value="${membersVO.identityID}"/><br/>
		緊急連絡人:<input type="text" value="${membersVO.emergencyContact}"/><br/>
		緊急聯絡人電話:<input type="text" value="${membersVO.emergencyPhone}"/><br/>
		緊急連絡人關係:<input type="text" value="${membersVO.emergencyRelation.relationID}"/><br/>
		建立日期:<input type="text" value="${membersVO.createDate}"/><br/>
		最後上線時間:<input type="text" value="${membersVO.lastOnlineDateTime}"/><br/>
	</td>
</tr>
<tr>
	<td>
		<input type="submit" class="btn btn-primary" value="登出">
	</td>
</tr>
</table>
</form>
</body>
</html>