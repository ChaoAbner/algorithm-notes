package com.fosuchao.enterprise.bytedance.enterprise;

/**
 * 674. 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
public class Num674 {
    public int findLengthOfLCIS(int[] nums) {
        int maxLength = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                curr = i;
            }
            maxLength = Math.max(maxLength, i - curr + 1);
        }
        return maxLength;
    }
}
