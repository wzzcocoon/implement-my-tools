package cn.wzz.interview2021.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {

    public static void main(String[] args) {
        /**
         * 1. synchronized
         *    wait notify
         * 条件：
         *    1.wait和notify方法必须要在synchronized内部执行，否则会有java.lang.IllegalMonitorStateException报错
         *    2.先wait后notify才可以(如果先notify后wait会出现另一个线程一直处于等待状态)
         */
//        synchronizedDemo();

        /**
         * 2. Lock
         *    await signal
         * 条件：
         *    1.await和signal方法必须要在lock/unlock内部执行，否则会有java.lang.IllegalMonitorStateException报错
         *    2.先await后signal才可以(如果先signal后await会出现另一个线程一直处于等待状态)
         */
//        lockDemo();

        /**
         * 3. LockSupport
         *    park  unPark
         *
         *    1.无需锁块，可以直接运行；
         *    2.之前错误的先唤醒后等待，LockSupport照样支持
         */
        lockSupportDemo();
    }


    public static void synchronizedDemo(){
        Object objectLock = new Object();
        new Thread(() -> {
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() + "\t" +"come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" +"被唤醒");
            }
        },"t1").start();
        new Thread(() -> {
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() + "\t" +"come in");
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" +"通知");
            }
        },"t2").start();
    }

    public static void lockDemo(){
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t" +"come in");
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "\t" +"被唤醒");
        },"t1").start();
        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t" +"come in");
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" +"通知");
            }
            finally {
                lock.unlock();
            }
        },"t2").start();
    }

    public static void lockSupportDemo(){
        Thread a = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(3L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + "\t" +"come in");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" +"被唤醒");
        },"t1");
        a.start();
        Thread b = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" +"come in");
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t" +"通知");
        },"t2");
        b.start();
    }
}
