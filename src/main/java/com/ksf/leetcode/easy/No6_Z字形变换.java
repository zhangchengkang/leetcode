package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2021/5/18 16:31
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class No6_Z字形变换 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    /**
     * 搞numRows个StringBuild的list-->rows
     * 遍历str,按1234(最大numRows)从小到大顺序获取rows[i]去append(char)
     * 如果碰到numRows第一行/最后一行 调头反向执行
     */
    public static String convert(String str, int numRows) {
        if (numRows < 2) {
            return str;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        int flag = -1;
        for (char c : str.toCharArray()) {
            rows.get(curRow).append(c);
            //碰到第一行和最后一行调头拼接
            if (curRow == 0 || curRow == numRows - 1) {
                flag = -flag;
            }
            curRow += flag;
        }

        StringBuilder res = new StringBuilder();
        rows.forEach(res::append);
        return res.toString();
    }
}
