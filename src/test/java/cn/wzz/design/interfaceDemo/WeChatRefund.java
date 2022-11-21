package cn.wzz.design.interfaceDemo;

public class WeChatRefund implements Refund{

    @Override
    public <T> T initOrder(T order) {
        return null;
    }

    @Override
    public <T> T callThird(T order) {
        return null;
    }
}
