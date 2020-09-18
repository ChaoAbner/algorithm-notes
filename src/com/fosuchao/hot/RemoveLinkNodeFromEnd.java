package com.fosuchao.hot;


import javax.sound.midi.Soundbank;
import java.sql.BatchUpdateException;
import java.util.List;

/**
 * @Description: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @Auther: Joker Ye
 * @Date: 2020/1/3 22:25
 * @noinspection Duplicates, ResultOfMethodCallIgnored
 */
public class RemoveLinkNodeFromEnd {


    public static void main(String[] args) {
        ListNode head = init();
//        ListNode listNode = removeNthFromEnd(head, 2);
        ListNode listNode = removeNthFromEnd1(head, 2);
        printListNode(listNode);
//        int listNodeLength = getListNodeLength(head);
//        System.out.println(listNodeLength);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 单指针
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        // 双指针法
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // 让first指针先向后移动，让两个指针保持n的距离
        for(int i = 0; i < n + 1; i++){
            first = first.next;
        }

        // 两个指针一起向后移动，直到first等于null
        while (first != null){
            first = first.next;
            second = second.next;
        }
        // 最后让second的next = second.next.next
        second.next = second.next.next;
        return dummy.next;
    }


    public static int getListNodeLength(ListNode head){
        int count = 1;
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void printListNode(ListNode listNode){
        while (listNode != null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }



    public static ListNode init(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        return listNode1;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}