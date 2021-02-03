package com.lee.learning.设计模式.策略模式;

/**
 * @author libin
 * @date 2021-02-02 15:54
 */
public class Price {
    /**
     * 私有策略对象
     */
    private  MemberStrategy memberStrategy;

    /**
     * 传入具体的策略对象
     * @param memberStrategy
     */
    public Price(MemberStrategy memberStrategy){
        this.memberStrategy = memberStrategy;
    }

    /**
     * 加个计算
     * @param bookPrice
     * @return
     */
    public double quote(double bookPrice){
        return this.memberStrategy.callPrice(bookPrice);
    }
}
