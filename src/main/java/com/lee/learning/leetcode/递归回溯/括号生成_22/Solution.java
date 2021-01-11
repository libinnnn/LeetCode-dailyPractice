package com.lee.learning.leetcode.递归回溯.括号生成_22;

import java.util.*;

/**
 * @author libin
 * @date 2021-01-11 17:18
 */
public class Solution {
    public static  List<String> generateParenthesis(int n) {
        // 生成括号
        List<String> result = new ArrayList<>();
        Deque<String> tmp = new ArrayDeque<>();
        dfs(result, n, tmp, 0, 0, "(", 0);
        return  result;
    }

    /**
     *
     * @param result
     * @param n
     * @param tmp
     * @param left 用于计数左括号值
     * @param right 计数右括号值
     * @param s 下一个准备插入的字符
     * @param match 匹配数，因为左括号个数始终需要大于等于右括号，因此该值小于0的时候需要剪枝
     */
    public static  void dfs(List<String> result, int n, Deque<String> tmp, int left, int right, String s, int match){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "(");
        map.put(1, ")");
        if(s.equals("(")){
            match++; // 左括号增加
            left++; // 左括号计数
        }else{
            right++; // 右括号数增加
            match--; // 消左括号 好像这里可以直接比较左右计数大小来判断就可以了
        }
        if(left > n || right > n || match < 0){ // 剪枝
            return;
        }
        for(int i = 0; i < 2; i++){
            tmp.addLast(s);
            if(left + right == 2*n){ // 当满足以上条件，便可生成正确结果
                result.add(listToString(tmp));
                tmp.removeLast(); // for循环中，还是需要删除该结果的，避免影响下一次的计算
                return;
            }
            dfs(result, n, tmp, left, right, map.get(i), match);
            tmp.removeLast(); // 对称操作
        }
    }

    public static  String listToString(Deque<String> tmp){
        String s = "";
        for(String index: tmp){
            s = s + index;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
