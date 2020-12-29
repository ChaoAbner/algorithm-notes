package com.fosuchao.enterprise.bytedance.enterprise;

import com.fosuchao.datastructure.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 19. 删除链表的倒数第N个节点
 */

public class Num19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;

        while (fast != null && n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode next = slow.next;
        slow.next = slow.next.next;
        next.next = null;
        return head;
    }
}
