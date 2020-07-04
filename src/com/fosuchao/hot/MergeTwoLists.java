package com.fosuchao.hot;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/27 14:26
 * @noinspection Duplicates
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        listNode.next = listNode3;
        listNode3.next = listNode5;
        listNode5.next = listNode7;
        listNode2.next = listNode4;
        listNode4.next = listNode6;
        listNode6.next = listNode8;

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        mergeTwoLists.mergeTwoLists(listNode, listNode2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
