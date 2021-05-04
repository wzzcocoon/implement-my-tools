package cn.wzz.interview_second.blockingqueuedemo.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutorDemo {


    public static ExecutorService getMyThreadPoolExecutor(int corePoolSize,
                                                          int maximumPoolSize, int blockingQueueSize, RejectedExecutionHandler handler){
        return new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                1,//keepAliveTime
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(blockingQueueSize),
                Executors.defaultThreadFactory(),
                handler);
    }


    public static void main(String[] args) {
        doSomething(getMyThreadPoolExecutor(2, 5, 3, new ThreadPoolExecutor.AbortPolicy()), 10);
        doSomething(getMyThreadPoolExecutor(2, 5, 3, new ThreadPoolExecutor.CallerRunsPolicy()), 20);
        doSomething(getMyThreadPoolExecutor(2, 5, 3, new ThreadPoolExecutor.DiscardOldestPolicy()), 10);
        doSomething(getMyThreadPoolExecutor(2, 5, 3, new ThreadPoolExecutor.DiscardPolicy()), 10);
    }
    public static void doSomething(ExecutorService executorService, int numOfRequest) {

        try {

            System.out.println(((ThreadPoolExecutor)executorService).getRejectedExecutionHandler().getClass() + ":");
            TimeUnit.SECONDS.sleep(1);

            for (int i = 0; i < numOfRequest; i++) {
                final int tempInt = i;
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tempInt + " 办理业务");
                });
            }

            TimeUnit.SECONDS.sleep(1);
            System.out.println("\n\n");

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            executorService.shutdown();
        }
    }
    
}

