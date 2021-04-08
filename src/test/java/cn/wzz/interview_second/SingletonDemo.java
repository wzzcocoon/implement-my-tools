package cn.wzz.interview_second;

public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName() + "线程：SingletonDemo初始化");
    }

    public static SingletonDemo getInstance(){
        if(instance == null){
            instance = new SingletonDemo();
        }
        return instance;
    }

    //可以用synchronized解决，但它属重量级同步机制，使用时慎重。
    public static synchronized SingletonDemo getSynchronizedInstance(){
        if(instance == null){
            instance = new SingletonDemo();
        }
        return instance;
    }

    /**
     DCL（Double Check Lock双端检锁机制）,加锁前后都进行判空
     DCL不一定线程安全，因为有指令重排序的存在，加入Volatile可防止指令重排
     原因在于某一个线程执行到第一次检测，读取到的instance不为null时，instance的引用对象可能没有完成初始化。instance = new SingletonDemo();可以分为以下3步完成(伪代码)：
         memory = allocate(); //1.分配对象内存空间
         instance(memory); //2.初始化对象
         instance = memory; //3.设置instance指向刚分配的内存地址，此时instance != null
     步骤2、3不存在依赖关系，所有指令重排后运行顺序是 1、3、2。所以当一条线程访问instance不为null时，由于instance实例未必已初始化完成，也就造成了线程安全问题。
     所以要加volatile关键字
     private static volatile SingletonDemo instance = null;
     */
    public static SingletonDemo getDCLInstance() {
        if(instance == null) {
            synchronized(SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }



    public static void main(String[] args) {
        // 单线程（main线程的操作）
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());


        /**
         * 多线程的情况下，会出现多个SingletonDemo对象
         */
//        for(int i=1; i<=10; i++){
//            new Thread(()->{
//                SingletonDemo instance = SingletonDemo.getInstance();
//            },String.valueOf(i)).start();
//        }

//        for(int i=1; i<=10; i++){
//            new Thread(()->{
//                SingletonDemo instance = SingletonDemo.getSynchronizedInstance();
//            },String.valueOf(i)).start();
//        }

        for(int i=1; i<=10; i++){
            new Thread(()->{
                SingletonDemo instance = SingletonDemo.getDCLInstance();
            },String.valueOf(i)).start();
        }

    }

}
