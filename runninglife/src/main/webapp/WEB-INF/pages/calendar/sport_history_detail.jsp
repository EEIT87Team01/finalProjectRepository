<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="UTF-8">
    <title>運動紀錄</title>
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 80%;
        width: 80%;
        margin: 10%;
        padding: 10%;
      }
    </style>
</head>
<body>
	開始時間:${startDateTime}	</br>
	結束時間:${endDateTime}	</br>
	持續時間:${duration}		</br>
	距離:${length}			</br>
	平均速度:${avgSpeed}		</br>
	
	路徑軌跡點:${paths}			</br>
	
	<div id="map"></div>
    <script>
		var paths = ${paths};
		var map;
		function initMap() {
		  	var myLatLng=${center}
			var map = new google.maps.Map(document.getElementById('map'),{
		    	zoom:18,
		    	center: myLatLng,
			});
		  	
		 	var flightPlanCoordinates=paths;
			var flightPath = new google.maps.Polyline({
				path:flightPlanCoordinates,
				geodesic:true,
				strokeColor:"#FF0000",
				strokeOpacity:1.0,
				strokeWeight:4
			});
		    flightPath.setMap(map);
		}
    </script>
    <script src="<%=request.getContextPath()%>/js/jquery-3.1.0.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBCmOChQ6jjB4VB9Q1vptGEmkcAcNiJZuk&callback=initMap"
        async defer></script>
</body>
</html>