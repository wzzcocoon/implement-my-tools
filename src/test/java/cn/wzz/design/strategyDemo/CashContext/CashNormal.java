package cn.wzz.design.strategyDemo.CashContext;

public class CashNormal extends CashSuper {

    @Override
    public double acceptCash(double money) {
        return money;
    }

}
