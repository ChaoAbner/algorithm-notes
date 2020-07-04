package com.fosuchao.offer;


/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/27 13:57
 */
public class MergeTwoSortList {

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

        MergeTwoSortList mergeTwoSortList = new MergeTwoSortList();
        ListNode merge = mergeTwoSortList.merge(listNode, listNode2);

        mergeTwoSortList.printList(merge);
    }

    public ListNode merge(ListNode node1, ListNode node2){
        ListNode newNode = new ListNode(-1);
        backTrack(newNode, node1, node2);

        return newNode.next;
    }

    public void printList(ListNode node){
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public ListNode backTrack(ListNode newNode, ListNode node1, ListNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;

        if(node1.val > node2.val){
            newNode.next = node2;
            node2 = node2.next;
            newNode.next.next = null;
        } else {
            newNode.next = node1;
            node1 = node1.next;
            newNode.next.next = null;
        }

        backTrack(newNode.next, node1, node2);

        return newNode.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}