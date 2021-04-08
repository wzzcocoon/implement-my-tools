package cn.wzz.interview_second.lockdemo;

import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{

    String resourceA;
    String resourceB;

    public MyThread(String resourceA, String resourceB) {
        this.resourceA = resourceA;
        this.resourceB = resourceB;
    }

    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(String.format("%s 自己持有%s，尝试持有%s",//
                    Thread.currentThread().getName(), resourceA, resourceB));

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (resourceB) {
                System.out.println(String.format("%s 同时持有%s，%s",//
                        Thread.currentThread().getName(), resourceA, resourceB));
            }
        }
    }
}



public class DeadLockDemo {

    public static void main(String[] args) {

        new Thread(new MyThread("lockA","lockB"),"AAA").start();
        new Thread(new MyThread("lockB","lockA"),"BBB").start();
    }

}
