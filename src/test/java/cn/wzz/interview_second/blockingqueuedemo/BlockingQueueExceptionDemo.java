package cn.wzz.interview_second.blockingqueuedemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExceptionDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        try {
            //抛出 java.lang.IllegalStateException: Queue full
            System.out.println(blockingQueue.add("XXX"));
        } catch (Exception e) {
            System.out.println(e);
        }
        //element() ：获取但不移除此队列的头元素，没有元素则抛异常
        System.out.println(blockingQueue.element());


        //============
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        try {
            //抛出 java.util.NoSuchElementException
            System.out.println(blockingQueue.remove());
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            //element()相当于peek(),但element()会抛NoSuchElementException
            System.out.println(blockingQueue.element());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

