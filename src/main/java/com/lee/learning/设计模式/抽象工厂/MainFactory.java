package com.lee.learning.设计模式.抽象工厂;

/**
 * @author libin
 * @date 2021-02-02 17:08
 */
public class MainFactory {
    public static void main(String[] args) {
        // 创建中国工厂
        ChinaFruitFactory chinaFruitFactory = new ChinaFruitFactory();
        // 通过中国工厂生产中国苹果
        Fruit chinaApple = chinaFruitFactory.getApple();
        chinaApple.get();
    }
}
