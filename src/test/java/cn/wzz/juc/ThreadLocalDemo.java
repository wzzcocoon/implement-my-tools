package cn.wzz.juc;


import java.text.SimpleDateFormat;

public class ThreadLocalDemo {

    static  ThreadLocal<String> threadLocal = new ThreadLocal<>();
    static  ThreadLocal<SimpleDateFormat> formatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat());

    public static void main(String[] args) {

//        testString();

    }

    private static void testString() {

        threadLocal.set("Main");

        new Thread(()-> {
            threadLocal.set("AAA");
            String s = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " threadLocal: " + s);
        },"AAA").start();

        System.out.println(Thread.currentThread().getName() + " threadLocal: " + threadLocal.get());
    }

    private static void testTrueUse() {


        new Thread(()-> {
            threadLocal.set("AAA");
            String s = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " threadLocal: " + s);
        },"AAA").start();

        System.out.println(Thread.currentThread().getName() + " threadLocal: " + threadLocal.get());
    }


}
