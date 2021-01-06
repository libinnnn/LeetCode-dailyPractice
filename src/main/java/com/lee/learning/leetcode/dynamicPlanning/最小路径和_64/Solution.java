package com.lee.learning.leetcode.dynamicPlanning.最小路径和_64;

/**
 * @author libin
 * @date 2021-01-06 22:07
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i-1 == 0){ // 如果碰到左边界条件，则直接和上一个元素相加
                    dp[i][j] = dp[i][j-1]+grid[i-1][j-1];
                }else if(j-1 == 0){ // 如果碰到上边界条件，则直接和左元素相加
                    dp[i][j] = dp[i-1][j]+grid[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j]+grid[i-1][j-1], dp[i][j-1]+grid[i-1][j-1]); // 状态转移方程
                }

            }
        }

        return dp[n][m];
    }
}
