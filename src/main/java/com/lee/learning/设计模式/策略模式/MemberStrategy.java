package com.lee.learning.设计模式.策略模式;

/**
 * @author libin
 * @date 2021-02-02 15:47
 */
public interface MemberStrategy {
    /**
     * 折扣计算策略
     * @param bookPrice
     * @return
     */
    public double callPrice(double bookPrice);
}
