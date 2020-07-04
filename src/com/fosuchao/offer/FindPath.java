package com.fosuchao.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Description: 输入一个整数和一个二叉树，找出二叉树从根出发到子节点的权之和为输入整数的所有路径
 * @Auther: Joker Ye
 * @Date: 2020/1/28 22:08
 */
public class FindPath {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(12);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        FindPath findPath = new FindPath();
        findPath.findPath(22, treeNode1);
    }

    public void findPath(int num, TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        backTrack(num, root, stack, sum);
        System.out.println(res);
    }

    public void backTrack(int num, TreeNode tree, Stack<Integer> stack, int sum) {
        if (tree == null) {
            return;
        }
        stack.push(tree.val);
        sum += tree.val;
        boolean isLeaf = tree.left == null && tree.right == null;
        if (sum == num && isLeaf) {
            res.add(new ArrayList<>(stack));
            // 满足完整路径条件
            for (Integer integer : stack) {
                System.out.print("-" + integer);
            }
            System.out.println();
        } else {
            // 继续递归
            backTrack(num, tree.left, stack, sum);
            backTrack(num, tree.right, stack, sum);
        }
        // 回到父节点
        stack.pop();

    }
}
