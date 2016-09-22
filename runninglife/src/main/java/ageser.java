import java.sql.Date;

public class ageser {

	public static void main(String[] args) {
		Long duration=System.currentTimeMillis()-Date.valueOf("1991-03-13").getTime();
		int age=(int) (duration/1000/60/60/24/356);
		System.out.println(age);
		System.out.println(duration/1000.0/60.0/60.0/24.0/365.0);
	}

}
