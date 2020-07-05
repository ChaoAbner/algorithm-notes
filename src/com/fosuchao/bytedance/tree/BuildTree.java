package com.fosuchao.bytedance.tree;

import com.fosuchao.bytedance.Utils;
import com.fosuchao.bytedance.datastructure.TreeNode;

import java.util.HashMap;

/**
 * @description: https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/ 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 * @author: Joker Ye
 * @create: 2020/7/5 22:07
 */
public class BuildTree {
    private static HashMap<Integer, Integer> inMap = new HashMap<>();
    private static int[] preorder;

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        Utils.preOrder(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        // 根据前序遍历的第一个节点，找到中序遍历中的对应节点作为分界线
        BuildTree.preorder = preorder;
        // 初始化中序遍历的元素与索引的映射
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int preL, int preR, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }

        // 前序遍历的第一个节点一定是根节点
        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inMap.get(rootVal);
        // 重建左子树
        root.left = buildTree(preL + 1, rootIndex - inL + preL, inL, rootIndex - 1);
        // 重建右子树
        root.right = buildTree(rootIndex - inL + preL + 1, preR, rootIndex + 1, inR);

        return root;
    }
}
