package cn.wzz.test;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeDemo {

    public static void main(String[] args) {

        System.out.println(LocalDateTime.now());

        /**
         * LocalDate
         */
        //获取当前日期
        LocalDate now = LocalDate.now();
        //获取昨天的日期
        LocalDate yesterday = now.plusDays(-1);
        //根据年月日获取日期
        LocalDate setDate = LocalDate.of(2019, 07, 10);
        //字符串转日期
        LocalDate parse = LocalDate.parse("2019-07-14");
        //将指定日期格式化，也就是将日期转换为字符串
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayStr = dateTimeFormatter.format(yesterday);

        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        String format = sdf.format(new Date());
        System.out.println("01".equals(format));


        //获取下一年的今天，参数是日期相加多少年
        LocalDate localDate = now.plusYears(1);
        //获取日期的年
        int year = localDate.getYear();
        //获取日期的月
        Month month = localDate.getMonth();
        //获取日期的天，这个是获取这个月的天数
        int dayOfMonth = localDate.getDayOfMonth();
        //获取当前日期的天数，也就是今年一共过了多少天，2019-07-14返回197
        int dayOfYear = localDate.getDayOfYear();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();


        /**
         * LocalTime
         */
        //获取当前时间
        LocalTime time = LocalTime.now();



        /**
         * LocalDateTime
         */
        //获取当前日期
        LocalDateTime ldt = LocalDateTime.now();
        //格式化时间类
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //讲字符串转化为时间，带格式
        LocalDateTime ldp = LocalDateTime.parse("2019-07-17 13:46:24",dtf);
        //获取日期中的小时
        int hour = ldp .getHour();   //这个返回的是13
        // 替换时间中的小时
        LocalDateTime localDateTime = ldp.withHour(23);//这个返回的是2019-07-17T23:46:24

        //计算两个时间差，第二个时间减去第一个时间
        Duration duration = Duration.between(ldt, ldp);
        //两个日期相差多少个小时
        long hours = duration.toHours();
        //两个日期相差多少毫秒
        long millis = duration.toMillis();
        //两个日期相差多少分钟
        long minute = duration.toMinutes();
        //两个日期相差多少天
        long day = duration.toDays();

        //获取秒数
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        // 将时间戳转为当前时间
        LocalDateTime dateFromSecond = LocalDateTime.ofEpochSecond(second, 0, ZoneOffset.ofHours(8));

        //获取毫秒数
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        // 将时间戳转为当前时间
        LocalDateTime dateFromMill = LocalDateTime.ofEpochSecond(milliSecond/1000, 0, ZoneOffset.ofHours(8));

        System.out.println("====");


        //格式化时间类
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        LocalDateTime ld = LocalDateTime.parse("2015-05-20T13:29:35.120+08:00", d);
        //讲字符串转化为时间，带格式
        System.out.println(ld);

        System.out.println(LocalDateTime.now());


        //格式化时间类
        DateTimeFormatter dd = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        LocalDateTime ldd = LocalDateTime.parse("2015-05-20T13:29:35+08:00", dd);
        //讲字符串转化为时间，带格式
        System.out.println(ldd);

    }
}
