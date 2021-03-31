package cn.wzz.juc.new2;

/**Dome 1  ==> synchronized代码  	wait ... notifyAll
 * 			notifyAll()方法（唤醒所有 wait线程）或 notify()方法（只随机唤醒一个 wait线程）
 * 现在两个线程，
 * 可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 交替，来10轮，变量初始值为零。
 * 
 * 2 多线程编写套路------下(线程之间的交互,生产者消费者模式)
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
	public synchronized void increment() throws InterruptedException{
		//1 判断
		//if(number != 0)
		while(number != 0){
			this.wait();// A......C......
		}
		//2 干活
		++number;
		System.out.println(Thread.currentThread().getName()+"\t"+number);
		//3 通知
		this.notifyAll();
	}
	
	public synchronized void decrement() throws InterruptedException{
		//1 判断
		//if(number == 0)
		while(number == 0){
			this.wait();
		}
		//2 干活
		--number;
		System.out.println(Thread.currentThread().getName()+"\t"+number);
		//3 通知
		this.notifyAll();
	}	
}
