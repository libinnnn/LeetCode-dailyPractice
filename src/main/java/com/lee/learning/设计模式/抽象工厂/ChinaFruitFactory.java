package com.lee.learning.设计模式.抽象工厂;

/**
 * @author libin
 * @date 2021-02-02 17:07
 */
public class ChinaFruitFactory implements FruitFactory {
    @Override
    public Fruit getApple() {
        return new ChinaApple();
    }

    @Override
    public Fruit getbanana() {
        return null;
    }
}
