package com.fosuchao.enterprise.bytedance.enterprise;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 32. 最长有效括号
 */

public class Num32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        // 先push-1，方便计算索引
        stack.push(-1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int length = 0;
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    length = i - stack.peek();
                } else {
                    stack.push(i);
                }
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
}
