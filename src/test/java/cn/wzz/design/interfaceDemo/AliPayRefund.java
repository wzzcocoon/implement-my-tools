package cn.wzz.design.interfaceDemo;

public class AliPayRefund implements Refund{

    @Override
    public <T> T initOrder(T order) {
        return null;
    }

    @Override
    public <T> T callThird(T order) {
        return null;
    }


    static class AliPayBean{

        private String name;

    }
}
