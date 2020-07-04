package com.fosuchao.offer;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/2/13 14:41
 */
public class FindKthToTail {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5= new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode kthToTail = new FindKthToTail().findKthToTail(listNode, 1);
        while (kthToTail != null) {
            System.out.print(kthToTail.val);
            kthToTail = kthToTail.next;
        }
    }

    public ListNode findKthToTail(ListNode head,int k) {
        // 思路1、先求出链表的总长度，在进行遍历求出结果
        if (head == null || head.next == null)
            return head;
        if (k < 1)
            return null;
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < length - k; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
