package com.lee.learning.设计模式.策略模式;

/**
 * @author libin
 * @date 2021-02-02 15:52
 */
public class AdvanceMemberStrategy implements MemberStrategy {
    @Override
    public double callPrice(double bookPrice) {
        System.out.println("高级会员享受八折");
        return bookPrice * 0.8;
    }
}
