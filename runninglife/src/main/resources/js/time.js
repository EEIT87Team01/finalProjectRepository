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

			var message = "";

			message += days + " 天" + ( days==1 ? '':'s' ) + ", ";
			message += hours + " 時" + ( hours==1 ? '':'s' ) + ", ";
			message += minutes + " 分" + ( minutes==1 ? '':'s' ) + " and ";
			message += seconds + " 秒" + ( seconds==1 ? '':'s' ) + " <br />";

			if(newYear){
				message += "left until the new year!";
			}
			else {
				message += "left to 10 days from now!";
			}

			note.html(message);
		}
	});

});