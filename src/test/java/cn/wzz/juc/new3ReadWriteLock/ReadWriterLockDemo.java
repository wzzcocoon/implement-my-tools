package cn.wzz.juc.new3ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**资源类，读写的方法就是变相的Set Get*/
class MyQueue{
	private Object obj;
	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	public void writeObj(Object obj) {
		rwLock.writeLock().lock();
		try {
			this.obj = obj;
			System.out.println(Thread.currentThread().getName() + "\t" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwLock.writeLock().unlock();
		}
	}
	public void redObj() {
		rwLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t" + obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rwLock.readLock().unlock();
		}
	}
}

/**一个线程写，100个线程读*/
public class ReadWriterLockDemo {
	public static void main(String[] args) throws InterruptedException {

		MyQueue mq = new MyQueue();
		
		new Thread(() -> {
			mq.writeObj("开始上课！！！");
		}, "Teacher").start();
		
		Thread.sleep(100);
		
		for (int i = 1; i <= 100; i++) {
			new Thread(() -> {
				mq.redObj();
			}, "Student"+i).start();
		}

	}
}
