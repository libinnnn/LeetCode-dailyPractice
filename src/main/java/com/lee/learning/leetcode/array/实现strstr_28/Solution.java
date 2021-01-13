package com.lee.learning.leetcode.array.实现strstr_28;

/**
 * 考虑KMP算法
 * @author libin
 * @date 2021-01-13 21:33
 */
public class Solution {
    public static  int strStr(String haystack, String needle) {
        int first = -1;
        int match = 0;
        if(needle.length() == 0){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(match)){
                if(match == 0){
                    first = i;
                }
                if(match == needle.length()-1){
                    return  first;
                } else {
                    match++;
                }

            } else{
                first = -1;
                match = 0;

            }


        }

        return first;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }
}
