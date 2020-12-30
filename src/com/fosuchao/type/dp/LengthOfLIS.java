package com.fosuchao.type.dp;

import java.util.Arrays;

/**
 * Created by Chao Ye on 2020/12/30
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 300. 最长递增子序列
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }

    /**
     * 二分 + dp
     */
    public int lengthOfLIS1(int[] nums) {
        // TODO: 2020/12/30  二分优化时间复杂度为Nlog(N)
        return 1;
    }
}
