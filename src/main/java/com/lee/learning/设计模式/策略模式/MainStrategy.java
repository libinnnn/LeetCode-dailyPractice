package com.lee.learning.设计模式.策略模式;

/**
 * @author libin
 * @date 2021-02-02 16:09
 */
public class MainStrategy {
    public static void main(String[] args) {
        // 创建策略
        MemberStrategy strategy = new PrimaryMemberStrategy();
        // 创建环境
        Price price = new Price(strategy);
        // 计算价格
        double quote = price.quote(300);
        System.out.println("普通会员折扣计算后为：" + quote);
    }
}
