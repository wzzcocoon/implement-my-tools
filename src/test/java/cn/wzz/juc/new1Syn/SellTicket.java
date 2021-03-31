package cn.wzz.juc.new1Syn;

/**资源类*/
class Ticket{
	private static int ticket = 100;
	public synchronized void sell(){
		if(ticket > 0){
			System.out.println(Thread.currentThread().getName() + "卖出了第" + (ticket--) +"张票。");
		}
	}
}

/**多线程编写（上）
 * 		线程    操作    资源类
 * 		高内聚    低耦合
 */
public class SellTicket {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 1; i <=40; i++) {
					ticket.sell();
				}
			}
		},"线程1").start();
		new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 1; i <=40; i++) {
					ticket.sell();
				}
			}
		},"线程2").start();
		new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 1; i <=40; i++) {
					ticket.sell();
				}
			}
		},"线程3").start();
	}
}


