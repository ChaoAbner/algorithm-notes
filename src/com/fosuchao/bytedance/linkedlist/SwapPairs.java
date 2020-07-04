package com.fosuchao.bytedance.linkedlist;

import com.fosuchao.bytedance.Utils;
import com.fosuchao.bytedance.datastructure.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/swap-nodes-in-pairs/ 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author: Joker Ye
 * @create: 2020/7/4 19:56
 */
public class SwapPairs {

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
        ListNode listNode = swapPairs(listNode1);
        Utils.printLinkedList(listNode);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(1);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;

            first.next = second.next;
            second.next = first;
            curr.next = second;

            curr = first;
        }

        return dummy.next;
    }
}
