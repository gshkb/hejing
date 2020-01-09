package cn.gshkb.data_structure.linked;

import java.util.*;

/**
 * 设计双向链表
 *
 * @author hkb
 * @create 2019-07-11 15:32 v1.0
 **/
public class MyLinkedList {

    private int size;
    private ListNode first;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode node = node(index);
        if (node == null) {
            return -1;
        }
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        // 如果index为负数，插入到头部？！
        // if (index == 0) {
        if (index <= 0) {
            first = new ListNode(val, first);
        } else {
            ListNode prev = node(index - 1);
            if (prev == null) {
                return;
            }
            prev.next = new ListNode(val, prev.next);
        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (rangeCheck(index) == false) {
            return;
        }
        if (index == 0) {
            first = first.next;
        } else {
            ListNode prev = node(index - 1);
            if (prev == null) {
                return;
            }
            prev.next = prev.next.next;
        }
        size--;
    }

    /**
     * 根据索引查找对应节点
     */
    private ListNode node(int index) {
        if (rangeCheck(index) == false) {
            return null;
        }
        ListNode node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private boolean rangeCheck(int index) {
        return !(index < 0 || index > (size - 1));
    }

    /**
     * ListNode 节点
     */
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this(val);
            this.next = next;
        }
    }

}

