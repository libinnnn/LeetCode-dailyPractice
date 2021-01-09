package com.lee.learning.leetcode.dynamicPlanning.无重复字符的最长子串_3;

import org.apache.logging.log4j.util.Strings;

/**
 * 动态规划解法，但是会出现运行时间超出限制，无法ac
 * @author libin
 * @date 2021-01-08 19:51
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length <= 1){
            return length;
        }
        boolean[][] dp = new boolean[length][length];
        int maxLength = 0;

        dp[0][0] = true;

        for(int j=1; j<length; j++){
            for(int i = 0; i <= j; i++){
                if(i == j){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = dp[i][j-1] && !s.substring(i, j).contains(""+s.charAt(j));
                    System.out.println(i + " " + j + "" + dp[i][j]);
                }
                if(dp[i][j]){
                    maxLength  = Math.max(maxLength, j-i+1);
                }
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        String s = "";
        s.substring(0,2);
        System.out.println(s.substring(0,2));

        lengthOfLongestSubstring(s);
    }
}
