package com.fosuchao.random;

/**
 * @Description: �������
 * @Auther: Joker Ye
 * @Date: 2019/11/15 21:46
 */


public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
//        l6.next = l4;
        l5.next = l6;
        l4.next = l3;
        l2.next = l4;
        ListNode listNode = addTwoNumbers(l2, l5);
        while (listNode.next != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

class ListNode{
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
