package com.lee.learning.leetcode.递归回溯.子集_78;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author libin
 * @date 2021-01-10 22:39
 */
public class Solution {
    public static  List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> tmp =  new ArrayDeque<>();
        dfs(result, tmp, 0, nums);

        return result;
    }

    public static  void dfs(List<List<Integer>> result, Deque<Integer> tmp, int index, int[] nums){
        result.add(new ArrayList<>(tmp));
        for(int i = index; i < nums.length; i++){ // 当不需要进行返回查找匹配时候，都应该从index开始继续往下匹配搜索
            tmp.addLast(nums[i]);
            dfs(result, tmp, i+1, nums); // index应该为当前搜索到的i的下一位继续进入下一层进行搜索
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        System.out.println(subsets(test));
    }
}
