package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2021/5/18 17:30
 */

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 输入：x = 123
 * 输出：321
 * <p>
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 输入：x = 120
 * 输出：21
 */
public class No7_整数反转 {

    public static void main(String[] args) {
        System.out.println(solution2(2147483647));
    }

    public static int solution1(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(x));

        try {
            int result = Integer.parseInt(sb.reverse().toString());
            return x > 0 ? result : -result;
        } catch (NumberFormatException ignored) {
        }

        return 0;
    }

    /**
     * x%10 得到的就是最后一位
     * int最大2147483647
     */
    public static int solution2(int x) {
        int res = 0;
        while (x != 0) {
            int last = x % 10;

            //判断是否 大于 最大32位整数
            if (res > 214748364 || (res == 214748364 && last > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && last < -8)) {
                return 0;
            }

            res = res * 10 + last;
            x /= 10;
        }

        return res;
    }
}
