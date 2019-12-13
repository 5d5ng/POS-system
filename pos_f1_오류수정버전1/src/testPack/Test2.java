package testPack;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Test2 {

	public static void main(String[] args) {
		
		Date today = new Date();
		SimpleDateFormat  format = new  SimpleDateFormat("yy-MM-dd");
		System.out.println(format.format(today));
			String s1 ="1111";
			String s2 = "1112";
			System.out.println(s1.compareTo(s2));
	}
	

}
