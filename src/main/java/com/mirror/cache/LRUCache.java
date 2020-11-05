package com.mirror.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mirrordingjing @ 2020/9/18
 */
public class LRUCache {

    private Map<Integer,Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(){}
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.capacity=capacity;
    }

    public int get(int key) {
        Node node=map.get(key);
        if(node==null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node=map.get(key);
        if(node==null){
            node=new Node(key,value);
            if(map.size()>=this.capacity){
                map.remove(tail.key);
                removeLast();
            }
        }else{
            node.value=value;
        }
        moveToHead(node);
        map.put(key,node);
    }

    public void moveToHead(Node node){
        //是否已经是头节点
        if(node==head) return;
        //双向链表是否为空
        if(head==null||tail==null){
            head=node;
            tail=node;
            return;
        }
        //是否为尾节点，是的话更新尾节点
        if(node==tail){
            tail=node.prev;
            tail.next=null;
            //是否为链表中已有节点（注意此时链表中一定有超过两个节点，否则node==tail且node.prev==null）
        }else if(node.prev!=null){
            node.prev.next=node.next;
            //无需此判断一定为非空 因为node不是尾节点
            // if(node.next!=null){
            node.next.prev=node.prev;
            // }
        }
        node.prev=null;
        node.next=head;
        head.prev=node;
        head=node;
    }

    public void removeLast(){

        tail=tail.prev;
        if(tail==null){
            head=null;
        }else{
            tail.next=null;
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
