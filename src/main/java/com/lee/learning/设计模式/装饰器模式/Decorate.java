package com.lee.learning.设计模式.装饰器模式;

/**
 * @author libin
 * @date 2021-02-02 20:26
 */
public class Decorate implements Water {
    private  Water water;

    public  Decorate(Water water){
        this.water = water;
    }

    @Override
    public void drink() {
        System.out.println("加点糖");
        this.water.drink();
    }
}
