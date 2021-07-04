//JAVA_Date Class 주요 메소드 활용
import java.util.Date;

public class PrDateClass {

	public static void main(String[] args) {
		
		@SuppressWarnings("deprecation")
		Date date1 = new Date("Mon, 04 July 2020 11:52:03 +0900");
		Date date2 = new Date("Mon, 04 July 2021 12:09:17 +0900");
		
		System.out.println(date1.toString());
		System.out.println(date1.getTime());
		System.out.println(date1.after(date2));
		System.out.println(date1.before(date2));
		
		date1.setTime(7000000);
	}

}
