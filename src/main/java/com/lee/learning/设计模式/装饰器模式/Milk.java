package com.lee.learning.设计模式.装饰器模式;

/**
 * @author libin
 * @date 2021-02-02 20:25
 */
public class Milk implements Water {
    @Override
    public void drink() {
        System.out.println("喝牛奶");
    }
}
