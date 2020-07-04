package com.fosuchao.offer;

/**
 * @Description: 将一个树变成他的镜像
 * 思路：
 * 判断当前节点是否为null，不是的话交换他的左右子树。再对子树进行递归执行
 * @Auther: Joker Ye
 * @Date: 2020/1/27 21:17
 */
public class MirrorTree {
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

        MirrorTree mirrorTree = new MirrorTree();
        treeNode1.preOrder();
        TreeNode treeNode = mirrorTree.mirrorTree(treeNode1);
        System.out.println();
        treeNode.preOrder();

    }

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}
