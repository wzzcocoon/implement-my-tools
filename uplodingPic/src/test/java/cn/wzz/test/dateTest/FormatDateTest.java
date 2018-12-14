package cn.wzz.test.dateTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateTest {

	public static void main(String[] args) throws Exception {
		
		String DATE_TIME_FORMAT = "HH:mm:ss";
		SimpleDateFormat sf = new SimpleDateFormat(DATE_TIME_FORMAT);
		Date l = sf.parse("17:30:00");
		System.out.println(l);
		
		final String DATE_TIME_FORMAT_FUNAL = "HH:mm:ss";
		SimpleDateFormat sf1 = new SimpleDateFormat(DATE_TIME_FORMAT_FUNAL);
		Date l1 = sf1.parse("17:30:00");
		System.out.println(l1);
		
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyyMMddHHmmss");
		Date l2 = sf2.parse("20181030000000");
		System.out.println(l2);
	}
}
