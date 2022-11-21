package cn.wzz.test.threadPoolDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class CompletableFutureDemo {

    public static void main(String[] args) {
        String str = "124";
        run( () -> {
            System.out.println(Thread.currentThread().getName() + ": " + str);
        }, AsyncScene.COMMON);

        System.out.println(Thread.currentThread().getName() + ": " + str);

//        testRun();
//
//        System.out.println(Thread.currentThread().getName() + " start,time->"+System.currentTimeMillis());
//        //等待子任务执行完成
//        System.out.println(Thread.currentThread().getName() + " exit,time->"+System.currentTimeMillis());

    }


    public static void testRun() {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        // 创建异步执行任务:
        CompletableFuture cf = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName() + " start,time->"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " exit,time->"+System.currentTimeMillis());
        },executorService);

    }

    private static final ConcurrentMap<AsyncScene, ExecutorService> threadPoolCacheMap = new ConcurrentHashMap<>(128);

    static {
        for (AsyncScene scene : AsyncScene.values()) {
            ThreadPoolExecutor executorService = new ThreadPoolExecutor(scene.corePoolSize, scene.maximumPoolSize,
                    scene.keepAliveTime, scene.unit, scene.workQueue, scene.threadFactory, scene.handler);
            executorService.allowCoreThreadTimeOut(true);
            threadPoolCacheMap.put(scene, executorService);
        }
    }

    public static void run(Runnable runnable) {
        run(runnable, AsyncScene.COMMON);
    }

    public static void run(Runnable runnable, AsyncScene asyncScene) {
        if (asyncScene == null) {
            asyncScene = AsyncScene.COMMON;
        }

        CompletableFuture.runAsync(runnable, threadPoolCacheMap.get(asyncScene));
    }

    public enum AsyncScene {
        /**
         * 通用场景
         */
        COMMON,
        /**
         * 退款场景
         */
        REFUND;

        AsyncScene() {
            this(Runtime.getRuntime().availableProcessors() * 2, 64, 60, TimeUnit.SECONDS, 1000, new ThreadPoolExecutor.CallerRunsPolicy());
        }

        AsyncScene(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, int workQueueCapacity, RejectedExecutionHandler handler) {
            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.keepAliveTime = keepAliveTime;
            this.unit = unit;
            this.workQueue = new LinkedBlockingQueue<>(workQueueCapacity);
            this.threadFactory = Executors.defaultThreadFactory();
            this.handler = handler;
        }

        int corePoolSize;
        int maximumPoolSize;
        long keepAliveTime;
        TimeUnit unit;
        BlockingQueue<Runnable> workQueue;
        ThreadFactory threadFactory;
        RejectedExecutionHandler handler;
    }

}
