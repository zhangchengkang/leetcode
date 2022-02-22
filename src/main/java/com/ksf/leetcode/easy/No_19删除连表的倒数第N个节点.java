package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2021/6/29 17:35
 */

import com.ksf.leetcode.util.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class No_19删除连表的倒数第N个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return new ListNode();
        }
        return null;
    }
}
