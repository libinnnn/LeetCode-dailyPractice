package com.lee.learning.leetcode.dynamicPlanning.买卖股票的最佳时机_121;

/**
 * @author libin
 * @date 2021-01-02 17:26
 */

/**
 * 记录股票的最低点，然后不断寻找高点，更新当前股票的最大收益值
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MIN_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;

    }
}
