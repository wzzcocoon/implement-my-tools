package cn.wzz.design.overrideDemo;

public class MainDemo {
    public static void main(String[] args) {

        Bean bean = new Bean();
        bean.setDao("123");
        System.out.println(bean.getDao());

    }
}
