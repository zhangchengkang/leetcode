package com.ksf.leetcode.easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangchengkang
 * @Date: 2020/10/10 16:47
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
