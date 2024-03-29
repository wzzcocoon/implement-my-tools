package cn.wzz.juc.newthread4;

/**
 * Executor的使用
 */
public class ExecutorUseImpl {
	/**
	 *    线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学
	 * 更加明确线程池的运行规则，规避资源耗尽的风险。
	 *    说明：Executor各个方法的弊端：
	 *    1）newFixedThreadPool 和 newSingleThreadExecutor :
	 *    	主要问题是堆积的请求处理队列可能会损耗非常大的内存,甚至OOM
	 *    2）newCachedTreadPool 和 newScheduledTheadPool :
	 *   	主要问题是线程数最大数是Integer.MAX_VALUE,可能会创建数量非常多的线程，甚至OOM
	 */
	
	/*Positive example 1:
	 
	// org.apache.commons.lang3.concurrent.BasicThreadFactory
	
	ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
        	new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
	 */
	
	
	/* Positive example 2:
	 
	// com.google.guava
	
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();
        // Common Thread Pool    
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
		pool.execute(() -> {System.out.println(Thread.currentThread().getName())})
		pool.shutdown();  //gracefully shutdown
	 */
	
	/* Positive example 2:
	  	
	  	<!-- 创建线程池 -->
	    <bean id="userThreadPool" 
	    	class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
	        <property name="corePoolSize" value="10" />
	        <property name="maxPoolSize" value="100" />
	        <property name="queueCapacity" value="2000" />

		 	<property name="threadFactory" value="threadFactory"/>
	        <property name="rejectedExecutionHandler">
	        	<ref local="rejectedExecutionHandler">
	        </property>
		</bean>
	 	// in code
	 	 userThreadPool.execute(thread);
	 */
}
