package cn.wzz.juc.newthread4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**第4种获得多线程的方式 -- 线程池
 * ExecutorService对象	submit(callable)
 * ExecutorService对象 	schedule(callable, delay, unit)
 */
public class ExecutorsDemo {
	public static void main(String[] args) {
		//带时间调度的ExecutorService(间隔delay的unit单位的时间的调用一个链接)
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		ScheduledFuture<Integer> result = null;
		try {
			for (int i = 1; i <=15; i++) {
				result = service.schedule(() -> {
					System.out.print(Thread.currentThread().getName());
					return new Random().nextInt(10);
				}, 2, TimeUnit.SECONDS);
				System.out.println("  ********result: "+result.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}		
	}

	private static void testThreadPool() {
		//ExecutorService service = Executors.newFixedThreadPool(5);//一池5线程
		//ExecutorService service = Executors.newSingleThreadExecutor();//一池1线程
		ExecutorService service = Executors.newCachedThreadPool();//一池N线程
		
		Future<Integer> result = null;
		try {
			for (int i = 1; i < 15; i++) {
				result = service.submit(() -> {
					System.out.print(Thread.currentThread().getName());
					return new Random().nextInt(10);
				});
				System.out.println("  ********result: "+result.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
	}
}
