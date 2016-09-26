package iii.runninglife.globalservice;

import java.sql.Date;
import java.util.Base64;

public class ELfunction {
	
	public static int compareDay(Date endDateString){
		long endDate = endDateString.getTime();
		long now = new java.util.Date().getTime();
		return (int) ((endDate - now)/(1000*60*60*24));
	}
	
	public static String byteToBase64(byte[] photo){
		return new String(Base64.getEncoder().encode(photo));
	}
	
}
