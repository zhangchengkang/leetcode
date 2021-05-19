package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2021/5/18 18:08
 */
public class No9_回文数 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(21123));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String str = String.valueOf(x);
        int size = str.length() / 2;
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
