$(document).ready(function(){
	addAds();
	deleteAds();
});

function addAds(){
	var adsdata =$($(".adsdatalist").find("#adsData").clone()).clone();
	$(adsdata).find('.adsId').text();
	$(adsdata).find('.adsTitle').text();
	$(adsdata).find('.division').text();
	$(adsdata).find('.startTime').text();
	$(adsdata).find('.endTime').text();
	$(adsdata).find('.priority').text();
	$('.adsdatalist').append(adsdata);
	$(adsdata).removeClass('hidden').addClass('adsListShow');

	deleteAds();
}



function deleteAds(){

	$(document).on('click','#adslist',function(){
		console.log("delete");
	})
}

function dataAjax (Method,Data,Url,Datetype,Async){

	var result1;
	$.ajax({
		type: Method,
		data:Data,
		url: Url,
		dataType: Datetype,
		async: Async,
		success:function(response) {
			result1 = response;
		}
	});
	return result1;
}