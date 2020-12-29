package com.fosuchao.enterprise.bytedance.type.linkedlist;

import com.fosuchao.enterprise.bytedance.Utils;
import com.fosuchao.datastructure.ListNode;

/**
 * @description: 反转从位置 m 到 n 的链表。
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 思路：先m次循环找到需要反转的链表的起点
 * 利用头插法，逐个反转节点
 * @author: Joker Ye
 * @create: 2020/7/4 19:08
 */
public class ReverseBetweenLinkedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        Utils.printLinkedList(listNode1);
        reverseBetween(listNode1, 2, 5);
        Utils.printLinkedList(listNode1);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode newHead = new ListNode(1);
        newHead.next = head;

        ListNode guard = newHead;
        ListNode point = newHead.next;
        int step = 1;

        while (step < m) {
            guard = guard.next;
            point = point.next;
            step++;
        }

        // 1 2 3 4 5   m = 2 n = 4
        // guard = 1   point = 2

        for (int i = 0; i < n - m; i++) {
            ListNode next = point.next;
            point.next = next.next;

            next.next = guard.next;
            guard.next = next;
        }

        return newHead.next;
    }
}
