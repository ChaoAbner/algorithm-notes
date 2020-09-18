package com.fosuchao.bytedance.enterprise;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 3. 无重复字符的最长子串
 */

public class Num3 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = -1;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 更新l
                l = Math.max(l, map.get(c));
            }
            map.put(c, i);
            max = Math.max(max, i - l);
        }
        return max;
    }
}
