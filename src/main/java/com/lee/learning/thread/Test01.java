package com.lee.learning.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author libin
 * @date 2020-11-23 22:08
 */
public class Test01 {
    private static volatile int a = 1;

    /**
     * 创建两个线程，a线程打印1-10，b线程进行监听，当发现a线程打印到5时候，b线程输出监听到的信息
     * @param args
     */
    public static void main(String[] args) {
        final  Object object = new Object();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                1,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(1024),
                new ThreadPoolExecutor.AbortPolicy()
                );
        /**
         * 先启动线程2再启动线程1，notify并未释放锁，因此需要在线程1中进行wait操作释放锁
         */
        threadPoolExecutor.execute(()->{
            synchronized (object) {

                if(a != 5){
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("a已经变成5了");
                object.notify();
            }
        });

        //创建打印0-9的线程
        threadPoolExecutor.execute(()->{
            synchronized (object){
                for(int i = 0;i <= 9; i++){
                    System.out.println(a);
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                    a++;
                    if(a==5){
                        object.notify();
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });



        threadPoolExecutor.shutdown();

    }
}
