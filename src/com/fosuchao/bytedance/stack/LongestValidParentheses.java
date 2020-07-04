package com.fosuchao.bytedance.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: https://leetcode-cn.com/problems/longest-valid-parentheses/ 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * @author: Joker Ye
 * @create: 2020/7/4 22:05
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        int i = longestValidParentheses("()(()())");      // ouput 8
        System.out.println(i);
    }

    public static int longestValidParentheses(String s) {
        char[] brackets = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxLength = 0;
        int length = 0;

        for (int i = 0; i < brackets.length; i++) {
            char c = brackets[i];
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    length = i - stack.peek();
                } else {
                    stack.push(i);
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
