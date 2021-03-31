package cn.wzz.juc.new22;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**Dome 2  ==> Condition对象  	  await ... signalAll
 *  1、await()：导致当前线程等待，直到其他线程调用该Condition的signal()或signalAll()方法唤醒该线程。
	2、signal()：唤醒在此Lock对象上等待的单个线程。
	3、signalAll()：唤醒在此Lock对象上等待的所有线程。
 * 
 * 现在两个线程，
 * 可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 交替，来10轮，变量初始值为零。
 * 
 * 2 多线程编写套路------下(线程之间的交互)
 * 		2.1 判断    2.2 干活    2.3 通知
 */
public class NotifyWaitDemo {
	public static void main(String[] args) {
	
		ShareDate sd = new ShareDate();
		
		new Thread(() -> {
			for (int i = 1; i <=10; i++) {
				try {
					Thread.sleep(200);
					sd.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "线程1").start();	
		new Thread(() -> {
			for (int i = 1; i <=10; i++) {
				try {
					Thread.sleep(200);
					sd.decrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "线程2").start();	new Thread(() -> {
			for (int i = 1; i <=10; i++) {
				try {
					Thread.sleep(200);
					sd.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "线程3").start();	new Thread(() -> {
			for (int i = 1; i <=10; i++) {
				try {
					Thread.sleep(200);
					sd.decrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "线程4").start();	
	}
}

class ShareDate{
	private int number = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void increment(){
		lock.lock();
		try{
			while(number != 0){
				condition.await();//this.wait();
			}
			//2 干活
			++number;
			System.out.println(Thread.currentThread().getName()+"\t"+number);
			//3 通知
			condition.signalAll();//this.notifyAll();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void decrement() {
		lock.lock();
		try {
			while(number == 0)
			{
				condition.await();//this.wait();
			}
			//2 干活
			--number;
			System.out.println(Thread.currentThread().getName()+"\t"+number);
			//3 通知
			condition.signalAll();//this.notifyAll();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}	
}
