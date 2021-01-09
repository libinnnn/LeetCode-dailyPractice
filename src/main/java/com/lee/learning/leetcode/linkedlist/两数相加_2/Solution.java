package com.lee.learning.leetcode.linkedlist.两数相加_2;

/**
 * @author libin
 * @date 2021-01-08 17:10
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode head = null; // 指向头指针
        int carry = 0;
        while (l1 != null || l2 != null){

            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            int sum = n1 + n2 + carry;
            carry = sum / 10; // 进位
            ListNode newNode = new ListNode(sum % 10);
            if(result == null){ // 判断是否为第一次插入
                head = result = newNode;
            } else {
                result.next = newNode;
                result = newNode;
            }

            if(l1 != null){  // 不为空则指针下移
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }


        }

        if(carry > 0){
            result.next = new ListNode(carry); // 最后还需要判断进位值，是否需要继续插入节点
        }

        return head;
    }
}
