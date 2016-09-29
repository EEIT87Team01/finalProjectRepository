$(function(){
	
	var note = $('#note'),
		ts = $('#timer').text(),

		newYear = true;
	console.log(ts);
//	if((new Date()) > ts){
//		// The new year is here! Count towards something else.
//		// Notice the *1000 at the end - time must be in milliseconds
//		ts = (new Date()).getTime() + 10*24*60*60*1000;
//		newYear = false;
//	}

	$('#countdown').countdown({
		timestamp	: ts,
		callback	: function(days, hours, minutes, seconds){

			var message = "報名截止剩餘";

			message += days + " 天" + ( days==1 ? '':'秒' ) + ", ";
			message += hours + " 時" + ( hours==1 ? '':'秒' ) + ", ";
			message += minutes + " 分" + ( minutes==1 ? '':'秒' ) + " and ";
			message += seconds + " 秒" + ( seconds==1 ? '':'秒' ) + " <br />";

//			if(newYear){
//				message += "left until the new year!";
//			}
//			else {
//				message += "left to 10 days from now!";
//			}

			note.html(message);
		}
	});

});