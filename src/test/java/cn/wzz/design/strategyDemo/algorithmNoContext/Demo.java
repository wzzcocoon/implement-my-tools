package cn.wzz.design.strategyDemo.algorithmNoContext;

import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        Map<Integer,Strategy> map = new HashMap<>();
        map.put(1,new ConcreteStrategyA());
        map.put(2,new ConcreteStrategyB());
        map.put(3,new ConcreteStrategyB());
        
        
       for (int i = 1;i <= 3; i++){
           map.get(i).algorithmInterface();
       }
    }

}
