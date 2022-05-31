package cn.wzz.test.streamTest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonTest implements Serializable {

    private static final long serialVersionUID = -5106588553779369521L;


    private String description;

    private String outTradeNo;

    private String timeExpire;

    /**
     * 订单金额
     */
    private WeChatAmount amount;

    private List<WeChatAmount> amountList;

    private Integer amountInteger;

    private LocalDateTime dateTime;

}
