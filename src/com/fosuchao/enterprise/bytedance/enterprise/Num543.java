package com.fosuchao.enterprise.bytedance.enterprise;


import com.fosuchao.datastructure.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 543. 二叉树的直径
 */
public class Num543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxHeight(root);
        return max;
    }

    private int maxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxHeight(root.left);
        int right = maxHeight(root.right);

        max = Math.max(left + right, max);

        return Math.max(left, right) + 1;
    }


}
