package com.fosuchao.bytedance.tree;

import com.fosuchao.bytedance.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/ 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * @author: Joker Ye
 * @create: 2020/7/4 22:10
 */
public class PreOrder {
    static List<Integer> res = new ArrayList<>();

    // 递归
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }

    // 非递归
    public static List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null)
            return null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
//        List<Integer> r = preorderTraversal(treeNode1);
        List<Integer> r1 = preorderTraversal1(treeNode1);
        System.out.println(r1);
    }
}
