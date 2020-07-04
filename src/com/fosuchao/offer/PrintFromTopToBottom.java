package com.fosuchao.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 从上到下打印二叉树
 * @Auther: Joker Ye
 * @Date: 2020/1/28 20:07
 */
public class PrintFromTopToBottom {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(10);
        TreeNode treeNode10 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(11);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode10;
        treeNode2.right = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;

        PrintFromTopToBottom printFromTopToBottom = new PrintFromTopToBottom();
        printFromTopToBottom.print(treeNode1);
    }

    public void print(TreeNode root){
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println("当前节点为：" + poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }

    }

}
