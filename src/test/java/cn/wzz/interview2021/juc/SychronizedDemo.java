package cn.wzz.interview2021.juc;

/**
 * Description:
 *  可重入锁(也叫做递归锁)
 *  指的是同一线程外层函数获得锁后,内层递归函数任然能获取该锁的代码
 *  在同一线程外外层方法获取锁的时候,在进入内层方法会自动获取锁
 *  也就是说,线程可以进入任何一个它已经标记的锁所同步的代码块
 *  **/
public class SychronizedDemo {
    Object object=new Object();

    public static void main(String[] args) {
        /**
         * 同步方法块测试
         */
//        new SychronizedDemo().sychronizedMethod();

        /**
         * 同步方法测试
         */
        new SychronizedDemo().m1();
    }

    public void sychronizedMethod(){
        new Thread(()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"\t"+"外层....");
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"\t"+"中层....");
                    synchronized (object){
                        System.out.println(Thread.currentThread().getName()+"\t"+"内层....");
                    }
                }
            }
        },"A").start();
    }


    public synchronized void m1(){
        System.out.println("外层....");
        m2();
    }
    public synchronized void m2(){
        System.out.println("中层....");
        m3();
    }
    public synchronized void m3(){
        System.out.println("内层....");
    }

}
