package com.fosuchao.bytedance.tree;

import com.fosuchao.bytedance.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/ 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author: Joker Ye
 * @create: 2020/7/4 22:10
 */
public class InfixOrder {
    static List<Integer> res = new ArrayList<>();

    // 递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    // 非递归
    public static List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null)
            return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            curr = node.right;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
//        List<Integer> r = inorderTraversal(treeNode1);
        List<Integer> r = inorderTraversal1(treeNode1);
        System.out.println(r);
    }

}
