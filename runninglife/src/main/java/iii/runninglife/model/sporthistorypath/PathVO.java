package iii.runninglife.model.sporthistorypath;

//import java.sql.Timestamp;

public class PathVO {
	private String lat;
	private String lng;
//	private Timestamp dateTime;
	
	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

//	public Timestamp getDateTime() {
//		return dateTime;
//	}
//
//	public void setDateTime(Timestamp dateTime) {
//		this.dateTime = dateTime;
//	}
}
