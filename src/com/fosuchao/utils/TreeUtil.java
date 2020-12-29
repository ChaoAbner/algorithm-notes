package com.fosuchao.utils;

import com.fosuchao.datastructure.TreeNode;

/**
 * Created by Chao Ye on 2020/12/29
 */
public class TreeUtil {

    /**
     * 前序遍历打印
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + "->");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历打印
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        preOrder(root.left);
        System.out.print(root.val + "");
        preOrder(root.right);
    }

    /**
     * 后序遍历打印
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if (root == null) return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val + "");
    }
}
