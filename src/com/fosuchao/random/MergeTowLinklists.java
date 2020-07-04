package com.fosuchao.random;

/**
 * @Description: �ϲ������������� https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *  �����ⷨ��https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/hua-jie-suan-fa-21-he-bing-liang-ge-you-xu-lian-bi/
 * @Auther: Joker Ye
 * @Date: 2019/11/24 11:36
 */
public class MergeTowLinklists {
    public static void main(String[] args) {
        ListNode1 listNode1 = new ListNode1(1);
        ListNode1 listNode2 = new ListNode1(2);
        ListNode1 listNode3 = new ListNode1(4);
        ListNode1 listNode4 = new ListNode1(1);
        ListNode1 listNode5 = new ListNode1(3);
        ListNode1 listNode6 = new ListNode1(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode1 listNode = mergeTwoLists(listNode1, listNode4);
        while (listNode.next != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }

//    public static ListNode1 mergeTwoLists(ListNode1 l1, ListNode1 l2) {
//        ListNode1 prehead = new ListNode1(-1);
//
//        ListNode1 prev = prehead;
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                prev.next = l1;
//                l1 = l1.next;
//            } else {
//                prev.next = l2;
//                l2 = l2.next;
//            }
//            prev = prev.next;
//        }
//        prev.next = l1 == null ? l2 : l1;
//
//        return prehead.next;
//    }

    public static ListNode1 mergeTwoLists(ListNode1 l1, ListNode1 l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
    }
}
