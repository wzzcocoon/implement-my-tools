package cn.wzz.test.streamTest;

import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        new StreamDemo().exec();
    }


    public void exec(){

        // sort 方法
        List<JsonTest> sortList = new ArrayList<>();
        sortList.add(JsonTest.builder().dateTime(LocalDateTime.of(2019, 12, 12, 12, 12 ,12)).build());
        sortList.add(JsonTest.builder().dateTime(LocalDateTime.of(2020, 12, 12, 12, 12 ,12)).build());
        sortList.add(JsonTest.builder().dateTime(LocalDateTime.of(2021, 12, 12, 12, 12 ,12)).build());
        sortList.add(JsonTest.builder().dateTime(LocalDateTime.of(2022, 12, 12, 12, 12 ,12)).build());
        List<JsonTest> collect6 = sortList.stream().sorted(Comparator.comparing(JsonTest::getDateTime).reversed()).collect(Collectors.toList());
        System.out.println(collect6);


        List<WeChatAmount> list = new ArrayList<>();
        list.add(new WeChatAmount(1,"1",new Object()));
        list.add(new WeChatAmount(2,"2",new Object()));

        // map 方法 (重新组合出对应的属性)
        List<String> collect = list.stream().map(WeChatAmount::getCurrency).collect(Collectors.toList());
        System.out.println(collect); //map( obj.xxx )

        List<WeChatAmount> collect1 = list.stream().map(po -> {
            po.setCurrency(po.getCurrency() + "加密");
            return po;
        }).collect(Collectors.toList());
        System.out.println(collect1);

        List<WeChatAmount> collect2 = list.stream().map(this::decrypt).collect(Collectors.toList());
        System.out.println(collect2); //map( this.xxx(obj) )  和上面写法一致


        //filter 方法 (过滤出符合的数据)
        list.add(null);
        System.out.println(list);
        List<WeChatAmount> collect3 = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(collect3);
        List<WeChatAmount> collect33 = collect3.stream().filter(weChatAmount -> weChatAmount.getTotal() == 1).collect(Collectors.toList());
        System.out.println(collect33);


        // Collectors.toMap
        Map<Integer, String> collect4 = collect3.stream().collect(Collectors.toMap(WeChatAmount::getTotal, WeChatAmount::getCurrency));
        System.out.println(collect4);

        List<Integer> strings = Arrays.asList(1, 2);
        Map<String, String> collect5 = strings.stream().collect(Collectors.toMap(String::valueOf, collect4::get));
        System.out.println(collect5);

        // return
        strings.forEach(str -> {
            if (1 == str){
                return;
            }
            System.out.println(str);
        });
    }


    public WeChatAmount decrypt(WeChatAmount po){
        WeChatAmount retPo = new WeChatAmount();
        BeanUtils.copyProperties(po, retPo);
        retPo.setCurrency(po.getCurrency() + "解密");
        return retPo;
    }
}
