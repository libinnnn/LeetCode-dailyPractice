package com.lee.learning.设计模式.装饰器模式;

/**
 * @author libin
 * @date 2021-02-02 20:28
 */
public class MainDecorate {
    public static void main(String[] args) {
        Water water = new Milk();
        Decorate decorate = new Decorate(water);
        decorate.drink();
    }
}
