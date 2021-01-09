package com.lee.learning.leetcode.递归回溯.电话号码的字母组合_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author libin
 * @date 2021-01-09 21:33
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        if(digits.length() == 0){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        dfs(digits, 0, result, new StringBuffer(), map);

        return result;
    }

    public void dfs(String digists, int index, List<String> result, StringBuffer tmp, HashMap<Character, String> map){
        int length = digists.length();
        if(index == length){ // 如果判断到了字符串尾部，则进行add操作
            result.add(tmp.toString());
        } else {
            char digit = digists.charAt(index);
            String letters = map.get(digit);

            for(int i = 0; i < letters.length(); i++){
                tmp.append(letters.charAt(i));
                dfs(digists, index+1, result, tmp, map);
                tmp.deleteCharAt(index); // 由于循环，所以需要删除上一个尝试的结果
            }
        }

    }
}
