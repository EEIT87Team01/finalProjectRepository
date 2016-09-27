package iii.runninglife.globalservice;

public class ConvertMilliseconds2Hours {
	private static final double MILLISECONDS_2_HOURS = 0.000000277778;//1ms = 0.000000277778 hour
	  
	  public static double getHours(long milliseconds)
	  {
	    return milliseconds * MILLISECONDS_2_HOURS;
	  }
	  
	  public static void main(String[] args)
	  {
	    System.out.println(ConvertMilliseconds2Hours.getHours(3600000));
	  }
	  
}
