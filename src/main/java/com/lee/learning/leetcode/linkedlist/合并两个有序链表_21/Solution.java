package com.lee.learning.leetcode.linkedlist.合并两个有序链表_21;

import com.lee.learning.leetcode.linkedlist.合并两个有序链表_21.ListNode;

/**
 * @author libin
 * @date 2021-01-07 14:07
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); // 创建一个新的链表
        ListNode res = head; // 该节点用于始终指向头结点的

        ListNode p = l1;
        ListNode q = l2;
        while(p != null && q != null){ // 循环判断两个链表中的值的大小
             if(p.val <= q.val){
                 head.next = p;
                 head = p;
                 p = p.next;
             } else {
                 head.next = q;
                 head = q;
                 q = q.next;
             }
        }
        // 结束时判断哪个链表仍然为走完，则继续将后续节点挂上
        if(q == null){
            while(p != null){
                head.next = p;
                head = p;
                p = p.next;
            }
        }else if(p == null){
            while(q != null){
                head.next = q;
                head = q;
                q = q.next;
            }
        }

        return res.next; // 由于第一个节点指向的是空节点，因此我们返回的时候需要往下再移动一个节点
    }
}
