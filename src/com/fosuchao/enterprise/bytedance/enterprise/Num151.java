package com.fosuchao.enterprise.bytedance.enterprise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 151. 翻转字符串里的单词
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */

public class Num151 {

    // 使用api
    public String reverseWords(String s) {
        // 去除首尾的空格
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    // 使用栈实现
    public String reverseWords1(String s) {
        // 去除首尾空格
        s = s.trim();

        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            char c = s.charAt(left);
            if (c == ' ' && sb.length() != 0) {
                stack.addFirst(sb.toString());
                sb.setLength(0);
            } else if (c != ' '){
                sb.append(c);
            }
            left++;
        }
        stack.addFirst(sb.toString());
        return String.join(" ", stack);
    }

    // 使用自己的函数
    public String reverseWords2(String s) {
        // 去除首尾的空格和单词中间多余的空格
        StringBuilder sb = trimSpaces(s);

        // 整个字符串翻转
        reverse(sb, 0, sb.length() - 1);

        // 每个单词进行翻转
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0, end = 0;
        int len = sb.length();
        while (start < len) {
            while (end < len && sb.charAt(end) != ' ') {
                end++;
            }
            reverse(sb, start, end - 1);
            start = end + 1;
            end++;
        }
    }

    private void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            char tmp = sb.charAt(r);
            sb.setCharAt(r, sb.charAt(l));
            sb.setCharAt(l, tmp);
            l++;
            r--;
        }
    }

    private StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        while ((left <= right) && s.charAt(left) == ' ') {
            left++;
        }
        while ((left <= right) && s.charAt(right) == ' ') {
            right--;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

}
