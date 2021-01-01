package com.lee.learning.leetcode.dynamicPlanning.零钱兑换II_518;

/**
 * @author libin
 * 341`@date 2020-12-29 23:16
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1]; // 下标问题
        dp[0] = 1; // 0元的时候，方法有一种

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) { // 从大于等于coin开始，因为如果小于该币种不会造成影响
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];


    }

}
