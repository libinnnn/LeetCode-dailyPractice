package com.lee.learning.设计模式.单例模式;

/**
 * @author libin
 * @date 2021-02-02 19:52
 */
public class Singleton {
    private static  volatile Singleton singleton = null;
    private Singleton(){ }

    public static  Singleton getInstance(){
        // 提升效率，发现不为空则可以直接返回
        if(singleton == null){
            synchronized(Singleton.class){
                // 可重入锁进入之后，防止再次new对象
                if(singleton == null){
                    // volatile防止指令重排
                    singleton = new Singleton();
                }
            }
        }
        return singleton;

    }
}
