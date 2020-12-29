package com.fosuchao.enterprise.bytedance;

import com.fosuchao.datastructure.ListNode;
import com.fosuchao.datastructure.TreeNode;

/**
 * @description:
 * @author: Joker Ye
 * @create: 2020/7/4 19:24
 */
public class Utils {

    /**
     * 打印链表
     * @Param [node]
     * @return void
     */
    public static void printLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + "->");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        preOrder(root.left);
        System.out.print(root.val + "");
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val + "");
    }
}
