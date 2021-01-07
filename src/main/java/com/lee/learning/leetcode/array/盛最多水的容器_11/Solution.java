package com.lee.learning.leetcode.array.盛最多水的容器_11;

/**
 * 双指针法，从左右两端开始移动，判断左右的值，较小的一端移动
 * 保证一定能遍历到最小在于移动的过程中实在不断地对最小值进行消除
 * @author libin
 * @date 2021-01-07 15:47
 */
public class Solution {
    public static  int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = (right-left) * Math.min(height[left], height[right]);

        while(left != right){
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
            maxArea = Math.max(maxArea, (right-left) * Math.min(height[left], height[right]));
        }

        return maxArea;
    }


    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int test = maxArea(height);
        System.out.println(test);
    }
}
