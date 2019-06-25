package cn.wzz.otherTools;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public static Date getDateOfLastMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		return calendar.getTime();
	}

	public static Timestamp getTimestamp(String sDate) {
		return Tools.getTimestamp(sDate);
	}

	public static Timestamp getEndTimestamp(String sDate) {
		return Tools.getEndTimestamp(sDate);
	}

	public static String date2String(Date date) {
		return Tools.Date2String(date);
	}

	public static String date2String(Date date, String formattingString) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formattingString);
		return simpleDateFormat.format(date);
	}

	/**
	 * format timestamp to string. parttern like SimpleDateFormat
	 *
	 * @param timestamp
	 *            timestamp
	 * @param formattingString
	 *            format parttern
	 * @return string
	 */
	public static String date2String(Timestamp timestamp, String formattingString) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formattingString);
		return simpleDateFormat.format(new Date(timestamp.getTime()));
	}

	public static Date toDate(String sDate) throws ParseException {
		return Tools.toDate(sDate);
	}

	public static Timestamp addDate(Timestamp oldDate, int addDays) {
		return Tools.addDate(oldDate, addDays);
	}

	public static Timestamp addMonth(Timestamp oldDate, int addMonths) {
		return Tools.addMonth(oldDate, addMonths);
	}

	public static Timestamp addYear(Timestamp oldDate, int addYears) {
		return Tools.addYear(oldDate, addYears);
	}

	public static Date addSeconds(Date oldDate, int addSeconds) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(oldDate);
		cal.add(Calendar.SECOND, addSeconds);
		return cal.getTime();
	}
	
	public static Date addDate(Date oldDate, int addDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(oldDate);
		cal.add(Calendar.DATE, addDays);
		return cal.getTime();
	}

	public static Date toDate(int year, int month, int date) {
		return Tools.toDate(year, month, date, 0, 0, 0);
	}

	public static Date toDate(int year, int month, int date, int hrs, int min, int sec) {
		return Tools.toDate(year, month, date, hrs, min, sec);
	}

	public static int getYear(Date date) {
		return Tools.getYear(date);
	}

	public static int getYear(long date) {
		return Tools.getYear(date);
	}

	public static int getMonth(Date date) {
		return Tools.getMonth(date);
	}

	public static int getMonth(long date) {
		return Tools.getMonth(date);
	}

	public static int getDate(Date date) {
		return Tools.getDate(date);
	}

	public static int getDate(long date) {
		return Tools.getDate(date);
	}

	public static int getHours(Date date) {
		return Tools.getHours(date);
	}

	public static int getMinutes(Date date) {
		return Tools.getMinutes(date);
	}

	public static int getSeconds(Date date) {
		return Tools.getSeconds(date);
	}

	public static String getChineseDate(Date d) {
		return Tools.getChineseDate(d);
	}

	public static int getMonthAmount(Date startDate, Date endDate) {
		return Tools.getMonthAmount(startDate, endDate);
	}

	public static int getDayAmount(Date startDate, Date endDate) {
		return Tools.getDayAmount(startDate, endDate);
	}

	/**
	 * 将日期格式转换为yyyy-mm-dd格式的String
	 *
	 * @param date
	 *            日期
	 * @param division
	 *            分割符
	 * @return 日期
	 */
	static public String dateToString(Date date, String division) {
		return Tools.dateToString(date, division);
	}

	/**
	 * 将日期格式转换为yyyy-mm-dd格式的String
	 *
	 * @param date
	 *            日期
	 * @param division
	 *            分割符
	 * @return 日期
	 */
	static public String dateToString(Timestamp date, String division) {
		return Tools.dateToString(date, division);
	}

	/**
	 * 将日期格式转换为yyyy-mm-dd格式的String
	 *
	 * @param date
	 *            日期
	 * @param division
	 *            分割符
	 * @return 日期
	 */
	static public String dateToString(long date, String division) {
		return Tools.dateToString(new Date(date), division);
	}

	public static String getChineseDate(long d) {
		return Tools.getChineseDate(new Date(d));
	}

	/**
	 * 将String转化为Timestamp, 格式规范遵循SimpleDateFormat规则.<br>
	 *
	 * @param date
	 *            日期
	 * @return Timestamp
	 * @see StringToTimestamp(String pData, String pFormat)
	 * @see java.text.SimpleDateFormat
	 */
	public static Timestamp stringToTimestamp(String date) {
		int length = date.length();
		if (length == 10) {
			return StringToTimestamp(date, "yyyy-MM-dd");
		} else if (length == 13) {
			return StringToTimestamp(date, "yyyy-MM-dd HH");
		} else if (length == 16) {
			return StringToTimestamp(date, "yyyy-MM-dd HH:mm");
		} else if (length == 19) {
			return StringToTimestamp(date, "yyyy-MM-dd HH:mm:ss");
		} else {
			// not supported
			return null;
		}
	}

	/**
	 * 将String转换为Timestamp, 格式规范遵循SimpleDateFormat规则.<br>
	 * 支持的格式有:<br>
	 * yyyy-MM-dd<br>
	 * yyyy-MM-dd-HH<br>
	 * yyyy-MM-dd HH<br>
	 * yyyy-MM-dd-HH:mm<br>
	 * yyyy-MM-dd HH:mm<br>
	 * yyyy-MM-dd-HH:mm:ss<br>
	 * yyyy-MM-dd HH:mm:ss
	 *
	 * @param pData
	 *            日期
	 * @param pFormat
	 *            日期格式
	 * @return Timestamp
	 * @see java.text.SimpleDateFormat
	 */
	public static Timestamp StringToTimestamp(String pData, String pFormat) {
		Timestamp ts = null;
		if (pData == null || "".equals(pData))
			return null;
		if (pFormat.equalsIgnoreCase("YYYY-MM-DD")) {
			String date = pData.substring(0, 10);
			ts = Timestamp.valueOf(date + " 00:00:00.000000000");
		} else if (pFormat.equalsIgnoreCase("YYYY-MM-DD HH") || pFormat.equalsIgnoreCase("YYYY-MM-DD-HH")) {
			String date = pData.substring(0, 10);
			String time = pData.substring(11, 13);
			ts = Timestamp.valueOf(date + " " + time + ":00:00.000000000");
		} else if (pFormat.equalsIgnoreCase("YYYY-MM-DD HH:MM") || pFormat.equalsIgnoreCase("YYYY-MM-DD-HH:MM")) {
			String date = pData.substring(0, 10);
			String time = pData.substring(11, 16);
			ts = Timestamp.valueOf(date + " " + time + ":00.000000000");
		} else if (pFormat.equalsIgnoreCase("YYYY-MM-DD HH:MM:SS") || pFormat.equalsIgnoreCase("YYYY-MM-DD-HH:MM:SS")) {
			String date = pData.substring(0, 10);
			String time = pData.substring(11, 19);
			ts = Timestamp.valueOf(date + " " + time + ".000000000");
		}
		return ts;
	}

	/**
	 * 将日期格式转换为指定格式的String
	 *
	 * @param pData
	 *            日期
	 * @param pFormat
	 *            日期格式
	 * @return 日期
	 */
	public static String TimestampToString(Timestamp pData, String pFormat) {
		String sReturn = "";
		String division = "-";
		if (pData == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(pData);
		int year = cal.get(Calendar.YEAR);
		String sYear = "" + year;
		int month = cal.get(Calendar.MONTH) + 1;
		String sMonth = "" + month;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String sDay = "" + day;
		int AMorPM = cal.get(Calendar.AM_PM);
		// System.out.println("am-pm==="+AMorPM);
		int hour = cal.get(Calendar.HOUR);
		// System.out.println("hour==="+hour);
		if (AMorPM == 1)
			hour = hour + 12;
		String sHour = "" + hour;
		int minute = cal.get(Calendar.MINUTE);
		String sMinute = "" + minute;
		int second = cal.get(Calendar.SECOND);
		String sSecond = "" + second;
		// sReturn += division;
		if (month < 10)
			sMonth = "0" + month;
		if (day < 10)
			sDay = "0" + day;
		if (hour < 10)
			sHour = "0" + hour;
		if (minute < 10)
			sMinute = "0" + minute;
		if (second < 10)
			sSecond = "0" + second;
		if (pFormat.equalsIgnoreCase("YYYY-MM-DD")) {
			// return dateToString(new Date(pData.getTime()),"-");
			sReturn = sYear + division + sMonth + division + sDay;
		} else if (pFormat.equalsIgnoreCase("YYYY-MM-DD-HH") || pFormat.equalsIgnoreCase("YYYY-MM-DD HH")) {
			// sReturn=sYear+division+sMonth+division+sDay+"
			// "+sHour+":"+sMinute+":"+sSecond+".000000000";
			sReturn = "" + sYear + division + sMonth + division + sDay + " " + sHour;
		} else if (pFormat.equalsIgnoreCase("YYYY-MM-DD HH:MM") || pFormat.equalsIgnoreCase("YYYY-MM-DD-HH:MM")) {
			sReturn = sYear + division + sMonth + division + sDay + " " + sHour + ":" + sMinute;
		} else if (pFormat.equalsIgnoreCase("YYYY-MM-DD HH:MM:SS") || pFormat.equalsIgnoreCase("YYYY-MM-DD-HH:MM:SS")) {
			sReturn = sYear + division + sMonth + division + sDay + " " + sHour + ":" + sMinute + ":" + sSecond;
		}
		return sReturn;
	}

	public static Timestamp stringToTimestamp(String pData, String pFormat) {
		return StringToTimestamp(pData, pFormat);
	}

	public static String timestampToString(Timestamp pData, String pFormat) {
		return TimestampToString(pData, pFormat);
	}

	// 获得系统时间
	public static Date getSystemDate() {
		return new Date();
	}

	/**
	 * 将日期字符串传入与系统时间比较, 相减获得的小时数是否小于传入参数 如果大于则返回为TRUE,否则返回FALSE
	 *
	 * @param date
	 *            日期
	 * @param num
	 *            int
	 * @return blooean
	 */
	public static boolean checkDate(String date, int num) {
		boolean bl = true;
		try {
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date lastTime = formatter.parse(date);
			// 把当前时间格式化成 yyyy-MM-dd HH:mm:ss 的形式
			Calendar c = Calendar.getInstance();
			String s = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE) + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":"
					+ c.get(Calendar.SECOND);

			System.out.println("the request date:" + date);
			System.out.println("system      date:" + s);
			Date nowDate = formatter.parse(s);
			System.out.println("change the request date:" + lastTime);
			System.out.println("the system         date:" + nowDate);
			// 时间格式一样的时间数相减
			long time = nowDate.getTime() - lastTime.getTime();
			// 得到小时数
			long newTime = time / (1000 * 60 * 60);
			System.out.println("time:" + time + "newTime:" + newTime + " num:" + num);
			if (newTime > Long.parseLong(String.valueOf(num))) {
				bl = true;
			} else {
				bl = false;
			}
		} catch (Exception ex) {
			bl = false;
		}
		return bl;
	}

	/**
	 * 将日期字符串传入与系统时间比较, 相减获得的小时数是否小于传入参数 如果大于则返回为TRUE,否则返回FALSE
	 *
	 * @param date
	 *            日期
	 * @param num
	 *            int
	 * @return blooean
	 */
	public static boolean checkMinutes(String date, int num) {
		boolean bl = true;
		try {
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date lastTime = formatter.parse(date);
			// 把当前时间格式化成 yyyy-MM-dd HH:mm:ss 的形式
			Calendar c = Calendar.getInstance();
			String s = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DATE) + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":"
					+ c.get(Calendar.SECOND);

			System.out.println("the request date:" + date);
			System.out.println("system      date:" + s);
			Date nowDate = formatter.parse(s);
			System.out.println("change the request date:" + lastTime);
			System.out.println("the system         date:" + nowDate);
			// 时间格式一样的时间数相减
			long time = nowDate.getTime() - lastTime.getTime();
			// 得到分钟数
			long newTime = time / (1000 * 60);
			System.out.println("time:" + time + "newTime:" + newTime + " num:" + num);
			if (newTime > Long.parseLong(String.valueOf(num))) {
				bl = true;
			} else {
				bl = false;
			}
		} catch (Exception ex) {
			bl = false;
		}
		return bl;
	}

	/* add by xiaojian 2013-04-13 begin reason：EBCSR-342-红道核损车物损增加跟踪信息需求 */
	public static int getWeekdayOfTimestamp(Timestamp iTimestamp) {
		GregorianCalendar gCalendar = convertToCalendar(iTimestamp);
		int weekday0 = gCalendar.get(GregorianCalendar.DAY_OF_WEEK); // 星期日=1、星期一=2、星期二=3。。。星期六=7
		int weekday1 = 0;
		if (weekday0 >= 2 && weekday0 <= 7) {
			weekday1 = weekday0 - 1;
		} else {
			weekday1 = 7;
		}
		return weekday1;
	}
	/* add by xiaojian 2013-04-13 end reason：EBCSR-342-红道核损车物损增加跟踪信息需求 */

	/* add by xiaojian 2013-04-13 begin reason：EBCSR-342-红道核损车物损增加跟踪信息需求 */
	public static GregorianCalendar convertToCalendar(Timestamp iTimestamp) {
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(convertTimestampToDate(iTimestamp));
		return gCalendar;
	}
	/* add by xiaojian 2013-04-13 end reason：EBCSR-342-红道核损车物损增加跟踪信息需求 */

	/* add by xiaojian 2013-04-13 begin reason：EBCSR-342-红道核损车物损增加跟踪信息需求 */
	public static Date convertTimestampToDate(Timestamp iTimestamp) {
		Date date = null;
		date = new Date(iTimestamp.getTime());
		return date;
	}
	/* add by xiaojian 2013-04-13 end reason：EBCSR-342-红道核损车物损增加跟踪信息需求 */

	/**
	 * 得到几天前的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}
	

	
    /**
     * 日期格式yyyyMMddHHmmss
     */
    public static final String DATE_FORMAT_14 = "yyyyMMddHHmmss";
    /**
     * 日期格式成yyyyMMddHHmm
     */
    public static final String DATE_FORMAT_12 = "yyyyMMddHHmm";
    /**
     * 日期格式成yyyyMMdd
     */
    public static final String DATE_FORMAT_8 = "yyyyMMdd";
    /**
     * 日期格式成yyyyMMdd
     */
    public static final String DATE_FORMAT_10 = "yyyy-MM-dd";

    /**
     * 将传入的日期格式化成特定的格式
     * 调用的时候不允许date和str为空
     *
     * @param date 日期
     * @param str  格式化的样式
     * @return 格式化好的日期
     */
    public static String format(Date date, String str) {
        SimpleDateFormat format = new SimpleDateFormat(str);
        return format.format(date);
    }

    public static Date format(String date, String str) {
        SimpleDateFormat format = new SimpleDateFormat(str);
        try {
            return format.parse(date);
        } catch (ParseException e) {

        }
        return null;
    }


    // 日期加n天
    public static Date getAddDate(Date dateParam,int num) {
        Calendar c = Calendar.getInstance(); // 初始化一个Calendar
        c.setTime(dateParam);
        c.add(Calendar.DATE, num);
        Date dateRet = c.getTime();
        return dateRet;
    }

    // 日期加n天
    public static String getAddDateStr(Date dateParam,int num,String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat); // 将字符串格式化
        Calendar c = Calendar.getInstance(); // 初始化一个Calendar
        c.setTime(dateParam);
        c.add(Calendar.DATE, num);
        Date dateRet = c.getTime();
        String dateStr = sdf.format(dateRet);
        return dateStr;
    }

    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static void main(String[] args) throws Exception{
    	//checkMinutes("2011-03-28 15:12:11", 30);
		int year = DateUtil.getYear(new Date());
		System.out.println(year);
    	
        System.out.println(daysBetween(new Date(),new Date()));
    }
	
}

