package com.fosuchao.enterprise.bytedance.enterprise;

import com.fosuchao.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 103. 二叉树的锯齿形层次遍历
 */

public class Num103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        // 存放奇数行的栈
        Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
        // 存放偶数行的栈
        Deque<TreeNode> stack2 = new ArrayDeque<TreeNode>();

        boolean odd = true;
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> inner = new ArrayList<>();
            if (odd) {
                while (!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    inner.add(node.val);
                    if (node.left != null) stack2.push(node.left);
                    if (node.right != null) stack2.push(node.right);
                }
                odd = false;
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    inner.add(node.val);
                    if (node.right != null) stack1.push(node.right);
                    if (node.left != null) stack1.push(node.left);
                }
                odd = true;
            }
            res.add(inner);
        }

        return res;
    }
}
