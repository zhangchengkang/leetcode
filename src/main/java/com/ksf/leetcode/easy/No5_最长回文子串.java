package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2021/5/17 17:36
 */

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 */
public class No5_最长回文子串 {

    public static void main(String[] args) {
        System.out.println(solution1("babad"));
    }

    /**
     * 暴力解法
     * 时间复杂度：两层 for 循环 O(n²），for循环里边判断是否为回文 O(n），所以时间复杂度为 O(n³）O(n³）。
     * 空间复杂度：O(1）O(1），常数个变量。
     */
    public static String solution1(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = ans.length();
                }
            }
        return ans;
    }

    private static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 中心扩散法
     * 时间复杂度：O(n²） 空间复杂度：O(1）。
     * 遍历字符 每次选择一个中心 进行左右扩散  判断左右字符是否相等即可
     * 由于字符长度可能为偶数  我们需要从一个字符或者从两个字符中间扩散  所以总共有n+n-1个中心
     */
    public static String solution2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (left >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
