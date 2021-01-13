package com.lee.learning.leetcode.linkedlist.两两交换链表中的节点_24;

/**
 * 递归思路最简单
 * @author libin
 * @date 2021-01-13 17:37
 */
public class Solution {
    public static  ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){ // 终止条件
            return head;
        }
        ListNode next = head.next; // 获取当前节点的下一个节点
        head.next = swapPairs(next.next); // 递归调用
        next.next = head; // 当前节点的下一个节点指向当前节点
        return next;
    }

    public static void main(String[] args) {
        ListNode node1  = new ListNode(1);
        ListNode node2  = new ListNode(2);
        ListNode node3  = new ListNode(3);
        ListNode node4  = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

//        swapPairs(node1);
//        System.out.println(swapPairs(node1));

        ListNode test = swapPairs(node1);
        while (test != null){
            System.out.println(test.val);
            test = test.next;
        }
    }
}
