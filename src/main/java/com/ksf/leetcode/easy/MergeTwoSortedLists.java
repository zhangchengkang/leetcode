package com.ksf.leetcode.easy;


import com.ksf.leetcode.util.ListNode;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    /**
     * 时间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。
     * 因为每次调用递归都会去掉 l1 或者 l2 的头节点（直到至少有一个链表为空），
     * 函数  至多只会递归调用每个节点一次。因此，时间复杂度取决于合并后的链表长度，即 O(n+m)。
     * <p>
     * 空间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。
     * 递归调用函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。
     * 结束递归调用时函数最多调用 n+m 次，因此空间复杂度为 O(n+m)。
     */
    public static ListNode solution1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = solution1(list1.next, list2);
            return list1;
        } else {
            list2.next = solution1(list1, list2.next);
            return list2;
        }
    }
}
