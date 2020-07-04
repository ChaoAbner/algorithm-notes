package com.fosuchao.hot;

/**
 * @Description: https://leetcode-cn.com/problems/diameter-of-binary-tree/submissions/
 * . 二叉树的直径
 * @Auther: Joker Ye
 * @Date: 2020/1/23 20:26
 */
public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}
