package com.lee.learning.leetcode.array.删除排序数组中的重复项_26;

/**
 * @author libin
 * @date 2021-01-13 20:54
 */
public class Solution {
    public static  int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int p = 1;
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] != nums[i-1]){
                nums[p++] = nums[i];
            }

        }

        return p;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        System.out.println(removeDuplicates(test));
        for(int i: test){
            System.out.println(i);
        }

    }
}
