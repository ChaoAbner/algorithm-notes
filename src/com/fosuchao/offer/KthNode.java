package com.fosuchao.offer;

/**
 * @Description: 二叉搜索树、二叉排序树，中序遍历的结果是从小到大排序的。
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @Auther: Joker Ye
 * @Date: 2020/2/16 11:05
 */
public class KthNode {
    int index = 0;

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.println(new KthNode().kthNode1(treeNode1, 3).val);
    }

    TreeNode kthNode1(TreeNode root, int k)
    {
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = kthNode1(root.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return root;
            node = kthNode1(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }
}
