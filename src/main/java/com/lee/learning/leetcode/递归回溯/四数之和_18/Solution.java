package com.lee.learning.leetcode.递归回溯.四数之和_18;

import java.util.*;

/**
 * 未通过，超出了时间限制，还需要再进一步进行剪枝，但是最优解主要还是通过dp来实现的
 * @author libin
 * @date 2021-01-12 17:17
 */
public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>  result = new ArrayList<>();
        Arrays.sort(nums);
        Deque<Integer> tmp = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(result, tmp, 0, nums, 0, target, used);
        return result;
    }

    public static  void dfs(List<List<Integer>>  result, Deque<Integer> tmp, int index, int[] nums, int count, int target, boolean[] used){
        if(count == 4 && target == 0){
            result.add(new ArrayList<>(tmp));
            return;
        }

        if(count > 4 || index >= nums.length){
            return;
        }

        for(int i = index; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            tmp.addLast(nums[i]);
            used[i] = true;
            dfs(result, tmp, i+1, nums, count+1, target-nums[i], used);
            used[i] = false;
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int taeget = 0;
        System.out.println(fourSum(nums, taeget));
    }
}
