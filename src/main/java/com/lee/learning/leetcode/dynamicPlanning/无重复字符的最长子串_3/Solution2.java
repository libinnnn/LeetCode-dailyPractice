package com.lee.learning.leetcode.dynamicPlanning.无重复字符的最长子串_3;

import java.util.HashMap;

/**
 * @author libin
 * @date 2021-01-08 20:48
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        for(int begin = 0, end = 0 ; end < length; end ++){
            if(map.containsKey(s.charAt(end))){
                begin = Math.max(map.get(s.charAt(end)), begin);  // 滑动窗口内的才需要更新
            }
            result = Math.max(result, end-begin+1); // 更新最大长度

            map.put(s.charAt(end), end+1); // end+1指向的是更新之后的后一个位置

        }

        return result;
    }
}
