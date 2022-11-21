package cn.wzz.design.interfaceDemo;

public interface Refund {

    <T> T initOrder(T order);

    <T> T callThird(T order);

}
