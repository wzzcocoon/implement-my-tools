package cn.wzz.interview_second.lockdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadWriteWithoutLockDemo {

    public static void main(String[] args) {
//        MyCache myCache = new MyCache();
//        // 线程操作资源类，5个线程写
//        for (int i = 0; i < 5; i++) {
//            final int tempInt = i;
//            new Thread(() -> {
//                myCache.put(tempInt + "", tempInt +  "");
//            }, String.valueOf(i)).start();
//        }
//        // 线程操作资源类， 5个线程读
//        for (int i = 0; i < 5; i++) {
//            final int tempInt = i;
//            new Thread(() -> {
//                myCache.get(tempInt + "");
//            }, String.valueOf(i)).start();
//        }

        MyLockCache myLockCache = new MyLockCache();
        // 线程操作资源类，5个线程写
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myLockCache.put(tempInt + "", tempInt +  "");
            }, String.valueOf(i)).start();
        }
        // 线程操作资源类， 5个线程读
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myLockCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }

    }

}



class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
        try {
            // 模拟网络拥堵，延迟0.3秒
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "\t 写入完成");
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "\t 正在读取:");
        try {
            // 模拟网络拥堵，延迟0.3秒
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object value = map.get(key);
        System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + value);
    }
}



class MyLockCache {

    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
        try {
            // 模拟网络拥堵，延迟0.3秒
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
        System.out.println(Thread.currentThread().getName() + "\t 写入完成");
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "\t 正在读取:");
        Object value = null;
        try {
            // 模拟网络拥堵，延迟0.3秒
            TimeUnit.MILLISECONDS.sleep(300);
            value = map.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
        System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + value);
    }
}

