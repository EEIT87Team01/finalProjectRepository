package iii.runninglife.globalservice;

public class CalulateTwoLatLng {
	private static final double EARTH_RADIUS = 6378.137;//地球半徑,單位公里
	  private static double rad(double d)
	  {
	    return d * Math.PI / 180.0;
	  }
	  
	  /**
	   * @param lat1 第一個緯度
	   * @param lng1第一個經度
	   * @param lat2第二個緯度
	   * @param lng2第二個經度
	   * @return 兩個經緯度的距離
	   */
	  public static double getDistance(double lat1,double lng1,double lat2,double lng2)
	  {
	    double radLat1 = rad(lat1);
	    double radLat2 = rad(lat2);
	    double diffLat = radLat1 - radLat2;
	    double diffLng = rad(lng1) - rad(lng2);
	    
	    double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(diffLat/2),2) +
	        Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(diffLng/2),2)));
	    s = s * EARTH_RADIUS;
	    s = Math.round(s * 100000)/100000.0;
	    return s;
	  }
	  
	  public static void main(String[] args)
	  {
	    System.out.println(CalulateTwoLatLng.getDistance( 23.08018406, 123.58298432, 25.080254516, 121.58279657));
	  }
	  
}
