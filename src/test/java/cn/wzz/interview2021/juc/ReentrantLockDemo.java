package cn.wzz.interview2021.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 显示锁:(即lock)也有ReentrantLock这样的可重入锁
 * (注意：有多少个lock,就有多少个unlock,他们是配对使用的；如果多一个或者少一个会使得其他线程处于等待状态)
 */
public class ReentrantLockDemo {

    static Lock lockA = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lockA.lock();
            lockA.lock();
            try{
                System.out.println("===外层");

                lockA.lock();
                try{
                    System.out.println("===内层");
                }finally {
                    lockA.unlock();
                }

            }finally {
                lockA.unlock();
                /**
                 * 如果将此处注释掉，实现加锁次数和释放次数不一样，会导致t2拿不到锁，造成等待；
                 * 正常情况下，加锁几次就要解锁几次
                 */
                lockA.unlock();
            }
        },"t1").start();


        new Thread(() -> {
            lockA.lock();
            try{
                System.out.println(Thread.currentThread().getName() + "运行");
            }finally {
                lockA.unlock();
            }
        },"t2").start();
    }
}
