package cn.wzz.test.streamTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeChatAmount {

    /**
     * 总金额
     */
    private int total;
    /**
     * 货币类型
     */
    private String currency;

    private Object test;
}
