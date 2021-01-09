package com.lee.learning.leetcode.递归回溯.组合总数_39;

import java.util.ArrayList;
import java.util.List;

/**
 * 针对该问题，通过递归的方式去进行验证，找到递归的终止条件
 * @author libin
 * @date 2021-01-07 16:55
 */
public class Solution {
    public  static  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        isCom(candidates, target, list, 0, result);
        return result;
    }

    static  void isCom(int[] candidates, int target, List<Integer> tmp1, int index, List<List<Integer>> result){
        List<Integer> tmp = new ArrayList<>(tmp1); // 需要将list复制到另外一个list中，否则对该list的修改都会作用于传递进来的list中
        if(target == 0){ // 为空情况，代表此时能凑整，因此可以将list加入最后的结果集中
            result.add(tmp);
            return;
        } else if(target < 0){ // 小于0的情况代表此时无法凑整，因此抛弃
            return;
        } else{
            for(int i = index; i<candidates.length; i++){ // 这里考虑到硬币是可以重复选择的，因此要从index开始
                tmp.add(candidates[i]);
                isCom(candidates, target-candidates[i], tmp, i, result);
                tmp.remove(tmp.size()-1); // 此时需要把之前增加的节点删除了才行，否则会影响后续tmp列表的计数
            }
        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> test = combinationSum(candidates, target);
        System.out.println(test);
    }
}
