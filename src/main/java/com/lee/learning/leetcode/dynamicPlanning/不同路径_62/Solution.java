package com.lee.learning.leetcode.dynamicPlanning.不同路径_62;

/**
 * @author libin
 * @date 2021-01-02 16:29
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m+1][n+1];
        // 初始化数组
        for(int i = 0; i <= m; i++){
            path[i][0] = 0;
        }
        for(int i = 0; i <= n; i++){
            path[0][i] = 0;
        }
        path[1][1] = 1;

        for(int j = 1; j <= m; j++){
            for(int k = 1; k <= n; k++){
                if(j == 1 && k== 1){
                    continue;
                }
                path[j][k] = path[j-1][k] + path[j][k-1]; // 转移方程式
            }
        }

        return path[m][n];

    }
}
