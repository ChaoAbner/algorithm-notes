package com.fosuchao.hot;

/**
 * @Description: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/submissions/
 * @Auther: Joker Ye
 * @Date: 2020/1/23 19:51
 */
public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            dfs(root, 0);
        }
        return root;
    }

    public int dfs(TreeNode root, int sum){
        if(root == null){
            return sum;
        }
        // 右子树的累加值
        sum = dfs(root.right, sum);
        // 当前节点加上右子树的累加值
        root.val += sum;
        // 将当前节点的值传给左子树去累加
        sum = dfs(root.left, root.val);

        return sum;
    }
}
