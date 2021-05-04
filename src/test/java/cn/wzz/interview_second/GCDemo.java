package cn.wzz.interview_second;

import java.util.Random;

public class GCDemo {

    public static void main(String[] args) throws InterruptedException {

        Random rand = new Random(System.nanoTime());

        try {
            String str = "Hello, World";
            while(true) {
                str += str + rand.nextInt(Integer.MAX_VALUE) + rand.nextInt(Integer.MAX_VALUE);
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }

    }
}

