package com.lee.learning.leetcode.dynamicPlanning.零钱兑换_322;

import java.util.Arrays;

/**
 * @author libin
 * @date 2021-01-03 16:25
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;  //最大不会超过这个值
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) { // 先遍历总金额，可以类比爬楼梯
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); // 状态转移方程，取决于前面几个最小的一个
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
