package com.lee.learning.leetcode.递归回溯.全排列II_42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author libin
 * @date 2021-01-10 11:47
 */
public class Solution {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); //排序是剪枝的前提
        boolean[] used = new boolean[nums.length];

        dfs(nums, 0, result, new ArrayList<Integer>(), used);

        return result;
    }

    public static void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> tmp1, boolean[] used){
        List<Integer> tmp = new ArrayList<>(tmp1);
        if(index == nums.length){ // 递归结束条件
            result.add(tmp);
        } else {
            for(int i = 0; i < nums.length; i++){
                if(used[i]){
                    continue;
                }
                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){ // 剪枝判断，i>0保证i-1不小于0，判断前后用于去重，！used[i-1]判断前一个数是否被使用过，使用过则剪枝
                    continue;
                }
                tmp.add(nums[i]);
                used[i] = true; // 标注当前节点已使用
                dfs(nums, index+1, result, tmp, used); // 前后代码对称
                used[i] = false; // 进行下一个节点的判断，当前节点尝试匹配结束，置为false
                tmp.remove(index);

            }

        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(permuteUnique(nums));
    }
}

