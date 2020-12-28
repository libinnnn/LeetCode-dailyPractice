package com.lee.learning.leetcode.array.合并两个有序数组;

/**
 * @author libin
 * @date 2020-12-28 22:43
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (n >= 0){ // 是nums1先判断，作为最后进行处理的序列
            while (m >= 0 && nums2[n] < nums1[m]){ // 因为是nums作为最后的序列判断，那么此时应该先判断nums2
                int indexM = m--;
                int indexI = i--;
                int tmp = nums1[indexM];
                nums1[indexM] = nums1[indexI];
                nums1[indexI] = tmp;
            }

            // 全部处理完成后处理nums1序列
            int indexM = i--;
            int indexN = n--;
            int tmp = nums2[indexN];
            nums2[indexN] = nums1[indexM];
            nums1[indexM] = tmp;

        }
    }

}
