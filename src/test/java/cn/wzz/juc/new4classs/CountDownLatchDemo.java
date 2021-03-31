package cn.wzz.juc.new4classs;

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		//等10个同学都走出教室后，班长(用主线程main)再锁门
		for (int j = 1; j <= 10; j++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "走出了教室...");
			}, "同学"+j).start();
		}
		
		Thread.sleep(100);
		 
		System.out.println(Thread.currentThread().getName() + "锁门");
		
//		new Thread(() -> {
//			System.out.println(Thread.currentThread().getName() + "锁门");
//		}, "班长").start();

	}
}
