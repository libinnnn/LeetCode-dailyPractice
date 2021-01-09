package com.lee.learning.leetcode.array.三数之和_15;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author libin
 * @date 2021-01-09 17:28
 */
public class threeSum {
    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) { // 大于0没有判断的必要
                return lists;
            }

            if(i > 0 && nums[i] == nums[i-1]){ // 枚举的时候也需要判断前后，但是这时候往后判断，代表之前已经扫过了
                continue;
            }

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L; // 避免出现移动之后数字还是相同的情况
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L; // 最后还是需要再进行前移的，因为判断的时候是向前判断的了L+1，所以即使+1之后，之前的还是指向了重复的数据
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-2,0,0,2,2};
        System.out.println(threeSum(test));
    }
}
