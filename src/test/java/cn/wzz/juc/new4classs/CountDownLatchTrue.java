package cn.wzz.juc.new4classs;

import java.util.concurrent.CountDownLatch;

/**等10个同学都走出教室后，班长再锁门    -- 使用CountDownLatch对象*/

/**
 * Talk is cheap,show me your code
 * 
 *让一些线程阻塞直到另一些线程完成一系列操作后才被唤醒。
 * 
 * CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞。
 * 其它线程调用countDown方法会将计数器减1(调用countDown方法的线程不会阻塞)，
 * 当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行。
 * 
 * 解释：5个同学陆续离开教室后值班同学才可以关门。
 * 也即	秦灭6国，一统华夏
 * main主线程必须要等前面5个线程完成全部工作后，自己才能开干
 */
public class CountDownLatchTrue {
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch cd = new CountDownLatch(10);
		
		for (int j = 1; j <= 10; j++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "走出了教室...");
				cd.countDown();
			}, "同学"+j).start();
		}
		
		cd.await();		//cd.wait(); ????	Thread.sleep(100); ???
		
		System.out.println(Thread.currentThread().getName() + "锁门");

	}
}
