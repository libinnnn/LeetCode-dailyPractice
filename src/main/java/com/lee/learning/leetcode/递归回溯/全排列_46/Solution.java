package com.lee.learning.leetcode.递归回溯.全排列_46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 递归回溯，类型题同一套路解法
 * @author libin
 * @date 2021-01-09 23:07
 */
public class Solution {
    public static  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<Integer>());

        return result;
    }

    public static void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> tmp1){
        List<Integer> tmp = new ArrayList<>(tmp1);
        if(index == nums.length){
            result.add(tmp);
        } else {
            for(int i = 0; i < nums.length; i++){
                if(!tmp.contains(nums[i])){ // 当列表中包含该数字时，则退出当前的递归，因为全排列不能出现重复的情况
                    tmp.add(nums[i]);
                    dfs(nums, index+1, result, tmp);
                    tmp.remove(index);
                } else{
                    continue;
                }


            }

        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }
}
