package cn.wzz.juc.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**两个线程，一个打印数字，一打印字符*/
public class Test22 {
	public static void main(String[] args) {
//		char b = 'a';
//		System.out.println((char)(b+1));
		Shared sharedate = new Shared();
		new Thread(() -> {
			for(int i=0;i<10;i++) {
				sharedate.printNum();
			}
		}, "线程1").start();
		new Thread(() -> {
			for(int i=0;i<10;i++) {
				sharedate.printEng();
			}
		}, "线程2").start();
	}
}

class Shared{
	private int a = 1;
	private char b = 'a';
	private boolean flag = true;
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void printNum(){
		lock.lock();
		try {
			//判断
			if(!flag) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() +"\t"+ (a++));
			flag = false;
			// 通知
			condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void printEng() {
		lock.lock();
		try {
			//判断
			if(flag) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() +"\t"+ (char)(b++));
			flag = true;
			// 通知
			condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
