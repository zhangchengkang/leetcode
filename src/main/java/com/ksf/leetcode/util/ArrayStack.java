package com.ksf.leetcode.util;

/**
 * @Author: zhangchengkang
 * @Date: 2021/12/29 14:19
 */
public class ArrayStack {
    //数组
    private String[] items;
    //栈元素个数
    private int count;
    //栈长度
    private int length;

    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.length = n;
    }

    public boolean push(String item) {
        if (count == length) {
            //扩容
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

        String temp = items[count - 1];
        count--;
        return temp;
    }

}
