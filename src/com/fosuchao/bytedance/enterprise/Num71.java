package com.fosuchao.bytedance.enterprise;


import java.util.ArrayDeque;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 * 71. 简化路径
 *
 */

public class Num71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
    }

    public static String simplifyPath(String path) {
        String[] pathList = path.split("/");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String s : pathList) {
            if (!stack.isEmpty() && "..".equals(s)) {
                stack.pollLast();
            } else if (!"..".equals(s) &&
                    !".".equals(s) &&
                    !"".equals(s)){
                stack.addLast(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pop());
        }
        return sb.toString();
    }
}
