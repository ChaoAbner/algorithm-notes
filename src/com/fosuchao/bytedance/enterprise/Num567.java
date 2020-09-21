package com.fosuchao.bytedance.enterprise;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 567. 字符串的排列
 *
 * 给定两个字符串s1和s2，写一个函数来判断 s2 是否包含 s1的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间

 * 滑动窗口
 *
 * 解题思路：
 * s1可以是任意的顺序，判断s1是否是s2的字串即可
 * 因为是s1的排列，那么可以判断s2中是否存在长度为s1的length的字串，并且字串中的字符个数等于s1的字符个数，
 * 如果相等那么说明s2包含s1的排列
 */

public class Num567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] l1 = new int[26];
        int[] l2 = new int[26];
        // 保存s1中的字符个数
        for (char c : s1.toCharArray()) {
            l1[c - 'a']++;
        }
        int len = s1.length();
        // 开始滑动窗口
        for (int i = 0; i < s2.length(); i++) {
            // 超出窗口值
            if (i >= len) {
                l2[s2.charAt(i - len) - 'a']--;
            }
            l2[s2.charAt(i) - 'a']++;
            // 判断数组是否相等
            if (Arrays.equals(l1, l2)) {
                return true;
            }
        }
        return false;
    }
}
