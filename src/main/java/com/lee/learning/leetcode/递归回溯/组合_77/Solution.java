package com.lee.learning.leetcode.递归回溯.组合_77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author libin
 * @date 2021-01-15 11:45
 */
public class Solution {
    public static  List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> tmp = new ArrayDeque<>();
        dfs(result, tmp, 1, n, k);
        return result;
    }

    public static  void dfs(List<List<Integer>> result, Deque<Integer> tmp, int index, int n, int k){
        if(tmp.size() == k){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = index; i <= n; i++){
            tmp.addLast(i);
            dfs(result, tmp, i+1, n, k);
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}
