package com.fosuchao.enterprise.bytedance.type.linkedlist;

import com.fosuchao.enterprise.bytedance.Utils;
import com.fosuchao.datastructure.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/reverse-nodes-in-k-group/  K 个一组翻转链表
 *
 * @author: Joker Ye
 * @create: 2020/7/4 20:08
 */
public class ReverseKGroup {

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
        Utils.printLinkedList(reverseKGroup(listNode1, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        ListNode dummy = new ListNode(1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        // 1 2 3 4 5 6 7 8
        // start = dummy  end = 3
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            ListNode next = end.next;
            end.next = null;

            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = next;

            end = start;
            pre = start;
        }

        return dummy.next;
    }

    private static ListNode reverse(ListNode node) {
        ListNode pre = null, curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
