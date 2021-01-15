package com.lee.learning.leetcode.other.最后一个单词的长度_58;

/**
 * @author libin
 * @date 2021-01-14 19:39
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] result = s.split(" ");
        if(result.length == 0){
            return 0;
        }
        int length = result.length;
        return result[length-1].length();
    }
}
