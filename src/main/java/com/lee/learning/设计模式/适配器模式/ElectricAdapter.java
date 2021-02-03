package com.lee.learning.设计模式.适配器模式;

/**
 * @author libin
 * @date 2021-02-02 21:48
 */
public class ElectricAdapter implements Motor {
    // 主要是实现同一个Motor接口，然后在构造函数中初始话该对象，然后在实现函数中调用对象的对应方法
    private ElectricMotor electricMotor;

    public ElectricAdapter(){
        this.electricMotor = new ElectricMotor();
    }

    @Override
    public void driver() {
        this.electricMotor.electricDrive();
    }
}
