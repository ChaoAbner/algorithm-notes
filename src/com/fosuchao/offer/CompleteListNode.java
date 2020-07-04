package com.fosuchao.offer;

import org.junit.rules.TestName;

import java.awt.*;

/**
 * @Description: 复杂链表的复制
 *
 * @Auther: Joker Ye
 * @Date: 2020/1/31 17:11
 */
public class CompleteListNode {
    public static void main(String[] args) {
        CListNode cListNode1 = new CListNode(1);
        CListNode cListNode2 = new CListNode(2);
        CListNode cListNode3 = new CListNode(3);
        CListNode cListNode4 = new CListNode(4);
        CListNode cListNode5 = new CListNode(5);
        cListNode1.next = cListNode2;
        cListNode2.next = cListNode3;
        cListNode3.next = cListNode4;
        cListNode4.next = cListNode5;
        cListNode1.sbling = cListNode3;
        cListNode2.sbling = cListNode5;
        cListNode3.sbling = cListNode2;
        cListNode4.sbling = cListNode1;
        cListNode5.sbling = cListNode4;

        CompleteListNode completeListNode = new CompleteListNode();
        CListNode copy = completeListNode.copy(cListNode1);
        completeListNode.print(cListNode1);
        System.out.println();
        completeListNode.print(copy);
    }

    public CListNode copy(CListNode head){
        if (head == null) {
            return null;
        }
        // 1、将每个节点复制后，添加在当前节点的后面 也就是1-2-3 =》 1-1-2-2-3-3
        generateCloneList(head);
        // 2、将复制的节点指向sbling节点
        generateCloneSbling(head);
        // 3、将整个链表分成原链表和复制链表，返回复制链表
        return separateCloneList(head);
    }

    public void generateCloneList(CListNode head) {
        CListNode temp = head;
        while (temp != null) {
            CListNode clone = (CListNode) temp.clone();
            CListNode next = temp.next;
            clone.next = next;
            temp.next = clone;
            temp = next;
        }
    }

    public void generateCloneSbling(CListNode head) {
        CListNode node = head;
        while (node != null) {
            CListNode clone = node.next;
            if(node.sbling != null)
                clone.sbling = node.sbling;
            node = clone.next;
        }
    }

    public CListNode separateCloneList(CListNode head) {
        CListNode node = head;              // node = 1-1^-2-2^-3-3^...
        CListNode cloneHead = head.next;
        CListNode cloneNode = cloneHead;    // cloneNode = 1^-2-2^-3-3^...
        node.next = cloneNode.next;         // node = 1-2-2^-3-3^...
        node = node.next;                   // node = 2-2^-3-3^...
        while (node != null) {
            cloneNode.next = node.next;     // cloneNode = 1^-2^-3-3^...
            cloneNode = cloneNode.next;     // cloneNode = 2^-3-3^...
            node.next = cloneNode.next;     // node = 2-3-3^...
            node = node.next;               // node = 3-3^...
        }
        return cloneHead;
    }

    public void print(CListNode head) {
        CListNode temp = head;
        while (temp != null) {
            System.out.print("[val=" + temp.val + "]" + "[sbling=" + temp.sbling.val +"]");
            temp = temp.next;
        }
    }



}


class CListNode implements Cloneable{
    int val;
    CListNode next;
    CListNode sbling;

    public CListNode(int val) {
        this.val = val;
    }

    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}