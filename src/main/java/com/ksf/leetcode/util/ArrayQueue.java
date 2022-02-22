package com.ksf.leetcode.util;

/**
 * @Author: zhangchengkang
 * @Date: 2021/12/29 15:16
 */
public class ArrayQueue {

    private String[] items;
    private int count;
    private int length;

    public ArrayQueue(int n) {
        this.items = new String[n];
        this.count = n;
        this.length = n;
    }

    public boolean push(String item) {
        if (count == length) {
            return false;
        }

        items[count] = item;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }

        String temp = items[0];
        for (int i = count; i > 0; i--) {
            items[i] = items[i - 1];
        }

        return temp;
    }
}
