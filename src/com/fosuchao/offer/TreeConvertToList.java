package com.fosuchao.offer;

/**
 * @Description: 将树转变成升序的双向链表
 * @Auther: Joker Ye
 * @Date: 2020/1/31 21:31
 */
public class TreeConvertToList {

    private TreeNode pre = null; //保存当前节点的前一个节点
    private TreeNode head = null;//保存链表的头结点


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(14);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(12);
        TreeNode treeNode7 = new TreeNode(16);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreeConvertToList treeConvertToList = new TreeConvertToList();
//        TreeNode convert = treeConvertToList.convert(treeNode1);
        TreeNode convert = treeConvertToList.convert(treeNode1);
        while (convert != null) {
            System.out.println(convert.val);
            convert = convert.right;
        }
    }

    public TreeNode convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null)  pre.right = node;
        pre = node;
        if (head == null) head = node;
        inOrder(node.right);
    }


}


