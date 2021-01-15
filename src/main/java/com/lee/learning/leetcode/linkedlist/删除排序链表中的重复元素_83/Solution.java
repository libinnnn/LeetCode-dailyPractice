package com.lee.learning.leetcode.linkedlist.删除排序链表中的重复元素_83;

/**
 * @author libin
 * @date 2021-01-15 17:01
 */
public class Solution {
    public static  ListNode deleteDuplicates(ListNode head) {
        if(head == null){  // 空指针直接返回
            return null;
        }
        ListNode prev = head;
        ListNode p = head.next;
        if(p == null){
            return head; // 只有一个节点，就直接返回当前链表
        }
        while (p != null){
            if(p.val != prev.val){
                prev = p;
                p = p.next;
            } else {
                prev.next = p.next;
                p = p.next;
            }
        }
        return  head;
    }

    public static void main(String[] args) {
        ListNode x1 = new ListNode(1);
        ListNode x2 = new ListNode(1);
        ListNode x3 = new ListNode(3);
        x1.next = x2;
        x2.next = x3;
        deleteDuplicates(x1);
    }
}
