package com.fosuchao.bytedance.enterprise;


import com.fosuchao.bytedance.datastructure.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 148. 排序链表
 */

public class Num148 {

    public static void main(String[] args) {


    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 拿到中间节点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        // 断开
        slow.next = null;
        // 递归拆分
        ListNode left = sortList(head);
        ListNode right = sortList(temp);

        ListNode p = new ListNode(-1);
        ListNode res = p;
        // 归并
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left != null ? left : right;
        // 返回排序好的头节点
        return res.next;
    }
}
