package com.lee.learning.设计模式.适配器模式;

/**
 * @author libin
 * @date 2021-02-02 21:51
 */
public class MainAdapter {
    public static void main(String[] args) {

        Motor motor = new ElectricAdapter();
        motor.driver();
    }
}
