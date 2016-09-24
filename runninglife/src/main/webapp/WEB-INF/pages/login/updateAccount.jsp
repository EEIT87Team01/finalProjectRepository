<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- Bootstrap CSS --> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

</head>
<body>
<form:form modelAttribute="memberForm" action="UpdateAccount.do" method="post" acceptCharset="UTF-8">
<table>
		<thead>
			<tr>
				<th>修改會員</th>
			</tr>
		</thead>
		<tbody>
			<form:input type="hidden" path="memberID" value="${membersVO.memberID}"/>
			<tr><td>姓:<form:input type="text" name="firstName" class="form-control" value="${membersVO.firstName}" path="firstName" /></td></tr>
			<tr><td>名:<form:input type="text" name="lastName" class="form-control" value="${membersVO.lastName}" path="lastName" /></td></tr>
			<tr><td>暱稱:<form:input type="text" name="nickname" class="form-control" value="${membersVO.nickname}" path="nickname" /></td></tr>
			<tr><td>email:<form:input type="text" name="email" class="form-control" value="${membersVO.email}" path="email" /></td></tr>
			<tr><td>性別:<form:radiobutton value="1" path="gender"/>男 <form:radiobutton value="0" path="gender"/> 女</td></tr>
			<tr><td>生日:<form:input type="text" name="birthday" class="form-control" value="${membersVO.birthday}" path="birthday"/></td></tr>
			<tr>
				<td>國家:<form:select id="select1" name="country" class="form-control" path="locationID.locationID.cityID.cityID.countryID.countryID">
					   	 </form:select>
				</td>
			</tr>
			<tr>
				<td>城市:<form:select id="select2" name="city" class="form-control" path="locationID.locationID.cityID.cityID.cityID">
					   	 </form:select>
				</td>
			</tr>
			<tr>
				<td>居住地:<form:select id="select3" name="location" class="form-control" path="locationID.locationID.locationID">
					   	 </form:select>
				</td>
			</tr>
			<tr><td>地址:<form:input type="text" name="address" class="form-control" value="${membersVO.address}" path="address"/></td></tr>
			<tr><td>身高:<form:input type="number" name="height" class="form-control" value="${membersVO.height}" path="height"/></td></tr>
			<tr><td>體重:<form:input type="number" name="weight" class="form-control" value="${membersVO.weight}" path="weight"/></td></tr>
			<tr><td>電話:<form:input type="text" name="phone" class="form-control" value="${membersVO.phone}" path="phone"/></td></tr>
			<tr><td>身分證字號:<form:input type="text" name="identityID" class="form-control" value="${membersVO.identityID}" path="identityID"/></td></tr>
			<tr><td>緊急連絡人:<form:input type="text" name="emergencyContact" class="form-control" value="${membersVO.emergencyContact}" path="emergencyContact"/></td></tr>
			<tr><td>緊急聯絡人電話:<form:input type="text" name="emergencyPhone" class="form-control" value="${membersVO.emergencyPhone}" path="emergencyPhone"/></td></tr>
			<tr><td>緊急連絡人關係:<form:input type="number" name="emergencyRelation" class="form-control" value="${membersVO.emergencyRelation.relationID}" path="emergencyRelation.relationID"/></td></tr>
			<tr>
				<td>
					<input type="submit" class="btn btn-primary" value="送出" />
				</td>
			</tr>
		</tbody>
</table>
</form:form>
<script>
$(function(){
	var mCountry = '${membersVO.locationID.locationID.cityID.cityID.countryID.countryID}';
	var mCity = '${membersVO.locationID.locationID.cityID.cityID.cityID}';
	var mLocation = '${membersVO.locationID.locationID.locationID}';
	$('#select1').empty();
	//country
	$.ajax({
		url: '/testlife/Login/Country.do',	type: 'get', dataType: 'json', success:function(response){
			$('#select1').empty();
			for (var i in response)
			{
				var opt = $("<option></option>");
				opt.text(response[i].country).val(response[i].countryID);
				if (response[i].countryID == mCountry) { opt.attr("selected","selected"); }
				$('#select1').append(opt);
			}
			
			$('#select2').empty();
			$.ajax({
				url: '/testlife/Login/City.do', type: 'post', dataType: 'json', data: {"countryID" : $('#select1').val()},
				success:function(response){
					for (var i in response)
					{
						var opt = $("<option></option>");
						opt.text(response[i].cityName).val(response[i].cityID.cityID);
						if (response[i].cityID.cityID == mCity) { opt.attr("selected","selected"); }
						$('#select2').append(opt);
					}
					$('#select3').empty();
					$.ajax({
						url: '/testlife/Login/Location.do', type: 'post', dataType: 'json', data: {"cityID" : $('#select2').val()},
						success:function(response){
							for (var i in response)
							{
								var opt = $("<option></option>");
								opt.text(response[i].locationName).val(response[i].locationID.locationID);
								if (response[i].locationID.locationID == mLocation) { opt.attr("selected","selected"); }
								$('#select3').append(opt);
							}
						}
					})
				}
			})
		}
	})
	//city
	$('#select1').change(function(){
		$('#select2').empty();
		$.ajax({
			url: '/testlife/Login/City.do', type: 'post', dataType: 'json', data: {"countryID" : $('#select1').val()},
			success:function(response){
				for (var i in response)
				{
					var opt = $("<option></option>");
					opt.text(response[i].cityName).val(response[i].cityID.cityID);
					$('#select2').append(opt);
				}
			}
		})
	})
	//location
	$('#select2').change(function(){
		$('#select3').empty();
		$.ajax({
			url: '/testlife/Login/Location.do', type: 'post', dataType: 'json', data: {"cityID" : $('#select2').val()},
			success:function(response){
				for (var i in response)
				{
					var opt = $("<option></option>");
					opt.text(response[i].locationName).val(response[i].locationID.locationID);
					$('#select3').append(opt);
				}
			}
		})
	})
});

</script>
</body>
</html>