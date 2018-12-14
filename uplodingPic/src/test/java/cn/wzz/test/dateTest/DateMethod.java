package cn.wzz.test.dateTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMethod {

	public static void main(String[] args) {
		
		Date checkDate0=new Date();
		Date checkDate1=DateUtils.addMonths(new Date(), 1);
		Date checkDate2=DateUtils.addMonths(new Date(), 2);
		Date checkDate3=DateUtils.addMonths(new Date(), 3);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString0 = formatter.format(checkDate0);
		String dateString1 = formatter.format(checkDate1);
		String dateString2 = formatter.format(checkDate2);
		String dateString3 = formatter.format(checkDate3);
		
		System.out.println(dateString0);
		System.out.println(dateString1);
		System.out.println(dateString2);
		System.out.println(dateString3);
		
		System.out.println("----------------------------------");
		
		System.out.println(DateUtil.getYear(new Date()));
		System.out.println(DateUtil.getMonth(new Date()));
		System.out.println(DateUtil.getDate(new Date()));
		System.out.println(DateUtil.getMonth(new Date()) == DateUtil.getMonth(new Date()));
		
		System.out.println("----------------------------------");
		
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
		 String format = sdf.format(new Date());
		 System.out.println(format);
	}
	
}
