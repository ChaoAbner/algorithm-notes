package com.fosuchao.hot;

import java.util.Stack;

/**
 @Description: https://leetcode-cn.com/problems/merge-two-binary-trees/
 两棵树的合并
 递归：
 当一个子树为null时，返回另一棵子树，改变两颗子树中的一颗进行累加或添加

 迭代：
 根据前序遍历的顺序，将两个字数的数组压入栈,如果有一个树为null，则不进行后续操作
 一次前序遍历将两颗字数的和累加，判断该树的左右子树是否为null，若为null，则将另一棵子树赋给该子树。
 继续压入左右子树完成所有合并操作
 @Auther: Joker Ye
 @Date: 2020/1/26 20:05
*/
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 递归方法
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    // 迭代方法
//        if (t1 == null)
//            return t2;
//        Stack< TreeNode[] > stack = new Stack < > ();
//        stack.push(new TreeNode[] {t1, t2});
//        while (!stack.isEmpty()) {
//            TreeNode[] t = stack.pop();
//            if (t[0] == null || t[1] == null) {
//                continue;
//            }
//            t[0].val += t[1].val;
//            if (t[0].left == null) {
//                t[0].left = t[1].left;
//            } else {
//                stack.push(new TreeNode[] {t[0].left, t[1].left});
//            }
//            if (t[0].right == null) {
//                t[0].right = t[1].right;
//            } else {
//                stack.push(new TreeNode[] {t[0].right, t[1].right});
//            }
//        }
//        return t1;
//    }


    public static void main(String[] args) {
        
    }
    
}
