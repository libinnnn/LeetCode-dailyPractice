package com.lee.learning.leetcode.other.LRU实现_146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author libin
 * @date 2021-01-14 17:27
 */
public class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int _key, int _value){
            this.key = _key;
            this.value = _value;
        }

    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size =  0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        // 虚拟节点，头尾指针，自身不携带数据
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){ // 节点不存在，则新建放入，并将当前节点插入链表头，同时更新哈希表
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if(size > capacity){ // 判断是否达到最大容量，是的话则需要将尾部的数据移除，同时更新哈希表
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else { // 节点以存在，则只需要将该节点移动到链表头，并更新数据即可
            node.value = value;
            moveToHead(node);
        }
    }

    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    // 原子操作，加入链表头
    public void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 原子操作，移除节点元素
    public void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public DLinkedNode removeTail(){
        DLinkedNode prev = tail.prev;
        removeNode(prev);
        return  prev;
    }

}
