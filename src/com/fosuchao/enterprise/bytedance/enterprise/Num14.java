package com.fosuchao.enterprise.bytedance.enterprise;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 14. 最长公共前缀
 */

public class Num14 {

    // 纵向对比，比较strs中每个元素的第一个字符，都相等则继续往后比较
    // 需要注意的是需要判断返回的条件
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;

        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                // 如果当前判断的字符索引等于某个字符串长度的时候，或者字符比较不相等的时候，直接返回当前索引的结果就是最长公共前缀
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // 如果不存在公共前缀（一定是从0开始），则逐渐缩小公共前缀
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
