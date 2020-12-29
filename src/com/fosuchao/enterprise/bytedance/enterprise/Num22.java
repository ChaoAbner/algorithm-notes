package com.fosuchao.enterprise.bytedance.enterprise;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22 括号生成
 */

public class Num22 {

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(res, n, 0, 0, "");
        return res;
    }

    private static void dfs(List<String> res, int n, int l, int r, String curr) {
        if (curr.length() == n * 2) {
            if (l == n && r == n) {
                res.add(curr);
            }
            return;
        }
        if (l < n) {
            dfs(res, n, l + 1, r, curr + "(");
        }
        if (r < l) {
            dfs(res, n, l, r + 1, curr + ")");
        }
    }
}
