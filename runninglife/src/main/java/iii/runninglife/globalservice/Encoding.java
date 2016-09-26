package iii.runninglife.globalservice;

import java.io.UnsupportedEncodingException;

	public class Encoding {
	//轉型
		public static String encodeStr(String str){
			try{
			return new String(str.getBytes("ISO-8859-1"),"UTF-8");
			}catch (UnsupportedEncodingException e){
				e.printStackTrace();
				return null;
			}
		}
}
