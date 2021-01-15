package com.lee.learning.leetcode.linkedlist.删除排序链表中的重复元素II_82;

/**
 * 主要是需要使用next来进行判断，判断当前双指针的下一个节点
 * @author libin
 * @date 2021-01-15 17:36
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }
        if(head.val == head.next.val){
            while (head.next != null &&head.val == head.next.val){
                head = head.next;
            }
            head = head.next;
        }
        if(head == null){
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode a = result;
        a.next = head;
        ListNode b = head;
        while (b!= null && b.next !=null){ // 因为有用到next，因此当前节点是否为空需要记得判断
            if(a.next.val != b.next.val){
                a = a.next;
                b = b.next;
            } else {
                while (b != null && b.next != null && a.next.val == b.next.val){
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }

        }
        return result.next;
    }
}
