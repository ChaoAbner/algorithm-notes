package com.fosuchao.exercise;

import org.junit.Test;

/**
 * @Description: 反转单向链表
 * 给定一个单链表的头节点 head,实现一个调整单链表的函数，
 * 使得每K个节点之间为一组进行逆序，并且从链表的尾部开始组起，头部剩余节点数量不够一组的不需要逆序。（不能使用队列或者栈作为辅助）
 * 例如：链表:1->2->3->4->5->6->7->8->null, K = 3。那么 6->7->8，3->4->5，1->2各位一组。
 * 调整后：1->2->5->4->3->8->7->6->null。其中 1，2不调整，因为不够一组。
 * @Auther: Joker Ye
 * @Date: 2020/1/3 11:28
 */
public class ReverseLinklist {

    public static void main(String[] args) {
        LinkNode head = initHead();
//        LinkNode linkNode = reverseList(head);
//        LinkNode linkNode = solve(head, 3);
//        printLinkNode(linkNode);
        LinkNode linkNode = reverseKGroup(head, 3);
        printLinkNode(linkNode);
    }

    private static LinkNode solve(LinkNode head, int k) {
        // 调用逆序函数
        head = reverse(head);
        // 调用每 k 个为一组的逆序函数（从头部开始组起）
        head = reverseKGroup(head, k);
        // 在逆序一次
        head = reverse(head);
        return head;

    }
    
    //k个为一组逆序
    private static LinkNode reverseKGroup(LinkNode head, int k) {
        LinkNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        //判断节点的数量是否能够凑成一组
        if(temp == null)
            return head;

        LinkNode t2 = temp.next;
        temp.next = null;
        //把当前的组进行逆序
        LinkNode newHead = reverse(head);
        //把之后的节点进行分组逆序
        LinkNode newTemp = reverseKGroup(t2, k);
        // 把两部分连接起来
        head.next = newTemp;

        return newHead;
    }

    //逆序单链表
    private static LinkNode reverse(LinkNode head) {
        if(head == null || head.next == null)
            return head;
        LinkNode result = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    @Test
    public void Test(){
        LinkNode head = initHead();
        head.next.next = head;
        head.next = null;
        printLinkNode(head);
    }



    private static void printLinkNode(LinkNode head){
        while (head.next != null){
            System.out.print(head.value);
            head = head.next;
        }
        System.out.println(head.value);
    }

    private static LinkNode initHead(){
        LinkNode linkNode1 = new LinkNode(1);
        LinkNode linkNode2 = new LinkNode(2);
        LinkNode linkNode3 = new LinkNode(3);
        LinkNode linkNode4 = new LinkNode(4);
        LinkNode linkNode5 = new LinkNode(5);
        LinkNode linkNode6 = new LinkNode(6);
        LinkNode linkNode7 = new LinkNode(7);
        LinkNode linkNode8 = new LinkNode(8);
        linkNode7.next = linkNode8;
        linkNode6.next = linkNode7;
        linkNode5.next = linkNode6;
        linkNode4.next = linkNode5;
        linkNode3.next = linkNode4;
        linkNode2.next = linkNode3;
        linkNode1.next = linkNode2;
        return linkNode1;
    }

}


class LinkNode{
    LinkNode next;
    int value;

    LinkNode(int value) {
        this.value = value;
    }
}