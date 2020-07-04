package com.fosuchao.recursion;

/**
 * @Description: 反转单链表。例如链表为：1->2->3->4。反转后为 4->3->2->1
 * @Auther: Joker Ye
 * @Date: 2020/1/3 14:45
 * @noinspection Duplicates
 */
public class ReverseLinklist {
    public static void main(String[] args) {
        LinkNode head = initLinkList();
        LinkNode newHead = reverse(head);
        printLinkNode(newHead);
    }

    private static LinkNode reverse(LinkNode head){
        // 1、明确将传入的节点反转
        if(head == null || head.next == null){
            // 2、明确终止条件
            return head;
        }
        // 3、明确等价关系式
        LinkNode result = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    private static void printLinkNode(LinkNode head){
        while (head.next != null){
            System.out.print(head.value);
            head = head.next;
        }
        System.out.println(head.value);
    }

    private static LinkNode initLinkList(){
        LinkNode linkNode1 = new LinkNode(1);
        LinkNode linkNode2 = new LinkNode(2);
        LinkNode linkNode3 = new LinkNode(3);
        LinkNode linkNode4 = new LinkNode(4);
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