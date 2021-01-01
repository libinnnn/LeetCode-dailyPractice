package com.lee.learning.leetcode.dynamicPlanning.爬楼梯_70;

/**
 * @author libin
 * @date 2021-01-01 23:13
 */


// 基于排列组合情况，2，2，1和2，1，2是有区别的
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 2; j++){
                if(j > i){ // 不能大于，否则会出现数组越界的情况
                    continue;
                }
                dp[i] += dp[i-j];
            }
        }

        return dp[n];
    }
}
