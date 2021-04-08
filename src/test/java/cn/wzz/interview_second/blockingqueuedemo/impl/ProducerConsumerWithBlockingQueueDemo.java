package cn.wzz.interview_second.blockingqueuedemo.impl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    // 默认开启，进行生产消费
    // 这里用到了volatile是为了保持数据的可见性，也就是当TLAG修改时，要马上通知其它线程进行修改
    private volatile boolean flag = true;
    // 使用原子包装类，而不用number++
    private AtomicInteger atomicInteger = new AtomicInteger();
    // 这里不能为了满足条件，而实例化一个具体的SynchronousBlockingQueue
    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> v){
        this.blockingQueue = v;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProducer()throws Exception{
        String data = null;
        boolean retValue;
        // 当flag为true的时候，开始生产
        while (flag){
            data = atomicInteger.incrementAndGet() + "";
            // 2秒存入1个data
            retValue = blockingQueue.offer(data,2L,TimeUnit.SECONDS);
            if(retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列:" + data  + "成功" );
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列:" + data  + "失败" );
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void myConsumer() throws Exception{
        String retValue;
        // 当flag为true的时候，开始消费
        while (flag){
            retValue = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(retValue != null && retValue != "") {
                System.out.println(Thread.currentThread().getName() + "\t 消费队列:" + retValue  + "成功" );
            } else {
                flag = false;
                System.out.println(Thread.currentThread().getName() + "\t 消费失败，队列中已为空，退出" );
                // 退出消费队列
                return;
            }
        }
    }

    public void stop() {
        flag = false;
    }

}

public class ProducerConsumerWithBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
        MyResource myResource = new MyResource(blockingQueue);

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                myResource.myProducer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Cons").start();

        TimeUnit.SECONDS.sleep(10L);

        myResource.stop();

    }

}
