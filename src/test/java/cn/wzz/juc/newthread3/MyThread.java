package cn.wzz.juc.newthread3;

import java.util.concurrent.Callable;

/** 第三种实现多线程的方法： 实现Callable接口
 * 			FutureTask(Callable )实现了Runnable接口(有适配器的功能)
 */
public class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("****开启线程");
		return 1;
	}

}
