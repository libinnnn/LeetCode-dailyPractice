package com.lee.learning.leetcode.递归回溯.组合总数II_40;

import java.util.*;

/**
 * @author libin
 * @date 2021-01-10 14:43
 */
public class Solution {
    public static  List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> tmp = new ArrayDeque<>();  // 好用的队列，比列表表示简单多了
        Arrays.sort(candidates);
        dfs(result, tmp, 0, target, candidates);
        return result;
    }

    public static  void dfs(List<List<Integer>> result, Deque<Integer> tmp, int index, int sum, int[] candidates){
        if(sum == 0){
            result.add(new ArrayList<>(tmp));
            return;
        }  else {
            for(int i = index; i < candidates.length; i++){
                if(sum - candidates[i] < 0){ // 剪枝，小于零之后无需继续递归下去
                    break;
                }
                if(i > index && candidates[i] == candidates[i-1]){ // 剪枝，判断同一层值不相等，i>index目的是保留同层的第一个节点
                    continue;
                }
                tmp.addLast(candidates[i]);
                dfs(result, tmp, i+1, sum-candidates[i], candidates);
                tmp.removeLast();

            }
        }

    }

    public static void main(String[] args) {
        int[] test = new int[]{10,1,2,7,6,1,5,8};
//        int[] test = new int[]{2,2,1,2,5};
        int traget = 8;
        System.out.println(combinationSum2(test, traget));
    }
}
