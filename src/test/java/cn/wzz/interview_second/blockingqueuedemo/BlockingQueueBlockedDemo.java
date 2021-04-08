package cn.wzz.interview_second.blockingqueuedemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueBlockedDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        new Thread(()->{
            try {
                blockingQueue.put("a");
                blockingQueue.put("b");
                blockingQueue.put("c");
                blockingQueue.put("c");//将会阻塞,直到主线程take()
                System.out.println("it was blocked.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);

        try {

            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();

            System.out.println("Blocking...");
            blockingQueue.take();//将会阻塞

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

