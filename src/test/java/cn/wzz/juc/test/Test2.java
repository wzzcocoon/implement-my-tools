package cn.wzz.juc.test;

/**两个线程，一个打印数字，一打印字符*/
public class Test2 {
	public static void main(String[] args) {
//		char b = 'a';
//		System.out.println((char)(b+1));
		Sharedate sharedate = new Sharedate();
		new Thread(() -> {
			for(int i=0;i<10;i++) {
				try {
					sharedate.printNum();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}, "线程1").start();
		new Thread(() -> {
			for(int i=0;i<10;i++) {
				try {
					sharedate.printEng();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}, "线程2").start();
	}
}

class Sharedate{
	private int a = 1;
	private char b = 'a';
	private boolean flag = true;
	
	public synchronized void printNum() throws InterruptedException {
		//判断
		if(!flag) {
			this.wait();
		}
		System.out.println(Thread.currentThread().getName() +"\t"+ (a++));
		flag = false;
		// 通知
		this.notifyAll();
	}
	public synchronized void printEng() throws InterruptedException {
		//判断
		if(flag) {
			this.wait();
		}
		System.out.println(Thread.currentThread().getName() +"\t"+ (char)(b++));
		flag = true;
		// 通知
		this.notifyAll();
	}
}
