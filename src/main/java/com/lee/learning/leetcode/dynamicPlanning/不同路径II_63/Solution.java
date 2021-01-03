package com.lee.learning.leetcode.dynamicPlanning.不同路径II_63;

/**
 * @author libin
 * @date 2021-01-03 17:44
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //行数
        int r = obstacleGrid.length;
        //列数
        int c = obstacleGrid[0].length;
        //如果开始位置就是障碍物，则直接结束，返回0
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        //如果开始位置不是障碍物，则该格子路径数量为1
        obstacleGrid[0][0] = 1;

        // 这里确定0行0列的目的主要是边界条件
        // 确定第一行格子路径数量
        for (int i = 1; i < r; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        //确定第一列格子路径数量
        for (int i = 1; i < c; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                //如果当前格子不是障碍物，则路过它的有效路径数量为上面格子路径数量 + 坐便格子路径数量
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[r - 1][c - 1];
    }
}
