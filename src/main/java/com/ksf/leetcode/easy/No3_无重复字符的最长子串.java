package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2020/10/16 16:29
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串，找到没有重复字符的最长子串，返回它的长度。
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 */
public class No3_无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(solution1("abaacd"));
    }

    /**
     * example:abcadbcbb
     * <p>
     * 假定滑动窗口左下标为left=0,最大子串长度为max
     * 遍历字符(i++),不断更新max=i-left+1
     * 遇到相同的字符更新left=重复字符(第一个)的下一个字符
     * <p>
     * 所以需要搞个map,key为字符,value为i,用来判断重复字符
     */
    public static int solution1(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
