package com.ksf.leetcode.sort;

import java.util.Arrays;

/**
 * @Author: zhangchengkang
 * @Date: 2021/12/29 17:34
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 2, 7, 1};
        bubbleSort(array);

        for (int value : array) {
            System.out.println(value);
        }
    }

    /**
     * O(n^2)
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int length = array.length;
        if (length <= 1) {
            return;
        }

        for (int i = 0; i < length; i++) {
            boolean flag = false;

            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }
    }
}
