package com.ksf.leetcode.easy;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 输入: "()"
 * 输出: true
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 输入: "(]"
 * 输出: false
 * <p>
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(solution("[]"));
    }

    /**
     * 时间复杂度：O(n)，其中 n 是字符串 s 的长度。
     */
    public static boolean solution(String str) {
        int length = str.length();
        if (length % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

}
