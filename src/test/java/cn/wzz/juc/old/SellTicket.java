package cn.wzz.juc.old;

/**旧的(继承的方法创建一个线程)	
 * 		run()不是开启线程的方法，start()才是
 */
public class SellTicket {
	public static void main(String[] args) {
		Ticket t1 = new Ticket();
		//t1.run();
		t1.start();
		Ticket t2 = new Ticket();
		//t2.run();
		t2.start();
		Ticket t3 = new Ticket();
		//t3.run();
		t3.start();
	}
}

class Ticket extends Thread {
	//定义100张票
	private static int ticket = 100;
	
	public void run() {
		while(true){
		synchronized(Ticket.class) {
			if(ticket > 0){
				try {
					Thread.sleep(100);			//模拟网络延迟，会出现多线程安全问题！！！！！
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println(this.getName() +"卖出了第"+ (ticket--) +"号的票");
			}
		}
		}
	};
}
