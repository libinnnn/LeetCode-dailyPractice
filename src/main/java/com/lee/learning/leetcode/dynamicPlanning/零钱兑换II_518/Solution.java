package com.lee.learning.leetcode.dynamicPlanning.零钱兑换II_518;

/**
 * @author libin
 * 341`@date 2020-12-29 23:16
 */

/**
 * problem(k,i) = problem(k-1, i) + problem(k, i-k)
 *
 * 即前k个硬币凑齐金额i的组合数等于前k-1个硬币凑齐金额i的组合数加上在原来i-k的基础上使用硬币的组合数。说的更加直白一点，那就是用前k的硬币凑齐金额i，要分为两种情况开率，一种是没有用前k-1个硬币就凑齐了，一种是前面已经凑到了i-k，现在就差第k个硬币了。
 *
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
