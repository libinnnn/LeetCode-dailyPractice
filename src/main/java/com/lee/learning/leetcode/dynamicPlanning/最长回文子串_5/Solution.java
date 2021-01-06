package com.lee.learning.leetcode.dynamicPlanning.最长回文子串_5;

/**
 * @author libin
 * @date 2021-01-06 19:39
 */
public class Solution {
    public static  String longestPalindrome(String s) {
        int n =s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";

        for(int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                if(i == j){ // 边界条件，指的是同一个元素，这时候为true
                    dp[i][j] = true;
                }else if(i + 1 == j && s.charAt(i) == s.charAt(j)){ // 边界条件，左右两个元素判断
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j)); // 状态迁移方程
                }

                if(dp[i][j]){ // 最终都要进行字符串的截取，判断大小进行返回
                    if(j - i + 1 > ans.length()){
                        ans = s.substring(i, j+1);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "cbbd";
//        System.out.println(s.substring(0,3));
        System.out.println(longestPalindrome(s));
    }
}
