package com.fosuchao.enterprise.bytedance.enterprise;

import com.fosuchao.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 105. 从前序与中序遍历序列构造二叉树
 */

public class Num105 {

    int preIndex = 0;
    Map<Integer, Integer> infixMap = new HashMap<>();
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        // 需要根据前序的首节点找到中序遍历的中间点
        for (int i = 0; i < inorder.length; i++) {
            infixMap.put(inorder[i], i);
        }
        return help(0, inorder.length);
    }

    private TreeNode help(int left, int right) {
        if (left == right) {
            return null;
        }
        int first = preorder[preIndex++];
        TreeNode root = new TreeNode(first);
        // 对应中序的元素
        int inIndex = infixMap.get(first);
        root.left = help(left, inIndex);
        root.right = help(inIndex + 1, right);
        return root;
    }
}
