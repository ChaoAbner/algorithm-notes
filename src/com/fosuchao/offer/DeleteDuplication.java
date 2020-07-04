package com.fosuchao.offer;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/2/12 19:46
 */
public class DeleteDuplication {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        ListNode listNode8 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode8;
        listNode8.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        ListNode listNode = new DeleteDuplication().deleteDuplication(listNode1);
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null)
            return null;
        ListNode last = pHead;
        ListNode cur = last.next;

        while (cur != null) {
            if (last.val == cur.val) {
                // 相同节点，cur后移，直到不相等
                cur = cur.next;
            } else if (last.next.val != cur.val){
                last.next = cur;
                last = last.next;
                cur = cur.next;
            } else {
                last = last.next;
                cur = cur.next;
            }
        }
        return pHead;
    }
}
