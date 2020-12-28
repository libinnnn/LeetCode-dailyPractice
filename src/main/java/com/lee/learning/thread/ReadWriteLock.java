package com.lee.learning.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author libin
 * @date 2020-11-25 17:37
 */
public class ReadWriteLock {
    private  final  static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                1,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(1024),
                new ThreadPoolExecutor.AbortPolicy()
        );

        threadPoolExecutor.execute(()->{
            try{
                reentrantReadWriteLock.readLock().lock();
                for (int i=0;i<10; i++){
                    System.out.println("线程1打印："+ i);
                    Thread.sleep(20);
                }
                reentrantReadWriteLock.readLock().unlock();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        threadPoolExecutor.execute(()->{
            try{
                reentrantReadWriteLock.readLock().lock();
                for (int i=0;i<10; i++){
                    System.out.println("线程2打印："+ i);
                    Thread.sleep(20);
                }
                reentrantReadWriteLock.readLock().unlock();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        threadPoolExecutor.execute(()->{
            try{
                reentrantReadWriteLock.writeLock().lock();
                for (int i=0;i<10; i++){
                    System.out.println("线程3写锁打印："+ i);
                    Thread.sleep(20);
                }
                reentrantReadWriteLock.writeLock().unlock();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        threadPoolExecutor.shutdown();
    }
}
