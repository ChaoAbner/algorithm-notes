package com.fosuchao.hot;

import java.util.HashMap;

/**
 * @description:
 * @author: Joker Ye
 * @create: 2020/3/11 11:32
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(preorder, inorder);
    }

    Integer preIndex = 0;
    int [] preorder;
    int [] inorder;
    // 存储中序遍历的数组元素对应的索引
    HashMap<Integer, Integer> inIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        // 初始化map
        int inIndex = 0;
        for (int i : inorder) {
            inIndexMap.put(i, inIndex++);
        }

        return helper(0, inorder.length);
    }

    public TreeNode helper(int left, int right) {
        if (left == right) {
            return null;
        }
        // 构建新的根节点
        TreeNode root = new TreeNode(preorder[preIndex++]);

        // 拿到中序遍历的根节点的索引
        int inIndex = inIndexMap.get(root.val);
        root.left = helper(left, inIndex);
        root.right = helper(inIndex + 1, right);

        return root;
    }
}
