$(function() {
	// ---------------------------------------------------------------------------
	// login.jsp
	// ---------------------------------------------------------------------------
	$('#loginBtn').click(function(){
		var account = $('#account').val();
		var password = $('#password').val();
		var myUrl = '/runninglife/Login/LoginCheck.do';
		var type = 'post';
		var dataType = 'json';
		var data = { "memberAccount" : account , "password" : password };
		var response = ajaxFunction(myUrl,type,data,dataType);
		console.log(response);
		for ( var i in response) {
			switch(response[i]){
				case "FialPassword":
					$('#gridSystemModalLabel').text('密碼錯誤');
					break;
				case "NotExitAccount":
					$('#gridSystemModalLabel').text('查無此帳號');
					break;
				case "LoginFial":
					$('#gridSystemModalLabel').text('登入失敗');
					break;
				case "LoginOK":
					$('#loginBtn1').click();
					break;
			}
		}
	});
	
	// ---------------------------------------------------------------------------
	// createAccount.jsp
	// ---------------------------------------------------------------------------
	var flag = true;
	$("#btn").attr("disabled", flag);
	$('#memberAccount').focusout(function(){
		var inAccount = $('#memberAccount').val();
		var AccountLength = inAccount.length;
		if(AccountLength == 0){
			$('#showText1').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("帳號未填");
			flag = true;
		}else{
			//ajax
			var myUrl = '/runninglife/Login/AccountCheck.do';
			var type = 'post';
			var dataType = 'json';
			var data = { "memberAccount" : $('#memberAccount').val() };
			
			var response = ajaxFunction(myUrl,type,data,dataType);
			console.log(response);
			if(response == "fail"){
				$('#showText1').removeClass().addClass('glyphicon glyphicon-remove-sign show1').text("帳號不可使用");
				flag = true;
			}else{
				$('#showText1').removeClass().addClass("glyphicon glyphicon-ok-sign show2").text("可使用");
				flag = false;
			}
		}
	})
	
	$('#password').focusout(function(){
		var inPassword = $('#password').val();
		var paswdLength = inPassword.length;
		if(paswdLength == 0){
			$('#showText2').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("密碼未填");
			flag = true;
		}else{
			if(paswdLength <= 6){
				$('#showText2').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("密碼長度不可小於6");
				flag = true;
			}else{
				var regx = /^[\w][^\s]{6,20}$/;
				var test = inPassword.match(regx);
				if(test){
					$('#showText2').removeClass().addClass("glyphicon glyphicon-ok-sign show2").text("正確");
					flag = false;
				}else{
					$('#showText2').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("請輸入正確密碼");
					flag = true;
				}
			}
		}
	})
	
	$('#email').focusout(function(){
		var inEmail = $('#email').val();
		var emailLength = inEmail.length;
		if(emailLength == 0){
			$('#showText3').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("Eamil未填");
			flag = true;
		}else{
			var regx = /^.+@.+\..{2,4}$/;
			var test = inEmail.match(regx);
			
			if(test){
				$('#showText3').removeClass().addClass("glyphicon glyphicon-ok-sign show2").text("正確");
				flag = false;
			}else{
				$('#showText3').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("Email格式不正確");
				flag = true;
			}
			
		}
	})
	
	$('#firstName').focusout(function(){
		var inFirstName = $('#firstName').val();
		var firstNameLength = inFirstName.length;
		if(firstNameLength == 0){
			$('#showText4').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("姓氏未填");
			flag = true;
		}else{
			$('#showText4').removeClass().addClass("hidden");
			flag = false;
		}
	})
	
	$('#lastName').focusout(function(){
		var inLastName = $('#lastName').val();
		var lastNameLength = inLastName.length;
		if(lastNameLength == 0){
			$('#showText5').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("名子未填");
			flag = true;
		}else{
			$('#showText5').removeClass().addClass("hidden");
			flag = false;
		}
	})
	
	$('#phone').focusout(function(){
		var inPhone = $('#phone').val();
		var phoneLength = inPhone.length;
		if(phoneLength == 0){
			$('#showText6').removeClass().addClass("glyphicon glyphicon-remove-sign show1").text("電話未填");
			flag = true;
		}else{
			$('#showText6').removeClass().addClass("hidden");
			flag = false;
		}
	})
	
	
	$("#birthday").datepicker({
		dateFormat:"yy-mm-dd"
//	    showOn: "button",
//	    buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
//        buttonImageOnly: true,
//        buttonText: "Select date"
	});
	
	$('#memberAccount,#password,#email,#firstName,#lastName,#phone,#birthday').change(function(){
		var inAccount = $('#memberAccount').val();
		var accountLen = inAccount.length;
		var inPassword = $('#password').val();
		var passLen = inPassword.length;
		var inEmail = $('#email').val();
		var emailLen = inEmail.length;
		var inFirstName = $('#firstName').val();
		var firstLen = inFirstName.length;
		var inLastName = $('#lastName').val();
		var lastLen = inLastName.length;
		var inPhone = $('#phone').val();
		var phoneLen = inPhone.length;
		var inBirthday = $('#birthday').val();
		var birthLen = inBirthday.length;
		
		if(accountLen == 0 && passLen == 0 && emailLen == 0 && firstLen == 0 && lastLen == 0 && phoneLen == 0 && birthLen == 0){
			$("#btn").attr("disabled", flag);
		}else{
			$("#btn").attr("disabled", flag);
		}
	})
	
	// ---------------------------------------------------------------------------
	// login changePaswd.jsp
	// ---------------------------------------------------------------------------
	$('#changepaswd').focusout(function(){
		var inPassword = $('#changepaswd').val();
		var paswdLength = inPassword.length;
		if(paswdLength == 0){
			$('#showText1').removeClass("hidden").addClass("show").text("請輸入密碼");
//			$("#changeBtn").attr("disabled", true);
		}else{
			if(paswdLength <= 6){
				$('#showText1').removeClass("hidden").addClass("show").text("密碼長度不可小於6");
//				$("#changeBtn").attr("disabled", true);
			}else{
				var regx = /^[\w][^\s]{6,20}$/;
				var test = inPassword.match(regx);
				if(test){
					$('#showText1').removeClass("hidden").addClass("show").text("正確");
//					$("#changeBtn").attr("disabled", false);
				}else{
					$('#showText1').removeClass("hidden").addClass("show").text("請輸入正確密碼");
//					$("#changeBtn").attr("disabled", true);
				}
			}
		}
	});
	
	$('#newPassword').focusout(function(){
		var inPassword = $('#changepaswd').val();
		var newPassword = $('#newPassword').val();
		if(inPassword == newPassword){
			$('#showText2').removeClass("hidden").addClass("show").text("正確");
		}else{
			$('#showText2').removeClass("hidden").addClass("show");
		}			
	});
	//country
	UpdateCountry();
	//city
	$('#select1').change(
			function(){
				var myUrl = '/runninglife/Login/City.do';
				var type = 'post';
				var dataType = 'json';
				var data = { "countryID" : $('#select1').val() };
				var response = ajaxFunction(myUrl,type,data,dataType);
				
				$('#select2').empty();
				for ( var i in response) {
					var opt = $("<option></option>");
					opt.text(response[i].cityName).val(response[i].cityID.cityID);
					$('#select2').append(opt);
				}
			});
		
	// location
	$('#select2').change(
			function() {
				var myUrl = '/runninglife/Login/Location.do';
				var type = 'post';
				var dataType = 'json';
				var data = { "cityID" : $('#select2').val() };
				var response = ajaxFunction(myUrl,type,data,dataType);
				
				$('#select3').empty();
				for ( var i in response) {
					var opt = $("<option></option>");
					opt.text(response[i].locationName).val(
							response[i].locationID.locationID);
					$('#select3').append(opt);
				}
			})


	// emergencyRelation
	UpdateEmergencyRelation();
	
	//---------------------------------------------------------------------------
	//Bootstrap修正
	//---------------------------------------------------------------------------
	$('#myModal').on('shown.bs.modal', function () {
		  $('#myInput').focus()
	})
	
});

//ajax
function ajaxFunction(url,type,data,dataType){
	var result;
	$.ajax({
		url : url,
		type : type,
		dataType : dataType,
		data : data,
		async : false,
		success : function(response){
			result = response;
		},
		error : function(response) {
			console.log("error");
		}
	});
		return result;
}

// ---------------------------------------------------------------------------
// updateAccount.jsp
// ---------------------------------------------------------------------------
function UpdateCountry(){
	var myUrl = '/runninglife/Login/Country.do';
	var type = 'get';
	var dataType = 'json';
	var data = null;
	var response = ajaxFunction(myUrl,type,data,dataType);
	
	$('#select1').empty();
	for ( var i in response) {
		var opt = $("<option></option>");
		opt.text(response[i].country).val(response[i].countryID);
		$('#select1').append(opt);
	}
}

function UpdateEmergencyRelation(){
	var myUrl = '/runninglife/Login/EmergencyRelation.do';
	var type = 'get';
	var dataType = 'json';
	var data = null;
	var response = ajaxFunction(myUrl,type,data,dataType);
	
	$('#select4').empty();
	for ( var i in response) {
		var opt = $("<option></option>");
		opt.text(response[i].relationName).val(response[i].relationID);
		$('#select4').append(opt);
	}
}




