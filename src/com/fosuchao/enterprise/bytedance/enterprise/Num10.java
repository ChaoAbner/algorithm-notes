package com.fosuchao.enterprise.bytedance.enterprise;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * 10. 正则表达式匹配
 */

public class Num10 {

    public static void main(String[] args) {
        Num10 ins = new Num10();

        System.out.println(ins.isMatch("mississippi", "***"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // 初始化匹配0次的情况
        for (int i = 2; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (firstMatch(sc, pc)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*' && j >= 2) {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else if (firstMatch(sc, p.charAt(j - 2))) {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean firstMatch(char a, char b) {
        return a == b || b == '.';
    }

    // 递归
    public boolean isMatch1(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        boolean firstMatch = s.length()  > 0 &&
                (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() > 2 && p.charAt(1) == '*') {
            // 匹配多次或者匹配0次
            return (firstMatch && isMatch(s.substring(1), p)) ||
                    isMatch(s, p.substring(2));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
