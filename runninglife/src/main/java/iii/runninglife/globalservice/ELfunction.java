package iii.runninglife.globalservice;

import java.sql.Date;

public class ELfunction {
	
	public static int compareDay(Date endDateString){
		long endDate = endDateString.getTime();
		long now = new java.util.Date().getTime();
		return (int) ((endDate - now)/(1000*60*60*24));
	}
}
