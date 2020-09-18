package com.fosuchao.bytedance.enterprise;


/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 5. 最长回文子串
 */

public class Num5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        int maxLen;
        for (int i = 1; i < s.length() - 1; i++) {
            // 奇数，偶数长度
            int oddLength = extendByCenter(s, i, i);
            int evenLength = extendByCenter(s, i, i + 1);
            maxLen = Math.max(oddLength, evenLength);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int extendByCenter(String s, int l, int r) {
        int maxLen = 1;
        while (r < s.length() && l >= 0 && s.charAt(l) == s.charAt(r)) {
            maxLen = r - l + 1;
            r++;
            l--;
        }
        return maxLen;
    }
}
