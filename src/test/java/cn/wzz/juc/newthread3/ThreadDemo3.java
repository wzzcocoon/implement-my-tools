package cn.wzz.juc.newthread3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**在主线程中需要执行比较耗时的操作时，但又不想阻塞主线程时，可以把这些作业交给Future对象在后台完成，
当主线程将来需要时，就可以通过Future对象获得后台作业的计算结果或者执行状态。

一般FutureTask多用于耗时的计算，主线程可以在完成自己的任务后，再去获取结果。

仅在计算完成时才能检索结果；如果计算尚未完成，则阻塞 get 方法。一旦计算完成，
就不能再重新开始或取消计算。get方法而获取结果只有在计算完成时获取，否则会一直阻塞直到任务转入完成状态，
然后会返回结果或者抛出异常。 

只计算一次
get方法放到最后*/
public class ThreadDemo3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> ft = new FutureTask<Integer>(new MyThread());
		/**
		 * Callable接口只计算一次，后面可以反复的利用
		 */
		new Thread(ft, "AA").start();
		new Thread(ft, "BB").start();
		
		System.out.println(Thread.currentThread().getName() + "\t 主线程");
		
		/**
		 * 将get放到最后使用
		 */
		Integer result = ft.get();
		System.out.println("***result ： " + result);
	}

}
