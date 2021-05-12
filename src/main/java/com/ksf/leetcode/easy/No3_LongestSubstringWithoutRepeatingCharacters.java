package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2020/10/16 16:29
 */

/**
 * 给定一个字符串，找到没有重复字符的最长子串，返回它的长度。
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 */
public class No3_LongestSubstringWithoutRepeatingCharacters {


    public static int solution1(String s) {
        StringBuilder target = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            if (target.toString().contains(substring)) {
                return target.length();
            }
            target.append(substring);
        }
        return 0;
    }
}
