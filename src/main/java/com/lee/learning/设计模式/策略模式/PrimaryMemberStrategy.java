package com.lee.learning.设计模式.策略模式;

/**
 * @author libin
 * @date 2021-02-02 15:50
 */
public class PrimaryMemberStrategy implements MemberStrategy {
    @Override
    public double callPrice(double bookPrice) {
        System.out.println("初级会员不享受折扣");
        return  bookPrice;
    }
}
