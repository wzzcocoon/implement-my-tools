package cn.wzz.test.micro;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {

    private String orderId;
    private Integer amount;
    private String channel;
    private LocalDateTime createTime;
}