package cn.wzz.interview_second.oomdemo;

import java.util.ArrayList;
import java.util.List;

public class OOMEGCOverheadLimitExceededDemo {

    /**
     * 设置JVM参数
     * -Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m
     *
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while(true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println("***************i:" + i);
            e.printStackTrace();
            throw e;
        }
    }

}

