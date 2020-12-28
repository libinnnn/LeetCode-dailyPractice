package com.lee.learning.leetcode.stack.用两个栈实现队列_09;

import java.util.LinkedList;

/**
 * @author libin
 * @date 2020-12-28 21:47
 */
class CQueue {
    private LinkedList<Integer> a,b;

    public CQueue() {
        a = new LinkedList<Integer>();
        b = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        a.add(value);
    }

    public int deleteHead() {
        if(!b.isEmpty()){
            return b.removeLast(); // b队列用于出队
        }

        if(a.isEmpty()){
            return -1; // 此时a,b为空，则返回-1
        }

        while (!a.isEmpty()){
            b.add(a.removeLast()); // 将a栈的内容出栈压入b中
        }
        return b.removeLast();
    }
}