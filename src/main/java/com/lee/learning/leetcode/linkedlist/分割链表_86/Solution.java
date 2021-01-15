package com.lee.learning.leetcode.linkedlist.分割链表_86;

/**
 * @author libin
 * @date 2021-01-15 14:12
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0);
        ListNode small = smaller; // 指向当前小元素的头结点
        ListNode bigger = new ListNode(0);
        ListNode big = bigger; // 指向当前大元素的头结点
        while (head != null){
            if(head.val <= x){
                smaller.next = head;
                smaller = head;
            } else{
                bigger.next = head;
                bigger = head;
            }
            head = head.next;
        }

        smaller.next = big.next;
        bigger.next = null;
        return small.next;
    }
}
