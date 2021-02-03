package com.lee.learning.设计模式.适配器模式;

/**
 * @author libin
 * @date 2021-02-02 21:50
 */
public class OpticalAdapter implements Motor {
    private  OpticalMotor opticalMotor;

    public OpticalAdapter(){
        this.opticalMotor = new OpticalMotor();
    }

    @Override
    public void driver() {
        this.opticalMotor.opticalDrive();
    }
}
