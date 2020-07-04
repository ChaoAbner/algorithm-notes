package com.fosuchao.bytedance;

import com.fosuchao.bytedance.datastructure.ListNode;

/**
 * @description:
 * @author: Joker Ye
 * @create: 2020/7/4 19:24
 */
public class Utils {

    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }
}
