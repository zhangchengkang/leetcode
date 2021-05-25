package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2021/5/19 16:36
 */

/**
 *  给你一个整数，将其转为罗马数字
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。
 * 12 写做 XII ，即为 X + II 。
 * 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 */
public class No12_整数转罗马数字 {

    /**
     * 贪心算法
     *
     * 现实中每一个「阿拉伯数字」固定对应一个「罗马数字」，不存在说一个「阿拉伯数字」能够对应出一个较长或者较短的「罗马数字」。
     * 因此这是一个按照固定规则进行转换的「模拟」过程。
     * 根据题意，我们可以列举出有限个罗马字符和其对应的数值。
     * 然后从左到右构建罗马数字，优先构建数值高的罗马字符（如果有足够的分值，尽量尝试构建 "M"，直到分值不够，再尽量尝试构建 "CM" ... ）
     */
    public String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中，并且按照阿拉伯数字的大小降序排列
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            while (num >= nums[index]) {
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Integer c = Integer.valueOf(128);
        Integer d = Integer.valueOf(128);
        System.out.println(c.equals(d));
    }





}
