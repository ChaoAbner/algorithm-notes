package com.fosuchao.enterprise.bytedance.enterprise;

import com.fosuchao.datastructure.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 124. 二叉树中的最大路径和
 */

public class Num124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSum(root);
        return maxSum;
    }

    private int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(maxSum(node.left), 0);
        int right = Math.max(maxSum(node.right), 0);
        maxSum = Math.max(node.val + left + right, maxSum);

        return node.val + Math.max(left, right);
    }
}
