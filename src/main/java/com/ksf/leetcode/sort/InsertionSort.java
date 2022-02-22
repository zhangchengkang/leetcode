package com.ksf.leetcode.sort;

/**
 * @Author: zhangchengkang
 * @Date: 2021/12/30 17:53
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 2, 7, 1};
        insertionSort(array);

        for (int value : array) {
            System.out.println(value);
        }
    }

    /**
     * O(n^2)
     * 虽然时间复杂度一样  但是交换次数要比冒泡排序少
     * @param array
     */
    public static void insertionSort(int[] array) {
        int length = array.length;
        if (length <= 1) {
            return;
        }

        for (int i = 1; i < length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }
}
