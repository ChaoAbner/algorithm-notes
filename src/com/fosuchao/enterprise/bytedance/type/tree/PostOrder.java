package com.fosuchao.enterprise.bytedance.type.tree;

import com.fosuchao.datastructure.TreeNode;

import java.util.*;

/**
 * @description: https://leetcode-cn.com/problems/binary-tree-postorder-traversal/ 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author: Joker Ye
 * @create: 2020/7/4 22:10
 */
public class PostOrder {
    static List<Integer> res = new ArrayList<>();

    // 递归
    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return null;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);

        return res;
    }

    // 非递归
    public static List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null)
            return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
            res.add(node.val);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
//        List<Integer> r = postorderTraversal(treeNode1);
        List<Integer> r = postorderTraversal1(treeNode1);
        System.out.println(r);
    }
}
