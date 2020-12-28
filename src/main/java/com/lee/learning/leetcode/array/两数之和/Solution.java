package com.lee.learning.leetcode.array.两数之和;

import java.util.HashMap;

/**
 * @author libin
 * @date 2020-12-27 22:19
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap();
        for(int i = 0; i<nums.length; i++){
            int getNum = target - nums[i];
            if(map.containsKey(getNum)){ // 利用key值判断可以很快地找到当前元素是否在这个查询集合内，因此只需要o(1）复杂度
                return new int[]{i, (int)map.get(getNum)};
            } else {
                map.put(nums[i], i); // map主要用来记录对应的值和数组元素位置的映射关系
            }
        }

        return  new int[]{};
    }
}
