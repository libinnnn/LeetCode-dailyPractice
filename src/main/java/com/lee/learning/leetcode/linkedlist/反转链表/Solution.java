package com.lee.learning.leetcode.linkedlist.反转链表;

/**
 * @author libin
 * @date 2020-12-27 21:30
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // 反转链表的头结点
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; // 下一个操作节点
            curr.next = prev; // 当前节点的下一个节点指向头结点
            prev = curr; // 头结点指向当前节点
            curr = nextTemp; // 当前节点后移
        }
        return prev;
    }
}
