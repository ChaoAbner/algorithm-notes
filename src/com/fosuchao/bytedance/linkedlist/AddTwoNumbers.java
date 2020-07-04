package com.fosuchao.bytedance.linkedlist;

import com.fosuchao.bytedance.Utils;
import com.fosuchao.bytedance.datastructure.ListNode;

/**
 * @description: https://leetcode-cn.com/problems/sum-lists-lcci/   链表求和
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * 示例：
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * @author: Joker Ye
 * @create: 2020/7/4 21:22
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(7);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        Utils.printLinkedList(listNode1);
        Utils.printLinkedList(listNode4);
        Utils.printLinkedList(addTwoNumbers(listNode1, listNode4));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        int carry = 0;
        ListNode newHead = new ListNode(0);
        ListNode tmp = newHead;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            tmp.next = node;
            tmp = tmp.next;
        }

        return newHead.next;
    }
}
