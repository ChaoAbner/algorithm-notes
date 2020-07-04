package com.fosuchao.offer;

/**
 * @Description: offer pdf 227页 判断一个树是不是平衡二叉树
 * @Auther: Joker Ye
 * @Date: 2020/2/11 14:07
 */
public class IsBalancedTree {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode5.left = treeNode7;
        treeNode3.right = treeNode6;
        System.out.println(new IsBalancedTree().isBalancedTree(treeNode1));
    }

    public boolean isBalancedTree(TreeNode root) {
        return isBalanced(root) != -1;

    }

    public int isBalanced(TreeNode root) {
        if (root == null) return 0;
        int left = isBalanced(root.left);
        if (left == -1) return -1;
        int right = isBalanced(root.right);
        if (right == -1) return -1;

        return Math.abs(left - right) > 1 ? -1 : (1 + Math.max(left, right));
    }

}
