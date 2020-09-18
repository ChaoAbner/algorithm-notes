package com.fosuchao.bytedance.enterprise;

import java.util.*;

/**
 * 复原ip地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class Num93 {

    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        List<String> strings = restoreIpAddresses("101023");
        System.out.println(strings);
    }

    public static List<String> restoreIpAddresses(String s) {
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, 0, 0, path);
        return res;
    }

    private static void dfs(String s, int begin, int level, Deque<String> path) {
        if (begin == s.length()) {
            if (level == 4) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3 && i < s.length(); i++) {
            String subIp = s.substring(begin, i + 1);
            if (validIp(subIp)) {
                path.addLast(subIp);
                dfs(s, i + 1, level + 1, path);
                path.pollLast();
            }
        }
    }

    private static boolean validIp(String subIp) {
        if (subIp.length() > 1 && subIp.charAt(0) == '0') {
            return false;
        }
        int ip = Integer.parseInt(subIp);
        return 0 <= ip && ip <= 255;
    }
}
