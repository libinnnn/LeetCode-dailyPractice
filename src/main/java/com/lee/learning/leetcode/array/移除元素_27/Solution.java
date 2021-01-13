package com.lee.learning.leetcode.array.移除元素_27;

/**
 * @author libin
 * @date 2021-01-13 21:18
 */
public class Solution {
    public static  int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0;i < nums.length; i++){
            nums[i-count] = nums[i];
            if(nums[i] == val){
                count++;
            }

        }

        return nums.length-count;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3,2,2,3};
        int result = removeElement(test, 3);
        System.out.println(result);
        for(int i = 0; i < result; i++){
            System.out.println(test[i]);
        }
    }
}
