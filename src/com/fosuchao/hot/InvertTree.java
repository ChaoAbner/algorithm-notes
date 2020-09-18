package com.fosuchao.hot;



import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @Description:
 * @Auther: Joker Ye
 * @Date: 2020/1/18 10:28
 */
public class InvertTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(9);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        InvertTree invertTree = new InvertTree();
        TreeNode treeNode1 = invertTree.invertTree(treeNode);
    }

    // 递归
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode right = invertTree(root.right);
//        TreeNode left = invertTree(root.left);
//        root.left = right;
//        root.right = left;
//        return root;
//    }

    // 循环
    public TreeNode invertTree(TreeNode root){
        // 使用队列
        Queue<TreeNode> treeNodes = new LinkedList<>();

        treeNodes.add(root);

        while (!treeNodes.isEmpty()){
            TreeNode poll = treeNodes.poll();
            TreeNode temp = poll.left;
            poll.right = poll.left;
            poll.left = temp;

            if(poll.left != null) treeNodes.add(poll.left);
            if(poll.right != null) treeNodes.add(poll.right);
        }
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

