package com.fosuchao.offer;


/**
 * @Description: 判断b树是否是a树的子树
 * 解决思路：
 * 1、遍历a树，比较当前节点的权是否跟b根节点的权相等
 * 2、若相等，则进入逐一判断
 * 2-1、如果递归到b节点为null是时候，说明左右的一边比较完毕，则返回true
 * 2-2、如果递归到a节点为null的时候或者两节点的权不相等的时候，返回false
 * 3、若不相等，则a树继续往下遍历
 * 4、如果a树遍历完毕，即等于null，返回false。
 * @Auther: Joker Ye
 * @Date: 2020/1/27 14:39
 */
public class IsInsideTree {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode10 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(8);
        treeNode6.left = treeNode2;
        treeNode6.right = treeNode4;
        treeNode4.left = treeNode5;
        treeNode4.right = treeNode3;
        tree1.left = treeNode6;
        tree1.right = treeNode10;

        TreeNode tree2 = new TreeNode(8);
        TreeNode treeNode8 = new TreeNode(9);
        TreeNode treeNode9 = new TreeNode(2);
        tree2.left = treeNode8;
        tree2.right = treeNode9;

        IsInsideTree isInsideTree = new IsInsideTree();
        boolean insideTree = isInsideTree.isInsideTree(tree1, tree2);
        System.out.println(insideTree);
        tree1.preOrder();
        System.out.println();
        tree2.preOrder();

    }

    public boolean isInsideTree(TreeNode tree1, TreeNode tree2) {

        boolean result = false;
        if (tree1 == null || tree2 == null) {
            return result;
        }

        if (tree1.val == tree2.val)
            result = doesTree1HaveTree2(tree1, tree2);

        if (!result)
            result = isInsideTree(tree1.left, tree2);

        if (!result)
            result = isInsideTree(tree1.right, tree2);

        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode tree1, TreeNode tree2) {
        // 判断树1是否包含树2
        if (tree2 == null)
            return true;

        if (tree1 == null)
            return false;

        if (tree1.val != tree2.val)
            return false;

        return doesTree1HaveTree2(tree1.left, tree2.left) && doesTree1HaveTree2(tree1.right, tree2.right);
    }

}

class Tree {
    TreeNode root;

    Tree(TreeNode root) {
        this.root = root;
    }


    public void preOrder() {
        if(root != null){
            root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void infixOrder() {
        if(root != null){
            root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if(root != null){
            root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "[value = " + this.val + "]";
    }

    public void preOrder() {
        // 前序遍历 根 -> 左 -> 右
        // 先输出根节点
        System.out.print(this);
        // 递归遍历左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归遍历右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        // 前序遍历  左 -> 根 -> 右
        // 递归遍历左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        // 输出根节点
        System.out.print(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        // 前序遍历  左 -> 右 -> 根

        // 递归遍历左子树
        if (this.left != null) {
            this.left.postOrder();
        }
        // 递归遍历右子树
        if (this.right != null) {
            this.right.postOrder();
        }
        // 输出根节点
        System.out.print(this);
    }
}
