package com.lee.learning.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author libin
 * @date 2020-12-07 12:49
 */
public class CountDown {



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                1,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(1024),
                new ThreadPoolExecutor.AbortPolicy()
        );

        CalculateTask calculateTask1 = new CalculateTask(new Integer(10), countDownLatch);
        CalculateTask calculateTask2 = new CalculateTask(new Integer(20), countDownLatch);

        Future<Integer> future1 = threadPoolExecutor.submit(calculateTask1);
        Future<Integer> future2 = threadPoolExecutor.submit(calculateTask2);



        try{
            countDownLatch.await();
            Integer result = future1.get() + future2.get();
            System.out.println("计算和为：" + result.toString());
        }catch (Exception e){
            e.printStackTrace();
        }


        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();

        HashMap hashMap = new HashMap();
        hashMap.put("a", "a");

        reentrantLock.wait();
        Object object = new Object();
        object.notify();
        object.toString();
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "aaa");

        Map map111 = new ConcurrentHashMap();
        map111.put("1", "1");




//        Future<String> future1 = threadPoolExecutor.submit(new Callable<String>() {
//            public String call() throws Exception {
//                System.out.println("子线程："+Thread.currentThread().getName()+"执行");
//                countDownLatch.countDown();
//                Thread.sleep(3000);
//                return "1";
//            }
//        });
//
//        Future<String> future2 = threadPoolExecutor.submit(new Callable<String>() {
//            public String call() throws Exception {
//                System.out.println("子线程："+Thread.currentThread().getName()+"执行");
//                Thread.sleep(3000);
//                countDownLatch.countDown();
//                return "2";
//            }
//        });
//
//        String result1 = future1.get();
//        String result2 = future2.get();
//
//        System.out.println("等待两个线程执行完毕");
//        try {
//            countDownLatch.await();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//        System.out.println(result1);
//        System.out.println(result2);


//        threadPoolExecutor.execute(()->{
//            try {
//                Thread.sleep(3000);
//                System.out.println("子线程："+Thread.currentThread().getName()+"执行");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            countDownLatch.countDown();
//        });
//
//        threadPoolExecutor.execute(()->{
//            try {
//                Thread.sleep(3000);
//                System.out.println("子线程："+Thread.currentThread().getName()+"执行");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            countDownLatch.countDown();
//        });
//
//        System.out.println("等待两个线程执行完毕");
//        try {
//            countDownLatch.await();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("两个子线程都执行完毕，继续执行主线程");

        threadPoolExecutor.shutdown();


    }
}
