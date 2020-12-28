package com.lee.learning.leetcode.array.数组中第K大元素;

/**
 * @author libin
 * @date 2020-12-28 20:41
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int result = nums[0];
        int count = 0;
        for(int i=1; i < nums.length; i++){
            if(nums[i] > result && count < k){
                count++;
                result = nums[i];
            }
        }
        return 0;
    }
}
