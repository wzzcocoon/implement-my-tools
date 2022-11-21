package cn.wzz.test.threadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {

        // 一池5个处理线程（用池化技术，一定要记得关闭）
//    	ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // 创建一个只有一个线程的线程池
//    	ExecutorService threadPool = Executors.newSingleThreadExecutor();

        // 创建一个拥有N个线程的线程池，根据调度创建合适的线程
        ExecutorService threadPool = Executors.newCachedThreadPool();

        // 模拟10个用户来办理业务，每个用户就是一个来自外部请求线程
        try {

            // 循环十次，模拟业务办理，让5个线程处理这10个请求
            for (int i = 0; i < 10; i++) {
                final int tempInt = i;
                //execute方法的返回值是void，即无法获取异步任务的执行状态，3个重载的submit方法的返回值是Future，可以据此获取任务执行的状态和结果
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tempInt + " 办理业务"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

