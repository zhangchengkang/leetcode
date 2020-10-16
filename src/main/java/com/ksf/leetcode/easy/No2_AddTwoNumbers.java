package com.ksf.leetcode.easy;

/**
 * @Author: zhangchengkang
 * @Date: 2020/10/10 16:12
 */

import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class No2_AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;

        System.out.println(solution1(l1, l4));
    }

    /**
     * 假设两个链表相应位置的数字为 n1,n2，进位值为 carry，则它们的和为 sum=n1+n2+carry
     * 所以返回链表值为sum%10,carry为sum/10
     * <p>
     * 处理边界问题及链表指针问题
     */
    public static ListNode solution1(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            carry = sum / 10;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }

}
