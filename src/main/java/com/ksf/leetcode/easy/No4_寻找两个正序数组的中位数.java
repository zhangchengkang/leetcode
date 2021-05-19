package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2021/5/17 16:36
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 */
public class No4_寻找两个正序数组的中位数 {

    /**
     * 二分法 -- 求第K小的数
     * <p>
     * 数组A B 长度之和/2=K
     * 如果A[K/2]<B[K/2] 抛弃A[0]~A[K/2]的元素
     * 因为数组是有序的 但凡A[K/2]<B[K/2]  A[0]~A[K/2]都小于 B[K/2]
     * 这样每次都能抛弃K/2个元素  然后 K = K - K/2  直到K为1
     */
    public static double solution1(int[] nums1, int[] nums2) {
        //求出两个数组的总长度
        int total = nums1.length + nums2.length;
        //如果是偶数数，则求出中间两个数的平均数
        if ((total & 1) == 0) {
            int left = find(nums1, 0, nums2, 0, total / 2);
            int right = find(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;    //求平均数，注意要除2.0，否则会下取整
        }
        //如果是奇数，则直接返回中位数
        return find(nums1, 0, nums2, 0, total / 2 + 1);
    }

    /**
     * 参数: nums1, nums2: 两个数组
     * i, j分别为抛弃元素后nums1, nums2的起始位置
     * k为要求的第K小的数
     **/
    private static int find(int[] nums1, int i, int[] nums2, int j, int k) {
        //为了方便，我们使nums1的长度小于nums2的长度
        if (nums1.length - i > nums2.length - j) {
            return find(nums2, j, nums1, i, k);
        }
        //如果nums1的起始位置已经与其长度相等，则nums1中的数已经用光了，返回nums2中第K小的数
        if (nums1.length == i) {
            return nums2[j + k - 1];
        }
        //如果k等于1，则相当与求出两个数组中的最小值，直接返回nums1[i], nums2[j]中较小的一个
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        //si表示我们上面所说的A[K/2]后面的那个数的下标。
        //为了防止数组长度小于 k/2,将num1和k/2作比较，取其中的小的(如果取大的，数组就会越界)
        int si = Math.min(nums1.length, i + k / 2);
        //sj与si表示的含义相同，表示B[K/2]后面的那个数的下标
        //这里使用sj = j + k - k / 2是为了保证以该点为分界线的数组的前半部分的总长与A数组中前半部分的总长度的和为k。
        //因为如果k是奇数，如果si,sj都使用k/2，则导致总数比k少1
        int sj = j + k - k / 2;

        //判断A[K/2] B[K/2]大小 抛弃k/2个元素然后递归
        if (nums1[si - 1] > nums2[sj - 1]) {
            //由于去除了从j 到 sj 之间的数，所以原本的第K小的数在新数组中为第k - (sj - j)小的数
            return find(nums1, i, nums2, sj, k - (sj - j));
        }
        else {
            return find(nums1, si, nums2, j, k - (si - i));
        }

    }
}
