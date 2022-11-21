package cn.wzz.test.stringDemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {

        //length
        String length = "OT2021112301063298264160196";
        System.out.println(length.length());

        //format
        String format = "%S%S";
        String.format(format, "A", "B");
        System.out.println(format);
        System.out.println(String.format(format, "A", "B"));

        //substring
        String sub = "D000000000008";
        System.out.println(sub.substring(1));
        System.out.println("TP2021111219302334143986961".substring(1, sub.length()));
        System.out.println("1117142331".substring(0, 2));


        //trim
        String space = "  123       ";
        System.out.println(space);
        System.out.println(space.trim());

        //split
        String service = "upay-center-go@/path";
        String[] split = service.split("@");
        Arrays.stream(split).forEach(System.out::println);
        System.out.println(split.length);
        for (int i = 0; i<split.length; i++){
            System.out.println(i + "---" + split[i]);
        }

        String orderNo = "OPP202001122130000000";
        String[] orderNos = orderNo.split("^[A-Z]+", 2);
        Arrays.stream(split).forEach(System.out::println);
        System.out.println(orderNos[1].substring(0, 17));

        LocalDateTime yyyyMMddHHmmss = LocalDateTime.parse(orderNos[1].substring(0, 14), DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        LocalDateTime dateTime = LocalDateTime.now().minusMonths(18);
        System.out.println(dateTime.isAfter(yyyyMMddHHmmss));

        String filePath = "/${tempDir}/2021-12-01/sgcx5/1488065062/transfer.gzip";
        String[] paths = filePath.split("/");
        String merId = paths[paths.length - 2];
        System.out.println(merId);

        // Equals
        String s = "123";
        long l = 123L;
        System.out.println(s.equals(l));
        System.out.println(s.equals(String.valueOf(l)));

        // startsWith
        String str = "Welcome to Yiibai.com";
        System.out.println(str.startsWith("Welcome") );
        System.out.println(str.startsWith("to") );
        System.out.println(str.startsWith("Yiibai", 11) );

        // indexOf
        System.out.println(str.indexOf("Welcome") );
        System.out.println(str.indexOf("Welcome") == 0);

        // replace
        String url = "test.com/{path}?appId={appId}";
        System.out.println(url.replace("{path}", "wechat").replace("{appId}","12345"));
        String json = "{\"risk_fund\":{\"amount\":30000,\"description\":\"\",\"name\":\"ESTIMATE_ORDER_COST\"},\"time_range\":{\"start_time\":\"20200102194721\"}}";
        System.out.println(json);
        System.out.println(json.replace("\\",""));
    }
}
