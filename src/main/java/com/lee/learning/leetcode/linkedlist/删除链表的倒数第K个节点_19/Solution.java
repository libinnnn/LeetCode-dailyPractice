package com.lee.learning.leetcode.linkedlist.删除链表的倒数第K个节点_19;




/**
 * 双指针法解决
 * @author libin
 * @date 2021-01-07 14:46
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode concurrnet = head; // 当前移动指针
        ListNode afterN = head; // 执行倒数第k个之前的指针
        while (concurrnet != null){
            if(count > n){
                afterN = afterN.next;
            }
            concurrnet = concurrnet.next;
            count++;
        }
        if(count == n){ // 距离第k个恰好是头结点的情况
            head = head.next;
        } else {
            afterN.next = afterN.next.next;
        }

        return head;
    }
}
